

/**
 * This class represents node which stores data and pointer to next element
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 * 
 */
public class Node {

	private long value;
	private Node nextNode;

	/**
	 * parameterized constructor
	 * 
	 * @param number
	 */
	public Node(long number) {
		value = number;
		nextNode = null;
	}

	/**
	 * getter and setter methods
	 */
	public Node getNext() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public long getValue() {
		return value;
	}
}
