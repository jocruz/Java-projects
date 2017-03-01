// ISE 208 
// John Cruz
// 108605747
public class PrepaidCard extends BankCard {

	public PrepaidCard(String n, long num, double startBal) {
		super(n, num);

		if(!validateNumber())
			System.out.println("Error: invalid card number.");
		
		balance = startBal;
	}
	
	public PrepaidCard(String n, long num) {
		super(n, num);
		
		if(!validateNumber())
			System.out.println("Error: invalid card number.");
		
		balance = 0;
	}
	
	public boolean addTransaction(Transaction t) {
		if(t.type() == "debit" && t.amount() <= balance()) {
			System.out.println("Transaction Accepted.");
			balance -= t.amount();
			transHolder.add(t);
			return true;
		}
		else if(t.type() == "debit" && t.amount() > balance()) {
			System.out.println("Transaction Declined.");
			return false;
		}
		else if(t.type() == "credit") {
			System.out.println("Transaction Accepted.");
			balance -= t.amount();
			transHolder.add(t);
			return true;
		}
		else {
			System.out.println("Transaction Declined.");
			return false;
		}
	}

	public boolean addFunds(double amt) {
		if(amt > 0) {
			balance += amt;
			transHolder.add(new Transaction("top-up", "User payment", amt));
			return true;
		}
		return false;
	}
	
	private boolean validateNumber() {
		int firstTwo = (int)(number / 100000000000000l);
		return (firstTwo >= 88 && firstTwo <= 89);
	}
	
	public String toString() {
		return "Card Number: " + number() + "   Balance: " + balance();
	}
	
	public void printStatement() {
		System.out.println(toString());
		for(int i=0; i<transHolder.size(); i++) {
			System.out.println("Transaction #" + i + ": " + transHolder.get(i));
		}

	}
}
