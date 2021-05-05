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


public class A implements DeepCopyable {
	
	private int a , b, c;
	
	public A(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof A)) return false;
		A a = (A)other;
		return (this.a == a.a) && (this.b == a.b) && (this.c == a.c);
	}
	
	@Override
	public DeepCopyable deepCopy() {
		return new A(a, b, c);
	}
	
}
