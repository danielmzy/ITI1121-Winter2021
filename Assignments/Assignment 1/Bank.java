//Bank.java
/*
 * Bank.java
 *
 * Created on July 21, 2004, 1:23 AM
 */

public class Bank {

    private Account[] accounts;
    private int size;
    private int capacity;

    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;    
    private static final int SENIOR = 0;
    private static final int ADULT = 1;    
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;



    /** Creates a new instance of Bank */
    public Bank(Account[] accounts, int size, int capacity) {
        this.accounts = accounts;
        this.size = size;
        this.capacity = capacity;
    }


    // Getters //

    public Account[] getAccounts() {
        return accounts;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public static int getSAVINGS() {
        return SAVINGS;
    }

    public static int getCHECKING() {
        return CHECKING;
    }

    public static int getSENIOR() {
        return SENIOR;
    }

    public static int getSTUDENT() {
        return STUDENT;
    }

    public static int getInitCapacity() {
        return INIT_CAPACITY;
    }

    public static int getADULT() {
        return ADULT;
    }


    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */

   /*public String addAccount(String customerName, String customerAddress, int customerAge, String customerPhoneNumber,
                                int customerType, int typeAccount){

        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < accounts.length ; j++) {
                Account newAccount = new Account();

            }


        }

    }*/
    
    
    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */

    public String makeDeposit(String accountNumber, double amount){

        if (amount > 0){
            for (int account = 0; account < getAccounts().length; account++) {
                if (getAccounts()[account].getAccountNumber().equals(accountNumber)) {
                    accountInfo = getAccounts()[account].toString();
                }
            }

            amount =  + amount;
            System.out.println(amount + " has been deposited in your account");
        }
        else{
            System.out.prinln("You can't deposit a negative amount");
        }
        return getBalance();
    }
     
    
    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */    
    public String makeWithdrawal(String accountNumber, double amount){
        int index = find(accountNumber);
        accounts[index].withdrawal(amount);
        return Double.toString(accounts[index].getBalance()); 
 
          if(amount <= 0 && amount > balance){
          System.out.println("Withdrawal impossible");
        }
        else{
          balance = balance - amount;
        }
        return balance;
    }

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */    

    public String getAccount(String accountNumber) {
        String accountInfo = null;

        for (int account = 0; account < getAccounts().length; account++) { // Loops through bank
            if (getAccounts()[account].getAccountNumber().equals(accountNumber)) { // Loops through individual accounts
                accountInfo = getAccounts()[account].toString();
            }
        }
        return accountInfo;
    }

    
    
    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
     */    

    private int find(String accountNumber) {
        int TRUE = 0;
        for (int account = 0; account < getAccounts().length; account++) { // Loops through bank
            if (getAccounts()[account].getAccountNumber().equals(accountNumber)) { // Loops through individual accounts
                return TRUE;
            }
        }
        return -1;
    }



 /***********************************************************************



    /** You need to create private method : Allocate to allocate a new array to hold the transactions. */
    private void reallocate(){
        if(capacity - size <= 5){
            capacity *= 2;
        }
    }
    
}
