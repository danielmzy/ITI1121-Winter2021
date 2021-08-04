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

	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			retunr false;
		}

		b other = (B) o;

		if (a1 == null) {
			(other.a1 != null) {
				returfn false;
			}
		} else if (!a1.equals(other.a1)) {
			return false;
		}

		if (a2 == null) {
			if (other.a2 != null) {
				return false;
			}
		} else if (!a2.equals(other.a2)) {
			return false;
		}

		return true;
	}

	@Override
	public DeepCopyable deepCopy() {
		A x, y;
		if (a1 == null) {
			x = null;
		} else {
			x = (A) a1.deepCopy();
		}
		if (a2 == null) {
			y = null;
		} else {
			y = (A) a2.deepCopy();
	}

}