/*
 * Author: Brandon Chang
 * Date: August 19, 2020
 * Resource: "Practice Java by Building Projects" on https://www.udemy.com
 * Description: Scenario: You are a back-end developer and need to create an 
 * application to handle new customer bank account requests.
 */

import java.util.Random;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking account
	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 10000; // used to create unique 5 digit number for accountNumber
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		
		// Set account number, incrememt index
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	// List common methods
	public abstract void setRate();
	
	// Generate 11 digit account number with the following process: 
	// 1 or 2 depending on Savings or Checking (handled in the respective child classes)
	// last two digits of SSN
	// unique 5 digit number
	// random 3 digit number
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		// Generate a random 3-digit number
		Random rand = new Random();
		int randomNumber = rand.nextInt(900) + 100;
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	// Method to add compounded interest to account balance if desired
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name + 
				"\nACCOUNT NUMBER: " + accountNumber + 
				"\nBALANCE: $" + balance +
				"\nRATE: " + rate + "%"
				);
	}

}
