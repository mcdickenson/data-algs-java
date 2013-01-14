import java.awt.Color;


public class Circle {
	//Instance variables
	//They hold the state of your object
	int myXLocation;
	int myYLocation;
	Color myColor;
	int myDiameter;
	
	Circle(int x, int y, Color c, int d)
	{
		myXLocation = x;
		myYLocation = y;
		myColor = c;
		myDiameter = d;
	}
	
	// Behavior methods
	public Color getColor() 
	{
		return myColor;
	}
	
	public int getXLocation()
	{
		return myXLocation;
	}
	
	public int getYLocation()
	{
		return myYLocation;
	}
	
	public int getDiameter()
	{
		return myDiameter;
	}
	
	public String toString(){
		return "Circle (" + myXLocation + "," + myYLocation + "," + myColor +")";
	}
	
	
}
