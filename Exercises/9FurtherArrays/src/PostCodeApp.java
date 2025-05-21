class Person {
    private String firstName;
    private String lastName;
    private String postalCode;
    public Person(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
    public void displayInfo() {
        System.out.printf("%-15s %-15s %-15s\n", firstName, lastName, postalCode);
    }
}
public class PostCodeApp {
    public static void main(String[] args) {
        Person[] people = new Person[25];
        int count = 0;
        String[] inputData = {
                "Pushpa\tRimal\t44600",
                "Sita\tShrestha\t12345",
                "John\tDoe\t56789",
                "lina\tLama\t12121",
        };
        for (String line : inputData) {
            if (count >= 25) break;
            String[] parts = line.split("\t");
            if (parts.length == 3) {
                String first = parts[0];
                String last = parts[1];
                String post = parts[2];
                people[count] = new Person(first,last,post);
                count++;
            }
        }
        System.out.println("First Name      Last Name       Post Code");
        System.out.println("___________________________________________");
        for (int i = 0; i < count; i++) {
            people[i].displayInfo();
        }
    }
}
