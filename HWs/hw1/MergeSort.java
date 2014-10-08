//Merge sort requires extra memory for the auxilliary array.

//Pratical Improvements for mergesort.
//1] Use insertion sort for small array sizes.
//2] If the biggest element of the first array is smaller than the smallest element of the second array they are already sorted. Thus no extra effort to sort this needs to be done. Thus, a check should be provided for this.



import java.util.Scanner;

public class MergeSort {

	public static void merge(int arr[], int lb1, int ub1, int ub2) {

		int temp[] = new int[arr.length];
		int i = lb1;
		int j = ub1 + 1;
		int k = 0;

		while (i <= ub1 && j <= ub2) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= ub1) {
			temp[k++] = arr[i++];
		}

		while (j <= ub2) {
			temp[k++] = arr[j++];
		}

		for (i = lb1, j = 0; i <= ub2; i++, j++) {
			arr[i] = temp[j];
		}
	}

	public static void useMerge(int arr[], int lb, int ub) {

		int middle;

		if (lb < ub) {
			middle = (lb + ub) / 2;
			useMerge(arr, lb, middle);
			useMerge(arr, middle + 1, ub);
			merge(arr, lb, middle, ub);
		}

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		useMerge(arr, 0, n - 1);

		sc.close();

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
