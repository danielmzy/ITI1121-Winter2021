/**
* this class represents a Rational number, an integer divided by another
* <p>
* Note: Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
*
* @author  Kian Zahrai
*/


public class Rational {

    private int numerator;
    private int denominator;

    // constructors
    /**
    * Constructor method initializing the numerator and denominator.
    * Sets the default value for the Rational object as (numerator, denominator) of type int.
    *@param numerator The first number
    *@param denominator is assumed to be 1
    */

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
    /**
    * Constructors method to ensure denominator is not 0.
    * Sets the default value for the Rational object as (numerator, denominator).
    *@param numerator The first number
    *@param denominator The second number
    * the this method sets the parameters as thier initial values
    */

    public Rational(int numerator, int denominator) {
        if (denominator < 0){
            denominator = -1 * denominator;
            numerator = -1 * numerator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // to reduce to rational number
    }

    // getters
    /**
    *this is a getter method
    *used to get the value of the variable numerator
    *@return int this returns the numertor
    */

    public int getNumerator() {
	     return numerator;
    }
    /**
    *this is a getter method
    *used to get the value of the variable denominator
    *@return int this returns the denominator
    *no parameters given  
    */
    public int getDenominator() {
	     return denominator;
    }

    // instance methods
    /**
    *this is an instance method
    *used to get the value of the variable denominator
    *@param other of type Rational
    *@return a new object of type Rational, representing the sum of this number and that of the parameter other.
    */
    public Rational plus(Rational other) {
        int newDenominator = denominator * other.denominator;
        int newNumerator = numerator * other.denominator;
        int newOtherNumerator = other.numerator * denominator;
        int sum = newNumerator + newOtherNumerator;

        return new Rational (sum, newDenominator);
    }
    /**
    *this is an instance method
    *used to get the value of the variable denominator
    *@param a of type Rational
    *@param b of type Rational
    *@return a new object of type Rational, representing the sum of parameters a and b.
    */
    public static Rational plus(Rational a, Rational b) {
    	// Your code here
        return a.plus(b);
    }

    // Transforms this number into its reduced form
    private void reduce() {
        // Your code here
        if(numerator == 0) {
            denominator = 1;
        } else{
            int common = gcd(Math.abs(numerator),denominator);
            numerator = numerator/common;
            denominator = denominator/common;

        }
    }
      
    // Euclid's algorithm for calculating the greatest common divisor
    
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
        while (a != b) {
            if (a > b) {
                for (int j = b; j > 0; j--) {
                    if (a % j == 0 && b % j == 0) {
                        return j;
                    }
                }
            } else{
                for (int d = a; d > 0; d--) {
                    if (a % d == 0 && b % d == 0){
                        return d;
                    }
                }
            }
        }
        return 0;
    }
    /**
    *this is an instance method
    *compares the object above with the specified object (other variable) for order, by computing the difference
    *@param other of type Rational
    *@return a negative integer, zero, or a positive integer as the object is less than, equal to, or greater than the specified object other.
    */
    public int compareTo(Rational other) {
      // Your code here
        int thisNewNum = other.denominator * numerator;
        int otherNewNum= other.numerator * denominator;

        return thisNewNum - otherNewNum;
    }
    /**
    *this is an instance method
    *@param other of type Rational
    *@return true if the fraction and the one designated by 'other' represent the same fraction (content equality).
    */
    public boolean equals(Rational other) {
      // Your code here
        if(numerator == other.numerator && denominator == other.denominator){
            return true;
        }
        return false;
    }
    /**
    *this is an instance method
    *compares the object above with the specified object (other variable) for order, by computing the difference
    *@return a string representation of this fraction (of numerator and denominator passed) 
    *with the numerator followed by the symbol /, followed by the denominator.
    *If the denominator is 1 then the method returns a String consisting of the numerator only (shown by Integer.toString)
    */
    public String toString() {
        String result;
        if(denominator == 1){
            result = Integer.toString(numerator);
        } else{
            result = numerator + "/" + denominator;
        }
        return result;
    }

}