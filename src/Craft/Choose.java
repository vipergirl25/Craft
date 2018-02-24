package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Choose {
	public static BufferedImage chooseButton;
	public static BufferedImage deleteObject;
	boolean drawChooseButton;
	Choose() {
		try {
			chooseButton = ImageIO.read(this.getClass().getResource("choose.jpg"));
			deleteObject = ImageIO.read(this.getClass().getResource("delete object.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	void drawChoose(Graphics g) {
		if(drawChooseButton == true) {
			g.drawImage(chooseButton, 1570, 370, null);
			g.drawImage(deleteObject, 1570, 410, null);
		}
	}
	void addChoose() {
		drawChooseButton = true;
	}
	void removeChoose() {
		drawChooseButton = false;
	}

}
