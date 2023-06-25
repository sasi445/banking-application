import com.bank.model.Account;
import com.bank.model.Customer;

import java.math.BigDecimal;
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
        Account account = new Account();
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
                    isLoggedIn = login(customer);
                    createBankAccount(account);
                }
                case 0 -> {
                    System.out.println("Exiting the Bank Application System...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            if (isLoggedIn) {
                displayLoggedInOptions(account);
                break;
            }
        }
    }

    private static void createBankAccount(Account account) {
        System.out.println("Please enter your account holder name: ");
        account.setAccountHolderName(scanner.nextLine());
        System.out.println("Please enter your account number: ");
        account.setAccountNumber(scanner.nextLine());
        System.out.println("Please enter your initial deposit: ");
        String deposit = scanner.nextLine();
        while(new BigDecimal(deposit).compareTo(new BigDecimal("500")) < 0) {
                System.out.println("Your initial deposit is less than the threshold.Please enter your initial deposit: ");
                deposit = scanner.nextLine();
        }
        account.setBalance(new BigDecimal(deposit));
    }

    private static void registerUser(Customer customer) {
        System.out.println("Please enter your first name: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Please enter your last name: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Please enter your Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.println("Please enter your Email Id: ");
        customer.setEmailId(scanner.nextLine());
        System.out.println("Please enter your address: ");
        customer.setAddress(scanner.nextLine());
        System.out.println("Please enter your user name: ");
        customer.setUserName(scanner.nextLine());
        System.out.println("Please enter your password: ");
        customer.setPassword(scanner.nextLine());
    }

    private static boolean login(Customer customer) {
        System.out.println("Please enter your user name: ");
        String loginUserName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String loginPassword = scanner.nextLine();

        if (loginUserName.equals(customer.getUserName()) && loginPassword.equals(customer.getPassword())) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed.");
            return false;
        }
    }

    private static void displayLoggedInOptions(Account account) {
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Fund Transfer");
            System.out.println("0. Exit\n");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> {
                    System.out.println("Balance Inquiry option selected.");
                    System.out.println("Please enter your account number: "); //12345
                    BigDecimal accountBalance = account.getAccountBalance(scanner.nextLine());
                    System.out.println("The account balance is " + accountBalance);
                }

                case 2 -> {
                    System.out.println("Deposit option selected.");
                    System.out.println("enter the deposit amount");
                    BigDecimal depositAmount = new BigDecimal(scanner.nextLine());
                    account.deposit(depositAmount);
                    //Ask the user to enter the deposit amount
                    //deposit(BigDecimal amount); add inside this method.
                    // add the deposit amount to the current balance: account.getBalance() + deposit amount entered by the user
                }
                case 3 -> {
                    System.out.println("Withdrawal option selected.");
                    System.out.println("Enter the withdrawal amount:");
                    BigDecimal withdrawalAmount = new BigDecimal(scanner.nextLine());
                    account.withdraw(withdrawalAmount);
                }

                   // withdraw(BigDecimal amount); 500. <= current balance
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
