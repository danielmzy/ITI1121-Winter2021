
public class Transaction {
	int customerNumber;
	String transactionType;
	double amount;
	String date;
	String fees;
	
	public Transaction(int customerNumber, String transactionType, double amount, String date, String fees) {
		this.customerNumber = customerNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.fees = fees;
	}

	public void processTran() {
		System.out.println(transactionType + ", " + amount + ", " + date + ", " + fees);
	}
	

}


