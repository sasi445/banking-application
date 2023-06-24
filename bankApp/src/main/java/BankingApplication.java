import com.bank.model.Customer;

import java.util.Scanner;

public class BankingApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeMessage();
        displayOptions();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Bank Application System!");
    }

    private static void displayOptions() {
        boolean isLoggedIn = false;
        Customer customer = new Customer();
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit\n");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> {
                    System.out.println("Registration option selected.");
                    registerUser(customer);
                    // Implement registration logic
                }
                case 2 -> {
                    System.out.println("Login option selected.");
                    isLoggedIn = login();
                }
                case 0 -> {
                    System.out.println("Exiting the Bank Application System...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            if (isLoggedIn) {
                displayLoggedInOptions();
                break;
            }
        }
    }

    private static void registerUser(Customer customer) {
        System.out.println("Please enter your first name: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Please enter your last name: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Please enter your Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.println("Please enter your Email Id: ");
        String emailId = scanner.nextLine();
        System.out.println("Please enter your address: ");
        String adddress = scanner.nextLine();
        System.out.println("Please enter your user name: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
    }

    private static boolean login() {
        System.out.println("Login successful.");
        // Implement login logic and return true if login is successful, otherwise false
        return true;
    }

    private static void displayLoggedInOptions() {
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Fund Transfer");
            System.out.println("0. Exit\n");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> System.out.println("Balance Inquiry option selected.");

                // Implement balance inquiry logic
                case 2 -> System.out.println("Deposit option selected.");

                // Implement deposit logic
                case 3 -> System.out.println("Withdrawal option selected.");

                // Implement withdrawal logic
                case 4 -> System.out.println("Fund Transfer option selected.");

                // Implement fund transfer logic
                case 0 -> {
                    System.out.println("Exiting the Bank Application System...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
