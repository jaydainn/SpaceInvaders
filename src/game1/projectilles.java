package game1;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class projectilles {
	private float x,y;
	private int vy;

	public projectilles(float x , float y ,int vy) {
		if(x < 634 && x > 0) {
			this.x = x;
		
		}
		if(y < 476 && y >0 ) {
			this.y = y ;
		}
		this.vy = vy;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(x, y, 6, 6);
		
	}
	
	public void deplacer(int delta) {
		y -= vy* delta/1000.f;
	}
	
	public boolean horsEcran() {
		if(y<-6) {
			return true ;
		}
		return false;
	}
	
	public boolean testCollision(ennemi e) {
		if(this.x> e.getX() &&this.x < e.getX()+30 && this.y > e.getY() && this.y < e.getY()+30) {
			return true;
		}
		return false;
		
	}
	

}
