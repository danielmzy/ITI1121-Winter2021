

public class Cashier {
	
	private ArrayQueue<Customer> queue = new ArrayQueue<Customer>();
	private Customer currentCustomer;
	private int totalCustomerWaitTime = 0;
	private int customersServed = 0;
	private int totalItemsServed = 0;
	
	public void addCustomer(Customer c) {
		queue.enqueue(c);
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
	public void serveCustomers(int currentTime) {
		if (queue.isEmpty() && currentCustomer == null) {
			return;
		}
		if (currentCustomer == null) {
			currentCustomer = queue.dequeue();
			totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
		}
		currentCustomer.serve();
		totalItemsServed++;
		if (currentCustomer.getNumberOfItems() == 0) {
			currentCustomer = null;
			customersServed++;
		}
	}
	
	public int getTotalCustomerWaitTime() {
		return totalCustomerWaitTime;
	}
	
	public int getTotalCustomersServed() {
		return customersServed;
	}
	
	public int getTotalItemsServed() {
		return totalItemsServed;
	}
	
	@Override
	public String toString() {
		return String.format("wait time: %d customers served: %d times served: %d%n", totalCustomerWaitTime, customersServed, totalItemsServed);
	}
	
	// public static void main(String[] args) {
	//
	// 	Cashier cashier = new Cashier();
	// 	Customer customer = new Customer(5);
	// 	cashier.addCustomer(customer);
	//
	// 	System.out.println("Queue size with one customer 1 " + cashier.getQueueSize());
	//
	// 	int items = customer.getNumberOfItems();
	//
	// 	for (int i = 0; i < items; i++) {
	// 		cashier.serveCustomers(10);
	// 	}
	//
	// 	System.out.println("Queue size after finishing to serve all items 0 " + cashier.getQueueSize());
	// 	System.out.println("Total number of items served after one customer " +  items + " " + cashier.getTotalItemsServed());
	// 	System.out.println("Total customers served after one customer 1 " + cashier.getTotalCustomersServed());
	// 	System.out.println("Total wait time after one customer " + 5 + cashier.getTotalCustomerWaitTime());
	// }
}
