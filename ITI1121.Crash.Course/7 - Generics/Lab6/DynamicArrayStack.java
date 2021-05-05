public class DynamicArrayStack<E> implements Stack<E> {
	
	// Instance variables
	
	private E[] elems;  // Used to store the elements of this ArrayStack
	private int top;    // Designates the first free cell
	private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement
	
	@SuppressWarnings( "unchecked" )
	
	// Constructor
	public DynamicArrayStack( int capacity ) {
		elems = (E[]) new Object[capacity];
		tryEnlarge();
		top = 0;
	}
	
	// Gets current capacity of the array
	public int getCapacity() {
		return elems.length;
	}
	
	// Returns true if this DynamicArrayStack is empty
	public boolean isEmpty() {
		return ( top == 0 );
	}
	
	// Returns the top element of this ArrayStack without removing it
	public E peek() {
		return elems[ top-1 ];
	}
	
	@SuppressWarnings( "unchecked" )
	
	// Removes and returns the top element of this stack
	public E pop() {
		E saved = elems[ --top ];
		
		elems[ top ] = null; // scrub the memory!
		tryReduce();
		return saved;
	}
	
	@SuppressWarnings( "unchecked" )
	
	// Puts the element onto the top of this stack.
	public void push( E element ) {
		tryEnlarge();
		elems[ top++ ] = element;
	}
	
	@SuppressWarnings( "unchecked" )
	
	public void clear() {
		elems = (E[]) new Object[DEFAULT_INC];
		top = 0;
	}
	
	@SuppressWarnings( "unchecked" )
	private void tryEnlarge() {
		if (elems.length >= DEFAULT_INC && elems[elems.length - 1] == null) return;
		System.out.println("enlarging at size " + elems.length);
		E[] newElems = (E[])new Object[elems.length + DEFAULT_INC];
		System.arraycopy(elems, 0, newElems, 0, elems.length);
		elems = newElems;
	}
	
	@SuppressWarnings( "unchecked" )
	private void tryReduce() {
		int nullCount = 0;
		for (; elems[elems.length - nullCount - 1] == null && nullCount < elems.length - 1; nullCount++);
		nullCount /= DEFAULT_INC;
		if (nullCount == 0) return;
		System.out.println("reducing at size " + elems.length);
		E[] newElems = (E[])new Object[elems.length - nullCount * DEFAULT_INC];
		System.arraycopy(elems, 0, newElems, 0, newElems.length);
		elems = newElems;
	}
}
