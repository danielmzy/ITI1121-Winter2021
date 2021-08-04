/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */

public class ArrayStack<E> implements Stack<E> {

	public Stack<E> uniquify() {
		if (isEmpty()) {
			return new UniquifyableArrayStack<>();
		}
		Stack<E> reverse = new UniquifyableArrayStack<>();
		Stack<E> result = new UniquifyableArrayStack<>();

		while (!isEmpty()) {
			reverse.push(pop());
		}

		E elem = reverse.pop();

		result.push(elem);
		push(elem);

		while (!reverse.isEmpty()) {
			// E elem = reverse.pop();
			// if (result.isEmpty()) {
				// result.push(elem);
			//}
			elem = reverse.pop();
			if (!result.peek().equals(elem)) {
				result.push(elem);
			}
			push(elem);
		}
		return result;
	}

}