import java.util.*;

/**
 * This class checks whether an element occur more than n/2 or n/3
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 */

public class Majority {

	/**
	 * Main method
	 * @param args (ignored)
	 */
	public static void main(String[] args) {

		//to read values
		Scanner sc = new Scanner(System.in);

		//number of values to be stored
		int n = sc.nextInt();
		int count = 0;

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();
		
		//temp contains the n/2th element.
		int temp = checkFirst(arr, 0, arr.length - 1, n/2);
		
		for (int i = 0; i < n; i++) {
			if (arr[i] == temp)
				count++;
		}
		
		if (count > n/2)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		if (count > n/3)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	/**
	 * Searches for the kth element
	 * @param arr array to be searched
	 * @param lb lowerbound
	 * @param ub upperbound
	 * @param k kth element to be searched
	 * @return the kth element
	 */
	public static int checkFirst(int arr[], int lb, int ub, int k) {

		//take a random number
		int rand = (lb + ub)/2;
		
		//pull the value at that random number
		int pivot = arr[rand];
		
		//initialize j1 to the start of the array
		int j1 = lb;
		
		//initialize j2 to the last position of the array
		int j2 = ub;
		int temp;
		
		while (j1 < j2) {
			
			//while value at j1 is less than pivot
			//increment the pointer j1.
			while (arr[j1] <= pivot && j1 < ub) {
				j1++;
			}
			
			//while value at j2 is more than pivot
			//decrement the pointer j2
			while (arr[j2] > pivot) {
				j2--;
			}
			
			while (arr[j1] > pivot) {
				temp = arr[j2];
				arr[j2] = arr[j1];
				arr[j1] = temp;
				j2--;
			}
		}
		
		if (k < j1)
			return checkFirst(arr, lb, j1-1, k);
		if (k >= j1 && k <= j2)
			return pivot;
		if (k > j2)
			return checkFirst(arr, j2+1, ub, k-j2);
		
		return 0;
	}
}
