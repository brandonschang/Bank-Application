/*
 * Author: Brandon Chang
 * Date: August 19, 2020
 * Resource: "Practice Java by Building Projects" on https://www.udemy.com
 * Description: Scenario: You are a back-end developer and need to create an 
 * application to handle new customer bank account requests.
 */

import java.util.Random;

public class Savings extends Account {
	// List properties specific to savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize settings for the savings properties
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber; // start accountNumber with 1 if Savings account
		setSafetyDepositBox();
	}
	
	// List any methods specific to savings account
	@Override
	public void setRate() {
		// Savings account rate is 0.25 points lower than base rate
		rate = getBaseRate() - 0.25;
	}
	
	// Savings account holders will be assigned a Safety Deposit Box with
	// Random 3 digit box number
	// Random 4 digit box key
	private void setSafetyDepositBox() {
		Random rand = new Random();
		// Generate a random 3 digit number
		safetyDepositBoxID = rand.nextInt(900) + 100;
		// Generate a random 4 digit number
		safetyDepositBoxKey = rand.nextInt(9000) + 1000;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Your Savings Account Features:" + 
				"\n Safety Deposit Box ID: " + safetyDepositBoxID + 
				"\n Safety Deposit Box Key: " + safetyDepositBoxKey
				);
	}
	
}
