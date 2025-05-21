public class Lights {
    public static void main(String[] args) {
        Bulb bulb1 = new Bulb();
        Bulb bulb2 = new Bulb();
        System.out.println("Initial Status:");
        System.out.println(bulb1.checkStatus());
        System.out.println(bulb2.checkStatus());

        bulb1.turnOn();
        bulb2.turnOn();

        System.out.println("\nAfter Turning On:");
        System.out.println(bulb1.checkStatus());
        System.out.println(bulb2.checkStatus());

        bulb2.turnOff();

        System.out.println("\nFinal Status:");
        System.out.println(bulb1.checkStatus());
        System.out.println(bulb2.checkStatus());
    }
}