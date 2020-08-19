/*
 * Author: Brandon Chang
 * Date: August 19, 2020
 * Resource: "Practice Java by Building Projects" on https://www.udemy.com
 * Description: Scenario: You are a back-end developer and need to create an 
 * application to handle new customer bank account requests.
 */

import java.util.Random;

public class Checking extends Account {
	// List properties specific to a checking account
	private long debitCardNumber;
	private int debitCardPIN;
	
	// Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber; // start accountNumber with 2 if Checking account
		setDebitCard();
	}
	
	// List any methods specific to the checking account
	@Override
	public void setRate() {
		// Checking account rate is 15% of base rate
		rate = getBaseRate() * 0.15;
	}
	
	// Checking account holders will be assigned a debit card with
	// Random 12 digit card number
	// Random 4 digit PIN
	private void setDebitCard() {
		Random rand = new Random();
		// Generate a random 12 digit number
		char[] digits = new char[12];
		digits[0] = (char)(rand.nextInt(9) + '1');
		for(int i=1; i<12; i++) {
			digits[i] = (char)(rand.nextInt(10) + '0');
		}
		debitCardNumber = Long.parseLong(new String(digits));
		// Generate a random 4 digit number
		debitCardPIN = rand.nextInt(9000) + 1000;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Features:" + 
				"\n Debit Card Number: " + debitCardNumber + 
				"\n Debit Card PIN: " + debitCardPIN
				);
	}

}
