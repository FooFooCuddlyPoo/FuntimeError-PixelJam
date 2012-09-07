package pxlJam;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;


public class ImageWrapper {
	private BufferedImage img;
	private int numSprites;
	
	public ImageWrapper(String file){
		try {
			ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.numSprites = (img.getWidth()+1)/16;
	}
	
	public void draw(Graphics g, int x, int y, int width, int height, int spriteStage){
		BufferedImage temp = img.getSubimage(spriteStage*16, 0, 16, 32);
		
		g.drawImage(temp, x, y, width, height, null);
	}

	public BufferedImage getImage() {
		return img;
	}

	public void setImage(BufferedImage img) {
		this.img = img;
	}

	public int getNumSprites() {
		return numSprites;
	}

	public void setNumSprites(int numSprites) {
		this.numSprites = numSprites;
	}
}
