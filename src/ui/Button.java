package ui;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by johan on 2017-04-10.
 */
public class Button {
	String text;
	int x,y,width,height;

	public Button(String text, int x, int y, int width, int height)
	{
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}



	public void draw(Graphics2D g2d)
	{
		g2d.setColor(Color.black);
		g2d.fill(new Rectangle2D.Double(x+10,y+10,width,height));
		g2d.setColor(Color.gray);
		g2d.fill(new Rectangle2D.Double(x,y,width,height));

		g2d.setColor(Color.black);
		g2d.setFont(new Font("Segoe UI", Font.PLAIN, 72));

		int textWidth = (int) g2d.getFont().getStringBounds(text, g2d.getFontRenderContext()).getWidth();

		g2d.drawString(text, x + width/2 - textWidth/2,y+72);

	}


	public boolean clicked(MouseState mouseState, MouseState lastMouseState) {
		return mouseState.left && !lastMouseState.left &&
						mouseState.x > x && mouseState.x < x+width &&
						mouseState.y > y && mouseState.y < y+height;
	}

	public String getText() {
		return text;
	}
}
