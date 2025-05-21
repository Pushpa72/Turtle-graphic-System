 public class Hospital {

     //Doctorclass
     static class Doctor {
         String name;
         int empId;
         String specialization;

         public Doctor(String name, int empId, String specialization) {
             this.name = name;
             this.empId = empId;
             this.specialization = specialization;
         }

         public void showSpecialization() {
             System.out.println("Doctor " + name + " Emp#" + empId + " specializes in " + specialization);
         }
     }

     // Nurse class
     static class Nurse {
         String name;
         int empId;
         int numberOfPatients;

         public Nurse(String name, int empId, int numberOfPatients) {
             this.name = name;
             this.empId = empId;
             this.numberOfPatients = numberOfPatients;
         }

         public void showPatients() {
             System.out.println("Nurse " + name + " Emp#" + empId + " has " + numberOfPatients + " patients");
         }
     }

     // Receptionist class
     static class Receptionist {
         String name;
         int empId;

         public Receptionist(String name, int empId) {
             this.name = name;
             this.empId = empId;
         }

         public void answerCall() {
             System.out.println("Receptionist " + name + " Emp#" + empId + " is answering a call");
         }
     }

     // Cleaner class
     static  class Cleaner {
         String name;
         int empId;
         String department;

         public Cleaner(String name, int empId, String department) {
             this.name = name;
             this.empId = empId;
             this.department = department;
         }

         public void sweep() {
             System.out.println("Cleaner " + name + " Emp#" + empId + " of " + department + " is sweeping");
         }
     }

 // Driver class
         public static void main(String[] args) {
             Doctor doc = new Doctor("Pushpa", 1, "Psychiatrist");
             Nurse nurse = new Nurse("Sita", 2, 4);
             Receptionist receptionist = new Receptionist("Rita", 3);
             Cleaner cleaner = new Cleaner("Lita", 4, "Emerceny");

             doc.showSpecialization();
             nurse.showPatients();
             receptionist.answerCall();
             cleaner.sweep();
         }
     }

