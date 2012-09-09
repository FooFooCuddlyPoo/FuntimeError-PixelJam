package Screen;

import pxlJam.Crayon;

public class Camera {
	private int x;
	private int y;
	
	public static final int SCREEN_WIDTH  = 1024;
	public static final int SCREEN_HEIGHT = 720;
	
	public Camera(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return (x - SCREEN_WIDTH/2);
	}

	public void setCamera(Crayon c){
		x = c.getX();
		y = c.getY();
	}

	public int getY() {
		return (y - SCREEN_HEIGHT/2);
	}

}
