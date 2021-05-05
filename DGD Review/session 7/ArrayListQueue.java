import java.util.ArrayList;


public class ArrayListQueue<E> {

	private ArrayList<E> list = new ArrayList<E>();

    public boolean isEmpty() {
    	return list.isEmpty();
    }

    public void enqueue(E o) {
    	list.add(o);
    }

    public E dequeue() {
    	return list.remove(0);
    }

    public static void main(String[] args) {
    	
    	TicTacToe.row = 2;
    	TicTacToe.col = 2;

    	TicTacToe tc = new TicTacToe();
    	// sol = [tcempty]
    	// elem = sol.dequeue()
    	// if elem has space
    	// create 2 copies, branch
    	// for each branch

    	ArrayListQueue<TicTacToe> solutions = new ArrayListQueue<TicTacToe>();

    	ArrayListQueue<TicTacToe> candidates = new ArrayListQueue<TicTacToe>();
    	candidates.enqueue(tc);

    	TicTacToe temp, s1, s2;	

    	while(!candidates.isEmpty()) {
    		temp = candidates.dequeue();

    		if(temp.isFull()) {
    			if(temp.isValid()) {
    				solutions.enqueue(temp);
    			}
    		} else {
	    		s1 = new TicTacToe(temp);
	    		s2 = new TicTacToe(temp);

	    		s1.add(1);
	    		s2.add(2);
	    		
	    		if(s1.isValid()) {	
	    			candidates.enqueue(s1);
	    		}
	    		if(s2.isValid()) {
	    			candidates.enqueue(s2);
	    		}
    		}
    	}
    	// a op b
    	// op a b
    	// a b op

    	while(!solutions.isEmpty()) {
    		solutions.dequeue().print();
    		System.out.println();
    	}

    	// tc.print();
    	// tc.add(1);
    	// tc.print();
    	// tc.add(2);
    	// tc.print();



    	// System.out.println(5/2);
    	// System.out.println((float) 5/2);
    }
}
