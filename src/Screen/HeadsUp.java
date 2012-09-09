package Screen;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class HeadsUp {
	
	int blueCrayon = 100;
	
	HeadsUp(){
		
		
		
	}
	
	public void draw(Graphics bf){
		drawScore(bf);
		drawLives(bf);
	}
	public void drawScore (Graphics bf){
		  ((Graphics2D) bf).setRenderingHint(
			        RenderingHints.KEY_TEXT_ANTIALIASING,
			        RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		  bf.setFont(new Font("Helvetica", Font.BOLD, 15));
		  bf.drawString("SCORE ", 20, 20);
	}
	
	public void drawLives(Graphics bf){
		
	}

}
