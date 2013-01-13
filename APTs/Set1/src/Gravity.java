
public class Gravity {

	public double falling(double time, double velo){
        double linear = time * velo; 
        double quadratic = (9.8 * Math.pow(time, 2) )/2.0; 
        double distance = linear + quadratic;
        return distance; 
      }
}
