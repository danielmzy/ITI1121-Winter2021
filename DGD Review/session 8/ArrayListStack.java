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

	public void print() {
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+", ");
		}
		System.out.print(" <-- start");
		System.out.println();
	}

	public static Integer max(ArrayListStack<Integer> s) {
		Integer max = null;
		ArrayListStack<Integer> temp = new ArrayListStack<Integer>();
		Integer value;
		// s = a b c d |
		// temp = d c b a |
		// s = a b c d |
		// X
		// s = a b c d |
		// temp = d c b a |
		// t2 = a b c d |
		// s = d c b a |
		while (!s.isEmpty()) {
			value = s.pop();
			if(max == null || value > max) {
				max = value;
			}
			temp.push(value);
		}

		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}

		return max;
	}

	public static Integer size(ArrayListStack<Integer> s) {
		Integer size = 0;
		ArrayListStack<Integer> temp = new ArrayListStack<Integer>();
		// s = a b c d |
		// temp = d c b a |
		// s = a b c d |
		// X
		// s = a b c d |
		// temp = d c b a |
		// t2 = a b c d |
		// s = d c b a |
		while (!s.isEmpty()) {
			size++;
			temp.push(s.pop());
		}

		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}

		return size;
	}

	public static void main(String[] args) {
		ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
		stack.push(2);
		stack.push(9);
		stack.push(0);
		stack.push(7);
		stack.push(3);
		stack.push(5);

		stack.print();

		System.out.println(max(stack));
		System.out.println(size(stack));

		stack.print();
	}
}


