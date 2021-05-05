// run this in Java visualizer

public class HelloWorldVisualizer{
	public static void main(String[] args) {

	System.out.println("Hello World!");
	System.out.println("Goodbye World!");
	System.out.println("This is really the end!!!");
	long x = 1000000;
	long y = 1000000;
	long z = x * y;
	System.out.println(z);

	x = 3;
	y = 2;

	System.out.println(x / y);
	System.out.println(3. / 2);

	float t = (float)x;
	System.out.println(t);

	int p = (int)(4.0/2);
	System.out.println("2^10 = " + Math.pow(2, 10));
	System.out.println(Math.abs(-22));

	boolean a = x != y;
	System.out.println(a);
	a = false || false;
	System.out.println(a);

	int[] A = new int[6];

	System.out.println(A);
	System.out.println(A.length);

	int[] B = A;
	B[1] = 100;
	System.out.println(A[1]);
	B[1] = 0;

	int[] L = {1, 4, 6, 3, 2, 7, };
	for (int i = 0; i < L.length; i++ ) {
		L[i] = 0;
		// no printing, only changing value sof list
	}

	for (int item : L) {
		System.out.println(item);
		// elements are not printed, the address that references 
		// the variable to the memory is printed instead
	}

	System.out.println(A == L); 
	// answer is false due to comparing different addresses
	System.out.println(A == B);
	// answer is true

	String s = "This is my string!";
	System.out.println( s.charAt(6) );

	double[] C = null;
	String[] s2 = null;
	// to all reference variables, null can be assinged
	System.out.println(C);
	}
}