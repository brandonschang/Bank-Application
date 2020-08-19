/*
 * Author: Brandon Chang
 * Date: August 19, 2020
 * Resource: "Practice Java by Building Projects" on https://www.udemy.com
 * Description: Scenario: You are a back-end developer and need to create an 
 * application to handle new customer bank account requests.
 */

public interface IBaseRate {
	
	// Method that returns a base rate
	default double getBaseRate() {
		return 2.5;
	}
	
}
