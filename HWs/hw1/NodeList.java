

/**
 * This class refers to linear collection of nodes
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 * 
 */
public class NodeList {
	// starting node of the List
	private Node startNode;
	// reference to last node in list
	private Node endNode;
	// keeps track of no of nodes inserted
	private int size = 0;

	/**
	 * This method computes array of nodes
	 * 
	 * @return array representation of nodes' data
	 */
	public long[] getArray() {

		long[] numbers = new long[size];
		// starting node of loop
		Node temp = startNode;

		// insert elements in array by going to next node till end node
		for (int i = 0; i < size; i++) {
			numbers[i] = temp.getValue();
			temp = temp.getNext();
		}

		return numbers;
	}

	/**
	 * this method inserts a value in a node list, according to the end pointer
	 * 
	 * @param value
	 *            of node to insert in nodelist
	 */
	public void insert(long value) {
		// if it is start node
		if (startNode == null) {
			startNode = new Node(value);
			endNode = startNode;
		} else {
			Node lastNode = new Node(value);
			endNode.setNextNode(lastNode);
			endNode = lastNode;
		}
		// increment size after inserting the element
		size++;
	}

	/*
	 * getter and setter methods
	 */
	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

}
