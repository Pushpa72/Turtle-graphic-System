public class Bulb {
    private boolean isOn;

    // Constructor: Initializes the bulb to be off
    public Bulb() {
        isOn = false;
    }
    public void turnOn() {
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }
    public String checkStatus() {
        return isOn ? "ON" : "OFF";
    }
}