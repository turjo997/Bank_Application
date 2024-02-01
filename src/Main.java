import java.util.ArrayList;
import java.util.Scanner;

class Account{

    private String name;
    private String accountNumber;
    private String creationDate;
    private double balance;
    private String address;
    private String phoneNumber;

    public Account(String name, String accountNumber, String creationDate, double balance, String address, String phoneNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.creationDate = creationDate;
        this.balance = balance;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


public class Main {

    private ArrayList<Account> accounts;
    private Scanner scanner;

    public Main(){
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void startApp(){

        int choice;
        do {
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for account");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    depositAmount();
                    break;
                case 6:
                    withdrawAmount();
                    break;
                case 7:
                    searchAccount();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

    }

    private void deleteAccount() {
        scanner.nextLine();
        System.out.println("Enter account number to delete:");
        String number = scanner.nextLine();
        boolean removed = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                accounts.remove(account);
                System.out.println("Account deleted successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Account not found.");
        }

    }

    private void depositAmount() {
        scanner.nextLine();
        System.out.println("Enter account number to deposit into:");
        String number = scanner.nextLine();

        boolean found = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                double amount;
                do {
                    System.out.println("Enter amount to deposit (minimum 1000):");
                    amount = scanner.nextDouble();
                    if (amount < 1000) {
                        System.out.println("Invalid deposit amount. Minimum deposit amount is 1000.");
                    }
                } while (amount < 1000);

                account.setBalance(account.getBalance() + amount);
                System.out.println("Amount deposited successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found.");
        }
    }

    private void withdrawAmount() {
        scanner.nextLine();
        System.out.println("Enter account number to withdraw from:");
        String number = scanner.nextLine();

        boolean found = false;
        do {
            System.out.println("Enter amount to withdraw:");
            double amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else {
                for (Account account : accounts) {
                    if (account.getAccountNumber().equals(number)) {
                        if (account.getBalance() - amount >= 1000) {
                            account.setBalance(account.getBalance() - amount);
                            System.out.println("Amount withdrawn successfully.");
                        } else {
                            System.out.println("Insufficient funds. Minimum balance of 1000 taka must be maintained.");
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Account not found.");
                } else {
                    break;
                }
            }
        } while (true);
    }

    private void searchAccount() {
        scanner.nextLine();
        System.out.println("Enter account number to search:");
        String number = scanner.nextLine();
        boolean found = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                System.out.println("Account found:");
                System.out.println("Name: " + account.getName() + ", Number: " + account.getPhoneNumber() +
                        ", Account Number: " + account.getAccountNumber() +
                        ", Address: " +account.getAddress() +
                        ", Creation Date: " + account.getCreationDate() + ", Balance: " + account.getBalance());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found.");
        }
    }

    private void updateAccount() {
        scanner.nextLine();

        boolean found = false;
        do {
            System.out.println("Enter account number to update:");
            String number = scanner.nextLine();

            for (Account account : accounts) {
                if (account.getAccountNumber().equals(number)) {
                    try {
                        System.out.println("Enter new account name:");
                        String newName = scanner.nextLine();

                        if (!isValidName(newName)) {
                            throw new IllegalArgumentException("Invalid account name. Account name should contain only letters and spaces, and should not exceed 40 characters.");
                        }

                        System.out.println("Enter new creation date(YYYY-MM-DD):");
                        String newCreationDate = scanner.nextLine();

                        if (!isValidDate(newCreationDate)) {
                            throw new IllegalArgumentException("Invalid creation date format. Please use YYYY-MM-DD.");
                        }

                        System.out.println("Enter address:");
                        String newAddress = scanner.nextLine();

                        System.out.println("Enter phone number:");
                        String newPhnNumber = scanner.nextLine();

                        if (!isValidPhoneNumber(newPhnNumber)) {
                            throw new IllegalArgumentException("Invalid phone number. Phone number must contain 11 characters starting with 0.");
                        }

                        account.setName(newName);
                        account.setCreationDate(newCreationDate);
                        account.setAddress(newAddress);
                        account.setPhoneNumber(newPhnNumber);

                        System.out.println("Account updated successfully.");
                        found = true;
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error updating account: " + e.getMessage());
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("Account not found.");
            } else {
                break;
            }
        } while (true);
    }

    private void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("All accounts:");
            for (Account account : accounts) {
                System.out.println("Name: " + account.getName() + ", Number: " + account.getPhoneNumber() +
                        ", Account Number: " + account.getAccountNumber() +
                        ", Address: " +account.getAddress() +
                        ", Creation Date: " + account.getCreationDate() + ", Balance: " + account.getBalance());
            }
        }
    }

    private void createAccount() {

        scanner.nextLine();

        try {

            System.out.println("Enter Account Name:");
            String name = scanner.nextLine();

            for (Account existingAccount : accounts) {
                if (existingAccount.getName().equals(name)) {
                    throw new IllegalArgumentException("An account with the same name already exists.");
                }
            }

            if (!isValidName(name)) {
                throw new IllegalArgumentException("Invalid account name. Account name should contain only letters and spaces, and should not exceed 40 characters.");
            }

            System.out.println("Enter Account Number:");
            String accNumber = scanner.nextLine();

            for (Account existingAccount : accounts) {
                if (existingAccount.getAccountNumber().equals(accNumber)) {
                    throw new IllegalArgumentException("An account with the same account number already exists.");
                }
            }

            if (!isValidNumber(accNumber)) {
                throw new IllegalArgumentException("Invalid account number. Account number should contain only digits.");
            }

            System.out.println("Enter creation date(YYYY-MM-DD):");
            String creationDate = scanner.nextLine();

            if (!isValidDate(creationDate)) {
                throw new IllegalArgumentException("Invalid creation date format. Please use YYYY-MM-DD.");
            }

            System.out.println("Enter address:");
            String address = scanner.nextLine();


            System.out.println("Enter phone number:");
            String phnNumber = scanner.nextLine();

            if(!isValidPhoneNumber(phnNumber)){
                throw new IllegalArgumentException("Invalid phone number. Phone number must be contain 11 characters starting with 0.");
            }

            System.out.println("Enter initial balance:");
            double balance = scanner.nextDouble();

            if (balance < 5000) {
                throw new IllegalArgumentException("Invalid initial balance. For creating an account minimum 5000 taka needs to be inserted.");
            }

            Account account = new Account(name, accNumber, creationDate, balance , address , phnNumber);
            accounts.add(account);
            System.out.println("Account created successfully.");

        }catch (IllegalArgumentException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }

    }

    private boolean isValidPhoneNumber(String phnNumber) {
        return phnNumber.matches("0\\d{10}");
    }

    private boolean isValidDate(String creationDate) {
        String regex = "^(?:19|20)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$";
        return creationDate.matches(regex);
    }

    private boolean isValidNumber(String accNumber) {
        return accNumber.matches("\\d+");
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+") && name.length() <= 40;
    }


    public static void main(String[] args) {
        Main app = new Main();
        app.startApp();

    }
}