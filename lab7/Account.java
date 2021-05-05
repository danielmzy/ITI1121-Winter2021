public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("new balance=" + getBalance() + "$");
    }

    public void withdraw(double amount) throws NotEnoughMoneyException {
        if (amount > getBalance()) {
            throw new NotEnoughMoneyException(amount, getBalance());
        } else {
            this.balance -= amount;
            System.out.println("new balance=" + getBalance() + "$");

        }
    }

    public double getBalance() {
        return this.balance;
    }

}
