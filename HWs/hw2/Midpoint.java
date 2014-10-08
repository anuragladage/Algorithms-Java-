/**
 * This class defines the equation and methods for one midpoint generated
 * 
 * @author Hitesh Vyas
 * @author Sushil Mohite
 */


public class Midpoint {
	//the points from which mid point generated
	Point one;
	Point two;
	//slope of midpoint equation ranging till inf(infinite)
	String slope;
	//constant of midpoint equation used as -> y=slope*x+c
	double constant;
	
	/**
	 * this is parameterized constructor that computes slope
	 * 
	 * @param first point
	 * @param another point
	 */
	public Midpoint(Point one,Point two){
		this.one=one;
		this.two=two;
		generateSlope();
	}
	
	/**
	 * This method is used to print the line equation for debugging purpose
	 */
	public String toString(){
		double midx=(one.x+two.x)/2.0;
		double midy=(one.y+two.y)/2.0;
		
		return one+"-"+two+" midpoint: ("+midx+","+midy+") slope: "+slope+" c: "+constant;
	}
	
	/**
	 * This method compares to another midpoint
	 * used to sort mid points according to the line equation(slope+constant)
	 * 
	 * @param another midpoint
	 * @return {-1(less),0(equal),1(greater}
	 */
	public int compare(Midpoint another){
		if(another.constant==this.constant && another.slope.equals(this.slope)){
			return 0;
		}else if(another.constant!=this.constant && another.slope.equals(this.slope)){
			if(another.constant>this.constant){
				return -1;
			}else{
				return 1;
			}
		}else{
			if(this.slope.equals("inf")){
				return 1;
			}else if(another.slope.equals("inf")){
				return -1;
			}else{
				if(Double.parseDouble(this.slope)>Double.parseDouble(another.slope)){
					return 1;
				}else{
					return -1;
				}
			}
		}
		
	}
	
	/**
	 * this method checks if a point satisfies in the line equation
	 * 
	 * @param a point
	 * @return true if on line else false
	 */
	public boolean satisfyPoint(Point a){
		double x=a.x;
		double y=a.y;
		
		if(slope.equals("0")){
			if(y==constant){
				return true;
			}else{
				return false;
			}
		}else if(slope.equals("inf")){
			if(x==constant){
				return true;
			}else{
				return false;
			}
		}else{
			if((y-(Double.parseDouble(slope)*x)-constant)==0){
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * This method computes the slope as (-dx/dy) i.e perpendicular to the point's line slope
	 * stores slope as string form of double thus, stores "inf" for infinite slope 
	 * It also computes the cosntant used to generate the line equation
	 * 
	 */
	private void generateSlope(){
		double dx=two.x-one.x;
		double dy=two.y-one.y;
		
		if(dy==0){
			slope= "inf";
			constant=(one.x+two.x)/2.0;
		}else{
			double s=dx/dy;
			s=-s;
			if(dx==0.0){
				slope="0";
				constant=(one.y+two.y)/2.0;
			}else{
				slope= ""+s;
				constant=((one.y+two.y)/2.0);
			}
		}
	}
}
	

