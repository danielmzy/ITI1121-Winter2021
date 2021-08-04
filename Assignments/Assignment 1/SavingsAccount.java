
public class SavingsAccount extends Account {
	
	// implementing the constructor
	public SavingsAccount (Customer customer, double balance, int accountNumber, Transaction [] transactions) {
		super(customer, balance, accountNumber, transactions);
	}
	
	
	//method to get deposit
	public void deposit(double deposit)
    {
        balance = balance + deposit; 				//add the amount to balance	
    }
    
	//method to withdraw
    public void withdraw(double withdraw)
    {
        balance = balance - withdraw;		 		//deduct the amount withdrawn from balance
    }
    
    //method to add interest to account
    public void addInterest(double interest)
    {
        balance = balance + (interest*balance);		// add the interest to balance
    }
}
