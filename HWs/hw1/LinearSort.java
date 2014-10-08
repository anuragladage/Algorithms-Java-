
/**
 * This class implements radix sort
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 * 
 */

import java.util.Scanner;

public class LinearSort {
	// the size of array
	public int radix;
	// array of nodelists
	public NodeList[] myArray;
	// the dividend
	private long div = 1;

	/**
	 * constructor with array of size same as input
	 */
	public LinearSort(int radix) {
		this.radix=radix;
		myArray = new NodeList[radix];

		for (int i = 0; i < radix; i++) {
			myArray[i] = new NodeList();
		}
	}

	/**
	 * This method clears the list after every digit sort iteration
	 * 
	 */
	public void clearNodeList() {
		for (int i = 0; i < radix; i++) {
			myArray[i] = new NodeList();
		}
	}

	/**
	 * This method returns the digit at position specified by dividend
	 * 
	 * @param number
	 * @return digit
	 */
	public long getIndex(long number) {
		long digit;
		long divide=number/div;
		digit=divide%radix;
		return digit;
	}

	/**
	 * This method inserts the input elements into the node list according to
	 * the digit
	 * 
	 * @param input
	 *            array
	 */
	public void insertToNodeLists(long[] input) {

		for (int i = 0; i < input.length; i++) {
			// calculate the index according to the digit at specified position
			unsigned int index = (unsigned int) getIndex(input[i]);
			// calls insert method of that nodelist
			myArray[index].insert(input[i]);
		}

	}

	/**
	 * This method sorts the array in total linear time
	 * 
	 * @param input
	 *            array
	 * @param max
	 *            no of digits
	 */
	public void sort(long[] input, int maxdigits) {

		/*
		 * this loop runs for constant time according to the max no of digit
		 * iterations
		 */
		for (int i = 0; i <= maxdigits; i++) {
			int index = 0;

			// this function inserts all the input element in nodelist
			insertToNodeLists(input);

			/*
			 * this loop runs for constant time i.e. size of array 
			 */
			for (int x = 0; x < radix; x++) {

				// this method get the array representation of node list in
				// linear time 
				long[] tempArray = myArray[x].getArray();

				/*
				 * get all the inserted elements back into the array sorted by
				 * the respective digit (linear time)
				 */
				for (int j = 0; j < tempArray.length; j++) {

					if ((index + j) == input.length) {
						return;
					}

					input[index + j] = tempArray[j];
				}

				index = index + tempArray.length;
			}

			// clear nodelists after every digit iteration(constant time)
			clearNodeList();

			// to get next digit after every iteration
			div = div * radix;
		}

	}

	/**
	 * This is main method. It takes input from console by scanner and calls the
	 * for sorting
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			int size = Integer.parseInt(sc.nextLine());
			long[] input = new long[size];

			String inputs = sc.nextLine();
			String[] inputInString = inputs.split(" ");

			sc.close();
			for (int i = 0; i < size; i++) {
				input[i] = Long.parseLong(inputInString[i]);
			}
			
			LinearSort obj = new LinearSort(size);
			obj.sort(input, 3);
			
			// print sorted array
			for (int i = 0; i < size; i++) {
				System.out.print(input[i] + " ");
			}

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
