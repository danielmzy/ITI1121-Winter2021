
abstract public class Customer {
// declaring variables
	String name;
	String address;
	int age;
	String telephoneNumber;
	String customerNumber;
	
	// constructor
	
	public Customer(String name, int age, String customerNumber, String address, String telephoneNumber){
	      this.name = name;
	      this.age = age;
	      this.customerNumber = customerNumber;
	      this.address = address;
	      this.telephoneNumber = telephoneNumber;
	}
	//access to name
	public String getName() {
		return name;
	}
	
	// access to address
	public String Address() {
		return address;
	}
	
	//access to age
	public int getAge() {
		return age;
	}
	
	//access to telephone number
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	//access to customer number
	public String getCustomerNumber() {
		return customerNumber;
	}
	
	//setter for name
	public void setName(String name){
		this.name = name;
	}
	
	//setter for address
	public void setAddress(String address){
		this.address = address;
	}
	
	//setter for age
	public void setAge(int age) {
		this.age = age;
	}
	
	//setter for customer number
	public void setCustomerNumber (String customerNumber){
		this.customerNumber = customerNumber;
	}
	
	// setter for telephone number
	public void setTelephoneNumber( String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	// the abstract methods to obtain the respective costs
	abstract public double getSavingsInterest(); 
	
	abstract public double getCheckInterest();
	
	abstract public double getCheckCharge();
	
	abstract double getOverdraftPenalty();
	
	public String customerInfo() {
        return "Name: " + name + "\n" + "Age: " + age + "\n" + "Customer Number: " + customerNumber + "\n"
                + "Address" + address + "\n" + "Telephone No.: " + address + "\n";
    }
}
