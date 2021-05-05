import java.io.IOException;

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
		VirtualDataSet[] newDataSet = null;
		boolean marker = false; 
		double maximum_n;  

		if (node == null || node.data == null) {
			throw new NullPointerException("Null parameter detected!!");
		}
		if (node.data.getNumberOfAttributes() < 1) {
			throw new IllegalArgumentException("No target values exist!!");
		}

		if ((node.data.numAttributes == 1) || (node.data.getAttribute(node.data.numAttributes - 1).getValues().length == 1)) {
			return;
		}
		for (int x = 0; x < node.data.numAttributes - 1; x++) {
			if (node.data.getAttribute(x).getValues().length > 1) {
				marker = true;
			}
		}
		if (marker == false) { 
			return;
		} else if (marker == true) {
			GainInfoItem[] units = InformationGainCalculator.calculateAndSortInformationGains(node.data);
			maximum_n = units[0].getGainValue();
			if (units[0].getAttributeType() == AttributeType.NOMINAL) {
				newDataSet = node.data
						.partitionByNominallAttribute(node.data.getAttributeIndex(units[0].getAttributeName()));
			} else if (units[0].getAttributeType() == AttributeType.NUMERIC) {
				int humidityIndex = node.data.getAttributeIndex(units[0].getAttributeName());
				Attribute valueOfHumidity = node.data.getAttribute(humidityIndex); 
				String[] values = valueOfHumidity.getValues();
				int eightyIndex = -1; 
				for (int x = 0; x < values.length; x++) {
					if (values[x].equals(units[0].getSplitAt())) {
						eightyIndex = x; 
						break;
					}
				}
				newDataSet = node.data.partitionByNumericAttribute(
						node.data.getAttributeIndex(units[0].getAttributeName()), eightyIndex);
			}
			node.children = (Node<VirtualDataSet>[]) new Node[newDataSet.length];
			for (int x = 0; x < node.children.length; x++) {
				node.children[x] = new DecisionTree.Node(newDataSet[x]);
			}
			for (int x = 0; x < node.children.length; x++) {
				build(node.children[x]);
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
		String stringToReturn = ""; 
		if (node == root.children[0]) {
			System.out.println("*** Decision tree for " + node.data.getSourceDataSet().getSourceId() + " ***\n");
		}
		if (node.children != null) {
			for (int x = 0; x < node.children.length; x++) {
				if (x == 0) {
					stringToReturn += createIndent(indentDepth) + "if (" + node.children[x].data.getCondition() + ") {" + "\n";
				} else {
					stringToReturn += createIndent(indentDepth) + "else if (" + node.children[x].data.getCondition() + ") {" + "\n";
				}
					stringToReturn += toString(node.children[x], indentDepth + 1);
				if ((x == node.children.length - 1) && (node != root.children[root.children.length - 1])) {
					stringToReturn += createIndent(indentDepth - 1) + "}\n";
				}

			}
		} else {
			stringToReturn = "";
			stringToReturn += createIndent(indentDepth + 1)	+ node.data.attributes[node.data.attributes.length - 1].getName() + " = " + node.data.getUniqueAttributeValues(node.data.attributes.length - 1)[0] + "\n";
			stringToReturn += createIndent(indentDepth - 1) + "}" + "\n";

		}
		return stringToReturn;
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
		for (int x = 0; x < indentDepth; x++) {
			buffer.append(' ');
		}
		return buffer.toString();
	}

	public static void main(String[] args) throws Exception {

        StudentInfo.display();

        if (args == null )
            throw new NullPointerException("Expected a file name as argument! -> Usage: java DecisionTree <file name>");
        if(args.length == 0)
            throw new ArrayIndexOutOfBoundsException("Expected a file name as argument! -> Usage: java DecisionTree <file name>");

        String strFilename = args[0];

        ActualDataSet data = new ActualDataSet(new CSVReader(strFilename));

        DecisionTree dtree = new DecisionTree(data);

        System.out.println(dtree);

    }
}