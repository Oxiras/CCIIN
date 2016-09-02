import java.io.*;					//Needed for File and PrintWriter.
import java.util.ArrayList;			//Needed to use ArrayList.
import java.util.Scanner;			//Needed to use the Scanner class.

/**
 *PROGRAM: Driver.java
 *@author Moustapha Dieng
 *@version 1.2.3
 *This program opens the file passed to the command file as an argument,
 *checks the contents for valid credit card numbers and then returns
 *their issuer.
 */
public class Driver {

	/**
	 *Executes the main method
	 *@param args as a string array
	 */
	public static void main(String[] args) {

		String line;													//To hold the value of each line.
		ArrayList<String> validNumbers = new ArrayList<String>();		//To hold the valid credit card numbers.
		ArrayList<String> invalidNumbers = new ArrayList<String>();		//To hold the invalid credit card numbers.
		String filename = null;											//To hold the name of the input file.
		PrintWriter outputFile = null;									//To hold the name of the output file.

		//Enter try-catch phase.
		try {
			//Accepts a filename as argument for the input file.
			if (args.length > 0)
			{
				filename = args[0];
			}
			//If no file name was passed, asks the user to enter it manually.
			else
			{
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Please enter the name of the file to open: ");
				filename = keyboard.nextLine();
				keyboard.close();
			}
			//Create a File object.
			File file = new File(filename);
			//Pass reference to File object to the Scanner object.
			Scanner inputFile = new Scanner(file);
			//Message displayed upon successful location of file.
			System.out.println("File was found. Contents are being displayed.");
			//Enter while loop - Reads file contents.
			while(inputFile.hasNext()){
				//Holds each line of data in file in the String line.
				line = inputFile.nextLine();
				//Creates an IssuerCheck object and passes the String line as argument.
				IssuerCheck issuer = new IssuerCheck(line);
				//Display initial information.
				System.out.println("\nCard number: " + line + " - Length:" + line.length());
				//Calls the setIssuer method which also calls the luhnAlg
				//method and determine valid credit card and issuer.
				issuer.setIssuer(line);
				//Displays valid card credit flag.
				System.out.println("Valid Credit Card Number Flag: " + issuer.luhnAlg(line));
				//Displays credit card issuer.
				System.out.println("Credit Card Issuer: " + issuer.getIssuer());

				//Enter if statement - for valid credit card numbers.
				if (issuer.luhnAlg(line))
				{
					//Stores valid credit card numbers into the validNumbers array
					//and then prints them to the valid_cards.txt file.
					try {
						validNumbers.add(line);
						outputFile = new PrintWriter("valid_cards.txt");
						outputFile.println(validNumbers);
						//Catches FileNotFoundException.
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					//Closes "valid_cards.txt" output file.
					outputFile.close();
				}
				//Enter else statement - for invalid credit card numbers.
				else
					//Stores invalid credit card numbers into the invalidNumbers array
					//and then prints them to the invalid_cards.txt file.
					try {
						invalidNumbers.add(line);
						outputFile = new PrintWriter("invalid_cards.txt");
						outputFile.println(invalidNumbers);
						//Catches FileNotFoundException.
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				//Closes "invalid_cards.txt" output file.
				outputFile.close();		
			}
			//Closes input file.
			inputFile.close();
		}
		//Catches FileNotFoundException.
		catch (FileNotFoundException e)
		{
			System.out.println("File name: " + e.getMessage());			
		}
		//Catches NullPointerException.
		catch (NullPointerException e)
		{
			System.out.println("File name: " + e.getMessage());			
		}
	}
}
