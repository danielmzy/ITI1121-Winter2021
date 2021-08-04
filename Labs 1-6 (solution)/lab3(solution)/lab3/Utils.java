
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/



/**
* The class Utils
* @author Glen Wang
*/
public class Utils {
	
	/**
	* Returns a copy of the array 'in' where each word occurring in the array
	* 'what' has been replaced by the word occurring in the same position
	* in the array 'with'.
	*
	* @param in an array of Strings;
	* @param what an array of words to be replaced;
	* @param with an array of replacement words;
	* @return a new array idententical to 'in' except that all the occurrences of words
	* found in 'what' have been replaced by the corresponding word from 'with'.
	*/
	public static String[] findAndReplace(String[] in, String[] what, String[] with) {
		
		if (in == null || what == null || with == null || what.length != with.length) return null;
		for (int i = 0; i < what.length; i++) {
			if (what[i] == null || with[i] == null) {
				return null;
			}
		}
		for (int i = 0; i < in.length; i++) {
			if (in[i] == null) {
				return null;
			}
		}
		
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < what.length; j++) {
				// in[i].replace(what[j], with[j]);
				if (in[i].equals(what[j])) {
					in[i] = with[j];
				}
			}
		}
		String[] out = new String[in.length];
		System.arraycopy(in, 0, out, 0, in.length);
		return out; // or skip the deep clone and return in[] if the ref doesnt matter
	}
	
	public static void main(String[] args) {
		
	}
}
