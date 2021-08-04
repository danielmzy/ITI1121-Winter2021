import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {
	
	// Implementation of the doubly linked nodes (nested-class)
	
	private static class Node {
		
		private Comparable value;
		private Node previous;
		private Node next;
		
		private Node (Comparable value, Node previous, Node next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		
		// private void debug() {
		// 	System.out.printf("value: %s this: %.3s prev: %.3s next: %.3s%n", value, System.identityHashCode(this), System.identityHashCode(previous), System.identityHashCode(next));
		// }
	}
	
	// Instance variables
	
	private Node head;
	private int size;
	
	// Representation of the empty list.
	
	public OrderedList() {
		head = new Node(null, null, null);
		head.previous = head;
		head.next = head;
	}
	
	// Calculates the size of the list
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Object get(int pos) {
		if (pos >= size || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node target = head.next;
		for (int i = 0; i < pos; i++) {
			target = target.next;
		}
		return target.value;
	}
	
	// Adding an element while preserving the order
	@Override
	public boolean add(Comparable o) {
		if (o == null) {
			throw new IllegalArgumentException();
		}
		Node next = head.next;
		while (next.value != null && o.compareTo(next.value) > 0) {
			next = next.next;
		}
		Node previous = new Node(o, next.previous, next);
		next.previous.next = previous;
		next.previous = previous;
		size++;
		return true;
	}
	
	//Removes one item from the position pos.
	@Override
	public void remove(int pos) {
		if (pos >= size || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node target = head.next;
		for (int i = 0; i < pos; i++) {
			target = target.next;
		}
		// System.out.print("remove target: ");
		// target.debug();
		target.previous.next = target.next;
		target.next.previous = target.previous;
		target = null;
		size--;
	}
	
	// Knowing that both lists store their elements in increasing
	// order, both lists can be traversed simultaneously.
	
	public void merge(OrderedList other) {
		for (int i = 0; i < other.size(); i++) {
			add((Comparable)other.get(i));
			// debug();
		}
	}
	
	// void debug() {
	// 	Node node = head;
	// 	for (int i = 0; i < size + 1; i++) {
	// 		node.debug();
	// 		node = node.next;
	// 	}
	// 	System.out.println();
	// }
	
	// public static void main(String[] args) {
	// 	OrderedList list1 = new OrderedList();
	// 	OrderedList list2 = new OrderedList();
	//
	// 	list1.add("C");
	// 	list1.debug();
	// 	list1.add("A");
	// 	list1.debug();
	// 	list1.add("D");
	// 	list1.debug();
	// 	list1.add("B");
	// 	list1.debug();
	// 	// list1.merge(list2);
	// }
}
