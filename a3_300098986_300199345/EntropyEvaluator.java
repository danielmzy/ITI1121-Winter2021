
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
	 * A static method that calculates the weighted-average entropy of a given set
	 * (array) of datasets. The assignment description provides a detailed
	 * explanation of this calculation. In particular, note that all logarithms are
	 * to base 2. For your convenience, we provide a log2 method. You can use this
	 * method wherever you need to take logarithms in this assignment.
	 * 
	 * @param partitions is the array of datasets to compute the entropy of
	 * @return Shannon's logarithmic entropy (to base 2) for the partitions
	 */
	public static double evaluate(DataSet[] partitions) {

		try {
			double win = 0.00; 
			double entireYesNoCount = 0.00; 
			double entireYes = 0.00;  
			double entireNo = 0.00; 
			String[] uniqueAttributes = partitions[0].getUniqueAttributeValues(partitions[0].numAttributes - 1);
			for (DataSet elem : partitions) {
				for (int z = 0; z < elem.numRows; z++) {
					entireYesNoCount = entireYesNoCount + 1;
				}
			}
			for (DataSet elem : partitions) {
				double entropyValue = 0.00;
				double yesCount = 0; 
				double noCount = 0; 
				for (int y = 0; y < elem.numRows; y++) {
					if (elem.getValueAt(y, elem.numAttributes - 1).equals(uniqueAttributes[0])) {
						yesCount= yesCount + 1;
					} else { // if (elem.getValueAt(j, elem.numAttributes -
								// 1).equals(uniqueAttributes[1])){
						noCount = noCount + 1;
					}
				}
				entireYes = entireYes + yesCount; 
				entireNo = entireNo + noCount;
				double rationalOne = yesCount / (yesCount + noCount);
				double rationalTwo = noCount / (yesCount + noCount);
				double logMajor = log2(rationalOne);
				double logMinor = log2(rationalTwo); 

				if (yesCount > 0 && noCount > 0) {
					entropyValue += ((-1 * rationalOne * logMajor) - (rationalTwo * logMinor));
					win += (entropyValue * ((noCount + yesCount) / entireYesNoCount));
				}

			}
			double rationalOne = entireYes / (entireYesNoCount);
			double rationalTwo = entireNo / (entireYesNoCount);
			double logMajor = log2(rationalOne);
			double logMinor = log2(rationalTwo); 
			double entropyDataSet = ((-1 * rationalOne * logMajor) - (rationalTwo * logMinor));
			return entropyDataSet - win; 
		} catch (Exception e) {
			System.out.println(" A problem has been found for the evaluate() method in EntropyEvaluator.java ");
			return -1;

		}
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
