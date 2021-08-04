
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/


/**
* The class Q3_ reverse sort demo
* @author Glen Wang
*/
public class Q3_ReverseSortDemo {
	
	
	// runs the program
	public static void main(String[] args) {
		
		char[] unorderedLetters = new char[] { 'b', 'm', 'z', 'a', 'u' };
		// unorderedLetters = "ehuasndtbcigwzpkyroqjxlvmfhumjxlb".toCharArray();
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++) System.out.print(unorderedLetters[i]);
	}
	
	/**
	*
	* method that sorts a char array into its reverse alphabetical order
	*
	* @param values  the char array
	*/
	public static void reverseSort(char[] values) {
		
		// arrays.sort would defeat the point of this exercise so have a bubbler
		char swap;
		int progress = 0;
		for (int i = 1; progress < values.length; i = (i + 1) % (values.length)) {
			if (i == 0) {
				i++;
			}
			if (values[i - 1] < values[i]) {
				swap = values[i];
				values[i] = values[i - 1];
				values[i - 1] = swap;
				progress = 0;
			} else progress++;
		}
	}
}
