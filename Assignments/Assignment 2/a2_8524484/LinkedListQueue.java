
public class LinkedListQueue implements Queue{
	
	//instance variables
	private Node head;
	private Node tail;
	
	//adds an element to the end of the queue
	public void enqueue( Job o) {
		Node newNode;						//creates the new node
		newNode = new Node(o, null);		
		
		if(tail == null){				// when the queue is  empty, the new node is both head and tail
			head = tail = newNode;
		}else{
			newNode = tail.getNext();  	//otherwise, that node next to tail is new node
			tail = newNode;				//tail becomes new node
		}
		
	}
	
	//removing an element from the start of the queue
	public Job dequeue() {
		Job result = head.getData();	// get the data stored in the head
		
		// only one node in the queue
		if(head != null & head.getNext() == null){ 
			 head = tail = null;		//scrubbing memory
		} else { 
			head = head.getNext();		// the next node to head become the head
		}
		
		return result;					//returns the data
		
	}
	
	//checks if the queue is empty
	public boolean isEmpty(){
		return head == null; //returns true if it is
	}
	
	//removes everything from the queue
	public void clear() {
			
		// while queue is not empty
		while (!isEmpty()){ 
		head = null;		//scrub memory
		head = head.getNext();	// reassign head
		}
		
	}

}
