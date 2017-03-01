
/*(Printing prime numbers between 2 and 10000) Write a program that prints all the prime numbers between 2 and 10000, inclusively. 
Display 20 prime numbers per line*/

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		int i = 2;
		int count = 0;
	
		while (i <= 10000) {
			
			if (isPrime(i) == true || i == 2) {
				System.out.print(i + " ");
				i ++;
				count ++;
				
				if (count % 20 == 0) {
					System.out.print("\n");
				}
			}
			
			else
				i ++;
		}

	}
	
	public static boolean isPrime(int n) {

	    if (n % 2==0) return false;

	    for (int x = 3; x * x <= n; x += 2) {
	    	
	        if(n % x == 0)
	            return false;
	    }
	    return true;
	}
}
	

