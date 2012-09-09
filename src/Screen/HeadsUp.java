package Screen;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import cells.Map;

public class HeadsUp {

	int blueCrayon = 100;
	static int BAR_HEIGHT = 10;

	HeadsUp() {

	}

	public void draw(Map theMap, Graphics bf) {

		drawScore(theMap, bf);
		drawLives(theMap, bf);

	}

	public void drawScore(Map theMap, Graphics bf) {

		int blueCrayon = theMap.getBlue();
		((Graphics2D) bf).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		bf.setFont(new Font("Helvetica", Font.BOLD, 20));
		bf.setColor(Color.BLUE);
		bf.drawString("BLUE CRAYON", 30, 30);
		if (blueCrayon > 0) {
			bf.fillRect(200, 50, blueCrayon, BAR_HEIGHT);
		}

	}

	public void drawLives(Map m, Graphics bf) {
		int lives = m.getCharacter().getLives();
		((Graphics2D) bf).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		bf.setFont(new Font("Helvetica", Font.BOLD, 20));
		bf.setColor(Color.BLUE);
		bf.drawString("LIVES: "+lives, 900, 30);
	}

	public void setBlueCrayon(int change) {

		this.blueCrayon += change;

	}

}
