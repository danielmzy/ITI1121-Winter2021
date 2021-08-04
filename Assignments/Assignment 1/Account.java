
public class Account {
	
	// creating the fields
	Customer customer; 
	double balance;
	int accountNumber;
		
	int i = 20; // assigning a variable
    Transaction[] transactions = new Transaction[i]; // setting the size of the array
    
    //Constructor for the Account
    public Account(Customer customer, double balance, int accountNumber, Transaction [] transactions){
    	this.customer = customer;
    	this.balance = balance;
    	this.accountNumber = accountNumber;
    	this.transactions = transactions;
    }
    
    
    // the method doubles the size of the array
    public void reallocate()
    {
        if(transactions.length == 20)
            transactions = new Transaction[i *2];
    }
    
    
    // getter for balance
	public double getBalance() {
		return balance;
	}
	
	//getter for customer
	public Customer getCustomer () {
		return customer;
	}
	
	// setter for customer
	public void  setCustomer (Customer customer) {
		this.customer = customer;
	}
	
	
	@Override
	// method to show the String representation of the data fields
	public String toString () {
		return "The account belongs to :" + customer + "," + accountNumber + "and balance:" + balance + 
				"followint are the transactions: " + transactions ;
	}
	
	
	}
	
	

