package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ExitGame {
	public static BufferedImage areYouSure;
	public static BufferedImage yes;
	public static BufferedImage noIllStay;
	ArrayList<BufferedImage>exitGame = new ArrayList<BufferedImage>();
	ExitGame() {
		try {
			areYouSure = ImageIO.read(this.getClass().getResource("are you sure.jpg"));
			yes = ImageIO.read(this.getClass().getResource("yes.jpg"));
			noIllStay = ImageIO.read(this.getClass().getResource("no ill stay.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void exitGame(Graphics g) {
		addExitGameButtons();
		for (int i = 0; i < exitGame.size(); i++) {
			if(i==0) {
				g.drawImage(areYouSure, 700, 400, null);
			} else if(i==1) {
				g.drawImage(yes, 730, 440, null);
			} else if(i==2) {
				g.drawImage(noIllStay, 960, 440, null);
			}
		}
	}
	void deleteExitGame(Graphics g) {
		for (int i = 0; i < exitGame.size(); i++) {
			exitGame.remove(exitGame.get(i));
		}
	}
	void addExitGameButtons() {
		exitGame.add(yes);
		exitGame.add(areYouSure);
		exitGame.add(noIllStay);
	}
}
