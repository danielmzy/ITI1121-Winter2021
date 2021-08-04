/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 Name: Kian Zahrai, Student ID: 300098986
 */

public class B implements DeepCopyable { // complete the class declaration as required

	private A a1, a2;

	public B( A a1, A a2){
		this.a1 = a1;
		this.a2 = a2;
	}

	public A getA1() {
		return a1;
	}

	public A getA2() {
		return a2;
	}

	public boolean equals(Object other) {
		B otherNumber = (B) other;
		return this.a1.equals(otherNumber.a1) && this.a2.equals(otherNumber.a2);

	}

	@Override
	public DeepCopyable deepCopy() {
		A newA1 = (A) a1.deepCopy();
		A newA2 = (A) a2.deepCopy();
		B newB = new B(newA1, newA2);
		return newB;
	}

}