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
	private static final int gravity = 1;
	
	private String filename = "Sprites/crayonMovementNew.png";
	
	private Hitbox hitbox;
	private Hitbox feetBox;
	
	private int spriteStage;

	public Crayon(int x, int y){
		this.x = x;
		this.y = y;
		image = new ImageWrapper(filename);
		hitbox = new Hitbox(x+15, y, CRAYON_WIDTH -30, CRAYON_HEIGHT);
		feetBox = new Hitbox(x+15, y+(CRAYON_HEIGHT*2)/3, CRAYON_WIDTH -30, CRAYON_HEIGHT/3);
		spriteStage = 0;
		ySpeed = 0;
	}
	
	public void move(Cell[][] tiles){
		if(!checkFeetCollision(tiles))
			falling = true;
		else{
			falling = false;
		}
		
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
		
		int collideY = 0;
		boolean collided = false;
		if(falling){
			Hitbox newFeet = feetBox;
			newFeet.setHitbox(this.x, this.y+ySpeed, CRAYON_WIDTH, CRAYON_HEIGHT);
			System.out.println("feetbox.getY = "+feetBox.getY());
			for (int i = feetBox.getY()/Cell.CELL_HEIGHT; i<tiles.length;i++){
				if (i > 0){
					if (tiles[i][feetBox.getX()/Cell.CELL_WIDTH] !=null){
						collideY = i;
						System.out.println(i);
						collided = true;
						break;
					}
				}
			}
			if (newFeet.getY()>=(collideY*Cell.CELL_HEIGHT)){
				if (collided){
					this.y=(collideY*Cell.CELL_HEIGHT)-CRAYON_HEIGHT;
					System.out.println("THIS IS COLLIDE Y = "+collideY);
				}
				else{
					this.y += ySpeed;
					ySpeed += gravity;
				}
			}
			else{
				this.y += ySpeed;
				ySpeed += gravity;
			}
			
		}
		
		hitbox.setHitbox(this.x+15, this.y, CRAYON_WIDTH-30, CRAYON_HEIGHT);
		feetBox.setHitbox(x+15, y+(CRAYON_HEIGHT*2)/3, CRAYON_WIDTH -30, CRAYON_HEIGHT/3);
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
	
	private boolean checkFeetCollision(Cell[][] tiles){
		int feetX = feetBox.getX()/Cell.CELL_WIDTH;
		
		for(int i = 0; i < tiles.length; i++){
			if(tiles[i][feetX] != null && feetBox.checkCollision(tiles[i][feetX].getHitbox())){
				return true;
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
