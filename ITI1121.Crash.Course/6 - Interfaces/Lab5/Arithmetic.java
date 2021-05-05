public class Arithmetic extends AbstractSeries {
	
	public double next() {
		sum += addend;
		addend++;
		cache.add(sum);
		return sum;
	}
}
