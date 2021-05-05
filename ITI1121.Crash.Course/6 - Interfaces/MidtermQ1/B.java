/*
Student name: Glen Wang
Student number: 300164126
*/

/**
* COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
*
* @author Guy-Vincent Jourdan
* @author Mehrdad Sabetzadeh
*/

public class B implements DeepCopyable {
	
	private A a1, a2;
	
	public B(A a1, A a2){
		this.a1 = a1;
		this.a2 = a2;
	}
	
	public A getA1() {
		return a1;
	}
	
	public A getA2() {
		return a2;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof B)) return false;
		B b = (B)other;
		return (this.a1.equals(b.a1)) && (this.a2.equals(b.a2));
	}
	
	@Override
	public DeepCopyable deepCopy() {
		return new B((A)a1.deepCopy(), (A)a2.deepCopy());
	}
}
