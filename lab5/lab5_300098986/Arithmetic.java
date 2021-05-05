public class Arithmetic extends AbstractSeries {

    // instance variables
    double term = 0;
    double sum = 0;

    public double next() {

        // implement the method
        sum += Series();
        return sum;
    }

    public double Series() {
        term++;
        return term;
    }
}