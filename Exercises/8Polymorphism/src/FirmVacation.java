public class FirmVacation {
    class Employee {
        String name;
        String position;
        Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }
        void displayInfo() {
            System.out.println("Employee: " + name+ "\nPosition: " + position);
        }
        int vacationDays() {
            return 14;
        }
    }
    class Manager extends Employee {
        Manager(String name) {
            super(name, "Manager");
        }
        @Override
        int vacationDays() {
            return 30;
        }
    }
    class Staff extends Employee {
        Staff(String name) {
            super(name, "Staff");
        }
        @Override
        int vacationDays() {
            return 21;
        }
    }
    class Intern extends Employee {
        Intern(String name) {
            super(name, "Intern");
        }
        @Override
        int vacationDays() {
            return 7;
        }
    }
    public static void main(String[] args) {
        FirmVacation firm = new FirmVacation();
        Employee e1=firm.new Manager("li");
        Employee e2=firm.new Staff("lis");
        Employee e3=firm.new Intern("Lisa");

        e1.displayInfo();
        System.out.println("Vacation Days: " + e1.vacationDays() + "\n");
        e2.displayInfo();
        System.out.println("Vacation Days: " + e2.vacationDays() + "\n");
        e3.displayInfo();
        System.out.println("Vacation Days: " + e3.vacationDays());
    }
}
