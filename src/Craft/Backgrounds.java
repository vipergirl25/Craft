package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Backgrounds {
	public static BufferedImage background1;
	public static BufferedImage background2;
	public static BufferedImage background3;
	public static BufferedImage background4;
	public static BufferedImage background5;
	public static BufferedImage background6;
	public static BufferedImage background7;
	boolean drawPreviewBackground;
	boolean drawRealBackground;
	int backgroundToDraw;
	int maximumBackground;
	ArrayList<BufferedImage>previewbackgrounds=new ArrayList<BufferedImage>();
	ArrayList<BufferedImage>backgrounds=new ArrayList<BufferedImage>();
	Backgrounds() {
		try {
			background1 = ImageIO.read(this.getClass().getResource("background 1.jpg"));
			background2 = ImageIO.read(this.getClass().getResource("background 2.jpg"));
			background3 = ImageIO.read(this.getClass().getResource("background 3.jpg"));
			background4 = ImageIO.read(this.getClass().getResource("background 4.jpg"));
			background5 = ImageIO.read(this.getClass().getResource("background 5.jpg"));
			background6 = ImageIO.read(this.getClass().getResource("background 6.jpg"));
			background7 = ImageIO.read(this.getClass().getResource("end screen background.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		previewbackgrounds.add(background1);
		previewbackgrounds.add(background2);
		previewbackgrounds.add(background3);
		previewbackgrounds.add(background4);
		previewbackgrounds.add(background5);
		previewbackgrounds.add(background6);
		previewbackgrounds.add(background7);
		backgrounds.add(background1);
		backgrounds.add(background2);
		backgrounds.add(background3);
		backgrounds.add(background4);
		backgrounds.add(background5);
		backgrounds.add(background6);
		backgrounds.add(background7);
		maximumBackground = backgrounds.size() - 1;
	}
	void drawPreviewBackground(Graphics g, int backgroundToDraw) {
		for (int i = 0; i < previewbackgrounds.size(); i++) {
			if(backgroundToDraw==i) {
				g.drawImage(previewbackgrounds.get(i), 1525, 50, 300, 300, null);
			}
		}
	}
	void drawRealBackground(Graphics g, int backgroundToDraw) {
		for (int i = 0; i < backgrounds.size(); i++) {
			if(backgroundToDraw==i) {
				g.drawImage(backgrounds.get(i), 270, 0, 1200, 1080, null);
				break;
			}
		}
	}
	}
	
