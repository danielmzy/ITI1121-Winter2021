import java.util.ArrayList;


public class ArrayListStack<T> implements Stack<T> {
	
	// public/private/protected
	// 
	private ArrayList<T> list = new ArrayList(); 

	public ArrayListStack() {
		// list = new ArrayList()
	}

	public boolean isEmpty() {
		return list.isEmpty();
		// return list.size() == 0;
	}

	public T pop() {
		// T result = peek();
		// list.remove(result);
		// return result;
		return list.remove(list.size()-1);
		// return list.remove(0);
	}
	// 1
	// 2 1
	// 3 2 1
	public T peek() {
		return list.get(list.size()-1);
		// return list.get(0);
	}
	// 0 1 2 3 4 elem, 0..n-1
	// 0 1 2 3 4 index
	public void push(T obj) {
		list.add(obj);
		// list.add(0, obj);
	}

	public static void main(String[] args) {
		// ArrayListStack<Integer> l = new ArrayListStack<Integer>();
		// System.out.println(l.isEmpty());
		// l.push(1);
		// System.out.println(l.isEmpty());
		// System.out.println(l.peek());
		// System.out.println(l.isEmpty());
		// System.out.println(l.pop());
		// System.out.println(l.isEmpty());

		String[] alphabets = new String[] {"a", "b", "c", "d", "e"};

		ArrayListStack<String> l = new ArrayListStack<String>();

		for(int i=0; i<alphabets.length; i++) {
			l.push(alphabets[i]);
		}

		for(int i=0; i<alphabets.length; i++) {
			alphabets[i] = l.pop();
		}

		// int i=0
		// while(!l.isEmpty()) {
		// 	alphabets[i++] = l.pop();
		// }

		for(int i=0; i<alphabets.length; i++) {
			System.out.print(alphabets[i]+", ");
		}

	}

}


