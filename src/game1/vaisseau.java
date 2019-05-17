package game1;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class vaisseau {
	private float x, y;

	public vaisseau() {
		this.x = 340;
		this.y = 400;

	}

	public void draw(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillOval(x - 50, y - 20, 50, 20);
	}

	public void gauche() {
		if ( x >= 50) {

			this.x = x - 10;
		}
		else {
			
			
			if(x <50){
				this.x = 51;
		
			}
		}
	}
	

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void droite() {
		if (x <= 640 ) {

			this.x = x + 10;
		}
		else {
			if(x >640){
				this.x = 641;
		
			}
			
		}
	}

}
