package game1;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class main extends BasicGame {
	private ArrayList<ennemi> e = new ArrayList<ennemi>();
	private vaisseau v = new vaisseau();
	private ArrayList<projectilles> p = new ArrayList<projectilles>();

	public main(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < e.size(); i++) {
			e.get(i).draw(g);
		}
		v.draw(g);
		for(int i = 0 ; i < p.size();i++) {
			p.get(i).draw(g);
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				Color c2 = Color.black;
				switch (j) {
				case 0:
					c2 = Color.red;
					break;
				case 1:
					c2 = Color.orange;
					break;
				case 2:
					c2 = Color.yellow;
					break;
				case 3:
					c2 = Color.green;
					break;
				case 4:
					c2 = Color.pink;
					break;
				case 5:
					c2 = Color.blue;
				}
				e.add(new ennemi(155 + i * 33, 50 + j * 33, c2));

			}
		}

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		for(int i =0 ; i < p.size();i++) {
			p.get(i).deplacer(delta);
			if(p.get(i).horsEcran()) {
				p.remove(i);
			}
			for(int j = 0 ; j < e.size();j++) {
				if(p.get(i).testCollision(e.get(j))) {
					p.remove(i);
					e.remove(j);
					break; 
				}
			}
		}
		
		

	}
	
	public void keyPressed(int key , char c) {
		switch(key) {
		case Input.KEY_LEFT : v.gauche(); break;
		case Input.KEY_RIGHT : v.droite(); break;
		case Input.KEY_SPACE: 
			if(p.size()<5) {
				p.add(new projectilles(v.getX()-22,v.getY()-25,50));
			}
			break;
			
		
		
		}
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		app = new AppGameContainer(new main("Space Invaders"));
		app.setDisplayMode(640, 480, false);
		app.setShowFPS(false);
		app.start();

	}

}
