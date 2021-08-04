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
	public boolean equals(Object other) {
		A otherNumber = (A) other;
		return this.getA() == otherNumber.getA() && this.getB() == otherNumber.getB() && this.getC() == otherNumber.getC();

	}

	@Override
	public DeepCopyable deepCopy() {

		A newA = A(this.a, this.b, this.c);
		return newA;
	}
	// ADD YOUR CODE HERE

}
