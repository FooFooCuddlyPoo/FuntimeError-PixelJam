package levelEditor;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JColorChooser;

import cells.Cell;

import comp102.*;

public class LevelEdit implements UIMouseListener, UIButtonListener {
	private int width;
	private int height;

	private Cell[][] map;

	private String filename;
	private File level;

	private int gamePosition;

	private Color c;

	public LevelEdit() {
		UI.setMouseListener(this);
		UI.setMouseMotionListener(this);
		UI.addButton("Choose Colour", this);
		UI.addButton("Finish", this);
		init();

	}

	public void init() {
		filename = UI.askString("What is the name of the level? ");
		width = UI.askInt("What is the width of the map?");
		height = UI.askInt("What is the height of the map?");
		gamePosition = UI.askInt("Where would you like the map to come in the level order?");

		level = new File(filename + ".txt");
		if (!level.exists()) {
			try {
				level.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		map = new Cell[height][width];
	}

	public void writeMap() {
		try {
			PrintStream out = new PrintStream(level);
			out.println(""+width+"  "+height);
			
			for (int h = 0; h < map.length; h++) {
				for (int w = 0; w < map[0].length; w++) {
					
				}
				out.println();
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mousePerformed(String action, double x, double y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(String action, double x, double y) {

	}
	
	public void draw(){
		UI.clearGraphics(false);
		UI.setColor(c);
		for(int h = 0; h < map.length; h++){
			for(int w = 0; w < map[0].length; w++){
				UI.fillRect(w*Cell.CELL_WIDTH, h*Cell.CELL_HEIGHT, Cell.CELL_WIDTH, Cell.CELL_HEIGHT, false);
			}
		}
		
		UI.repaintGraphics();
		
	}

	@Override
	public void buttonPerformed(String name) {
		if (name.equals("Choose Colour")) {
			Color temp = JColorChooser.showDialog(null, "Choose your line color", c);
			if (temp != null) {
				c = temp;
			}
		}
		if(name.equals("Finish")){
			writeMap();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new LevelEdit();
	}
}
