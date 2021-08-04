
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/

/**
* The class Combination
* @author Glen Wang
*/
public class Combination {
	
	public int[] combo = new int[3];
	
	
	/**
	*
	* Constructs a combination
	*
	* @param first  the first digit
	* @param second  the second digit
	* @param third  the third digit
	*/
	public Combination(int first, int second, int third) {
		
		combo[0] = first;
		combo[1] = second;
		combo[2] = third;
	}
	
	/**
	*
	* Equals
	*
	* @param other  the other
	* @return boolean
	*/
	public boolean equals(Combination other) {
		if (other == null) return false;
		// Combination other = (Combination)obj;
		for (int i = 0; i < 3; i++) if (combo[i] != other.combo[i]) return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return String.format("%d:%d:%d", combo[0], combo[1], combo[2]);
	}
}
