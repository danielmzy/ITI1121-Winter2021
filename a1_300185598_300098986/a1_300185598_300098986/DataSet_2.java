import java.io.File;
import java.util.Scanner;

/**
 * The class enables loading a dataset from a file (CSV format) and deriving
 * some important characteristics of the data
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 * @author Guy-Vincent Jourdan, University of Ottawa
 *
 */
public class DataSet {

	/**
	 * The delimiter that separates attribute names and attribute values
	 */
	private static final char DELIMITER = ',';

	/**
	 * Character allowing escape sequences containing the delimiter
	 */
	private static final char QUOTE_MARK = '\'';

	/**
	 * Instance variable for storing the number of attributes (columns)
	 */
	private int numColumns;

	/**
	 * Instance variable for storing the number of datapoints (data rows)
	 */
	private int numRows;

	/**
	 * Instance variable for storing attribute names
	 */
	private String[] attributeNames;

	/**
	 * Instance variable for storing datapoints
	 */
	private String[][] matrix;

	/**
	 * Constructs a dataset by loading a CSV file
	 * 
	 * @param strFilename is the name of the file
	 */
	public DataSet(String strFilename) throws Exception {

		calculateDimensions(strFilename);

		attributeNames = new String[numColumns];

		matrix = new String[numRows][numColumns];

		instantiateFromFile(strFilename);
	}

	/**
	 * Returns the name of the attribute at a given column index
	 * 
	 * @param column is the column index
	 * @return attribute name at index (null if the index is out of range)
	 */
	public String getAttributeName(int column) {
		if (column < 0 || column >= numColumns)
			return null;

		return attributeNames[column];
	}

	/**
	 * Returns the value of a given column for a given row (datapoint)
	 * 
	 * @param row    is the row (datapoint) index
	 * @param column is the column index
	 * @return the value of the attribute at column for the datapoint at row (null
	 *         if either row or column are out of range)
	 */
	public String getAttributeValue(int row, int column) {

		if (row < 0 || row >= numRows)
			return null;

		if (column < 0 || column >= numColumns)
			return null;

		return matrix[row][column];
	}

	/**
	 * Returns the number of attributes
	 * 
	 * @return number of attributes
	 */
	public int getNumberOfAttributes() {
		return numColumns;
	}

	/**
	 * Returns the number of datapoints
	 * 
	 * @return number of datapoints
	 */
	public int getNumberOfDatapoints() {
		return numRows;
	}

	/**
	 * Returns a reference to an array containing the unique values that an
	 * attribute can assume in the dataset
	 * 
	 * @param attributeName is the name of the attribute whose unique values must be
	 *                      returned
	 * @return String[] reference to the unique values of the the attribute with the
	 *         given name
	 */
	public String[] getUniqueAttributeValues(String attributeName) {

		if (attributeName == null) {
			return null;
		}

		for (int i = 0; i < attributeNames.length; i++) {
			if (attributeName.equals(attributeNames[i])) {
				return getUniqueAttributeValues(i);
			}
		}
		return null;
	}

	/**
	 * Returns a reference to an array containing the unique values that the
	 * attribute at a certain column can assume in the dataset
	 * 
	 * @param column is the index (staring from zero) for the attribute whose unique
	 *               values must be returned
	 * @return String[] reference to the unique values of the attribute at the given
	 *         column
	 */
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

			if (!found) {
				tempValues[count++] = matrix[i][column];
			}
		}

		String[] values = new String[count];

		for (int i = 0; i < count; i++) {
			values[i] = tempValues[i];
		}

		return values;
	}

	/**
	 * Returns in the form of an explanatory string some important characteristics
	 * of the dataset. These characteristics are: the number of attributes, the
	 * number of datapoints and the unique values that each attribute can assume
	 * 
	 * @return String containing the characteristics (metadata)
	 */
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

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the CSV file to process. Next, it creates an instance of
	 * DataSet. Finally, it prints to the standard output the metadata of the
	 * instance of the DataSet just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 */
	public static void main(String[] args) throws Exception {

		System.out.print("Please enter the name of the CSV file to read: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		DataSet dataset = new DataSet(strFilename);

		System.out.print(dataset.metadataToString());

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