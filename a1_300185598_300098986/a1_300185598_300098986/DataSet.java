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
		instantiateFromFile(strFilename);
	}

	/**
	 * Returns the name of the attribute at a given column index
	 * 
	 * @param column is the column index
	 * @return attribute name at index (null if the index is out of range)
	 */
	public String getAttributeName(int column) {
		if(column >= this.numColumns){
			return null;
		}
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
		if((row >= this.numRows) || (column >= this.numColumns)){
			return null;
		}
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

		int indexAttributeName = 0;
		for(int i = 0; i < this.attributeNames.length; i++){
			if(attributeName.equals(this.attributeNames[i])){
				indexAttributeName = i;
				break;
			}
		}

		String[] uniqueValuesArray = getUniqueAttributeValues(indexAttributeName);
		
		return uniqueValuesArray;
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
		String[] array = new String[this.numRows];
		String[] uniqueValuesArray;
		boolean isValueUnique = true;
		int numElements = 0;
		for(int i = 0; i < array.length; i++){
			String valueToCompare = this.matrix[i][column];

			for(String element:array){
				try{
				if(element.equals(valueToCompare)){
					isValueUnique = false;
					break;
				}
			}catch (Exception e){
				isValueUnique = true;
			}
			}
			if(isValueUnique == true){
				array[numElements] = matrix[i][column];
				numElements++;
			}
		}
			String[] dummyArray = new String[numElements];
			for (int i = 0; i < dummyArray.length; i++) {
			if(!array[i].equals("null")){
				dummyArray[i] = array[i];
			}
		}
	return dummyArray;
	}
	
	/**
	 * Returns in the form of an explanatory string some important characteristics
	 * of the dataset. These characteristics are: the number of attributes, the
	 * number of datapoints and the unique values that each attribute can assume
	 * 
	 * @return String containing the characteristics (metadata)
	 */
	public String metadataToString() {

		String separator = System.getProperty("line.separator");
		String text = "";
		String finalText = "Number of attributes: " + this.numColumns + separator + "Number of datapoints: " + this.numRows + separator + separator + "* * * Attribute value sets * * *" + separator;
		for (int i = 0; i < this.attributeNames.length; i++){
			String[] uniqueValueArray = getUniqueAttributeValues(attributeNames[i]);
			if (Util.isArrayNumeric(uniqueValueArray)){
				String line = Util.numericArrayToString(uniqueValueArray);
				text = "" + (i + 1) + ")" + attributeNames[i] + ": ";
				text = text + line + separator;
			}
			else {
				String line = Util.nominalArrayToString(uniqueValueArray);
				text = "" + (i + 1) + ")" + attributeNames[i] + ": ";
				text = text + line + separator;
			}
			finalText = finalText + text;
		}
		return finalText;
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

        StudentInfo.display();

		System.out.print("Please enter the name of the CSV file to read: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		DataSet dataset = new DataSet(strFilename);

		System.out.print(dataset.metadataToString());

	}

	/**
	 * This method should set the numColumns and numRows instance variables
	 * The method is incomplete; you need to complete it.
	 * @param strFilename is the name of the dataset file
	 */
	private void calculateDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		
		// YOU ARE ALLOWED TO DEFINE LOCAL VARIABLES

		int rowCounter = 0;
		int colCounter = 0;
		boolean colCondition = false;
		boolean quoteCondition = false;
		while (scanner.hasNext()) {
			// Read one full line from file
			String str = scanner.nextLine();

			if (str.strip() != ""){
				if (colCondition == false){
					for (int i = 0; i < str.length(); i++){
						char charLoop = str.charAt(i);
						if((charLoop == QUOTE_MARK) && (quoteCondition == false)){
							quoteCondition = true;
						}
						else if((charLoop == QUOTE_MARK) && (quoteCondition == true)){
							quoteCondition = false;
						}
						else if((charLoop == DELIMITER) && (quoteCondition == false)){
							colCounter++;
						}
						if (i == str.length() - 1){
							colCounter++;
						}
					}
					colCondition = true;
				}
				else {
					rowCounter++;
				}
			}
		}
		this.numColumns = colCounter;
		this.numRows = rowCounter;
	}

	/**
	 * This method should load the attribute names into the attributeNames
	 * instance variable and load the datapoints into the matrix instance variable.
	 * The method is incomplete; you need to complete it.
	 * @param strFilename is the name of the file to read
	 */
	private void instantiateFromFile(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));
		
		// YOU ARE ALLOWED TO DEFINE LOCAL VARIABLES
		int rowCounter = 0;
		String[][] matrix1 = new String[this.numRows][this.numColumns];
		String[] attributeNames1 = new String[this.numColumns];
		boolean colCondition = false;
		
		boolean quoteCondition2 = false;
		int rowIndex2 = 0;
		int columnIndex = 0;
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (str.strip() != ""){
				if (colCondition == false){
					String stringLoop = "";
					boolean quoteCondition = false;
					int rowIndex = 0;
					for (int i = 0; i < str.length(); i++) {
						char charLoop = str.charAt(i);
						if((charLoop == QUOTE_MARK) && (quoteCondition == false)){
							quoteCondition = true;
						}
						else if((charLoop == QUOTE_MARK) && (quoteCondition == true)){
							quoteCondition = false;
						}
						else if((charLoop == DELIMITER) && (quoteCondition == false)){
							attributeNames1[rowIndex] = stringLoop.strip();
							rowIndex++;
							stringLoop = "";
						}
						else{
							stringLoop = stringLoop + charLoop;
						}
						if(i == str.length() - 1){
							attributeNames1[rowIndex] = stringLoop.strip();
							rowIndex++;
						}
					}
					colCondition = true;
				}
				else{
					rowIndex2=0;
					String stringLoop2 = "";
					for (int i = 0; i < str.length(); i++) {
						char charLoop = str.charAt(i);
						if((charLoop == QUOTE_MARK) && (quoteCondition2 == false)){
							quoteCondition2 = true;
						}
						else if((charLoop == QUOTE_MARK) && (quoteCondition2 == true)){
							quoteCondition2 = false;
						}
						else if((charLoop == DELIMITER) && (quoteCondition2 == false)){
							matrix1[columnIndex][rowIndex2] = stringLoop2.strip();
							rowIndex2++;
							stringLoop2 = "";
						}
						else{
							stringLoop2 = stringLoop2 + charLoop;
						}
						if(i == str.length() - 1){
							matrix1[columnIndex][rowIndex2] = stringLoop2.strip();
							rowIndex2++;
						}
						if(rowIndex2 == numColumns){
							columnIndex++;
						}
					}
				matrix = matrix1;
				}
				
			}
		}
	attributeNames = attributeNames1;
	}
}