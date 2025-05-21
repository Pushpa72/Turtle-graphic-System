import java.awt.FlowLayout;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.LBUGraphics;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





public class TurtleGraphics extends LBUGraphics {
    private boolean isImageSaved = true;


    public TurtleGraphics() {
        JFrame mainFrame = new JFrame("Turtle Graphics");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(this);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    @Override
    public void processCommand(String command) {
        logCommand(command);
        command = command.trim().toLowerCase();
        String[] parts = command.split(" ");
        String mainCommand = parts[0];
        String param = parts.length > 1 ? parts[1] : "";

        switch (mainCommand) {
            case "clear":
                handleClear();
                break;
            case "reset":
                reset();
                displayMessage("Turtle reset to center and pointing down.");
                break;
            case "about":
                about();
                break;
            case "pendown":
                setPenState(true);
                displayMessage("Pen is now down.turtle will  draw ");
                break;
            case "penup":
                setPenState(false);
                displayMessage("Pen is now up.turtle will not draw now ");
                break;
            case "move":
                handleMove(param);
                break;
            case "reverse":
                handleReverse(param);
                break;
            case "left":
                handleTurn(param, "left");
                break;
            case "right":
                handleTurn(param, "right");
                break;
            case "red":
                setPenColour(Color.RED);
                displayMessage("Pen color is now red.");
                break;
            case "blue":
                setPenColour(Color.BLUE);
                displayMessage("Pen color is now blue.");
                break;
            case "green":
                setPenColour(Color.GREEN);
                displayMessage("Pen color is now green.");
                break;
            case "yellow":
                setPenColour(Color.YELLOW);
                displayMessage("Pen color is now yellow.");
                break;
            case "square":
                handleSquare(param);
                break;
            case "save":
                saveImage();
                break;
            case "load":
                load();
                break;
            case "commandhistory":
                cmdHistory();
                break;
            case "exit":
                exit();
                System.exit(0);
                break;
            case "runcommands":
                runSavedCommands();
                break;
            case "pen":
                handlePen(parts);
                break;
            case "penwidth":
                handlePenWidth(param);
                break;
            case "triangle":
                handleTriangle(parts);
                break;

            case "help":
                showHelp();
                break;

            default:
                showError("Invalid command: \"" + command + "\". Please try again.");
                break;

        }
    }

    private void handleClear() {
        if (!isImageSaved) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "You have unsaved changes. Do you want to save before clearing?",
                    "Unsaved Changes", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirm == JOptionPane.CANCEL_OPTION || confirm == JOptionPane.CLOSED_OPTION) {
                displayMessage("Clear operation cancelled.");
                return;
            } else if (confirm == JOptionPane.YES_OPTION) {
                saveImage();
            }
        }
        clear();
        isImageSaved = true;
        displayMessage("Screen cleared.");
    }


    private void handleMove(String param) {
        int distance = 100;
        if (!param.isEmpty()) {
            try {
                distance = Integer.parseInt(param);
                if (distance < 0 || distance > 500) {
                    showError("Distance must be between 0 and 500 units.");
                    return;
                }
            } catch (NumberFormatException e) {
                showError("Invalid parameter. Expected a number.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "No distance specified. Using default of 100 units.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        forward(distance);
        isImageSaved = false;
        displayMessage("Moved forward by " + distance + " units.");
    }

    private void handleReverse(String param) {
        int reverseDistance = 100;
        if (!param.isEmpty()) {
            try {
                reverseDistance = Integer.parseInt(param);
                if (reverseDistance < 0 || reverseDistance > 500) {
                    showError("Reverse distance must be between 0 and 500 units.");
                    return;
                }
            } catch (NumberFormatException e) {
                showError("Invalid reverse distance. Using default 100.");
            }
        }
        forward(-reverseDistance);
        isImageSaved = false;
        displayMessage("Reversed by " + reverseDistance + " units.");
    }

    private void handleTurn(String param, String direction) {
        int angle = 90;
        if (!param.isEmpty()) {
            try {
                angle = Integer.parseInt(param);
                if (angle < 0 || angle > 360) {
                    showError("Angle must be between 0 and 360.");
                    return;
                }
            } catch (NumberFormatException e) {
                showError("Invalid angle. Using default 90.");
            }
        }

        if (direction.equalsIgnoreCase("left")) {
            left(angle);
        } else if (direction.equalsIgnoreCase("right")) {
            right(angle);
        }

        isImageSaved = false;
        displayMessage("Turned " + direction + " by " + angle + " degrees.");
    }

    private void handleSquare(String param) {
        if (param.isEmpty()) {
            showError("Missing parameter for square. Usage: square <size>");
            return;
        }
        try {
            int size = Integer.parseInt(param);
            square(size);
            displayMessage("Drawn square with side " + size);
        } catch (NumberFormatException e) {
            showError("Invalid parameter. Expected a number for: square");
        }
    }

    private void handlePen(String[] parts) {
        if (parts.length != 4) {
            showError("Invalid pen command. Usage: pen <r> <g> <b>");
            return;
        }

        try {
            int r = Integer.parseInt(parts[1]);
            int g = Integer.parseInt(parts[2]);
            int b = Integer.parseInt(parts[3]);

            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                throw new NumberFormatException();
            }

            setPenColour(new Color(r, g, b));
            displayMessage("Pen colour set to RGB(" + r + "," + g + "," + b + ")");
        } catch (NumberFormatException e) {
            showError("Invalid pen colour values. Must be integers between 0 and 255.");
        }
    }


    private void handlePenWidth(String param) {
        if (param.isEmpty()) {
            showError("Missing parameter. Usage: penWidth <size>");
            return;
        }
        try {
            int width = Integer.parseInt(param);
            setStroke(width);
            displayMessage("Pen width set to " + width);
        } catch (NumberFormatException e) {
            showError("Invalid width. Please enter a number.");
        }
    }

    private void handleTriangle(String[] parts) {
        if (parts.length < 2) {
            showError("Missing parameter. Usage: triangle <side> or triangle <a> <b> <c>");
            return;
        }

        try {
            if (parts.length == 2) {
                int side = Integer.parseInt(parts[1]);
                equilateralTriangle(side);
                displayMessage("Drawn equilateral triangle with side " + side);
            } else if (parts.length == 4) {
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);
                int c = Integer.parseInt(parts[3]);
                triangle(a, b, c);
                displayMessage("Drawn triangle with sides " + a + ", " + b + ", " + c);
            } else {
                showError("Invalid number of parameters. Use: triangle <side> or triangle <a> <b> <c>");
            }
        } catch (NumberFormatException e) {
            showError("All triangle sides must be valid numbers.");
        }
    }


    public void square(int size) {
        setPenState(true);
        for (int i = 0; i < 4; i++) {
            forward(size);
            right(90);
        }
        isImageSaved = false;
    }

    public void saveImage() {
        try {
            BufferedImage img = getBufferedImage();
            File outputfile = new File("my_drawing.png");
            ImageIO.write(img, "png", outputfile);
            displayMessage("Image saved as 'my_drawing.png'.");
            isImageSaved = true;
        } catch (Exception e) {
            displayMessage("Error saving image: " + e.getMessage());
        }
    }

    public void load() {
        try {
            clear();
            File inputFile = new File("my_drawing.png");
            if (!inputFile.exists()) {
                showError("Error: 'my_drawing.png' not found. Please save first.");
                return;
            }
            BufferedImage loadedImage = ImageIO.read(inputFile);
            setBufferedImage(loadedImage);
            displayMessage("Image loaded from 'my_drawing.png'.");
        } catch (Exception e) {
            displayMessage("Error loading image: " + e.getMessage());
        }
    }

    public void logCommand(String command) {
        try (FileWriter writer = new FileWriter("commands_log.txt", true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + timestamp + "] " +"\n" + "\t"+ command + "\n");

        } catch (IOException e) {
            displayMessage("Error writing command to log: " + e.getMessage());
        }
    }

    public void cmdHistory() {
        StringBuilder history = new StringBuilder();//empty buffer
        try (BufferedReader reader = new BufferedReader(new FileReader("commands_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.append(line).append("\n");
            }
        } catch (IOException e) {
            history.append("Error reading command history: ").append(e.getMessage());
        }
        JTextArea textArea = new JTextArea(history.toString(), 20, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Command History", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exit() {
        if (!isImageSaved) {
            int confirmExit = JOptionPane.showConfirmDialog(null,
                    "You have unsaved changes. Do you want to save before exiting?",
                    "Unsaved Changes", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirmExit == JOptionPane.CANCEL_OPTION || confirmExit == JOptionPane.CLOSED_OPTION) {
                displayMessage("Exit cancelled.");
                return;
            } else if (confirmExit == JOptionPane.YES_OPTION) {
                saveImage();
            }
        }
        displayMessage("Exiting program...");
    }

    public void runSavedCommands() {
        try (BufferedReader reader = new BufferedReader(new FileReader("commands_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();

                if (line.isEmpty() || line.equals("runcommands")) {
                    continue;
                }
                if (Character.isLetter(line.charAt(0))) {
                    displayMessage("Running: " + line);
                    processCommand(line);
                }
            }
            displayMessage("All commands executed.");
        } catch (IOException e) {
            displayMessage("Error reading commands: " + e.getMessage());
        }
    }

    public void equilateralTriangle(int size) {
        setPenState(true);
        for (int i = 0; i < 3; i++) {
            forward(size);
            right(120);//externalangle
        }
        isImageSaved = false;
    }

    private void triangle(int a, int b, int c) {
        if (!getPenState()) {
            displayMessage("Pen is up. Set the pen state to down to draw a triangle.");
            return;
        }
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            showError("Invalid triangle sides.");
            return;
        }
        double angleA = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2.0 * b * c)));
        double angleB = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2.0 * a * c)));
        double angleC = 180 - angleA - angleB;
        int extAngleB = 180 - (int)Math.round(angleB);
        int extAngleC = 180 - (int)Math.round(angleC);

        forward(a);
        right(extAngleB);
        forward(b);
        right(extAngleC);
        forward(c);

        isImageSaved = false;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    public void showHelp() {
        String helpText = """
        Available Commands:

        Movement:
          move <distance>         - Move forward (default 100)
          reverse <distance>      - Move backward
          left <angle>            - Turn left (default 90°)
          right <angle>           - Turn right (default 90°)

        Pen Control:
          penup                   - Lift pen (no drawing)
          pendown                 - Lower pen (drawing)
          pen <r> <g> <b>         - Set pen color using RGB values (0-255)
          penwidth <size>         - Set the thickness of the pen

        Drawing Shapes:
          square <size>           - Draw a square
          triangle <side>         - Equilateral triangle
          triangle <a> <b> <c>    - Custom triangle

        Colors:
          red / green / blue / yellow - Set predefined pen colors

        File Operations:
          save                    - Save current image
          load                    - Load saved image
          commandhistory          - View command log
          runcommands             - Replay logged commands

        Other:
          clear                   - Clear the screen
          reset                   - Center turtle and face down
          about                   - Show app info
          help                    - Show this help dialog
          exit                    - Exit the program

        """;

        JTextArea textArea = new JTextArea(helpText);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Help - Command Reference", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void about() {
        super.about();
        displayMessage("Enhanced Turtle Graphics bY Pushpa Rimal");
    }

}




