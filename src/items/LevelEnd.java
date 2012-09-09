package items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pxlJam.Hitbox;
import cells.Map;

public class LevelEnd implements Item{
	public static final int LEVELEXIT_WIDTH  = 19;
	public static final int LEVELEXIT_HEIGHT = 29;
	
	private BufferedImage img;
	private int x;
	private int y;
	private Hitbox hit;
	private String filename = "Sprites/levelExit.png";
	
	public LevelEnd(int x, int y){
		this.x = x;
		this.y = y;
		hit = new Hitbox(x, y, LEVELEXIT_WIDTH, LEVELEXIT_HEIGHT);
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doAction(Map m) {
		m.nextLevel();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, LEVELEXIT_WIDTH, LEVELEXIT_HEIGHT, null);
	}

	@Override
	public Hitbox getHitbox() {
		return hit;
	}

}
