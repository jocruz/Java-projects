import java.util.Scanner;

public class LeapYear {

	public static boolean isLeapYear(int year)
	{
		if( year % 400 == 0 ) //divided by 400
		{
			return true;//boolean
		}

		if(( year % 4 == 0 )&&(year % 100 != 0))//divided by 4 evenly but not by evenly by 100. . .
		{
			return true;
		}
		else // if not return false. . .
		{
			return false;
		}
	}
	
	public static int dayNum(int month, int day, int year) {
		int dayNum = 31 * (month - 1) + day;
		//If the month is after February (2), then subtract (4 * month + 23)/10 from dayNum.
		if(month > 2) {
			dayNum -= ((4*month) + 23)/10;
		}
		
		//If the year is a leap year and the date is after February 29, add 1 to dayNum.
		if(year%4 == 0 || (year%4 == 0 && year%100 != 0)) {
			if(month >= 3) {
				dayNum++;
			}
		}
		return dayNum;
	}
	
	public static String dayOfWeek(int mon, int day, int year) {
		int q = day;
		int m;
		if(mon < 3) {
			m = mon + 12;
			year --;
		}
		else
			m = mon;
		
		int j = year /100;
		int k = year % 100;
		
		int h = (q + ((26*(m+1))/10) + k + (k/4) + (j/4) + 5*j) % 7; 
		
		if(h==0)
			return "Saturday";
		else if(h==1)
			return "Sunday";
		else if (h==2)
			return "Monday";
		else if (h==3)
			return "Tuesday";
		else if (h==4)
			return "Wednesday";
		else if(h==5)
			return "Thursday";
		else
			return "Friday";
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the month: ") ;
		int month = input.nextInt();
		System.out.print("Please enter the day: ");
		int day = input.nextInt();
		System.out.print("Please enter the year: ");
		int year = input.nextInt();
		
		if(month > 12 || month < 1) {
			System.out.println("Invalid month");
			System.exit(0);
		}
		if(day < 1 || day > 31) {
			System.out.println("Day " + day + " is invalid!");
			System.exit(0);
		}
		if(year < 0) {
			System.out.println("Year " + year + " is invalid!");
			System.exit(0);
		}
		boolean j = isLeapYear(year);
		
		String monthString;
		if(month == 1)
			monthString = "January";
		else if(month == 2)
			monthString = "February";
		else if(month==3)
			monthString = "March";
		else if(month==4)
			monthString = "April";
		else if(month==5)
			monthString = "May";
		else if(month==6)
			monthString = "June";
		else if(month==7)
			monthString = "July";
		else if(month==8)
			monthString = "August";
		else if(month==9)
			monthString = "September";
		else if(month==10)
			monthString = "October";
		else if(month==11)
			monthString = "November";
		else
			monthString = "December";
		

		if((month==4 || month == 7 || month == 9 || month == 11) && day > 30) {           
			System.out.println("Day " + day + " is invalid for month " + monthString);
			System.exit(0);
		}
		
		if(month==2 && !isLeapYear(year) && day > 28) {
			System.out.println("Day " + day + " is invalid for month " + monthString + " on the year " + year);
			System.exit(0);
		}
		
		System.out.println("\nLeap Year status is " + j);//print
		System.out.println("The day is " + dayNum(month,day,year));
		System.out.println(monthString + " " + day + ", " + year + ", is a " + dayOfWeek(month,day,year));
		
	}
	
	
}
