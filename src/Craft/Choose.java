package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Choose {
	public static BufferedImage chooseButton;
	boolean drawChooseButton;
	Choose() {
		try {
			chooseButton = ImageIO.read(this.getClass().getResource("choose.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	void drawChoose(Graphics g) {
		if(drawChooseButton == true) {
			g.drawImage(chooseButton, 1570, 370, null);
		}
	}
	void addChoose() {
		drawChooseButton = true;
	}
	void removeChoose() {
		drawChooseButton = false;
	}

}
