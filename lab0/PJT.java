/*
Java (data) types

Primitive types (byte --> bit amount represents the allocation 
amount of varibale in memory (how much space it will need to be saved):
- byte (1 byte --> 8 bits: 256 different values --> -128 .... 127)
- short (2 bytes --> 16 bits: 65536 different values --> -32xxx ... 32xxx)
- int (4 bytes --> 32 bits: 2^32 different values --> -2 billion ... 2 billion)
- long (8 bytes --> 64 bits: 2^64 different values --> very large integers, but still not exact)
- float (4 bytes --> 32 bits: like real number representation (approximations) -- be careful, since they are not exact)
- double (8 bytes  --> 64 bits, approximations of real numbers -- higher precision than above)
- boolean (1 bit: true or false --> notce the not capitalized, unlike python)
- char (16 bits: single UNICODE characters)
---- reference (a reference to an object --> stores an address to an object)
	- in python, every variable created (assigned/initialiazed) is stored in the memory,
	in which are referenced by an ddressed to be accessed to their value
The above allows for below, which operations are allowed:
Arithmetic Operations are basically the same in terms of syntax
--> for exponentiation, must use the specific method for java	


Comparison Operators: 
- ==, !=
- >, <, >=, <=
Boolean Operators (python --> java):
- and --> &&
- or --> ||
- not --> !
*/

import java.util.Scanner;

public class PJT{
	public static void main(String[] args){
		System.out.println("Hello World!");
		System.out.println("Goodbye World!");
		System.out.println("This is really the end!!!!");

		byte x = -50;
		System.out.println(x);
		short y = -129;
		System.out.println(y);
		int a = 1000000;
		int b = 1000000;
		int z = a * b;
		x = 3;
		y = 2;
		System.out.println(z);
		System.out.println(x/y);
		// in the output, since both x and y are of type int,
		// java uses integer division to display result,
		// thus answer shown is 1
		// if inside the println() is 3.0 / y --> 1.5 since
		// 3.0 is of type float, and java does the higher precision division
		// extra: if assigned x = 3.0, error is produced
		// since it should be of type byte
		float t = (float)x; // type casting x --> 3.0
		System.out.println(t);
		int p = (int) 4.0 / 2;
		System.out.println(p);
		// java is able to concatenate the below argument 
		// since one of the elements is already of type string
		// no need to import the class Math here (some others you will need to)
		// result of Math.pow is float (or double)
		System.out.println("2^10 = " + Math.pow(2,10));
		System.out.println(Math.abs(-22));

		boolean s = x != y;
		System.out.println(s);
		s = false || false;
		System.out.println(s);


		// creating an array (check the word new)
		int[] A = new int[6]; // int object of type array with specified length
		// or:
		// int[] A;
		// A = new int[6];
		// A = 6*[A]
		// print(A)
		// print(len(A))
		A[3] = 100;
		// but this is wrong: A[3] = "today"
		System.out.println(A);
		// the output will be the address of A (reference variable)
		System.out.println(A.length); // gives the length of array (like len() 
		// in python) length of array is IMMUTABLE!!!

		int[] B = A;
		B[100] = 100;
		System.out.println(A[1]);
		B[1] = 0;

		int[] L = {1, 4, 6, 3, 2, 7}; //manual creation of an array
		// if manually, cannot do the or: statement above (2-step code)

		for (int item: L){
			System.out.println(item);
			// for item in L:
				// print(item)
		}
		for (int i = 0; i< L.length; i++){
			L[i] = 0;
			// for i in range(len(L)):
				// L[i] = 0
		}
		System.out.println(A == L);
		// in python (print(A == L)) --> True (elements/values are compared,thus different addresses)
		// in java --> false, becaaue the addresses are compared,
		// not elements/values contained
		System.out.println(A == B);
		String q = "This is my string!";
		// OR: 
		// String q;
		// s = "This is my string!"
		// variable s is assigned/referenced to object q of type String
		// *** no single-quote strings and no multi-line strings
		System.out.println(q);
		// System.out.println(q[6]); indexing will produce error in java
		// must use class methods
		System.out.println(q.charAt(6));

		Scanner sc = new Scanner(System.in);
		System.out.println("Input something: ");
		String s2 = sc.nextLine();
		System.out.println("You inputted ' " + s2 + " '");
		System.out.println("Input an integer: ");
		int w = sc.nextInt();
		System.out.println("You inputted ' " + w + " '");

		// value null can be declared to all reference data types
		double[] C = null;
		String[] s2 = null;
		System.out.println(C); 
	}
}

// print("Hello World!")
// one line comment (mult-line is next --> notice the *)
/*
*/