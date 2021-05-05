import java.io.File;
import java.util.Scanner;

public class DataSet {

	private static final char DELIMITER = ',';
	private static final char QUOTE_MARK = '\'';
	
	private int numColumns;
	private int numRows;
	private String[] attributeNames;
	private String[][] matrix;
	
	public static void main(String[] args) throws Exception {
		String strFilename = "weather-with-spaces.csv";
		DataSet dataset = new DataSet(strFilename);
		System.out.print(dataset.metadataToString());
	}
	
	public DataSet(String strFilename) throws Exception {
		calculateDimensions(strFilename);
		attributeNames = new String[numColumns];
		matrix = new String[numRows][numColumns];
		instantiateFromFile(strFilename);
	}

	public String getAttributeName(int column) {
		if (column < 0 || column >= numColumns)
			return null;
		return attributeNames[column];
	}

	public String getAttributeValue(int row, int column) {
		if (row < 0 || row >= numRows) return null;
		if (column < 0 || column >= numColumns) return null;
		return matrix[row][column];
	}

	public int getNumberOfAttributes() {
		return numColumns;
	}

	public int getNumberOfDatapoints() {
		return numRows;
	}

	public String[] getUniqueAttributeValues(String attributeName) {
		if (attributeName == null) return null;
		for (int i = 0; i < attributeNames.length; i++) {
			if (attributeName.equals(attributeNames[i])) {
				return getUniqueAttributeValues(i);
			}
		}
		return null;
	}

	private String[] getUniqueAttributeValues(int column) {
		String[] tempValues = new String[matrix.length];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			boolean found = false;
			for (int j = 0; j < count; j++) {
				if (matrix[i][column].equals(tempValues[j])) {
					found = true;
					break;
				}
			}
			if (!found) tempValues[count++] = matrix[i][column];
		}

		String[] values = new String[count];
		for (int i = 0; i < count; i++) values[i] = tempValues[i];
		return values;
	}

	public String metadataToString() {
		StringBuffer buffer = new StringBuffer();
		String separator = System.getProperty("line.separator");
		buffer.append("Number of attributes: ").append(numColumns).append(separator);
		buffer.append("Number of datapoints: ").append(numRows).append(separator).append(separator);
		buffer.append("* * * Attribute value sets * * *").append(separator);

		for (int i = 0; i < attributeNames.length; i++) {
			buffer.append(i + 1 + ") " + attributeNames[i]);
			String[] values = getUniqueAttributeValues(i);
			if (Util.isArrayNumeric(values)) {
				buffer.append(" (numeric): ");
				buffer.append(Util.numericArrayToString(values));
				buffer.append(separator);
			} else {
				buffer.append(" (nominal): ");
				buffer.append(Util.nominalArrayToString(values));
				buffer.append(separator);
			}
		}

		return buffer.toString();
	}

	private void calculateDimensions(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));
		boolean firstLine = true;
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (!str.trim().isEmpty()) {
				if (firstLine) {
					numColumns = countColumns(str);
					firstLine = false;
				} else {
					numRows++;
				}
			}
		}
		scanner.close();
	}

	private void instantiateFromFile(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));
		boolean firstLine = true;
		int rowNum = 0;
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (!str.trim().isEmpty()) {
				if (firstLine) {
					firstLine = false;
					populateAttributeNames(str);
				} else {
					populateRow(str, rowNum++);
				}
			}
		}
		scanner.close();
	}

	private void populateAttributeNames(String str) {
		if (str == null || str.isEmpty()) {
			return;
		}
		StringBuffer buffer = new StringBuffer();
		boolean isInQuote = false;
		int position = 0;
		char[] chars = str.toCharArray();
		char ch;
		for (int i = 0; i < chars.length; i++) {
			ch = chars[i];
			if (isInQuote) {
				if (ch == QUOTE_MARK) {
					isInQuote = false;
				} else {
					buffer.append(ch);
				}
			} else if (ch == QUOTE_MARK) {
				isInQuote = true;
			} else if (ch == DELIMITER) {
				attributeNames[position++] = buffer.toString().trim();
				buffer.delete(0, buffer.length());
			} else {
				buffer.append(ch);
			}
		}
		if (buffer.toString().trim().length() > 0) { // deal with last attribute name
			attributeNames[position++] = buffer.toString().trim();
		}
	}

	private void populateRow(String str, int currentRow) {
		if (str == null || str.isEmpty()) {
			return;
		}
		StringBuffer buffer = new StringBuffer();
		boolean isInQuote = false;
		int position = 0;
		char[] chars = str.toCharArray();
		char ch;
		for (int i = 0; i < chars.length; i++) {
			ch = chars[i];
			if (isInQuote) {
				if (ch == QUOTE_MARK) {
					isInQuote = false;
				} else {
					buffer.append(ch);
				}
			} else if (ch == QUOTE_MARK) {
				isInQuote = true;
			} else if (ch == DELIMITER) {
				matrix[currentRow][position++] = buffer.toString().trim();
				buffer.delete(0, buffer.length());
			} else {
				buffer.append(ch);
			}
		}
		if (buffer.toString().trim().length() > 0) { // deal with last attribute value
			matrix[currentRow][position++] = buffer.toString().trim();
		} else if (chars[chars.length - 1] == ',') {// deal with potentially missing last attribute value
			matrix[currentRow][position++] = "";
		}
	}

	private static int countColumns(String str) {
		int count = 0;
		if (str == null || str.isEmpty()) {
			return count;
		}
		char[] chars = str.toCharArray();
		boolean isInQuote = false;
		char ch;
		for (int i = 0; i < chars.length; i++) {
			ch = chars[i];
			if (isInQuote) {
				if (ch == QUOTE_MARK) {
					isInQuote = false;
				}
			} else if (ch == QUOTE_MARK) {
				isInQuote = true;
			} else if (ch == DELIMITER) {
				count++;
			}
		}
		return count + 1;
	}
}
