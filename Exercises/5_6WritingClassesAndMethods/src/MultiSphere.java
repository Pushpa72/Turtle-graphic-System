public class MultiSphere {
    public static void main(String[] args) {

        Sphere sphere1 = new Sphere(16.0);
        Sphere sphere2 = new Sphere(18.0);

        System.out.println(sphere1.toString());
        System.out.println("Volume:"+ sphere1.calculateVolume());
        System.out.println("Surface Area:"+ sphere1.calculateSurfaceArea());

        System.out.println();

        System.out.println(sphere2.toString());
        System.out.println("Volume:"+ sphere2.calculateVolume());
        System.out.println("Surface Area:"+ sphere2.calculateSurfaceArea());

        sphere1.setDiameter(20.0);// Update
        System.out.println("\nUpdated"+ sphere1.toString());
        System.out.println("Volume:"+ sphere1.calculateVolume());
        System.out.println("Surface Area:"+ sphere1.calculateSurfaceArea());
    }
}
