package Screen;

import java.util.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CrayonRiot extends JFrame {
<<<<<<< HEAD
	public static final int FRAMETICK = 60;
	 
=======

>>>>>>> 8e0b2584d517afed5b0de1fb99038a5b3c776c90
	public CrayonRiot(){
		
		setTitle("Crayon Riot");
        setSize(900, 700);
		ScreenPanel sc = new ScreenPanel();
		add(sc);
		setVisible(true);
	}
	
	public void gameLoop(){
		
	}

	public static void main(String[] args) {
<<<<<<< HEAD
		new CrayonRiot();
	  
=======
		
		CrayonRiot cr = new CrayonRiot();
		  
>>>>>>> 8e0b2584d517afed5b0de1fb99038a5b3c776c90
	}

}
