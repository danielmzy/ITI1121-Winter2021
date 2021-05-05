public class Combination {
	
	public int[] combo = new int[3];
	
	public Combination(int first, int second, int third) {
		combo[0] = first;
		combo[1] = second;
		combo[2] = third;
	}
	
	public boolean equals(Combination other) {
		if (other == null) return false;
		for (int i = 0; i < combo.length; i++) if (combo[i] != other.combo[i]) return false;
		return true;
	}
	
	public String toString() {
		return combo[0] + ":" + combo[1] + ":" + combo[2];
	}
}
