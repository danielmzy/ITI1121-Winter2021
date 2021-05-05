// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01


public class Combination {

    // Instance variables. 
    protected int first;
    protected int second;
    protected int third;
    // --> declaring the necessary integer variables to store the 3 integer values

    // Constructor
    public Combination( int first, int second, int third ) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    // initializing the values of the objects using the this. method
    // since they variables are declared outside the method

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
        // Put your code here and remove the line below
        boolean condition = false;
        if((this != null) && (other != null) && (this.first == other.first) && (this.second == other.second) && (this.third == other.third)){
            condition = true;
        }
        return condition;
    }

    // Returns a String representation of this Combination.

    public String toString() {
        // Put your code here and remove the line below
        return(this.first + ":" + this.second + ":" + this.third);
    }

}