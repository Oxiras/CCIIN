/**
 *PROGRAM: IssuerCheck.java
 *@author Moustapha Dieng
 *@version 1.0.4
 *This class checks for the issuer of valid credit card
 *numbers based on them passing luhn's algorithm check.
 */

public class IssuerCheck extends Validation {

	//To hold the issuer of the credit cards.
	private String issuer = "Issuer not found.";

	/*
	 * Calls the superclass constructor and passes the
	 */
	public IssuerCheck(String line)
	{
		super(line);
	}

	/*
	 * This setIssuer method assigns a issuer to credit card numbers.
	 */
	public void setIssuer (String line)
	{
		int oneChar = Integer.parseInt(line.substring(0, 1));
		int twoChars = Integer.parseInt(line.substring(0, 2));
		int threeChars = Integer.parseInt(line.substring(0, 3));
		int fourChars = Integer.parseInt(line.substring(0, 4));
		int sixChars = Integer.parseInt(line.substring(0, 6));

		if (super.luhnAlg(line))
		{
			if (oneChar == 4)
			{
				if (line.length() >= 13 && line.length() <= 16)
					issuer = "Visa";
			}
			if (twoChars == 34 || twoChars == 37)
			{
				if (line.length() == 15)
					issuer = "American Express";
			}
			if (twoChars == 36)
			{
				if (line.length() == 14)
					issuer = "Diners Club - International";
			}
			if (twoChars == 51 || twoChars == 52 || twoChars == 53 || twoChars == 54 || twoChars == 55)
			{
				if (line.length() >= 16 && line.length() <= 19)
					issuer = "MasterCard";
			}
			if (twoChars == 54)
			{
				if (line.length() == 16)
					issuer = "Diners Club - USA & Canada";
			}
			if (threeChars == 300 ||threeChars == 301 || threeChars == 302 || threeChars == 303 || threeChars == 304 || threeChars == 305 )
			{
				if (line.length() == 14)
					issuer = "Diners Club - Carte Blanche";
			}
			if (threeChars == 637 ||threeChars == 638 || threeChars == 639)
			{
				if (line.length() == 16)
					issuer = "InstaPayment";
			}
			if (twoChars == 31 || twoChars == 33 || fourChars >= 3528 && fourChars <= 3589)
			{
				if (line.length() == 16)
					issuer = "JCB";
			}
			if (fourChars == 6304 || fourChars == 6706 || fourChars == 6771 || fourChars == 6709)
			{
				if (line.length() >= 16 && line.length() <= 19)
					issuer = "Laser";
			}
			if (fourChars == 5018 || fourChars == 5020 || fourChars == 5038 || fourChars == 5893 ||
					fourChars == 6304 || fourChars == 6759 || fourChars == 6761 || fourChars == 6762 || fourChars == 6763)
			{
				if (line.length() >= 16 && line.length() <= 19)
					issuer = "Maestro";
			}
			if (fourChars == 4026 || fourChars == 4508 || fourChars == 4844 || fourChars == 4913|| fourChars == 4917 || sixChars == 417500)
			{
				if (line.length() == 16)
					issuer = "Visa Electron";
			}
			if (twoChars == 65 || threeChars == 644 || threeChars == 645 || threeChars == 646 || threeChars == 647|| threeChars == 648 || 
					threeChars == 649 || fourChars == 6011 || sixChars >= 622126 && sixChars <= 622925)
			{
				if (line.length() == 16)
					issuer = "Discover";
			}
		}
	}
	
	/*
	 * This getIssuer method returns the issuer of the credit card numnbers.
	 */
	public String getIssuer()
	{
		return issuer;
	}
}
