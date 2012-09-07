package cells;
import java.awt.Graphics;


public interface Cell {
	public static final int CELL_WIDTH = 4;
	public static final int CELL_HEIGHT = 4;
	
	public void draw(Graphics g);
}
