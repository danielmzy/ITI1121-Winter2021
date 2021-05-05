public class Geometric extends AbstractSeries {
	
	public double next() {
		sum += addend;
		addend *= 0.5;
		cache.add(sum);
		return sum;
	}
}
