package Craft;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Trees {
	public static BufferedImage tree1;
	public static BufferedImage tree2;
	public static BufferedImage tree3;
	public static BufferedImage tree4;
	public static BufferedImage tree5;
	boolean drawRealTree;
	boolean drawPreviewTree;
	int treeToDraw;
	int x = 270;
	int y = 0;
	int maximumTree;
	ArrayList<BufferedImage>previewtrees = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage>trees = new ArrayList<BufferedImage>();
	Trees() {
		try {
			tree1 = ImageIO.read(this.getClass().getResource("tree 1.png"));
			tree2 = ImageIO.read(this.getClass().getResource("tree 2.png"));
			tree3 = ImageIO.read(this.getClass().getResource("tree 3.png"));
			tree4 = ImageIO.read(this.getClass().getResource("tree 4.png"));
			tree5 = ImageIO.read(this.getClass().getResource("tree 5.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		previewtrees.add(tree1);
		previewtrees.add(tree2);
		previewtrees.add(tree3);
		previewtrees.add(tree4);
		previewtrees.add(tree5);
		trees.add(tree1);
		trees.add(tree2);
		trees.add(tree3);
		trees.add(tree4);
		trees.add(tree5);
		maximumTree = trees.size() - 1;
	}
	void drawPreviewTree(Graphics g, int treeToDraw) {
		for (int i = 0; i < previewtrees.size(); i++) {
			if(treeToDraw==i) {
				g.drawImage(previewtrees.get(i), 1525, 50, 300, 300, null);
			}
		}
	}
	void drawrealTree(Graphics g, int treeToDraw) {
		for (int i = 0; i < trees.size(); i++) {
			if(treeToDraw==i) {
				g.drawImage(trees.get(i), x, y, null);
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
