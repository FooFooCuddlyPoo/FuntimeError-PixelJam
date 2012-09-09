package items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pxlJam.Hitbox;
import pxlJam.ImageWrapper;

import cells.Map;

public class Heart implements Item{
	public static final int HEART_WIDTH  = 13;
	public static final int HEART_HEIGHT = 13;
	
	private int x;
	private int y;
	
	private String filename;
	
	private BufferedImage img;
	
	private Hitbox hit;
	
	public Heart(int x, int y){
		this.x = x;
		this.y = y;
		filename = "Sprites/heart.png";
		hit = new Hitbox(x, y, HEART_WIDTH, HEART_HEIGHT);
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void doAction(Map m) {
		m.getCharacter().incrementLives();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, HEART_WIDTH, HEART_HEIGHT, null);
	}


	@Override
	public Hitbox getHitbox() {
		return hit;
	}
	
}
