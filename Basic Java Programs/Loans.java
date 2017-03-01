
/*Comparing loans with various interest rates) 
Write a program that lets the user enter the loan amount and loan period in number of years and 
displays the monthly and total payments for each interest rate starting from 5% to 8%, with an increment of 1/8. 
Suppose you enter the loan amount 10,000 for five years; display a table as follows:

Loan Amount: 10000
Number of Years: 5

Interest Rate	Monthly Payment	Total Payment
5% 				188.71 			11322.74
5.125% 			189.28 			11357.13
5.25% 			189.85			11391.59
...
8.0% 			202.76			12165.83

The formulas are:
monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
totalPayment = monthlyPayment * numberOfYears * 12;*/

import java.util.Scanner;

public class Loans {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the loan amount: ");
		double loanAmount = input.nextDouble();
		
		System.out.print("Enter the loan period in years: ");
		double numberOfYears = input.nextDouble();
		
		System.out.println("\n" + "Loan Amount: " + loanAmount);
		System.out.println("Number of Years: " + numberOfYears);
		
		System.out.println("\n" + "Interest Rate" + "\t" + "Monthly Payment" + "\t" + "Total Payment");
		
		double annualInterestRate = 0.05;
		
		while (annualInterestRate < 0.08125) {
			double monthlyInterestRate = annualInterestRate/12;
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
			double totalPayment = (monthlyPayment * numberOfYears * 12);
			System.out.println(String.format("%.3f", (monthlyInterestRate * 100)) + "%" + "\t\t" + String.format("%.2f",monthlyPayment) + "\t\t" + String.format("%.2f",totalPayment));
			annualInterestRate += 0.00125;
		}
	}

}
