import java.util.*;

public class OnlineExam {

    static Scanner sc = new Scanner(System.in);

    // Default Login Details
    static String username = "student";
    static String password = "1234";

    public static void main(String[] args) {

        if (login()) {
            int choice;
            do {
                System.out.println("\n===== ONLINE EXAM SYSTEM =====");
                System.out.println("1. Update Profile & Password");
                System.out.println("2. Start Exam");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        updateProfile();
                        break;
                    case 2:
                        startExam();
                        break;
                    case 3:
                        System.out.println("Logged out successfully!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 3);
        }
    }

    // Login Method
    static boolean login() {
        System.out.println("===== LOGIN =====");
        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Login!");
            return false;
        }
    }

    // Update Profile
    static void updateProfile() {
        System.out.print("Enter new username: ");
        username = sc.next();

        System.out.print("Enter new password: ");
        password = sc.next();

        System.out.println("Profile updated successfully!");
    }

    // Exam Section
    static void startExam() {

        String[] questions = {
                "1. Java is developed by?\nA. Microsoft\nB. Sun Microsystems\nC. Google\nD. IBM",
                "2. Which keyword is used to inherit a class?\nA. implements\nB. import\nC. extends\nD. package",
                "3. JVM stands for?\nA. Java Virtual Machine\nB. Java Variable Method\nC. Joint Virtual Machine\nD. None"
        };

        char[] answers = {'B', 'C', 'A'};
        int score = 0;

        long startTime = System.currentTimeMillis();
        long examDuration = 60000; // 60 seconds

        for (int i = 0; i < questions.length; i++) {

            long currentTime = System.currentTimeMillis();

            if (currentTime - startTime > examDuration) {
                System.out.println("\nTime's up! Auto Submitting...");
                break;
            }

            System.out.println("\n" + questions[i]);
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            if (userAnswer == answers[i]) {
                score++;
            }
        }

        System.out.println("\nExam Submitted Successfully!");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}