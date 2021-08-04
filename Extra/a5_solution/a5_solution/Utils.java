import java.io.*;

/** Helper methods for this assignment.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Utils {

    private static boolean isLinear = true;

    /** The method is used to specify the type of object to be
     * returned by the method getFrequencyTable.
     *
     * @param value true if getFrequencyTable should return an object of the class LinearFrequencyTable
     */
    
    public static void setLinear(boolean value) {
	isLinear = value;
    }

    /** A factory method returning an object implementing the
     * interface FrequencyTable. The actual type depends on the
     * current selection.
     *
     * @return an object implementing the interface FrequencyTable
     */
    
    public static FrequencyTable getFrequencyTable() {

	if (isLinear) {
	    return new LinearFrequencyTable();
	} else
	    return new TreeFrequencyTable();
    }

    /** Reads a file and returns its content as a String.
     *
     * @param name the name of the file
     * @return a string
     * @throws IOException if an I/O error occurs.
     * @throws FileNotFoundException if the file cannot be found
     */
    
    public static String readFile(String name) throws IOException, FileNotFoundException {

	String line;
	StringBuffer buffer;
	BufferedReader input;
            
	input = new BufferedReader(new InputStreamReader(new FileInputStream(name)));

	buffer = new StringBuffer();

	while ((line = input.readLine()) != null) {
	    buffer.append(line);
	}

	input.close();

	return buffer.toString();
    }

}
