package items;

import java.awt.Graphics;

import pxlJam.Hitbox;

import cells.Map;

public interface Item {
	
	public void doAction(Map m);
	public void draw(Graphics g);
	public Hitbox getHitbox();
}
