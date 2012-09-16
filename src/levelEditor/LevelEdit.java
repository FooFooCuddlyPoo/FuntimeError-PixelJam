package levelEditor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;

import pxlJam.Crayon;

import cells.Cell;
import cells.Wall;

import comp102.*;

public class LevelEdit implements UIMouseListener, UIButtonListener {
	private int width;
	private int height;

	private Cell[][] map;

	private String filename;
	private File level;

	private int gamePosition;

	private BufferedImage charImg;
	private int charX = -10;
	private int charY = -10;
	private boolean setChar = false;

	private Color c;

	public LevelEdit() {
		init();
		UI.setMouseListener(this);
		UI.setMouseMotionListener(this);
		UI.addButton("Choose Colour", this);
		UI.addButton("Finish", this);
		UI.addButton("Place Character", this);
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

		try {
			charImg = ImageIO.read(new File("Sprites/crayonMovementNew.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		charImg = charImg.getSubimage(0, 0, Crayon.CRAYON_WIDTH, Crayon.CRAYON_HEIGHT);

		map = new Cell[height][width];
	}

	public void writeMap() {
		try {
			PrintStream out = new PrintStream(level);
			out.println("" + width + "  " + height);

			for (int h = 0; h < map.length; h++) {
				for (int w = 0; w < map[0].length; w++) {

				}
				out.println();
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mousePerformed(String action, double x, double y) {
		if (x < width * Cell.CELL_WIDTH && y < height * Cell.CELL_HEIGHT) {
			if (action.equals("pressed")) {
				if (setChar) {
					charX = (int) x - 20;
					charY = (int) y - 5;
					setChar = false;
				}
			}
			if (action.equals("dragged")) {
				add((int) x, (int) y);
			}
		}
		draw();
	}

	public void add(int x, int y) {
		map[y / Cell.CELL_HEIGHT][x / Cell.CELL_WIDTH] = new Wall(x, y);
	}

	public void draw() {
		UI.clearGraphics(false);
		UI.setColor(c);
		for (int h = 0; h < map.length; h++) {
			for (int w = 0; w < map[0].length; w++) {
				if (map[h][w] != null) UI.fillRect(w * Cell.CELL_WIDTH, h * Cell.CELL_HEIGHT, Cell.CELL_WIDTH, Cell.CELL_HEIGHT, false);
			}
		}

		if (charX >= 0 && charY >= 0) UI.drawImage(charImg, charX, charY, Crayon.CRAYON_WIDTH, Crayon.CRAYON_HEIGHT, false);

		UI.repaintGraphics();

	}

	@Override
	public void buttonPerformed(String name) {
		if (name.equals("Choose Colour")) {
			Color temp = JColorChooser.showDialog(null, "Choose your line color", c);
			if (temp != null) {
				c = temp;
			}
		} else if (name.equals("Finish")) {
			writeMap();
			System.exit(0);
		} else if (name.equals("Place Character")) {
			setChar = true;
		}

	}

	public static void main(String[] args) {
		new LevelEdit();
	}
}
