
/**
 * The class  <b>Statistics</b> accumulates the results of
 * the experiments. It know ahead of time how many experiments
 * will be run, and provides at the end the min, the max, the
 * average and the standard deviation for the data.
 *
 * <b> this class should not use classes such as Array, 
 * Lists etc. </b> to store the data, only prinitive types 
 * and java arrays.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Statistics {

	private int[] values;
	private int counter;
	private int min, max;

	/** 
     * Constructor.
     * 
     * @param numberOfRuns the number of experiments that will be run
     */
 	public  Statistics(int numberOfRuns){
		values = new int[numberOfRuns];
		counter = 0;		
	}
	
	/** 
     * Updates statistics after one experiment.
     * This method cannot be called more times than the 
     * paramter that was passed in the constructor. If
     * it is, an error message should be printed and
     * no change should occur.
     *   @param value the result of the new experiment
     */
	public void updateStatistics(int value){
		if(counter == 0){
			min=max=value;
		} else if (counter >= values.length) {
			System.out.println("More runs than expected");
		}
		min = Math.min(min,value);
		max = Math.max(max,value);
		values[counter++] = value;
	}
	

	/** 
     *   @return the current average of the values passed
     * to the method updateStatistic
     */
	public double average(){
		double result = 0.0;
		for(int i = 0 ; i < counter; i++){
			result += values[i];
		}
		return result/counter;
	}


	/** 
     *   @return the current standard deviation of the values passed
     * to the method updateStatistic
     */
	public double standardDeviation(){
		
		double mean = average();
		double squareSum = 0;
		for (int i = 0; i < counter; i++) {
			squareSum += Math.pow(values[i] - mean, 2);
		}
		return Math.sqrt((squareSum) / counter);
	}

	/** 
     *  @return Returns the complete statistics information:
     * current minimum, current maximim, current average and
     * current standard deviation. For the last two, only two 
     * digits decimals are shown
     */
	public String toString(){
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		return("We have run " + counter + " experiments.\n\t the minimum was " + min 
			+"\n\t the maximum was: "+ max 
			+ "\n\t the mean was: " + df.format(average()) 
			+ "\n\t the standard deviation was: " + df.format(standardDeviation()));
	}

}
