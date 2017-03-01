
/*
	A program that reads in investment amount, annual interest rate, and number of years, and displays the future investment value using the following formula:
	futureInvestmentValue = investmentAmount x (1 + monthlyInterestRate)^numberOfYears*12
	where "^" is the exponent operator.
	For example, if you entered amount 1000, annual interest rate 3.25%, and number of years 1, the future investment value is 1032.98.
*/


import java.util.Scanner;

public class FutureInvestmentValue {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter the investment amount: ");		
		double investmentAmount = input.nextDouble();
		
		System.out.print("Enter the annual interest rate: ");		
		double interest = input.nextDouble();
		
		double monthlyInterest = (interest/12) * 0.01;
		
		System.out.print("Enter the number of years: ");		
		double years = input.nextDouble();
		//investmentAmount * Math.pow(
		double futureInvestmentValue = investmentAmount * Math.pow(( 1 + monthlyInterest),(years*12)) ;
		
		System.out.print("The future investment value is $" + String.format("%.2f",futureInvestmentValue));



	}

}
