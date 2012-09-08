package pxlJam;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;

public class ImageWrapper {
	private BufferedImage img;
	private BufferedImage reverseImg;
	private int numSprites;

	public ImageWrapper(String file) {
		try {
			img = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		reverse();
		this.numSprites = (img.getWidth() + 1) / Crayon.CRAYON_WIDTH;
	}

	public void draw(Graphics g, int x, int y, int width, int height, int spriteStage, boolean reversed) {

		if (reversed) {
			BufferedImage temp = reverseImg.getSubimage(spriteStage * Crayon.CRAYON_WIDTH + 3, 0, Crayon.CRAYON_WIDTH - 6, Crayon.CRAYON_HEIGHT);
			g.drawImage(temp, x, y, width, height, null);
		} else {
			BufferedImage temp = img.getSubimage(spriteStage * Crayon.CRAYON_WIDTH + 3, 0, Crayon.CRAYON_WIDTH - 6, Crayon.CRAYON_HEIGHT);
			g.drawImage(temp, x, y, width, height, null);
		}
	}

	private void reverse() {
		int height = this.img.getHeight();
		int width = this.img.getWidth();
		reverseImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				reverseImg.setRGB(i, j, img.getRGB(width - i - 1, j));
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
