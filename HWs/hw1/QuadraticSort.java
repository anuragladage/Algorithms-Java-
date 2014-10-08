import java.util.Scanner;

/**
 * This class sorts array in quadratic time
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 */
public class QuadraticSort {

	/**
	 * this method implements bubble sort
	 * 
	 * @param input
	 *            array
	 * @return sorted array
	 */
	public long[] bubbleSort(long[] input) {

		// 2 for loops each running for n times
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				// swap elements if required
				if (input[j] < input[j - 1]) {
					long temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}

	/**
	 * this method reads input from console by scanner and display them after
	 * sorted
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			/*
			 * read input by scanner
			 */
			Scanner sc = new Scanner(System.in);
			int size = Integer.parseInt(sc.nextLine());
			long[] input = new long[size];

			String inputs = sc.nextLine();
			String[] inputInString = inputs.split(" ");

			sc.close();

			for (int i = 0; i < size; i++) {
				input[i] = Long.parseLong(inputInString[i]);
			}

			// method call
			QuadraticSort obj = new QuadraticSort();
			input = obj.bubbleSort(input);

			// print sorted array
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[i] + " ");
			}

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
