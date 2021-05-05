public class Geometric extends AbstractSeries {

    // instance variables
    double term = -1;
    double sum = 0;

    public double next() {

        // implement the method
        sum += Series();
        return sum;
    }

    public double Series() {
        term++;
        return (1/(Math.pow(2,term)));
    }
}