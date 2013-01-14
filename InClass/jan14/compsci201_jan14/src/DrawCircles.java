import java.awt.*;
import java.util.HashMap;

import javax.swing.JFrame;


public class DrawCircles extends JFrame{

	private static final long serialVersionUID = 1L;

	private HashMap<Color, Integer> aMap = new HashMap<Color, Integer>();
	
	public static void main(String[] args){		
		DrawCircles drawCircles = new DrawCircles();
		//the number of circles you are drawing
		//you can change this number if you want to draw more
		int numCircles = 50;
		
		// Set up the display
		DrawHelper myDisplay = new DrawHelper();
		myDisplay.setTitle("Learning Objects and Classes");
		myDisplay.setSize(500,500);
		myDisplay.setBackground(Color.BLACK);
		myDisplay.setVisible(true);
		
		//this is your method call
		Circle[] c = drawCircles.buildCircles(numCircles);
		drawCircles.countColors(c);
		
		myDisplay.drawCircle(c);
		myDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Circle[] buildCircles(int numCircles){
		Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.CYAN};
		//x location, y location, color, diameter
		Circle[] c = new Circle[numCircles];
		
		for(int i=0; i<c.length; i++){
			c[i] = new Circle(i*(500/c.length), i*(500/c.length), colors[i%colors.length], 30); 
		}
		
		return c;	
	}
	
	public void countColors(Circle[] circles){
		for(Circle c: circles){
			Color circleColor = c.getColor();
			if(aMap.containsKey(circleColor)){
//				int tmp = aMap.get(circleColor);
//				tmp += 1; 
//				aMap.put(circleColor, tmp);
				aMap.put(circleColor, aMap.get(circleColor)+1);
			}
			else{
				aMap.put(circleColor, 1);
			}
		}
		
		for(Color c: aMap.keySet()){
			System.out.println(c.toString() + ", " + aMap.get(c));
		}
	}
}

