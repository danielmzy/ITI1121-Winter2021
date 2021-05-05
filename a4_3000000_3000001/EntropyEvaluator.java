/**
 * This class enables calculating (weighted-average) entropy values for a set of
 * datasets
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 * @author Guy-Vincent Jourdan, University of Ottawa
 *
 */
public class EntropyEvaluator {

	/**
	 * if (partitions == null ){ throw new NullPointerException("The DataSet array
	 * is null"); if(partitions.length == 0){ throw new
	 * ArrayIndexOutOfBoundsException("The length of the DataSet array is 0"); } A
	 * static method that calculates the weighted-average entropy of a given set
	 * (array) of datasets. The assignment description provides a detailed
	 * explanation of this calculation. In particular, note that all logarithms are
	 * to base 2. For your convenience, we provide a log2 method. You can use this
	 * method wherever you need to take logarithms in this assignment.
	 * 
	 * @param partitions is the array of datasets to compute the entropy of
	 * @return Shannon's logarithmic entropy (to base 2) for the partitions
	 */
	public static double evaluate(DataSet[] partitions) {

		if (partitions == null) {
			throw new NullPointerException("DataSet array is null for the method to work on");
		}

		if (partitions.length == 0) {
			throw new IllegalArgumentException("length of DataSet array passed on is 0");
		}
		
		// All partitions will have the same attributes, so we simply take the first:
		DataSet p = partitions[0];

		// Assume that "class" is the last attribute.
		int classIndex = p.getNumberOfAttributes() - 1; 

		double[] entropyValues = new double[partitions.length];
		int totalCount = 0;

		for (int i = 0; i < partitions.length; i++) {
			String[] classes = partitions[i].getUniqueAttributeValues(classIndex);
			int currentPartitionSize = partitions[i].getNumberOfDatapoints();

			if (currentPartitionSize == 0)
				continue;

			totalCount += currentPartitionSize;

			int[] classCounts = new int[classes.length];

			for (int j = 0; j < partitions[i].getNumberOfDatapoints(); j++) {
				String cls = partitions[i].getValueAt(j, classIndex);
				for (int k = 0; k < classes.length; k++) {
					if (cls.equals(classes[k])) {
						classCounts[k]++;
						break;
					}
				}
			}

			for (int k = 0; k < classes.length; k++) {
				if (classCounts[k] == 0)
					continue;
				entropyValues[i] += -1 * (((double) classCounts[k]) / currentPartitionSize)
						* log2(((double) classCounts[k]) / currentPartitionSize);
			}

		}

		if (totalCount == 0)
			return 0;

		double average = 0;

		for (int i = 0; i < partitions.length; i++) {
			average += (((double) partitions[i].getNumberOfDatapoints()) / totalCount) * entropyValues[i];
		}

		return average;
	}

	/**
	 * Calculate base-2 logarithm for a given number
	 * 
	 * @param x is the number to take the logarithm of
	 * @return base-2 logarithm for x
	 */
	public static double log2(double x) {
		return (Math.log(x) / Math.log(2));
	}
}
