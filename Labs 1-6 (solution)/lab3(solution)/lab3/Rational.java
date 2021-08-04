
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/


/**
* The class Rational
* @author Glen Wang
*/
public class Rational {
	
	private int numerator;
	private int denominator;
	
	// constructors
	
	
	/**
	*
	* Constructs a rational number
	*
	* @param numerator  the numerator
	*/
	public Rational(int numerator) {
		this(numerator, 1);
	}
	
	
	/**
	*
	* Constructs a rational number
	*
	* @param numerator  the numerator
	* @param denominator  the denominator
	*/
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}
	
	
	/**
	*
	* Gets the numerator
	*
	* @return the numerator
	*/
	public int getNumerator() {
		return numerator;
	}
	
	
	/**
	*
	* Gets the denominator
	*
	* @return the denominator
	*/
	public int getDenominator() {
		return denominator;
	}
	
	// instance methods
	
	
	/**
	*
	* Adds this rational with another one
	*
	* @param other  the other
	*/
	public Rational plus(Rational other) {
		Rational sum = Rational.plus(this, other);
		numerator = sum.getNumerator();
		denominator = sum.getDenominator();
		return sum;
	}
	
	
	/**
	*
	* Adds two rationals together
	*
	* @param a  a rational
	* @param b  another rational
	*/
	public static Rational plus(Rational a, Rational b) {
		int denominator = a.getDenominator() * b.getDenominator();
		int numerator = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
		return new Rational(numerator, denominator);
	}
	
	/**
	*
	* Transforms this number into its reduced form
	*
	*/
	private void reduce() {
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		int gcd = gcd(numerator, denominator);
		numerator /= gcd;
		denominator /= gcd;
	}
	
	/**
	*
	* Euclid's algorithm for calculating the greatest common divisor
	*
	* @param a  one of the numbers
	* @param b  another one of the numbers
	* @return int
	*/
	private int gcd(int a, int b) {
		a = Math.abs(a);
		// b = Math.abs(b); // reduce() makes this case impossible
		while (a != b)
		if (a > b) a -= b;
		else b -= a;
		return a;
	}
	
	
	
	/**
	*
	* Compares this rational with another one
	*
	* @param other  the other rational
	* @return boolean
	*/
	public int compareTo(Rational other) {
		double otherDouble = (double)other.getNumerator() / other.getDenominator();
		double difference = (double)numerator / denominator - otherDouble;
		// not sure if we need epsilon
		if (difference > 0) {
			return 1;
		} else if (difference < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
	/**
	*
	* Whether this rational is equal to another one
	*
	* @param other  the other
	* @return boolean
	*/
	public boolean equals(Rational other) {
		// thank you reduce()
		return numerator == other.getNumerator() && denominator == other.getDenominator();
	}
	
	
	@Override
	public String toString() {
		if (denominator == 1) {
			return "" + numerator;
		} else {
			return String.format("%d/%d", numerator, denominator);
		}
	}
}
