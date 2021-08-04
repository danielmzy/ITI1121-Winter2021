/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
   Name: Kian Zahrai, Student ID: 300098986
 */

public class UniquifiableArrayStack<E> extends ArrayStack<E> {

	public Stack<E> uniquify() {
	  // ADD YOUR CODE HERE
		List<E> origin = new ArrayList<>();

		List<E> uniqueList = new ArrayList<>();

		E previous = null;
		while (!isEmpty()) {
			E x = pop();
			origin.add(x);
			if (!x.equals(previous)) {
				uniqueList.add( x );
			}
			previous = x;
		}

		Stack<E> rev = new ArrayStack<>();

		for ( int i = uniqueList.size() - 1; i >= 0; i--) {
			reversage.push(uniqueList.get(i));
		}

		for ( int i = original.size() - 1; i >= 0; i--) {
			push(origin.get(i));
		}

	return reversage;


	}

}