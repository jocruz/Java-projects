// ISE 208 
// John Cruz
// 108605747
import java.util.ArrayList;

public abstract class BankCard {
	private String name;
	protected long number;
	protected double balance;
	protected ArrayList<Transaction> transHolder = new ArrayList<Transaction>();
	
	public BankCard(String n, long num) {
		name = n;
		number = num;
		balance = 0;
	}
	
	public double balance() {
		return balance;
	}
	
	public long number() {
		return number;
	}
	
	public String cardHolder() {
		return name;
	}
	
	private boolean validateNumber() {
		int firstTwo = (int)(number / 100000000000000l);
		return (firstTwo >= 84 && firstTwo <= 89);
	}
	
	public abstract boolean addTransaction(Transaction t);
	
	public abstract void printStatement();
	
	public String toString() {
		return "Card #" + number + "     Balance:" + balance;
	}
	

}
