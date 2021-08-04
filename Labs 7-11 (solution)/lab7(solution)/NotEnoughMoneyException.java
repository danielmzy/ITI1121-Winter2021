public class NotEnoughMoneyException extends IllegalStateException {
	
	private double amount;
	private double balance;
	
	NotEnoughMoneyException(double amount, double balance) {
		super(String.format("$%f cannot be withdrawn from $%f.", amount, balance));
		this.amount = amount;
		this.balance = balance;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getMissingAmount() {
		return amount - balance;
	}
}
