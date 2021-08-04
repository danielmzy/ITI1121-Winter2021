import java.io.*;

public class SecretMessage {
	
	public static void encrypt(String inputFile, String outputFile, int key) {
		translate(inputFile, outputFile, key);
	}
	
	public static void decrypt(String inputFile, String outputFile, int key) {
		translate(inputFile, outputFile, -key);
	}
	
	private static void translate(String inputFile, String outputFile, int delta) {
		InputStreamReader input;
		OutputStreamWriter output;
		try {
			input = new InputStreamReader(new FileInputStream(inputFile));
			output = new OutputStreamWriter(new FileOutputStream(outputFile));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			return;
		}
		try {
			int i;
			while ((i = input.read()) != -1) {
				output.write((i + delta) % 256);
			}
			input.close();
			output.flush();
			output.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		if (args.length != 4) {
			System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
			System.exit(0);
		}
		
		if(args[0].equals("encrypt")){
			encrypt(args[1],args[2], Integer.parseInt(args[3]));
		} else if(args[0].equals("decrypt")){
			decrypt(args[1],args[2], Integer.parseInt(args[3]));
		} else{
			System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
			System.exit(0);
		}
		
	}
}
