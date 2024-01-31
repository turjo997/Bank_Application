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

    }

    private void depositAmount() {

    }

    private void withdrawAmount() {

    }

    private void searchAccount() {

    }

    private void updateAccount() {

    }

    private void displayAllAccounts() {

    }

    private void createAccount() {

    }


    public static void main(String[] args) {
        Main app = new Main();

        app.startApp();

    }
}