package cells;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import pxlJam.Crayon;
import items.Item;
import items.Heart;
import items.LevelEnd;

public class Map {
	private Cell[][] tiles;
	private Crayon character;

	private int width;
	private int height;

	private File file;
	
	private ArrayList<Item> items;

	public Map(String filename) {
		file = new File(filename);
		items = new ArrayList<Item>();
		readMap();
	}

	public void readMap() {
		try {
			Scanner scan = new Scanner(file);

			height = scan.nextInt();
			width = scan.nextInt();
			
			tiles = new Cell[width][height];
			int tempInt;

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (scan.hasNext()) {
						tempInt = scan.nextInt();
						if (tempInt == 10)
							character = new Crayon(j * Cell.CELL_WIDTH, i * Cell.CELL_HEIGHT, this);
						else if(tempInt == 11)
							items.add(new Heart(j * Cell.CELL_WIDTH, i * Cell.CELL_HEIGHT));
						else if(tempInt == 12)
							items.add(new LevelEnd(j * Cell.CELL_WIDTH, i * Cell.CELL_HEIGHT));
						else {
							tiles[i][j] = getWalltype(tempInt, j * Cell.CELL_WIDTH, i * Cell.CELL_HEIGHT);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Cell getWalltype(int fileNum, int x, int y) {
		Cell tempCell = null;
		if (fileNum == 1)
			tempCell = new Wall(x, y);
		else if (fileNum == 2) {
			// something else
		} else if (fileNum == 0) {
			tempCell = null;
		}

		return tempCell;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < tiles.length; i++)
			for (int j = 0; j < tiles[i].length; j++) {
				if (tiles[i][j] != null) {
					tiles[i][j].draw(g);
				}
				
			}

		for(Item i:items){
			i.draw(g);
		}
		
		if (character != null) {
			character.draw(g);
		}
	}
	
	public void checkItemCollision(){
		ArrayList<Item> temp = new ArrayList<Item>();
	
		for(Item i: items){
			if(character.getHitbox().checkCollision(i.getHitbox())){
				i.doAction(this);
				temp.add(i);
			}
		}
		
		items.removeAll(temp);
	}

	public Crayon getCharacter() {
		return character;
	}

	public void setCharacter(Crayon character) {
		this.character = character;
	}
	public void setCell(int x, int y, Cell c){
		tiles[x][y] = c;
	}

	public Cell[][] getTiles() {
		return tiles;
	}
	
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	
	
}
