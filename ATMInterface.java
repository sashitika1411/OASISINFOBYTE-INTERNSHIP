import java.util.*;

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Default Login Details
        String correctUserId = "user123";
        String correctPin = "1234";

        double balance = 10000;
        ArrayList<String> transactionHistory = new ArrayList<>();

        System.out.println("===== ATM MACHINE =====");

        // Login
        System.out.print("Enter User ID: ");
        String userId = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (!userId.equals(correctUserId) || !pin.equals(correctPin)) {
            System.out.println("Invalid User ID or PIN!");
            return;
        }

        System.out.println("Login Successful!");

        int choice;

        do {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        System.out.println("Transaction History:");
                        for (String t : transactionHistory) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        transactionHistory.add("Withdraw: " + withdrawAmount);
                        System.out.println("Withdraw Successful!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();

                    balance += depositAmount;
                    transactionHistory.add("Deposit: " + depositAmount);
                    System.out.println("Deposit Successful!");
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = sc.nextDouble();

                    if (transferAmount <= balance) {
                        balance -= transferAmount;
                        transactionHistory.add("Transfer: " + transferAmount);
                        System.out.println("Transfer Successful!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 5:
                    System.out.println("Thank You for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("Current Balance: " + balance);

        } while (choice != 5);

        sc.close();
    }
}
