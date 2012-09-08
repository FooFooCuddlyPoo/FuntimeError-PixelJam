package pxlJam;
import java.awt.Graphics;

import cells.Cell;


public class Crayon {
	private ImageWrapper image;
	
	private int x;
	private int y;
	public static final int CRAYON_WIDTH  = 50;
	public static final int CRAYON_HEIGHT = 50;
	
	private int direction;  //-1 for left, 0 for still, 1 for right
	private int xSpeed;
	private int ySpeed;
	
	private boolean falling;
	private static final double gravity = 1;
	
	private String filename = "Sprites/crayonMovementNew.png";
	
	private Hitbox hitbox;
	private Hitbox feetBox;
	
	private int spriteStage;

	public Crayon(int x, int y){
		this.x = x;
		this.y = y;
		image = new ImageWrapper(filename);
		hitbox = new Hitbox(x , y, CRAYON_WIDTH -15, CRAYON_HEIGHT);
		feetBox = new Hitbox(x, y+(CRAYON_HEIGHT*2)/3, CRAYON_WIDTH, CRAYON_HEIGHT/3);
		spriteStage = 0;
		ySpeed = 0;
	}
	
	public void move(Cell[][] tiles){
		if(!checkCollision(tiles))
			falling = true;
		else
			falling = false;
		
		if(direction == 1){
			xSpeed = 4;
			spriteStage++;
		}
		else if(direction == -1){
			xSpeed = -4;
			spriteStage++;
		}
		else 
			xSpeed = 0;
		
		this.x += xSpeed;
		if(spriteStage == image.getNumSprites()){
			spriteStage = 0;
			xSpeed = 0;
			direction = 0;
		}
		
		if(falling){
			this.y += ySpeed;
			ySpeed += gravity;
		}
		
		hitbox.setHitbox(this.x, this.y, CRAYON_WIDTH, CRAYON_HEIGHT);
		feetBox.setHitbox(x, y+(CRAYON_HEIGHT*2)/3, CRAYON_WIDTH, CRAYON_HEIGHT/3);
	}
	
	public void jump(){
		ySpeed = -8;
		this.y -= 2;
		falling = true;
	}
	
	public boolean checkCollision(Cell[][] tiles){
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[i].length; j++){
				if(tiles[i][j] != null && hitbox.checkCollision(tiles[i][j].getHitbox())){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void draw(Graphics g){
		if(direction == -1)
			image.draw(g, x, y, CRAYON_WIDTH, CRAYON_HEIGHT, spriteStage, true);
		else
			image.draw(g, x, y, CRAYON_WIDTH, CRAYON_HEIGHT, spriteStage, false);
		hitbox.draw(g);
		feetBox.draw(g);
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

	public void setDirection(int direction) {
		if(direction < 0){
			this.direction = -1;
		}else if(direction > 0){
			this.direction = 1;
		}else
			direction = 0;
		
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	
}
