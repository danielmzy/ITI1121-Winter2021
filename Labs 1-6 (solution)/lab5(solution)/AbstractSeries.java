import java.util.ArrayList;

public abstract class AbstractSeries implements Series {
	
	protected ArrayList<Double> cache = new ArrayList<Double>();
	protected double sum = 0;
	protected double addend = 1;
	
	public double[] take(int k) {
		while (k > cache.size()) next();
		double[] elements = new double[k];
		// System.arraycopy(cache, 0, elements, 0, k-1);
		for (int i = 0; i < k; i++) {
			elements[i] = cache.get(i);
		}
		// System.out.printf("###############%d: %d%n", k, elements[k-1]);
		return elements;
	}
}
