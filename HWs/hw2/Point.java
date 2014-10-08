/**
 * This class defines a point which is then used to generate midpoint equation
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 */



public class Point {
	//x and y coordinates
	int x,y;

	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * string representation of points for debugging purpose
	 */
	public String toString(){
		return "("+x+","+y+")";
	}

}
