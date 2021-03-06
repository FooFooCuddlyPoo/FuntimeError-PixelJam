package cells;

import java.awt.Color;
import java.awt.Graphics;
import Screen.*;
import pxlJam.Hitbox;

public class DrawnWall implements Cell{
	private int x;
	private int y;
	private Color c;
	private Hitbox hit;
	long initialTime = System.currentTimeMillis();
	long delay;
	Map theMap;
	public boolean coloured = false;

	public DrawnWall(int x, int y, long d, Map m){
		hit = new Hitbox(x, y, Cell.CELL_WIDTH, Cell.CELL_HEIGHT);
		c = Color.BLUE;
		this.x = x;
		this.y = y;
		this.delay = d;
		this.theMap = m;
	}


	public void draw (Graphics g) {
		if (System.currentTimeMillis() - initialTime > delay){
			theMap.setCell(y / Cell.CELL_HEIGHT, x / Cell.CELL_WIDTH, null);
			this.hit = null;
			theMap.setBlueCrayon(1);
			
		}
		else { 
			g.setColor(c);
			g.fillRect(x, y, CELL_WIDTH, CELL_HEIGHT);
		}
		
	}

	public int getX(){
		return x;
	}
	
	public boolean isColoured (){
		return coloured;
	}
	
	public void setColoured(boolean c){
		
		this.coloured = c;
	
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
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


