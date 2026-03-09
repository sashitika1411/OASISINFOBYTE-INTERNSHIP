import java.util.*;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String> books = new ArrayList<>();
    static ArrayList<String> issuedBooks = new ArrayList<>();

    static String adminUser = "admin";
    static String adminPass = "1234";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminModule();
                    break;
                case 2:
                    userModule();
                    break;
                case 3:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);
    }

    // ---------------- ADMIN MODULE ----------------
    static void adminModule() {

        System.out.print("Enter Admin Username: ");
        String user = sc.next();

        System.out.print("Enter Admin Password: ");
        String pass = sc.next();

        if (user.equals(adminUser) && pass.equals(adminPass)) {

            int choice;
            do {
                System.out.println("\n--- ADMIN PANEL ---");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. View Books");
                System.out.println("4. Logout");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book Name: ");
                        sc.nextLine();
                        String book = sc.nextLine();
                        books.add(book);
                        System.out.println("Book Added Successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Book Name to Delete: ");
                        sc.nextLine();
                        String deleteBook = sc.nextLine();
                        books.remove(deleteBook);
                        System.out.println("Book Deleted Successfully!");
                        break;

                    case 3:
                        viewBooks();
                        break;

                    case 4:
                        System.out.println("Admin Logged Out!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 4);

        } else {
            System.out.println("Invalid Admin Credentials!");
        }
    }

    // ---------------- USER MODULE ----------------
    static void userModule() {

        int choice;

        do {
            System.out.println("\n--- USER PANEL ---");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewBooks();
                    break;

                case 2:
                    System.out.print("Enter Book Name to Search: ");
                    sc.nextLine();
                    String search = sc.nextLine();
                    if (books.contains(search)) {
                        System.out.println("Book Available!");
                    } else {
                        System.out.println("Book Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Name to Issue: ");
                    sc.nextLine();
                    String issueBook = sc.nextLine();

                    if (books.contains(issueBook)) {
                        books.remove(issueBook);
                        issuedBooks.add(issueBook);
                        System.out.println("Book Issued Successfully!");
                    } else {
                        System.out.println("Book Not Available!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book Name to Return: ");
                    sc.nextLine();
                    String returnBook = sc.nextLine();

                    if (issuedBooks.contains(returnBook)) {
                        issuedBooks.remove(returnBook);
                        books.add(returnBook);

                        System.out.print("Enter Days Late: ");
                        int days = sc.nextInt();

                        if (days > 7) {
                            int fine = (days - 7) * 5;
                            System.out.println("Fine Amount: ₹" + fine);
                        } else {
                            System.out.println("No Fine!");
                        }

                        System.out.println("Book Returned Successfully!");
                    } else {
                        System.out.println("Invalid Book!");
                    }
                    break;

                case 5:
                    System.out.println("User Logged Out!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }

    // View Books Method
    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No Books Available!");
        } else {
            System.out.println("Available Books:");
            for (String b : books) {
                System.out.println("- " + b);
            }
        }
    }
}