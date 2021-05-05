public class LinkedList<E> implements List<E> {
	// single linked
	public static class Node<E> {
		E value;
		Node<E> next;
		public Node(E v, Node<E> next) {
			this.value = v;
			this.next = next;
		}
	}

	private Node<E> head;

	public void addLast(E o) {
		if(head == null) {
			head = new Node<E>(o, null);
		} else {
			// keep going next
			// until next is null
			Node<E> node = head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node<E>(o, null);
		}
	}

	public boolean contains(E o) {
		if(o == null) {
			throw new NullPointerException("can't add a null element");
		}
		if(head == null) {
			return false;
		} else {
			Node<E> node = head;
			while(!node.value.equals(o) && node.next != null) {
			// while(node.value != o && node.next != null) {
				node = node.next;
			}
			return node.value.equals(o);
		}
	}

	public E removeFirst() {
		if(head == null) {
			throw new IllegalStateException("empty list");
		} else {
			E result = head.value;
			head = head.next;
			return result;
		}
	}
	
	public int size() {
		return recursiveSize(head);	
	}
	
	private int recursiveSize(Node<E> node) {
		if(node == null) {
			return 0;
		} else {
			int size = recursiveSize(node.next);
			return 1 + size;
		}
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println("init size "+list.size());

		list.addLast(1);
		list.addLast(2);

		System.out.println("init half size "+list.size());
		list.addLast(3);
		list.addLast(4);
		
		System.out.println("found 2 "+ list.contains(2));
		System.out.println("found 5 "+ list.contains(5));
		System.out.println("final size "+ list.size());

		System.out.println(list.removeFirst());
		System.out.println(list.removeFirst());

		System.out.println("final half size"+list.size());

		System.out.println(list.removeFirst());
		System.out.println(list.removeFirst());

		System.out.println("final final  size "+ list.size());
	}
}
