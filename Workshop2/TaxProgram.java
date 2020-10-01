/**********************************************
Workshop #2
Course: JAC444NCC - Fall2020
Last Name: Nguyen
First Name: Pham Gia Bao
ID: 125433177
Section: NCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: September 30th 2020
**********************************************/
import java.util.*;
public class TaxProgram {
	public static void main(String[] args) {
		
		int choice;
		Scanner input = new Scanner(System.in);
		do {
		
			System.out.println("---Tax Program Menu---");
			System.out.println("1. Caculate your personal income tax");
			System.out.println("2. Print the tax tables for taxable incomes");
			System.out.println("3. Quit");
			System.out.print("Your choice: ");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				IncomeTax personalTax =new IncomeTax();
				System.out.println("---Personal Income IncomeTax Program---");
				System.out.println("Chose Your Income Status:");
				System.out.println("0 - single filer");
				System.out.println("1- married jointly or qualifying widow(er)");
				System.out.println("2- married separately");
				System.out.println("3 - head of household");
				
				System.out.print("Your status: ");
				int st = input.nextInt();
				System.out.print("Your income: ");
				int income = input.nextInt();
				
				switch(st) {
				case 0:
					personalTax.setFilingStatus(personalTax.SINGLE_FILER);
					personalTax.setTaxableIncome(income);
					System.out.printf("IncomeTax is: $%.2f%n%n", personalTax.getIncomeTax());
					
					break;
				case 1:
					personalTax.setFilingStatus(personalTax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER);
					personalTax.setTaxableIncome(income);
					System.out.printf("IncomeTax is: $%.2f%n%n", personalTax.getIncomeTax());
					
					break;
				case 2:
					personalTax.setFilingStatus(personalTax.MARRIED_SEPARATELY);
					personalTax.setTaxableIncome(income);
					System.out.printf("IncomeTax is: $%.2f%n%n", personalTax.getIncomeTax());
					
					break;
				case 3:
					personalTax.setFilingStatus(personalTax.HEAD_OF_HOUSEHOLD);
					personalTax.setTaxableIncome(income);
					System.out.printf("IncomeTax is: $%.2f%n%n", personalTax.getIncomeTax());
					break;
				default:
			        System.out.printf(st + " is  Invalid Status!!! Please Select Another Option.%n%n");	
			
				}
				break;
			case 2:
				System.out.print("---Print the tax tables---");
				// Create two tax objects
				IncomeTax tax2001 = new IncomeTax();
				IncomeTax tax2009 = new IncomeTax(); // Current Year

				// IncomeTax rates for 2001
				double[] rates2001 = {15, 27.5, 30.5, 35.5, 39.1};
				tax2001.setRates(rates2001);

				// The 2001 brackets for each rate for all the filing statuses
				int[][] brackets2001 = {
					{27050, 65550, 136750, 297350},  // Single filer
					{45200, 109250, 166500, 297350}, // Married jointly
																// -or qualifying widow(er)
					{22600, 54625, 83250, 148675},  	// Married separately
					{36250, 93650, 151650, 297350} 	// Head of household
				};
				tax2001.setBrackets(brackets2001);

				// Print tax tables for 2001 and 2009
				final double FROM = 50000;		// Start table taxable income range at $50,000
				final double TO = 60000;		// End table taxable income range at $60,000
				final double INTERVAL = 1000;	// Increase each row by $1000

				System.out.println(
					"\n2001 tax tables for taxable income from $50,000 to $60,000");
				print(tax2001, FROM, TO, INTERVAL);
				
				System.out.println(
					"\n2009 tax tables for taxable income from $50,000 to $60,000");
				print(tax2009, FROM, TO, INTERVAL);
				System.out.println();
					break;
			case 3: 
				System.out.println("---Thank you for using program---");
					break;
			default:
			        System.out.printf(choice + " is not a valid Menu Option! Please Select Another.%n%n");		
			}
		
			
		}while(choice !=3);
		
		input.close();
		
	}

	/** Display taxable for  taxable income with specified range and interval */
	public static void print(IncomeTax incomeTax, double from, double to, double interval) {
		// Print header
		System.out.println(
			"---------------------------------------------------------------------\n" +
			"Taxable       Single      Married Joint       Married        Head of\n" +
			"Income                    or Qualifying       Separate       a House\n" +
			"                          Widow(er)\n" +
			"---------------------------------------------------------------------");
		// Print Data
		for (double taxableIncome = from; 
			  taxableIncome <= to; taxableIncome += interval) {
			incomeTax.setTaxableIncome(taxableIncome);
			System.out.printf("%-13.0f", taxableIncome);
			incomeTax.setFilingStatus(incomeTax.SINGLE_FILER);
			System.out.printf("%8.2f", incomeTax.getIncomeTax());
			incomeTax.setFilingStatus(incomeTax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER);
			System.out.printf("%15.2f", incomeTax.getIncomeTax());
			incomeTax.setFilingStatus(incomeTax.MARRIED_SEPARATELY);
			System.out.printf("%18.2f", incomeTax.getIncomeTax());
			incomeTax.setFilingStatus(incomeTax.HEAD_OF_HOUSEHOLD);
			System.out.printf("%15.2f\n", incomeTax.getIncomeTax());
		}
	}
}
