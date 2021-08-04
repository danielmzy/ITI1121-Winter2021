import java.util.NoSuchElementException;

/** Implements the interface <code>FrequencyTable</code> using linked
 *  elements. The linked structure is circular and uses a dummy node.
 *
 * @author Marcel Turcotte (turcott@eecs.uottawa.ca)
 */

public class LinearFrequencyTable implements FrequencyTable {

    // Linked elements

    private static class Elem {

	private String key;
	private long count;
	private Elem previous;
	private Elem next;

	private Elem(String key, Elem previous, Elem next) {
	    this.key = key;
	    this.count = 0;
	    this.previous = previous;
	    this.next = next;
	}

    }

    private Elem head;
    private int size;

    /** Constructs and empty <strong>FrequencyTable</strong>.
     */

    public LinearFrequencyTable() {
	head = new Elem(null, null, null); // dummy node
	head.previous = head; // making the dummy node circular
	head.next = head; // making the dummy node circular
	size = 0;
    }

    /** The size of the frequency table.
     *
     * @return the size of the frequency table
     */

    public int size() {
	return size;
    }
  
    /** Returns the frequency value associated with this key.
     *
     *  @param key key whose frequency value is to be returned
     *  @return the frequency associated with this key
     *  @throws NoSuchElementException if the key is not found
     */

    public long get(String key) {
	
	if (key == null) {
	    throw new NullPointerException();
	}

        Elem current;
        current = head.next;

	while (current != head && ! current.key.equals(key)) {
            current = current.next;
        }

	if (current == head) {
	    throw new NoSuchElementException(key);
	}

	return current.count;
    }

    /** Creates an entry in the frequency table and initializes its
     *  count to zero. The keys are kept in order (according to their
     *  method <strong>compareTo</strong>).
     *
     *  @param key key with which the specified value is to be associated
     *  @throws IllegalArgumentException if the key was alreaddy present
     */

    public void init(String key) {

	if (key == null) {
	    throw new NullPointerException();
	}

        Elem before, after;
        before = head;

	while (before.next != head && before.next.key.compareTo(key) < 0) {

            before = before.next;

	    if (before.key.equals(key)) {
		throw new IllegalArgumentException("duplicate key: "+key);
	    }

        }

	after = before.next;

        before.next = new Elem(key, before, after);
        after.previous = before.next;

        size++;

    }

    /** The method updates the frequency associed with the key by one.
     *
     *  @param key key with which the specified value is to be associated
     *  @throws NoSuchElementException if the key is not found
     */

    public void update(String key) {
	
	if (key == null) {
	    throw new NullPointerException();
	}

        Elem current;
        current = head.next;

	while (current != head && ! current.key.equals(key)) {
            current = current.next;
        }

	if (current == head) {
	    throw new NoSuchElementException(key);
	}

	current.count++;

    }

    /** Returns the list of keys in order, according to the method
     *  <strong>compareTo</strong> of the key objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {

	LinkedList<String> xs = new LinkedList<String>();
	
        Elem current;
        current = head.next;

	while (current != head) {
	    xs.addLast(current.key);
            current = current.next;
        }

	return xs;
    }

    /** Returns an array containing the frequencies of the keys in the
     *  order specified by the method <strong>compareTo</strong> of
     *  the key objects.
     *
     *  @return an array of frequency counts
     */

    public long[] values() {

	long[] values = new long[size];
	
        Elem current;
        current = head.next;

	int pos = 0;

	while (current != head) {
	    values[pos++] = current.count;
            current = current.next;
        }

	return values;
    }

    /** Returns a <code>String</code> representations of the elements
     * of the frequency table.
     *  
     *  @return the string representation
     */

    public String toString() {

	StringBuffer str = new StringBuffer("{");
	Elem p = head.next;

	while (p != head) {
	    str.append("{key="+p.key+", count="+p.count+"}");
	    if (p.next != head) {
		str.append(",");
	    }
	    p = p.next;
	}
	str.append("}");
	return str.toString();
    }

}
