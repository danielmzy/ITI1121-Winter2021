
public class Adult extends Customer{
	
	// assigning the values for the following variables

	double SAVINGS_INTEREST = 0.03;
	double CHECK_INTEREST = 0.01;
	double CHECK_CHARGE = 0.03;
	double OVERDRAFT_PENALTY = 25.0;
	
	// constructor
	public Adult (String name, int age, String customerNumber, String address, String telephoneNumber){
		super(name, age, customerNumber, address, telephoneNumber);
	}

	// getter to get interest

	public final double getSavingsInterest(){
		return SAVINGS_INTEREST;
	}
	
	// getter to checking account interest

	public final double getCheckInterest(){
		return CHECK_INTEREST;
	}
	
	// getter to check charge

	public final double getCheckCharge() {
		return CHECK_CHARGE;
	}
	
	// getter to access overdraft penalty

	public final double getOverdraftPenalty(){
		return OVERDRAFT_PENALTY;
	}
	
	
	



}
