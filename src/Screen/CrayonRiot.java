package Screen;

import java.util.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CrayonRiot extends JFrame {

	public CrayonRiot(){
		
		setTitle("Crayon Riot");
        setSize(900, 700);
		ScreenPanel sc = new ScreenPanel();
		add(sc);
		setVisible(true);
		sc.run();
	}
	
	public void gameLoop(){
		
	}

	public static void main(String[] args) {
		new CrayonRiot();
	}

}
