/**
 * This class enables the calculation and sorting of information gain values, where gain is represented by vairable win(s)
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 * @author Guy-Vincent Jourdan, University of Ottawa
 *
 */
public class InformationGainCalculator {

	/**
	 * @param dataset is the dataset whose attributes we want to analyze and sort
	 *                according to information gain
	 * @return an array of GainInfoItem instances sorted in descending order of gain
	 *         value
	 */
	public static GainInfoItem[] calculateAndSortInformationGains(VirtualDataSet dataset) {
		try{
		GainInfoItem[] wins = new GainInfoItem[dataset.getNumberOfAttributes() - 1];

		for (int i = 0; i < dataset.getNumberOfAttributes() - 1; i++) {

			if (Util.isArrayNumeric(dataset.getUniqueAttributeValues(i))) {
				String onCueSplit = numericEntropyCalc(i, dataset);
				// VirtualDataSet[] infoArray2 = dataset.partitionByNumericAttribute(2, 4); 
				// double valueOfEntropy2 = EntropyEvaluator.evaluate(infoArray2);
				wins[i] = new GainInfoItem(dataset.getAttribute(i).getName(), AttributeType.NUMERIC,
						Double.parseDouble(onCueSplit.split(",")[0]), onCueSplit.split(",")[1]); 
			} else {
				VirtualDataSet[] infoArray = dataset.partitionByNominallAttribute(i);
				double valueOfEntropy = EntropyEvaluator.evaluate(infoArray);
				wins[i] = new GainInfoItem(dataset.getAttribute(i).getName(), AttributeType.NOMINAL, valueOfEntropy, null);
			}

		}
		GainInfoItem.reverseSort(wins); 
		return wins;
	}catch(Exception e){
		System.out.println(" In InformationGainCalculator.java file, a problem has been found for the the calculateAndSortInformationGains() method. ");
		return null;
	}
	}

	private static String numericEntropyCalc(int i, VirtualDataSet dataSet) {
		String recoveryString = "";
		int indexNumeric = -1; 
		String[] amounts;

		if (Util.isArrayNumeric(dataSet.getAttribute(i).getValues())) {
			indexNumeric = i;
			amounts = dataSet.getAttribute(i).getValues();
			double[] entropyTotal = new double[amounts.length];
			for (int x = 0; x < amounts.length; x++) {
				VirtualDataSet[] infoArray2 = dataSet.partitionByNumericAttribute(indexNumeric, x);
				double valueOfEntropy = EntropyEvaluator.evaluate(infoArray2);
				entropyTotal[x] += valueOfEntropy;

			}
			double maxNumber = 0;
			for (int x = 0; x < entropyTotal.length; x++) {
				maxNumber = Math.max(entropyTotal[x], maxNumber);
			}
			recoveryString += maxNumber + ",";
			for (int x = 0; x < amounts.length; x++) {
				VirtualDataSet[] infoArray2 = dataSet.partitionByNumericAttribute(indexNumeric, x);
				double valueOfEntropy2 = EntropyEvaluator.evaluate(infoArray2);
				if (valueOfEntropy2 == maxNumber) {
					recoveryString += amounts[x] + ",";

					return recoveryString;
				}
			}
		}

		return null;

	}

	public static void main(String[] args) throws Exception {

		StudentInfo.display();

		// if (args == null || args.length == 0) {
		// System.out.println("Expected a file name as argument!");
		// System.out.println("Usage: java InformationGainCalculator <file name>");
		// return;
		// }

		String strFilename = "credit-info.csv";
		// args[0]
		ActualDataSet actual = new ActualDataSet(new CSVReader(strFilename));

		// System.out.println(actual);

		VirtualDataSet virtual = actual.toVirtual();

		System.out.println(virtual);

		GainInfoItem[] items = calculateAndSortInformationGains(virtual);

		// Print out the output
		System.out.println(" *** items are represented by attribute name, information gain in descending order of gain(win here) value *** ");
		System.out.println();

		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}
}
