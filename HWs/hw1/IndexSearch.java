/**
 * IndexSearch.java
 * 
 * Version: $1.0$
 * 
 * Revisions: $Log$
 * 
 * This class gives a representation of Binary Search
 *
 * @author Sushil Mohite
 * @author Hitesh Vyas
 */

import java.util.Scanner;

public class IndexSearch {

	/**
	 * This method performs binary search
	 * 
	 * @param arr contains list of elements
	 * @param start index of the first element
	 * @param end index of the last element
	 * @return true if element is found
	 */
	public static boolean binarySearch(int arr[], int start, int end) {

		// if only 1 or 2 elements remain the check them
		// for the required element.
		if ((end - start == 1) || (start == end)) {
			if (arr[start] == start)
				return true;
			else if (arr[end] == end)
				return true;
			else
				return false;
			// else compute the middle element and search.
		} else {
			int middle = (start + end) / 2;
			if (arr[middle] == middle)
				return true;
			else if (arr[middle] < middle)
				return binarySearch(arr, middle + 1, end);
			else
				return binarySearch(arr, start, middle);
		}
	}

	/**
	 * Main method
	 * 
	 * @param args (ignored)
	 */
	public static void main(String args[]) {

		try {
			// Scanner is used to read the elements.
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int arr[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
			}
			sc.close();
			// Displays the result
			System.out.println(binarySearch(arr, 1, n));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
