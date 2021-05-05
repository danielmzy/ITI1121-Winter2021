import java.util.Arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVUtils {

	public static String[][] readCSV(String filePath) throws IOException {

		BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
		// List<String[]> res = new ArrayList<String[]>();
		int lineNumber = 0;

		String row;
		while ((row = csvReader.readLine()) != null) {
		    lineNumber++;
		}

		csvReader.close();

		csvReader = new BufferedReader(new FileReader(filePath));
		String[][] res = new String[lineNumber][];

		int i = 0;
		while ((row = csvReader.readLine()) != null) {
		    res[i++] = row.split(",");
		}

		csvReader.close();

		return res;
		// return res.toArray(new String[res.size()][]);
	}

	public static void main(String[] args) throws IOException {

		String[][] data = readCSV(args[0]);

		for (String[] row: data) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println(data.length);
		System.out.println(data[0].length);

	}
}