package ps3n5Chapter9;

import java.util.Date;

/**
 *
 * @author Marshall Ehlinger
 */
public class P9N7Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    
    public P9N7Account() {
        // No arg constructor
        this.dateCreated = new Date(0);
    }
    
    public P9N7Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "P9N7Account{" + "id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate + ", dateCreated=" + dateCreated + '}';
    }
    
    public void withdraw(double amount) {
        this.balance = balance - amount;
    }
    
    public void deposit(double amount) {
        this.balance = balance + amount;
    }
    
    public double getMonthlyInterest() {
        return balance * (((this.annualInterestRate) / 100.0) / 12.0);
    }
}
