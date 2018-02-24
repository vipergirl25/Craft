package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Characters {
	public static BufferedImage character1;
	public static BufferedImage character2;
	public static BufferedImage character3;
	public static BufferedImage character4;
	public static BufferedImage character5;
	public static BufferedImage character6;
	public static BufferedImage character7;
	public static BufferedImage character8;
	boolean drawPreviewCharacter;
	boolean drawRealCharacter;
	int characterToDraw;
	int x = 270;
	int y = 0;
	int maximumCharacter;
	ArrayList<BufferedImage>previewcharacters = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage>characters = new ArrayList<BufferedImage>();
	Characters() {
		try {
			character1 = ImageIO.read(this.getClass().getResource("character 1.png"));
			character2 = ImageIO.read(this.getClass().getResource("character 2.png"));
			character3 = ImageIO.read(this.getClass().getResource("character 3.png"));
			character4 = ImageIO.read(this.getClass().getResource("character 4.png"));
			character5 = ImageIO.read(this.getClass().getResource("character 5.png"));
			character6 = ImageIO.read(this.getClass().getResource("character 6.png"));
			character7 = ImageIO.read(this.getClass().getResource("character 7.png"));
			character8 = ImageIO.read(this.getClass().getResource("character 8.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		previewcharacters.add(character1);
		previewcharacters.add(character2);
		previewcharacters.add(character3);
		previewcharacters.add(character4);
		previewcharacters.add(character5);
		previewcharacters.add(character6);
		previewcharacters.add(character7);
		previewcharacters.add(character8);
		characters.add(character1);
		characters.add(character2);
		characters.add(character3);
		characters.add(character4);
		characters.add(character5);
		characters.add(character6);
		characters.add(character7);
		characters.add(character8);
		maximumCharacter = characters.size()-1;
	}
	void drawPreviewCharacter(Graphics g, int characterToDraw) {
		for (int i = 0; i < characters.size(); i++) {
			if(i==characterToDraw) {
				g.drawImage(characters.get(i), 1525, 50 ,300, 300, null);
			}
		}
	}
	void drawRealCharacter(Graphics g, int characterToDraw) {
		for (int i = 0; i < characters.size(); i++) {
			if(i==characterToDraw) {
				g.drawImage(characters.get(i), x, y, null);
				break;
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
