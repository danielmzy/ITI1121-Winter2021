/**
 * This class enables the construction of a decision tree
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 * @author Guy-Vincent Jourdan, University of Ottawa
 *
 */

public class DecisionTree {

	private static class Node<E> {
		E data;
		Node<E>[] children;

		Node(E data) {
			this.data = data;
		}
	}

	Node<VirtualDataSet> root;

	/**
	 * @param data is the training set (instance of ActualDataSet) over which a
	 *             decision tree is to be built
	 */
	public DecisionTree(ActualDataSet data) {
		if (data == null)
			throw new NullPointerException("Cannot create a decision tree for a null dataset.");

		root = new Node<VirtualDataSet>(data.toVirtual());
		build(root);
	}

	/**
	 * The recursive tree building function
	 * 
	 * @param node is the tree node for which a (sub)tree is to be built
	 */
	@SuppressWarnings("unchecked")
	private void build(Node<VirtualDataSet> node) {

		if (node == null)
			throw new NullPointerException("Cannot built a decision (sub)tree for a null node.");

		VirtualDataSet set = node.data;

		if (set == null || set.getNumberOfDatapoints() == 0 || set.getNumberOfAttributes() == 0)
			throw new IllegalStateException("The dataset is in an invalid state!");

		if (set.getNumberOfAttributes() == 1) // We have only the class attribute left
			return;

		if (set.getAttribute(set.getNumberOfAttributes() - 1).getValues().length == 1) // No uncertainty left
			return;

		boolean needsSplit = false;

		for (int i = 0; i < set.getNumberOfAttributes() - 1; i++) {
			if (set.getAttribute(i).getValues().length < 2) {
				continue;
			}
			needsSplit = true;
		}

		if (!needsSplit) // split would be futile for all remaining attributes
			return;

		GainInfoItem[] gains = InformationGainCalculator.calculateAndSortInformationGains(set);
		
		if (gains[0].getGainValue() == 0.0) // No split when there is no gain
			return; 

		Attribute bestAttribute = set.getAttribute(gains[0].getAttributeName());

		if (bestAttribute.getType() == AttributeType.NOMINAL) {
			VirtualDataSet[] partitions = set
					.partitionByNominallAttribute(set.getAttributeIndex(bestAttribute.getName()));
			node.children = (Node<VirtualDataSet>[]) new Node[partitions.length];

			for (int i = 0; i < node.children.length; i++) {
				node.children[i] = new Node<VirtualDataSet>(partitions[i]);
			}

			for (int i = 0; i < node.children.length; i++) {
				build(node.children[i]);
			}

		} else {
			int attributeIndex = node.data.getAttributeIndex(bestAttribute.getName());

			String[] values = bestAttribute.getValues();

			int valueIndex = -1;

			for (int i = 0; i < values.length; i++) {
				if (values[i].equals(gains[0].getSplitAt())) {
					valueIndex = i;
					break;
				}
			}

			if (valueIndex == -1) {
				System.out.println("Houston, we have a problem!");
				return;
			}

			VirtualDataSet[] partitions = set.partitionByNumericAttribute(attributeIndex, valueIndex);

			node.children = (Node<VirtualDataSet>[]) new Node[partitions.length];

			for (int i = 0; i < node.children.length; i++) {
				node.children[i] = new Node<VirtualDataSet>(partitions[i]);
			}

			for (int i = 0; i < node.children.length; i++) {
				build(node.children[i]);
			}
		}
	}

	@Override
	public String toString() {
		return toString(root, 0);
	}

	/**
	 * The recursive toString function
	 * 
	 * @param node        is the tree node for which an if-else representation is to
	 *                    be derived
	 * @param indentDepth is the number of indenting spaces to be added to the
	 *                    representation
	 * @return an if-else representation of node
	 */
	private String toString(Node<VirtualDataSet> node, int indentDepth) {
		String indent = createIndent(indentDepth);

		if (node == null)
			return null;

		if (indentDepth < 0)
			throw new IllegalArgumentException("indentDepth cannot be a negative number.");

		if (node.children == null) {
			Attribute classAttribute = node.data.getAttribute(node.data.getNumberOfAttributes() - 1);
			return indent + classAttribute.getName() + " = " + classAttribute.getValues()[0] + System.lineSeparator();
		}

		int statementNo = 0;

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < node.children.length; i++) {
			buffer.append(indent + ((statementNo++ == 0) ? "if (" : "else if (") + node.children[i].data.getCondition()
					+ ") {" + System.lineSeparator());
			buffer.append(toString(node.children[i], indentDepth + 2));
			buffer.append(indent + "}" + System.lineSeparator());
		}

		return buffer.toString();
	}

	/**
	 * @param indentDepth is the depth of the indentation
	 * @return a string containing indentDepth spaces; the returned string (composed
	 *         of only spaces) will be used as a prefix by the recursive toString
	 *         method
	 */
	private static String createIndent(int indentDepth) {
		if (indentDepth <= 0) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < indentDepth; i++) {
			buffer.append(' ');
		}
		return buffer.toString();
	}

	public static void main(String[] args) throws Exception {
		StudentInfo.display();

		if (args == null || args.length == 0) {
			System.out.println("Expected a file name as argument!");
			System.out.println("Usage: java DecisionTree <file name>");
			return;
		}

		String strFilename = args[0];

		ActualDataSet data = new ActualDataSet(new CSVReader(strFilename));

		DecisionTree dtree = new DecisionTree(data);

		System.out.println(dtree);
	}

	public static void mainTest(String[] args) {

		StudentInfo.display();

		try {
			ActualDataSet data1 = new ActualDataSet(
					new CSVReader("weather-nominal.csv"));
			DecisionTree dtree1 = new DecisionTree(data1);

			System.out.println("*** Decision tree for weather-nominal.csv ***");
			System.out.println();

			System.out.println(dtree1);

			System.out.println("*** Decision tree for weather-numeric.csv ***");
			System.out.println();

			ActualDataSet data2 = new ActualDataSet(
					new CSVReader("weather-numeric.csv"));
			DecisionTree dtree2 = new DecisionTree(data2);

			System.out.println(dtree2);

			System.out.println("*** Decision tree for credit-info.csv ***");
			System.out.println();

			ActualDataSet data3 = new ActualDataSet(new CSVReader("credit-info.csv"));
			DecisionTree dtree3 = new DecisionTree(data3);

			System.out.println(dtree3);

			System.out.println("*** Decision tree for diabetes.csv ***");
			System.out.println();

			ActualDataSet data4 = new ActualDataSet(new CSVReader("diabetes.csv"));
			DecisionTree dtree4 = new DecisionTree(data4);

			System.out.println(dtree4);
		} catch (Exception e) {
			System.out.println("Oops! Something went wrong.");
			e.printStackTrace();

		}
	}
}
