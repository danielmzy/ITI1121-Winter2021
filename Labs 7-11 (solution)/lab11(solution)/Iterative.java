import java.util.function.Function;

public class Iterative {
	
	public static BitList complement(BitList in) {
		String inStr = in.toString();
		BitList out = new BitList();
		Iterator outIterator = out.iterator();
		for (int i = 0; i < inStr.length(); i++) {
			outIterator.add(inStr.charAt(i) == '1' ? 0 : 1);
		}
		return out;
	}
	
	public static BitList or(BitList a, BitList b) {
		return merge(a, b, (aBit, bBit) -> aBit || bBit);
	}
	
	public static BitList and(BitList a, BitList b) {
		return merge(a, b, (aBit, bBit) -> aBit && bBit);
	}
	
	public static BitList xor(BitList a, BitList b) {
		return merge(a, b, (aBit, bBit) -> aBit ^ bBit);
	}
	
	private static BitList merge(BitList a, BitList b, Operator operator) {
		String aStr = a.toString();
		String bStr = b.toString();
		if (!a.iterator().hasNext() || !b.iterator().hasNext() || aStr.length() != bStr.length()) {
			throw new IllegalArgumentException();
		}
		BitList out = new BitList();
		Iterator outIterator = out.iterator();
		for (int i = 0; i < aStr.length(); i++) {
			boolean aBit = aStr.charAt(i) == '1';
			boolean bBit = bStr.charAt(i) == '1';
			outIterator.add(operator.eval(aBit, bBit) ? 1 : 0);
		}
		return out;
		
		// if (!a.iterator().hasNext() || !b.iterator().hasNext()) {
		// 	throw new IllegalArgumentException();
		// }
		// BitList out = new BitList();
		// Iterator aIterator = a.iterator();
		// Iterator bIterator = b.iterator();
		// Iterator outIterator = out.iterator();
		// while (aIterator.hasNext() && bIterator.hasNext()) {
		// 	boolean aBit = aIterator.next() == 1;
		// 	boolean bBit = bIterator.next() == 1;
		// 	outIterator.add(operator.eval(aBit, bBit) ? 1 : 0);
		// }
		// if (aIterator.hasNext() || bIterator.hasNext()) {
		// 	throw new IllegalArgumentException();
		// }
		// return out;
	}
	
	private interface Operator {
		abstract boolean eval(boolean a, boolean b);
	}
	
	// public static void main(String[] args) {
	// 	BitList list1 = new BitList("10001");
	// 	BitList list2 = new BitList("00011");
	// 	Iterative it = new Iterative();
	//
	// 	BitList list3 = it.or(list1, list2);
	// 	int bit1 = list3.removeFirst();
	// 	int bit2 = list3.removeFirst();
	// 	int bit3 = list3.removeFirst();
	// 	int bit4 = list3.removeFirst();
	// 	int bit5 = list3.removeFirst();
	//
	// 	System.out.printf("%d%d%d%d%d%n", bit1, bit2, bit3, bit4, bit5);
	// }
}
