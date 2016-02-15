
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

public class StatusBar extends JComponent {

	private int X = 0;
	private int Y = 15;
	private int Z = 45;
	Color tempC = Color.black;
	public int fill = 0;
	public int length = 300;
	
	public void paintComponent(Graphics g) {
		fill = getFill();
		g.drawRect(X, Y, length, Z);
		g.setColor(tempC);
		g.fillRect(X, Y, fill, Z);
	}
	
	public int getLength() {
		return length;
	}

	public int getFill() {
		return fill;
	}

	public void setFill(int fill) {
		this.fill = fill;
	}
	
	public void setNewValues(){
		fill = getFill();
		repaint();
	}
}
