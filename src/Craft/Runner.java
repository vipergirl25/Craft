package Craft;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Runner {
	JFrame frame;
	CraftPanel craftpanel;
	final int width = 1920;
	final int height = 1080;
	Runner() {
		frame = new JFrame();
		craftpanel = new CraftPanel();
	}
	void setup() {
		frame.add(craftpanel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setTitle("Make A World");
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(width, height));
		frame.addKeyListener(craftpanel);
		frame.addMouseListener(craftpanel);
		craftpanel.startGame();
	}
	public static void main(String[] args) {
		new Runner().setup();
	}
}
