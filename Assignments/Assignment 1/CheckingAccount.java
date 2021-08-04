
public class CheckingAccount extends Account{
	// implementing the constructor
		public CheckingAccount (Customer customer, double balance, int accountNumber, Transaction [] transactions) {
			super(customer, balance, accountNumber, transactions);
		}
		
		
		// depositing in the account
		public void deposit(double deposit)
	    {
	        balance = balance + deposit; 	//add the amount to balance	
	    }
	    
		//withdrawing from account
	    public void withdraw(double withdraw)
	    {
	        balance = balance - withdraw; 	//deduct the amount withdrawn from balance
	    }
	    
	    //adding interest to the banalce in account
	    public void addInterest(double interest)
	    {
	        balance = balance + (interest*balance); // add the interest to balance
	    }

}
