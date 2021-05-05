public abstract class AbstractSeries implements Series {
    private double[] partialSums;

    public double[] take(int k) {

        // implement the method
        partialSums = new double[k];

        for (int i = 0; i < k; i++) {
            partialSums[i] = next();
        }

        return partialSums;
    }

    public double next() {
        return 0;
    }

}