public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables
    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
        int tempC = capacity>DEFAULT_INC? capacity: DEFAULT_INC;
        elems = (E[]) new Object[ tempC ];
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
        // Your code here.
        E saved = elems[ --top ];

        elems[ top ] = null;

        if (this.getCapacity()-top >= DEFAULT_INC && this.getCapacity()>=50) {
            E[] tempElems = (E[]) new Object[this.getCapacity()-DEFAULT_INC];

            for (int i = 0; i<this.top; i++) {
                tempElems[i] = elems[i];
            }

            elems = tempElems;

        }

        return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.

        if (top>=this.getCapacity()) {
            E[] tempElems = (E[]) new Object[this.getCapacity()+DEFAULT_INC];

            for (int i = 0; i<this.top; i++) {
                tempElems[i] = elems[i];
            }

            elems = tempElems;
        }
        elems[ top++ ] = element;
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        while (!this.isEmpty()) {
            this.pop();
        }
    }

}