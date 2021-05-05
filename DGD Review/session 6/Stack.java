interface Stack<T> {
	// Stack<Integer> -> Integer
	// Stack<String> -> String
	// Stack<Object>

	public boolean isEmpty();
	public T pop();
	public T peek();
	public void push(T obj);
}

