package pxlJam;
import java.awt.Graphics;


public class Crayon {
	private ImageWrapper image;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private String filename;
	
	private Hitbox hitbox;
	
	private int spriteStage;

	public Crayon(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		image = new ImageWrapper(filename);
		hitbox = new Hitbox(x, y, width, height);
		spriteStage = 0;
	}
	
	public void move(int x){
		this.x += x;
		spriteStage++;
		if(spriteStage == image.getNumSprites())
			spriteStage = 0;
	}
	
	public void draw(Graphics g){
		image.draw(g, x, y, width, height, spriteStage);
	}

	private int getX() {
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

	private int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	private int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	private ImageWrapper getImage() {
		return image;
	}

	private void setImage(ImageWrapper image) {
		this.image = image;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
}
