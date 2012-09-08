package cells;

import java.awt.Color;
import java.awt.Graphics;

import pxlJam.Hitbox;

public class Wall implements Cell{
	private int x;
	private int y;
	private Color c;
	private Hitbox hit;
	
	public Wall(int x, int y){
		hit = new Hitbox(x, y, Cell.CELL_WIDTH, Cell.CELL_HEIGHT);
		c = Color.black;
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw (Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, CELL_WIDTH, CELL_HEIGHT);
		
	}

	private int getX(){
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	private int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return c;
	}

	@Override
	public Hitbox getHitbox() {
		return hit;
	}
	
	
}
