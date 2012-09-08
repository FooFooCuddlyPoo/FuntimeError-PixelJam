package Screen;

import java.util.*;
import java.awt.*;
import javax.swing.*;



@SuppressWarnings("serial")
public class CrayonRiot extends JFrame {
	public static final int FRAMETICK = 60;
	 
	public CrayonRiot(){
	    
		ScreenPanel sc = new ScreenPanel();
		add(sc);
		setVisible(true);
	}
	
	public void gameLoop(){
		
	}

	public static void main(String[] args) {
		new CrayonRiot();
	  
	}

}
