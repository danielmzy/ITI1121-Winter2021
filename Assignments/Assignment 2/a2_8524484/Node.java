
public  class Node {
	
	//instance variables
	private Job data;
	private Node next;
	
	//contructors
	public Node(Job data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public Node (Job data) {
		this.data = data;
		this.next = null;
	}
	
	//accessor----- getting private variable data
	public Job getData(){
		return data;
	}
	
	//setter ------setting private variable data
	public void  setData(Job data) {
		this.data = data;
		
	}
	
	//accessor------getting private variable next
	public Node getNext() {
		return next;
	}
	
	
	//setter------setting private variable next
	public void  setNext(Node next) {
		this.next = next;
	}

	

}
