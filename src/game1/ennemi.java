package game1;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;



public class ennemi {
	private float x,y;
	private Color c;

	public ennemi(float x , float y , Color c ) {
		if(x < 610 && x>0 ) {
			this.x = x ;
		}
		
		if(y < 450 && y > 0) {
			this.y = y ; 
		}
		this.c = c ;
		
		
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void draw(Graphics g ) {
		g.setColor(c);
		g.fillRect(x, y, 30, 30);
	}
	
	

}
