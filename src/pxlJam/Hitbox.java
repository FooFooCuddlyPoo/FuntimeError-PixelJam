package pxlJam;
import java.awt.Color;
import java.awt.Graphics;


public class Hitbox {
	public int width;
	public int height;
	public int x;
	public int y;
	
	public Hitbox(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean checkCollision(Hitbox h){
		boolean collision;
		collision = 			 (this.x >= h.x) && (this.x < h.x+h.width) && (this.y >= h.y) && (this.y < h.y+h.height);
		collision = collision || (this.x+this.width >= h.x) && (this.x+this.width < h.x+h.width) && (this.y >= h.y) && (this.y< h.y+h.height);
		collision = collision || (this.x >= h.x) && (this.x < h.x+h.width) && (this.y+this.height >= h.y) && (this.y+this.height < h.y+h.height);
		collision = collision || (this.x+this.width >= h.x) && (this.x+this.width < h.x+h.width) && (this.y+this.height >= h.y) && (this.y+this.height < h.y+h.height);
				
		return collision;
	}
	
	public boolean checkCollision(int x, int y){
		return (x > this.x && x < this.x+this.width && y > this.y && y < this.y+this.height);
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setHitbox(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.drawRect(x, y, width, height);
	}
}
