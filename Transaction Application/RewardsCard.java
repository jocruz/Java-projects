// ISE 208 
// John Cruz
// 108605747

public class RewardsCard extends CreditCard {
	
	protected int points;
	
	public RewardsCard(String n, long num, int exp, double creditLimit) {
		super(n, num, exp, creditLimit);
		points = 0;

		if(!validateNumber())
			System.out.println("Error: invalid card number.");
	}
	
	public RewardsCard(String n, long num, int exp) {
		super(n, num, exp, 500);
		if(!validateNumber())
			System.out.println("Error: invalid card number.");
		points = 0;
	}
	
	public int rewardsPoints() {
		return points;
	}
	
	public boolean redeemPoints(int amt) {
		if(amt < points) {
			this.balance -= (amt / 100);
			points -= amt;
			transHolder.add(new Transaction("redemption", "ISEBank", (0 - (amt / 100))));
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private boolean validateNumber() {
		int firstTwo = (int)(number / 100000000000000l);
		return (firstTwo >= 86 && firstTwo <= 87);
	}
	
	public boolean addTransaction(Transaction t) {
		if(t.type() == "debit" && t.amount() <= availableCredit()) {
			System.out.println("Transaction accepted.");
			this.balance += t.amount();
			this.transHolder.add(t);
			points += (t.amount() * 100);
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
		return super.toString() + "   Rewards Points: " + points;
	}
	
	public void printStatement() {
		System.out.println(toString());
		for(int i=0; i<transHolder.size(); i++) {
			System.out.println("Transaction #" + i + ": " + transHolder.get(i));
		}
	}

}
