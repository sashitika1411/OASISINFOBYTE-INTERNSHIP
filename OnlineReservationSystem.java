import java.util.*;

class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);

    // Login credentials
    static String username = "admin";
    static String password = "1234";

    // Reservation data
    static String name;
    static int trainNo;
    static String trainName;
    static String classType;
    static String date;
    static String from;
    static String to;
    static int pnr = 1001;   // simple fixed PNR

    // Login Method
    static boolean login() {
        System.out.print("Enter Login ID: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Invalid Login Details!");
            return false;
        }
    }

    // Reservation Method
    static void reservation() {
        System.out.println("---- Reservation Form ----");

        System.out.print("Enter Passenger Name: ");
        name = sc.next();

        System.out.print("Enter Train Number: ");
        trainNo = sc.nextInt();

        // Auto train name
        if (trainNo == 123) {
            trainName = "Express";
        } else if (trainNo == 456) {
            trainName = "Superfast";
        } else {
            trainName = "Special Train";
        }

        System.out.print("Enter Class Type (Sleeper/AC): ");
        classType = sc.next();

        System.out.print("Enter Date of Journey: ");
        date = sc.next();

        System.out.print("From: ");
        from = sc.next();

        System.out.print("To: ");
        to = sc.next();

        System.out.println("\nReservation Successful!");
        System.out.println("Your PNR Number is: " + pnr);
    }

    // Cancellation Method
    static void cancellation() {
        System.out.print("Enter PNR Number to Cancel: ");
        int inputPNR = sc.nextInt();

        if (inputPNR == pnr) {
            System.out.println("\nTicket Details:");
            System.out.println("Name: " + name);
            System.out.println("Train: " + trainName);
            System.out.println("From: " + from + " To: " + to);

            System.out.print("Confirm Cancellation? (yes/no): ");
            String confirm = sc.next();

            if (confirm.equalsIgnoreCase("yes")) {
                System.out.println("Ticket Cancelled Successfully!");
            } else {
                System.out.println("Cancellation Aborted.");
            }
        } else {
            System.out.println("Invalid PNR Number!");
        }
    }

    public static void main(String[] args) {

        if (login()) {
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reservation();
                    break;
                case 2:
                    cancellation();
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}