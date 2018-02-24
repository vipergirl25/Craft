package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Buildings {
	public static BufferedImage building1;
	public static BufferedImage building2;
	public static BufferedImage building3;
	boolean drawPreviewBuilding;
	boolean drawRealBuilding;
	int buildingToDraw;
	int x = 270;
	int y = 0;
	int maximumBuilding;
	ArrayList<BufferedImage>previewbuildings = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage>buildings = new ArrayList<BufferedImage>();
	Buildings() {
		try {
			building1 = ImageIO.read(this.getClass().getResource("building 1.png"));
			building2 = ImageIO.read(this.getClass().getResource("building 2.png"));
			building3 = ImageIO.read(this.getClass().getResource("building 3.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		previewbuildings.add(building1);
		previewbuildings.add(building2);
		previewbuildings.add(building3);
		buildings.add(building1);
		buildings.add(building2);
		buildings.add(building3);
		maximumBuilding = buildings.size() - 1;
	}
	void drawPreviewBuilding(Graphics g, int buildingToDraw) {
		for (int i = 0; i < previewbuildings.size(); i++) {
			if(buildingToDraw==i) {
				g.drawImage(previewbuildings.get(i), 1525, 50, 300, 300, null);
			}
		}
	}
	void drawRealBuilding(Graphics g, int buildingToDraw) {
		for (int i = 0; i < buildings.size(); i++) {
			if(buildingToDraw==i) {
				g.drawImage(buildings.get(i), x, y, null);
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
