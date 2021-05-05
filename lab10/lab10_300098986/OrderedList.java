
public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        // Your code here.
        head = new Node(null, null, null); 
        head.next = head;
        head.previous = head;
    }

    // Calculates the size of the list

    public int size() {
        // head is always present.
    	Node x = head;
    	int numberCount = 0;
    	while ( x.next != head ) {
    	    x = x.next;
    	    numberCount++;
    	}
    	return numberCount;
    }


    public Object get( int pos ) {

        if (pos < 0) { 
            throw new IndexOutOfBoundsException(Integer.toString(pos)); 
        }

        Node x = head.next; 

        for (int i = 0; i < pos; i++) { 
            if (x.next == head) { 
                throw new IndexOutOfBoundsException(Integer.toString(pos)); 
            } else { 
                x = x.next; 
            }
        }

        return x.value; 
    
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {

        if (o == null) { 
            throw new IllegalArgumentException("null"); 
        }
        
        if (head.next == head) { 
            head.next = new Node(o, head, head.next); 
        } else { 
            Node x = head; 

            while(x.next != head && x.next.value.compareTo(o) < 0) { 
                x = x.next; 
            }

            Node y = x.next; 
            x.next = new Node(o, x, y); 
            y.previous = x.next; 
        }

        return true; 

    }

    //Removes one item from the position pos.

    public void remove( int pos ) {

    	if ( pos < 0 ) 
    	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    	Node x = head.next;
    	for ( int i = 0; i < pos; i++ ) // traversing pos nodes
    		if ( x.next == head )
    		    throw new IndexOutOfBoundsException(Integer.toString(pos));
    		else
    		    x = x.next;
    	    
    	    Node delete = x;  // the node to delete
    	    x = x.previous; // x designates de previous node

    	    Node y = delete.next; // y designates the node that follows
    	    x.next = y;
    		y.previous = x;

    	    delete.value = null;
    	    delete.next = null;
    	    delete.previous = null;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge(OrderedList other) { 

        Node x = head.next; 
        Node y = other.head.next; 

        while(y != other.head) { 
            if (x == head) { 
                x.next = new Node(y.value, x, x.next); 
                x = x.next; 
                y = y.next; 
            } else if (y.value.compareTo(x.value) < 0) { 
                x.previous = new Node(y.value, x.previous, x); 
                x.previous.previous.next = x.previous; 
                y = y.next; 
            } else if (x.next == head) {
            	x.next = new Node( y.value, x, head );
            	x = x.next;
            	y = y.next;
            } else {
            	x = x.next;
            }
        }

    }

}