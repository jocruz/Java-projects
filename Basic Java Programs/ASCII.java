
/*	
	(Finding the character of an ASCII code) Write a program that receives an ASCII code (an integer between 0 and 127) and displays its character. 
	For example, if the user enters 97, the program displays character a. 
*/


import java.util.Scanner;

public class ASCII {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter an ASCII value: ");
		
		int i = input.nextInt();
		
		if (i >= 0 && i <= 127) {
			Character.toString ((char) i);
	
			System.out.println("The character code for the ASCII value of " + i + " is '" + (char) i + "'");
		}
		
		else
			System.out.print(i + " is an invalid value");
		
	}

}

