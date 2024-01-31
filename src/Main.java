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

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}