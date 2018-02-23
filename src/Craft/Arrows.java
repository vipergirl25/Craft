package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Arrows {
	public static BufferedImage leftArrow;
	public static BufferedImage rightArrow;
	boolean drawLeftArrow = true;
	boolean drawRightArrow = true;
	ArrayList<BufferedImage>arrows = new ArrayList<BufferedImage>();
	Arrows() {
		try {
			leftArrow = ImageIO.read(this.getClass().getResource("arrow left.png"));
			rightArrow = ImageIO.read(this.getClass().getResource("arrow right.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		arrows.add(leftArrow);
		arrows.add(rightArrow);
	}
	void drawArrows(Graphics g) {
		if(drawLeftArrow == true) {
			g.drawImage(leftArrow, 1475, 150, 50, 50, null);
		}
		if(drawRightArrow == true) {
			g.drawImage(rightArrow, 1830, 150, 50, 50, null);
		}
	}
	void removeLeftArrow() {
		arrows.remove(leftArrow);
		drawLeftArrow = false;
	}
	void removeRightArrow() {
		arrows.remove(rightArrow);
		drawRightArrow = false;
	}
	void addLeftArrow() {
		drawLeftArrow = true;
	}
	void addRightArrow() {
		drawRightArrow = true;
	}
}
