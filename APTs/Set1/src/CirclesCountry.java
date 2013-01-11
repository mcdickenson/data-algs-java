public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, 
                            int x1, int y1, int x2, int y2) {
    	int circles = 0;
    	for(int i=0; i < x.length; i++){
    		boolean point1IsInCircle = inCircle(x[i], y[i], r[i], x1, y1);
    		boolean point2IsInCircle = inCircle(x[i], y[i], r[i], x2, y2);
    		if(point1IsInCircle==point2IsInCircle){}
    		else {circles += 1; } 
    	}

    	return circles; 
    }

    public boolean inCircle(int cx, int cy, int radius, int px, int py){
    	int xdist = px - cx;
    	int ydist = py - cy; 
    	double distance = Math.sqrt( Math.pow(xdist, 2) + Math.pow(ydist, 2) );

    	boolean isInCircle = distance <= radius; 
    	return isInCircle; 
    }
 }
