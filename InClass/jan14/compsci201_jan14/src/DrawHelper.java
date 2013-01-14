import java.awt.*;
import java.util.Arrays;

import javax.swing.JFrame;

public class DrawHelper extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Circle[] circleArray;
	
	DrawHelper()
	{	
		circleArray = null;
	}
	
	public void drawCircle(Circle[] c)
	{
		circleArray = Arrays.copyOf(c, c.length);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		if(circleArray !=null)
		{
			for(int i = 0; i < circleArray.length; i++)
			{
				g2d.setColor(circleArray[i].getColor());
				g2d.fillOval(circleArray[i].getXLocation(), circleArray[i].getYLocation(), circleArray[i].getDiameter(), circleArray[i].getDiameter());
			}
		}
	}
}
