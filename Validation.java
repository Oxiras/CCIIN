/**
 *PROGRAM: Validation.java
 *@author Moustapha Dieng
 *@version 1.1.1
 *This class uses Luhn algorithm to check
 *for valid credit card numbers.
 */

public class Validation {

	@SuppressWarnings("unused")
	private String line;					//To hold the value of each line.
	private boolean isValid;				//To hold value of true or false for credit card number validity.

	/*
	 * This constructor initializes the field line
	 * with the value passed to its argument.
	 */
	public Validation(String line)
	{
		this.line = line;
	}

	/*
	 * This method uses luhn's algorithm in order
	 * to determine whether credit card numbers are valid.
	 */
	public boolean luhnAlg(String line)
	{
		int minLength = 13;				//To hold minimum possible length for credit cards.
		int maxLength = 19;				//To hold maximum possible length for credit cards.
		int odd = 0;					//To hold value of sum of odd digits.
		int even = 0;					//To hold value of sum of even digits.
		//Check for valid credit card number length.
		if (line.length() >= minLength && line.length() <= maxLength)
		{
			//Reverses the credit card number for processing.
			String reverse = new StringBuffer(line).reverse().toString();
			//Runs the algorithm.
			for(int i = 0 ; i < reverse.length(); i++)
			{
				int digit = Character.digit(reverse.charAt(i), 10);
				if(i % 2 == 0)
				{
					even += digit;
				}
				else
				{
					odd += 2 * digit;
					if(digit >= 5)
					{
						odd -= 9;
					}
				}
			}
		}
		//Message returns if invalid length.
		else
			System.out.println("Invalid Credit Card Length.\n");
		//Sets isValid boolean value.
		isValid = (odd + even) % 10 == 0;
		//Returns isValid boolean value.
		return isValid;
	}
}
