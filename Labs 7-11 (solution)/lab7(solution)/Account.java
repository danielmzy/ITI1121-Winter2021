public class Account {
	
	private double balance = 0.0;
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
		// exercise output specifies this format instead of $0.00 which is a little strange but whatever
		System.out.printf("new balance=%.1f$\n", balance);
	}
	
	public void withdraw(double amount) {
		if (amount > balance) throw new NotEnoughMoneyException(amount, balance);
		balance -= amount;
		System.out.printf("new balance=%.1f$\n", balance);
	}
	
	// public static void main(String[] args) {
	// 	Account account = new Account();
	// 	account.deposit(10.37);
	// 	try {
	// 		account.withdraw(15.37);
	// 	} catch(NotEnoughMoneyException e){
	// 		System.out.println("############## 15.37" + e.getAmount());
	// 	}
	// }
}
