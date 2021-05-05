import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Test {

	public boolean equals(Object o) {
		if(o == null) {
			throw new NullPointerException();
		}
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// File file = new File("path");
		// BufferedReader reader = new BufferedReader(null);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("path")));
		
		// try {
		// } catch (FileNotFoundException e) {

		// } catch (Exception e) {

		// }
	}	
}
