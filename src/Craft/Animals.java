package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Animals {
	public static BufferedImage animal1;
	public static BufferedImage animal2;
	public static BufferedImage animal3;
	public static BufferedImage animal4;
	public static BufferedImage animal5;
	public static BufferedImage animal6;
	boolean drawRealAnimal;
	boolean drawPreviewAnimal;
	int animalToDraw;
	int x = 270;
	int y = 0;
	int maximumAnimal;
	ArrayList<BufferedImage>previewanimals = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage>animals = new ArrayList<BufferedImage>();
	Animals() {
		try {
			animal1 = ImageIO.read(this.getClass().getResource("animal 1.png"));
			animal2 = ImageIO.read(this.getClass().getResource("animal 2.png"));
			animal3 = ImageIO.read(this.getClass().getResource("animal 3.png"));
			animal4 = ImageIO.read(this.getClass().getResource("animal 4.png"));
			animal5 = ImageIO.read(this.getClass().getResource("animal 5.png"));
			animal6 = ImageIO.read(this.getClass().getResource("animal 6.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		previewanimals.add(animal1);
		previewanimals.add(animal2);
		previewanimals.add(animal3);
		previewanimals.add(animal4);
		previewanimals.add(animal5);
		previewanimals.add(animal6);
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		animals.add(animal6);
		maximumAnimal = animals.size() - 1;
	}
	void drawPreviewAnimal(Graphics g, int animalToDraw) {
		for (int i = 0; i < previewanimals.size(); i++) {
			if(i==animalToDraw) {
				g.drawImage(previewanimals.get(i), 1525, 50, 300, 300, null);
			}
		}
	}
	void drawRealAnimal(Graphics g, int animalToDraw) {
		for (int i = 0; i < animals.size(); i++) {
			if(i==animalToDraw) {
				g.drawImage(animals.get(i), x, y, null);
			}
		}
	}
	void setX(int x) {
		this.x = x;
	}
	void setY(int y) {
		this.y = y;
	}
}
