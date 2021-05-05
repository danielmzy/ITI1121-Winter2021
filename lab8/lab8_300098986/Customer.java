public class Customer{
  private int arrivalTime;
  private int initialNumberOfItems;
  private int numberOfItems;
  private static final int MAX_NUM_ITEMS = 25;
  
  public Customer(int arrivalTime){
    this.arrivalTime = arrivalTime;
    numberOfItems = (int)((MAX_NUM_ITEMS - 1) * Math.random() + 1);
    initialNumberOfItems = numberOfItems;
   
  }
  
  public int getArrivalTime(){
    return arrivalTime;
      
  }
  
  public int getNumberOfItems(){
    return numberOfItems;
  }
  
  public int getNumberOfServedItems(){
    return initialNumberOfItems - numberOfItems;
  }
  
  public void serve(){
    numberOfItems--;
  }
}