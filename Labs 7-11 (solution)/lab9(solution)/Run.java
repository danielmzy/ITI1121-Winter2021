/**
* @author Marcel Turcotte, Universite d'Ottawa/University of Ottawa
*/

public class Run {
	
	public static void displayStudentInfo() {
		System.out.println("Glen Wang | 300164126 | ITI 1121-B | Assignment One");
	}
	
	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.err.println("Usage: java Run infile outfile");
			System.exit(1);
		}
		
		displayStudentInfo();
		
		PlayListManager manager = new PlayListManager(args[ 0 ], args[ 1 ]);
		manager.copySongListFromFileToFile();
	}
}
