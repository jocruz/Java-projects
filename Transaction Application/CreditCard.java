// ISE 208 
// John Cruz
// 108605747
public class CreditCard extends BankCard {

	private int expiration;
	protected double creditLimit;
	
	public CreditCard(String n, long num, int exp, double lim) {
		super(n, num);
		expiration = exp;
		creditLimit = lim;
		
		if(!validateNumber() && !(this instanceof RewardsCard))
			System.out.println("Error: invalid card number.");
		creditLimit = lim;
	}
	
	public CreditCard(String n, long num, int exp) {
		super(n, num);
		expiration = exp;
		creditLimit = 500;
		if(!validateNumber() && !(this instanceof RewardsCard))
			System.out.println("Error: invalid card number.");
	}
	
	public double limit() {
		return creditLimit;
	}
	
	public double availableCredit() {
		return creditLimit - balance();
	}
	
	public int expiration() {
		return expiration;
	}
	
	private boolean validateNumber() {
		int firstTwo = (int)(number / 100000000000000l);
		return (firstTwo >= 84 && firstTwo <= 85);
	}
	
	public boolean addTransaction(Transaction t) {
		if(t.type() == "debit" && t.amount() <= availableCredit()) {
			System.out.println("Transaction accepted.");
			this.balance += t.amount();
			this.transHolder.add(t);
			return true;
		}
		else if(t.type() == "debit" && t.amount() > availableCredit()) {
			System.out.println("Transaction declined.");
			return false;
		}
		else if(t.type() == "credit") {
			System.out.println("Transaction accepted.");
			this.balance += t.amount();
			this.transHolder.add(t);
			return true;
		}
		else {
			System.out.println("Transaction declined.");
			return false;
		}
	}
	
	public String toString() {
		return ("Cardholder name: " + cardHolder() + "   Card number: " + number() + "   Expiration Date: " + expiration() + "   Current Balance: " + balance());
	}
	
	public void printStatement() {
		System.out.println(toString());
		for(int i=0; i<transHolder.size(); i++) {
			System.out.println("Transaction #" + i + ": " + transHolder.get(i));
		}
	}
}
