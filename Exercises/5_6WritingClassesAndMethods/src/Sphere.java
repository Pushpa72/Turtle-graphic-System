public class Sphere {
    private double diameter;
    public Sphere(double diameter) {
        this.diameter = diameter;
    }
    public double getDiameter() {//getter
        return diameter;
    }
    public void setDiameter(double diameter) {//setter
        this.diameter = diameter;
    }

    public double calculateVolume() {
        double radius = diameter / 2.0;
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }


    public double calculateSurfaceArea() {
        double radius = diameter / 2.0;
        return 4.0 * Math.PI * Math.pow(radius, 2);
    }
    @Override
    public String toString() {
        return "Sphere with diameter "+ diameter;
    }
}