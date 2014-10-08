import java.util.*;

/**
 * This class matches a point in A to a point in B.
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 */

public class MatchPoints {

	//array to store already connected points
	int ref[];
	
	//To store x value of A.
	double Ax[];
	
	//To store y value of A.
	double Ay[];

	//To store x value of B.
	double Bx[];
	
	//To store y value of B.
	double By[];

	/**
	 * This function performs the check between two points.
	 * @param m the slope
	 * @param c the intercept
	 * @param aindex the current index of A.
	 * @param bindex the current index of B.
	 * @return true if the points match.
	 */
	public boolean checkPoints(double m, double c, int aindex, int bindex) {
		
		//keeps count of positive A points
		int posA = 0;
		
		//keeps count of negative A points.
		int negA = 0;
		for (int i = 0; i < Ax.length; i++) {
			if (i != aindex && !visitedA(i)) {
				if (Ax[aindex] != Bx[bindex]) {
					double b = m * Ax[i] - Ay[i] + c;
					if (b > 0) {
						posA++;
					} else if (b < 0) {
						negA++;
					} else if (b == 0) {
						return false;
					}
				} else {
					if (Ax[i] > Ax[aindex])
						posA++;
					else
						negA++;
				}
			}
		}
		
		//keeps track of positive B points.
		int posB = 0;
		
		//keeps track of negative B points.
		int negB = 0;
		for (int i = 0; i < Bx.length; i++) {
			if (i != bindex && !visitedB(i)) {
				if (Ax[aindex] != Bx[bindex]) {
					double b = m * Bx[i] - By[i] + c;
					if (b > 0) {
						posB++;
					} else if (b < 0) {
						negB++;
					} else if (b == 0) {
						return false;
					}
				} else {
					if (Bx[i] > Bx[bindex])
						posB++;
					else
						negB++;
				}
			}
		}

		//If the number of positive A & B points and 
		//negative A & B points are equal then they can be joined.
		if ((posA == posB) && (negA == negB)) {
			return true;
		} else
			return false;
	}

	/**
	 * Main method
	 * @param args (ignored)
	 */
	public static void main(String args[]) {
		
		//To collect input.
		Scanner sc = new Scanner(System.in);

		//To read the number of points.
		int n = Integer.parseInt(sc.nextLine());
		String s;

		MatchPoints mat = new MatchPoints();

		mat.ref = new int[n / 2];

		//initialize each point to -1
		for (int i = 0; i < n / 2; i++) {
			mat.ref[i] = -1;
		}

		mat.Ax = new double[n / 2];
		mat.Ay = new double[n / 2];

		mat.Bx = new double[n / 2];
		mat.By = new double[n / 2];

		//stores all values in A
		for (int i = 0; i < n / 2; i++) {
			s = sc.nextLine();
			String Fld[] = s.split(" ");
			mat.Ax[i] = Integer.parseInt(Fld[1]);
			mat.Ay[i] = Integer.parseInt(Fld[2]);
		}
		
		//stores all values in B
		for (int i = 0; i < n / 2; i++) {
			s = sc.nextLine();
			String Fld[] = s.split(" ");
			mat.Bx[i] = Integer.parseInt(Fld[1]);
			mat.By[i] = Integer.parseInt(Fld[2]);
		}

		sc.close();
		
		double m;
		double c;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				if ((mat.Ax[i] - mat.Bx[j]) == 0) {
					m = 0;
					c = 0;
				} else {
					//calculating slope.
					m = (mat.Ay[i] - mat.By[j]) / (mat.Ax[i] - mat.Bx[j]);
					
					//calculating intercept.
					c = mat.Ay[i] - m * mat.Ax[i];
				}
				
				//if true then add points to ref
				if (mat.checkPoints(m, c, i, j)) {
					mat.ref[i] = j;
					break;
				}
			}
		}
		for (int i = 0; i < n / 2; i++) {
			System.out.println("A" + (i + 1) + " " + "B" + (mat.ref[i] + 1));
		}

	}

	/**
	 * To check whether i is already visited
	 * @param i integer to check
	 * @return true if it exists
	 */
	public boolean visitedA(int i) {

		if (ref[i] == -1)
			return false;
		else
			return true;
	}

	/**
	 * To check whether i is already visited
	 * @param i integer to check
	 * @return true if it exists
	 */
	public boolean visitedB(int i) {
		for (int k = 0; k < ref.length; k++) {
			if (ref[k] == i)
				return true;
		}
		return false;
	}

}
