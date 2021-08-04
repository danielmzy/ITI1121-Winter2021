/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
  Name: Kian Zahrai, Student ID: 300098986
 */


public class A implements DeepCopyable { // complete the class declaration as required
	
	private int a , b, c;

	public A(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (getClass() != o.getClass()) {
			return false;
		}

		A other = (A) o;

		return a == other.a && b == other.b && c == other.c;
	}

	@Override
	public DeepCopyable deepCopy() {
		return new A(a, b, c);
	}
	// ADD YOUR CODE HERE

}
