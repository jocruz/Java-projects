

/*Calculating tips: write a program that reads an amount and prints the tip (15%) and the total amount after adding the tip to the original bill. 
If the amount is under $30, the tip is fixed to $5. 

Here is a run:

Enter the subtotal: $15.69 (Enter)

The gratuity is: $5 and the total is $20.69*/



import java.util.*;

public class Gratuity {

	public static void main(String[] args) {
		Scanner cat = new Scanner(System.in);
		
		System.out.print("Enter the amount: ");
		double amount = cat.nextDouble();
		
		double tip = amount * 0.15;
		
		if (amount < 30) {
			double total = amount + 5.0;
			System.out.println("The gratuity is $5 and the total is $" + total);
		}
		
		else {
			double total = tip + amount;
			System.out.println("The gratuity is " + tip + "and the total is $" + String.format("%.2f",total));
		}
		
		

	}

}
