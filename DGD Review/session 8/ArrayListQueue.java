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

    public void print() {
        System.out.print("back --> ");
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+", ");
        }
        System.out.print(" <-- front");
        System.out.println();
    }


    public static Integer max(ArrayListQueue<Integer> s) {
        Integer max = null;
        ArrayListQueue<Integer> temp = new ArrayListQueue<Integer>();
        Integer value;
        // s = back --> a b c d <-- front
        // s = back --> b c d a <-- front
        // s = back --> c d a b <-- front
        while(!s.isEmpty()) {
            value = s.dequeue();
            if (max == null || max < value) {
                max = value;
            }
            temp.enqueue(value);
        }

        while(!temp.isEmpty()) {
            s.enqueue(temp.dequeue());
        }

        return max;
    }

    public static Integer size(ArrayListQueue<Integer> s) {
        Integer size = 0;
        ArrayListQueue<Integer> temp = new ArrayListQueue<Integer>();
        // s = back --> a b c d <-- front
        // s = back --> b c d a <-- front
        // s = back --> c d a b <-- front
        while(!s.isEmpty()) {
            size++;
            temp.enqueue(s.dequeue());
        }

        while(!temp.isEmpty()) {
            s.enqueue(temp.dequeue());
        }

        return size;
    }

    public static void main(String[] args) {
        ArrayListQueue<Integer> q = new ArrayListQueue<Integer>();
        q.enqueue(2);
        q.enqueue(9);
        q.enqueue(0);
        q.enqueue(7);
        q.enqueue(3);
        q.enqueue(5);

        q.print();

        System.out.println(max(q));
        System.out.println(size(q));

        q.print();
    }
}
