/*
Student name: Glen Wang
Student number: 300164126
*/

/**
* COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
*
* @author Guy-Vincent Jourdan
* @author Mehrdad Sabetzadeh
*/

public class UniquifiableArrayStack<E> extends ArrayStack<E> {
	
	public Stack<E> uniquify() {
		Stack<E> clones = new ArrayStack<E>();
		Stack<E> uniques = new ArrayStack<E>();
		E current;
		E prev = null;
		while (!isEmpty()) {
			if (prev == null) {
				prev = pop();
				clones.push(prev);
			}
			
			if (isEmpty()) { // stack may have one element
				push(clones.pop());
				return this;
			}
			
			current = pop();
			clones.push(current);
			if (current.equals(prev)) {
				continue;
			} else {
				uniques.push(prev);
				prev = current;
			}
		}
		uniques.push(prev);
		
		while (!clones.isEmpty()) push(clones.pop());
		flip(uniques);
		return uniques;
	}
	
	private void flip(Stack<E> stack) {
		Stack<E> load = new ArrayStack<E>();
		Stack<E> flip = new ArrayStack<E>();
		while (!stack.isEmpty()) load.push(stack.pop());
		while (!load.isEmpty()) flip.push(load.pop());
		while (!flip.isEmpty()) stack.push(flip.pop());
	}
}
