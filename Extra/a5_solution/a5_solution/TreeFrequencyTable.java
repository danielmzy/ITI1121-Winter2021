import java.util.NoSuchElementException;

/** Implements the interface <code>FrequencyTable</code> using a
 *  binary search tree.
 *
 * @author Marcel Turcotte (turcott@eecs.uottawa.ca)
 */

public class TreeFrequencyTable implements FrequencyTable {

    // Stores the elements of this binary search tree (frequency
    // table)
    
    private static class Elem {
    
        private String key;
        private long count;
    
        private Elem left;
        private Elem right;
    
        private Elem(String key) {
            this.key = key;
            this.count = 0;
            left = null;
            right = null;
        }
    }

    private Elem root = null; // A reference to the root element
    private int size = 0; // The size of the tree

    /** The size of the frequency table.
     *
     * @return the size of the frequency table
     */
    
    public int size() {
        return size;
    }
  
    /** Creates an entry in the frequency table and initializes its
     *  count to zero.
     *
     * @param key key with which the specified value is to be associated
     */
  
    public void init(String key) {
    
        // pre-condtion
    
        if (key == null) {
            throw new NullPointerException();
        }

        // special case
    
        if (root == null) {
            root = new Elem(key);
        } else {
	    init(key, root);
	}
    
    }
  
    // helper method

    private void init(String key, Elem current) {

        int test = key.compareTo(current.key);
    
        if (test == 0) { // already exists
            throw new IllegalArgumentException("duplicate key: "+key);
        } else if (test < 0) {
	    if (current.left == null) {
		current.left = new Elem(key);
	    } else {
		init(key, current.left);
	    }
        } else {
	    if (current.right == null) {
		current.right = new Elem(key);
	    } else {
		init(key, current.right);
	    }
        }

    }
  
    /** The method updates the frequency associed with the key by one.
     *
     * @param key key with which the specified value is to be associated
     */
  
    public void update(String key) {
    
        // pre-condtion:
    
        if (key == null) {
            throw new NullPointerException();
        }

	if (root == null) {
	    throw new IllegalArgumentException("not found: "+key);
	}
	
        update(key, root);
    }
  
    // helper method

    private void update(String key, Elem current) {

	if (current == null) {
	    throw new IllegalArgumentException("not found: "+key);
	}
    
        int test = key.compareTo(current.key);
    
        if (test == 0) {
            current.count++;
        } else if (test < 0) {
	    update(key, current.left);
        } else {
	    update(key, current.right);
        }

    }
  
    /**
     * Looks up for key in this TreeFrequencyTable, returns associated value.
     *
     * @param key value to look for
     * @return value the value associated with this key
     * @throws NoSuchElementException if the key is not found
     */
  
    public long get(String key) {
    
        // pre-condtion:
    
        if (key == null) {
            throw new NullPointerException();
        }
    
        return get(key, root);
    }
  
    private long get(String key, Elem current) {
    
        long value;
    
        if (current == null) {
	    throw new NoSuchElementException();
	}
      
	int test = key.compareTo(current.key);
      
	if (test == 0) {
	    value = current.count;
	} else if (test < 0) {
	    value = get(key, current.left);
	} else {
	    value = get(key, current.right);
	}

	return value;
    }
  
    /** Returns the list of keys in order, according to the method compareTo of the key
     *  objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {

        LinkedList<String> keys = new LinkedList<String>();
    
        if (root != null) {
            keys(keys, root);
        }
    
        return keys;

    }

    // Helper method.

    private void keys(LinkedList<String> keys, Elem current) {
    
        if (current.left != null) {
            keys(keys, current.left);
        }
    
        keys.addLast(current.key);
    
        if (current.right != null) {
            keys(keys, current.right);
        }
    
    }
      
    /** Returns the values in the order specified by the method compareTo of the key
     *  objects.
     *
     *  @return the values
     */

    public long[] values() {

	LinkedList<Long> values = new LinkedList<Long>();
    
        if (root != null) {
            values(values, root);
        }

	long[] elems = new long[values.size()];

	Iterator<Long> i = values.iterator();

	int pos = 0;
	
	while (i.hasNext()) {
	    elems[pos++] = i.next();
	}

	return elems;
    }

    // helper method (in order traversal)
  
    private void values(LinkedList<Long> values, Elem current) {
    
        if (current.left != null) {
            values(values, current.left);
        }
    
        values.addLast(current.count);
    
        if (current.right != null) {
            values(values, current.right);
        }
    
    }

    /** Returns a String representation of the tree.
     *
     * @return a String representation of the tree.
     */

    public String toString() {
        return toString( root );
    }

    // helper
  
    private String toString(Elem current) {
    
        if (current == null) {
            return "{}";
        }
    
        return "{" + toString(current.left) + "[" + current.key + "," + current.count + "]" + toString(current.right) + "}";
    }
  
}
