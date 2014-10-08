import java.util.Scanner;

/**
 * This class finds max pair aligned when folded a paper(plane)
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 */
public class AlignPoints {
	
	//midpoints generated
	Midpoint[] midpoints;
	//points input
	Point[] points;
	//set max to default
	int max = 0;
	//max point(line) track
	Midpoint maxPoint=null;
	
	/**
	 * this is parameterized constructor which performs all the tasks
	 * 
	 * @param points
	 */
	public AlignPoints(Point[] points) {
		this.points=points;
		//generate the midpoints
		midpoints = generateMidpoints(points);
		//sort midpoints
		sortPoints(midpoints, 0, midpoints.length - 1);
		//find the line with max alignments
		maxAligns(midpoints, 0);
	}
	
	/**
	 * This method finds out the line where max points aligned
	 * 
	 * @param midpoint
	 * @param index
	 */
	private void maxAligns(Midpoint[] midpoint, int i) {
		//initialize the count
		int count = 1;
		//reference to the line whom to be compared
		Midpoint tempPoint = midpoint[i];
		
		//finds if any point is on the midpoint line
		for(int j=0;j<points.length;j++){
			if(tempPoint.satisfyPoint(points[j])){
				++count;
				if(count>max){
					max=count;
					maxPoint=tempPoint;
				}
			}
		}
		
		//run loop till the midpoints are in the same line
		while (i<midpoint.length-1) {
			if(tempPoint.compare(midpoint[++i]) == 0){
					count++;
				}else{
					break;
				}
			
			
		}
		//update the count
		if (count > max) {
			max = count;
			maxPoint=midpoint[i-1];
		}
		
		
		
		//recursive call till last index of array is reached
		if(i!=midpoint.length-1){
			maxAligns(midpoint, i);
		}

	}
	
	/**
	 * 
	 * method for combination of arrays used in merge sort(from previous assignment)
	 * 
	 * @param array
	 * @param index1
	 * @param index2
	 * @param index3
	 */
	private void combine(Midpoint[] arr, int lb1, int ub1, int ub2) {

		Midpoint temp[] = new Midpoint[arr.length];
		int i = lb1;
		int j = ub1 + 1;
		int k = 0;

		while (i <= ub1 && j <= ub2) {
			if (arr[i].compare(arr[j]) == -1) {
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
	
	/**
	 * Method to sort the array of midpoints(used from previous assignment)
	 * 
	 * @param arr
	 * @param lb
	 * @param ub
	 */
	private void sortPoints(Midpoint[] arr, int lb, int ub) {
		int middle;

		if (lb < ub) {
			middle = (lb + ub) / 2;
			sortPoints(arr, lb, middle);
			sortPoints(arr, middle + 1, ub);
			combine(arr, lb, middle, ub);
		}

	}

	/**
	 * generate all possible midpoints
	 * 
	 * @param points
	 * @return array of midpoints
	 */
	private Midpoint[] generateMidpoints(Point[] points) {

		Midpoint[] midpoints = new Midpoint[((points.length * (points.length - 1)) / 2)];

			int i=0;
			for (int j = 0; j < points.length-1; j++) {
				for (int k = points.length-1; k >j ; k--) {
					midpoints[i++] = new Midpoint(points[j], points[k]);
				}
			}

		
		return midpoints;
	}

	public static void main(String[] args) {
		/*
		 * scanner to read the input and store it in array
		 */
		Scanner scan = new Scanner(System.in);
		int noOfElements = Integer.parseInt(scan.nextLine());
		Point[] points = new Point[noOfElements];
		
		for (int i = 0; i < noOfElements; i++) {
			String point=scan.nextLine();
			String[] coordinates=point.split(" ");
			points[i] = new Point(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
		}
		scan.close();
		//instantiation of job
		AlignPoints obj = new AlignPoints(points);
		System.out.println(obj.max);
	}

	

}
