public class Cashier {
        
        private Queue<Customer> queue;
        private Customer currentCustomer;
        
        private int customerWaitTime,itemsServed,customersServed;
        
        public Cashier(){
                queue = new ArrayQueue<Customer>();
                
                customerWaitTime = 0;
                itemsServed = 0;
                customersServed = 0;
        }
        
        public void addCustomer(Customer c) {
                queue.enqueue(c);
        }
        public void serveCustomers(int currentTime){
                if(currentCustomer == null && queue.isEmpty()){//no customers in line
                        return;
                }
                if(currentCustomer == null){
                        currentCustomer = queue.dequeue();
                        customerWaitTime += currentTime - currentCustomer.getArrivalTime();
                        customersServed++;
                }
                currentCustomer.serve();
                //current customer has no more items
                if(currentCustomer.getNumberOfItems() == 0){
                        itemsServed += currentCustomer.getNumberOfServedItems();
                        currentCustomer = null;
                }
        }
        
        public int getQueueSize(){
                return queue.size();
        }
        
        public int getTotalCustomerWaitTime(){
                return customerWaitTime;
        }
        public int getTotalItemsServed(){
                return itemsServed;
        }
        public int getTotalCustomersServed(){
                return customersServed;
        }
        public String toString(){
                StringBuffer results = new StringBuffer();
                
                results.append("The number of customers served: ");
                results.append(customersServed);
                results.append("\n");
                results.append("The average number of items served: ");
                results.append(itemsServed/customersServed);
                results.append("\n");
                results.append("Total customer wait time (in seconds) = " );
                results.append(customerWaitTime/customersServed);
                results.append("\n");
                
                return results.toString();
                
                
        }

}