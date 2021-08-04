public class Dictionary implements Map<String, Integer> {
	
	private final static int INITIAL_CAPACITY = 10;
	private final static int INCREMENT = 5;
	private int count = 0;
	
	private Pair[] elems;
	
	public int getCount() {
		return count;
	}
	
	public int getCapacity() {
		return elems.length;
	}
	
	public Dictionary() {
		elems = new Pair[INITIAL_CAPACITY];
	}
	
	@Override
	public void put(String key, Integer value) {
		if (count >= elems.length) {
			Pair[] temp = new Pair[elems.length + INCREMENT];
			System.arraycopy(elems, 0, temp, 0, elems.length);
			elems = temp;
		}
		elems[count++] = new Pair(key, value);
	}
	
	@Override
	public boolean contains(String key) {
		for (int i = 0; i < elems.length; i++) {
			if (elems[i] == null) {
				continue;
			}
			if (elems[i].getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Integer get(String key) {
		for (int i = elems.length - 1; i >= 0; i--) {
			if (elems[i] == null) {
				continue;
			}
			if (elems[i].getKey().equals(key)) {
				return elems[i].getValue();
			}
		}
		return -1;
	}
	
	@Override
	public void replace(String key, Integer value) {
		for (int i = elems.length - 1; i >= 0; i--) {
			if (elems[i] == null) {
				continue;
			}
			if (elems[i].getKey().equals(key)) {
				elems[i].setValue(value);
				return;
			}
		}
	}
	
	@Override
	public Integer remove(String key) {
		for (int i = elems.length - 1; i >= 0; i--) {
			if (elems[i] == null) {
				continue;
			}
			if (elems[i].getKey().equals(key)) {
				int value = elems[i].getValue();
				elems[i] = null;
				count--;
				return value;
			}
		}
		return -1;
	}
	
	@Override
	public String toString() {
		String res;
		res = "Dictionary: {elems = [";
		for (int i = count-1; i >= 0 ; i--) {
			res += elems[i];
			if(i > 0) {
				res += ", ";
			}
		}
		return res +"]}";
	}
	
	// public static void main(String[] args) {
	// 	Dictionary dict = new Dictionary();
	// }
}
