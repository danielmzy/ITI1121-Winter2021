import java.util.StringTokenizer;
import java.util.*;
import javax.swing.*;

class Shuffle2 {

	public static String shuffle(String name) throws Exception {
		if(name == null || name.length() == 0) {
			throw new Exception("Invalid name");
		}
		StringTokenizer shufflename = new StringTokenizer(name, " ");
		if(shufflename.countTokens() == 2) {
			// ["string1", "String2", "string3"]
			// i
			// i++
			String e1 = shufflename.nextToken(); // name[0]
			String e2 = shufflename.nextToken(); // name[1]
			return e2 + " " + e1;
		} 
		else {
			throw new Exception("You have entered more than 2 words");
		}
	}

	public static String shuffle2(String name) throws Exception {
		if(name == null || name.length() == 0) {
			throw new Exception("Invalid name");
		}
		String[] newArray = name.split(" ");
		String newString = "";

		// for (int i=newArray.length - 1; i >= 0 ; i-- ) {
		// 	// [ 1, 12, 3, 4, 4]
		// 	//   0  1   2  3  4
		// 	// 5
		// 	newString += newArray[i] + " ";

		// }

		for(String s: name.split(" ")) {
			newString = s + " " + newString;
		}


		return newString;
	}

	public static void main(String[] args) throws Exception {

		// System.out.println(shuffle(null));
		// System.out.println(shuffle(args[0]));
		// args = [ "bejb ejbeke kbceb e bek b",  "bkevjb", "aekj", "beabb", "eak", "j"]
		// args[0] = "bejb ejbeke kbceb e bek b"

		String name = "";
		for(String s: args) {
			name += s + " ";
		}

		// System.out.println(shuffle2(args[0]));
		// System.out.println(shuffle2(name));
		System.out.println(shuffle2(JOptionPane.showInputDialog("input")));

		try {

			Scanner scanner = new Scanner(new File("./input.txt"));  // Create a Scanner object
		// Scanner scanner = new Scanner(System.in);  // Create a Scanner object

			System.out.println("Enter username");

			String userName = scanner.nextLine();  // Read user input
			System.out.println("Username is: " + userName);  // Output user input

		} catch (Exception e) {

		}
		

	}
}
