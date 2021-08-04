/**
 * The class  <b>BirthdayParadox</b> is used to
 * simulated the so-called Birthday paradox, and uses
 * the class <b>Statistics</b> to store the results of
 * the experiments.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class BirthdayParadox {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();


	/** 
     * Runs the series of experiments, and stores the result into
     * a Statistics object
     * 
     * @param range the size of the set from which random number are drawn
     * @param numberOfRuns the number of experiments to run
	 *
	 * @return a reference to a Statistics instance the holds the result
	 * of the experiment
     */
 	public static Statistics runExperiments(int range, int numberOfRuns){

 		Statistics stats = new Statistics(numberOfRuns);
		for(int i = 0; i < numberOfRuns; i++){
			stats.updateStatistics(oneRun(range));
		}
		return stats;
	}

 	/** 
     * Runs a single experiment.
     * The parameter range defines the size of the set from which
     * the experiment is drawn
     * 
     * @param range the size of the set from which random number are drawn
     *
	 * @return the number of random draw in the set that the method 
	 * used before drawing an element of the set for the second time
     */
	
 	private static int oneRun(int range){

		boolean[] drawnValues = new boolean[range];
		
/*	
		// This code isn't needed, since the default boolean value is false
		for(int i = 0; i < drawnValues.length; i++){
			drawnValues[i]= false;
		}
*/

		int counter = 1;
		int nextDraw = generator.nextInt(drawnValues.length);
		while(!drawnValues[nextDraw]){
			drawnValues[nextDraw] = true;
			counter ++;	
			nextDraw = generator.nextInt(drawnValues.length);
		}

		return counter;
	}
	

	/** 
     * Main method. The default size of the set is 365, and
     * the experiment is run 50 times. Both numbers can be reset
     * from the command line.
     * This method runs the experiments and prints the
     * resulting Statistics
     * 
     * @param args if not empty, contains the runtime values for
     * the size of the set and the number of runs
     */
	public static void main(String[] args) {

		int range = 365;
		int numberOfRuns= 50;
		
		//StudentInfo.display();

		if (args.length == 2) {
			range = Integer.parseInt(args[0]);
			numberOfRuns = Integer.parseInt(args[1]);
		} 
		
		System.out.println(runExperiments(range,numberOfRuns));
	}

}
