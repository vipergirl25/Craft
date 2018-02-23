package Craft;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CraftPanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	Timer timer;
	final int MENU_STATE = 0;
	final int INSTRUCTION_STATE = 1;
	final int CRAFT_STATE = 2;
	final int END_STATE = 3;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subtitleFont;
	Font instructionFont;
	public static BufferedImage beginGameBackground;
	public static BufferedImage instructionBackground;
	public static BufferedImage addAnimal;
	public static BufferedImage addCharacter;
	public static BufferedImage addBuilding;
	public static BufferedImage addTree;
	public static BufferedImage chooseBackground;
	public static BufferedImage exitGame;
	public static BufferedImage playAgain;
	public static BufferedImage seeInstructions;
	boolean drawAreYouSure;
	boolean deleteExitGame;
	boolean drawLeft;
	boolean drawRight;
	boolean drawBackground;
	boolean drawTree;
	boolean chooseFunctional;
	int previewBackgroundToDraw;
	int realBackgroundToDraw;
	int previewTreeToDraw;
	int realTreeToDraw;
	int previewCharacterToDraw;
	int realCharacterToDraw;
	int previewBuildingToDraw;
	int realBuildingToDraw;
	int previewAnimalToDraw;
	int realAnimalToDraw;
	Characters characters = new Characters();
	ExitGame exitgame  = new ExitGame();
	Backgrounds backgrounds = new Backgrounds();
	Trees trees = new Trees();
	Arrows arrows = new Arrows();
	Choose choose = new Choose();
	CraftPanel() {
		timer = new Timer(1000/60, this);
		titleFont = new Font("Helvetica", Font.PLAIN, 150);
		subtitleFont = new Font("Helvetica", Font.ITALIC, 50);
		instructionFont = new Font("Helvetica", Font.PLAIN, 50);
		try {
			beginGameBackground = ImageIO.read(this.getClass().getResource("Title Screen Background.png"));
			instructionBackground = ImageIO.read(this.getClass().getResource("Instructions Background.jpg"));
			addCharacter = ImageIO.read(this.getClass().getResource("add character.jpg"));
			addAnimal = ImageIO.read(this.getClass().getResource("add animal.jpg"));
			addBuilding = ImageIO.read(this.getClass().getResource("add building.jpg"));
			addTree = ImageIO.read(this.getClass().getResource("add tree.jpg"));
			chooseBackground = ImageIO.read(this.getClass().getResource("choose background.jpg"));
			exitGame = ImageIO.read(this.getClass().getResource("exit game.jpg"));
			playAgain = ImageIO.read(this.getClass().getResource("play again.jpg"));
			seeInstructions = ImageIO.read(this.getClass().getResource("see instructions.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void startGame() {
		timer.start();
	}
	void updateMenuState() {
		
	}
	void drawMenuState(Graphics g) {
		g.drawImage(beginGameBackground, 0, 0, 1920, 1080, this);
		g.setColor(Color.GRAY);
		g.setFont(titleFont);
		g.drawString("Create A Scene", 375, 150);
		g.setColor(Color.GRAY);
		g.setFont(subtitleFont);
		g.drawString("Press Enter To Continue", 625, 900);
	}
	void updateInstructionState() {
		
	}
	void drawInstructionState(Graphics g) {
		g.drawImage(instructionBackground, 0, 0, 1920, 1080, this);
		g.setColor(Color.GRAY);
		g.setFont(instructionFont);
		g.drawString("Welcome to the Create A World Game!", 450, 150);
	}
	void updateCraftState() {
		
	}
	void drawCraftState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1920, 1080);
		g.setColor(Color.GRAY);
		g.fillRect(270, 0, 1200, 1080);
		g.drawImage(addCharacter, 20, 40, this);
		g.drawImage(addAnimal, 20, 80, this);
		g.drawImage(addBuilding, 20, 120, this);
		g.drawImage(addTree, 20, 160, this);
		g.drawImage(chooseBackground, 20, 200, this);
		g.drawImage(exitGame, 20, 240, this);
		if(drawBackground==true) {
			if(backgrounds.drawPreviewBackground==true) {
				if(previewBackgroundToDraw!=0&&previewBackgroundToDraw!=5) {
					arrows.drawLeftArrow = true;
					arrows.drawRightArrow = true;
					arrows.drawArrows(g);
				}else if(previewBackgroundToDraw==0) {
					arrows.drawLeftArrow=false;
					arrows.drawRightArrow = true;
					arrows.drawArrows(g);
				}else if(previewBackgroundToDraw==5) {
					arrows.drawRightArrow=false;
					arrows.drawLeftArrow=true;
					arrows.drawArrows(g);
				}
				choose.addChoose();
				choose.drawChoose(g);
				backgrounds.drawPreviewBackground(g, previewBackgroundToDraw);
			}
		}
		if(drawTree==true) {
			if(trees.drawPreviewTree==true) {
				if(previewTreeToDraw!=0&&previewTreeToDraw!=4) {
					arrows.drawLeftArrow = true;
					arrows.drawRightArrow = true;
					arrows.drawArrows(g);
				}else if(previewTreeToDraw==0) {
					arrows.drawLeftArrow=false;
					arrows.drawRightArrow = true;
					arrows.drawArrows(g);
				}else if(previewTreeToDraw==4) {
					arrows.drawRightArrow=false;
					arrows.drawLeftArrow=true;
					arrows.drawArrows(g);
				}
				choose.addChoose();
				choose.drawChoose(g);
				trees.drawPreviewTree(g, previewTreeToDraw);
			}
		}
		if(backgrounds.keepBackground==true) {
			backgrounds.drawRealBackground(g, realBackgroundToDraw);
		}
		if(trees.keepTree==true) {
			trees.drawrealTree(g, realTreeToDraw);
		}
		if(drawAreYouSure == true) {
			exitgame.exitGame(g);
		}
		if(deleteExitGame == true) {
			exitgame.deleteExitGame(g);
		}
	}
	void updateEndState() {
		
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 1920, 1080);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState==MENU_STATE) {
			updateMenuState();
		}else if(currentState==INSTRUCTION_STATE) {
			updateInstructionState();
		}else if(currentState==CRAFT_STATE) {
			updateCraftState();
		}else if(currentState==END_STATE) {
			updateEndState();
		}
	}
    @Override
    public void paintComponent(Graphics g){
    	if(currentState==MENU_STATE) {
			drawMenuState(g);
		}else if(currentState==INSTRUCTION_STATE) {
			drawInstructionState(g);
		}else if(currentState==CRAFT_STATE) {
			drawCraftState(g);
		}else if(currentState==END_STATE) {
			drawEndState(g);
		}
   }
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Point click = arg0.getPoint();
		System.out.println(click);
		Rectangle addCharacterClicked = new Rectangle(30, 90, 200, 30);
		Rectangle addAnimalClicked = new Rectangle(30, 135, 200, 30);
		Rectangle addBuildingClicked = new Rectangle(30, 175, 200, 30);
		Rectangle addTreeClicked = new Rectangle(30, 215, 200, 30);
		Rectangle chooseBackgroundClicked = new Rectangle(30, 255, 200, 30);
		Rectangle exitGameClicked = new Rectangle(30, 295, 200, 30);
		Rectangle yesClicked = new Rectangle(740, 490, 200, 30);
		Rectangle noIllStayClicked = new Rectangle(970, 490, 200, 30);
		Rectangle leftArrowClicked = new Rectangle(1485, 210, 50, 50);
		Rectangle rightArrowClicked = new Rectangle(1840, 210, 50, 50);
		Rectangle chooseClicked = new Rectangle(1580, 425, 200, 30);
		if(addCharacterClicked.contains(click)) {
			System.out.println("change this to a thing");
			backgrounds.drawPreviewBackground = false;
			trees.drawPreviewTree = false;
		}else if(addAnimalClicked.contains(click)) {
			System.out.println("add animal");
			backgrounds.drawPreviewBackground = false;
			trees.drawPreviewTree = false;
		}else if(addBuildingClicked.contains(click)) {
			System.out.println("add building");
			backgrounds.drawPreviewBackground = false;
			trees.drawPreviewTree = false;
		}else if(addTreeClicked.contains(click)) {
			System.out.println("add tree");
			trees.keepTree = false;
			backgrounds.drawPreviewBackground = false;
			trees.drawPreviewTree = true;
			drawTree = true;
		}else if(chooseBackgroundClicked.contains(click)) {
			System.out.println("choose background");
			backgrounds.keepBackground = false;
			backgrounds.drawPreviewBackground = true;
			trees.drawPreviewTree = false;
			drawBackground = true;
		}else if(exitGameClicked.contains(click)) {
			drawAreYouSure = true;
			deleteExitGame = false;
		}else if(yesClicked.contains(click)) {
			currentState = END_STATE;
		}else if(noIllStayClicked.contains(click)) {
			deleteExitGame = true;
			drawAreYouSure = false;
		}else if(leftArrowClicked.contains(click)) {
			System.out.println("left");
			chooseFunctional = false;
			drawLeft = true;
			drawRight = false;
			if(backgrounds.drawPreviewBackground == true) {
				if(chooseFunctional==false) {
					if(previewBackgroundToDraw==0) {
						previewBackgroundToDraw=0;
					}else {
						previewBackgroundToDraw--;
					}
				}
			}else if(trees.drawPreviewTree == true) {
				if(chooseFunctional==false) {
					if(previewTreeToDraw==0) {
						previewTreeToDraw=0;
					}else {
						previewTreeToDraw--;
					}
				}
			}
		}else if(rightArrowClicked.contains(click)) {
			System.out.println("right");
			chooseFunctional = false;
			drawRight = true;
			drawLeft = false;
			if(backgrounds.drawPreviewBackground == true) {
				if(chooseFunctional==false) {
					if(previewBackgroundToDraw==5) {
						previewBackgroundToDraw=5;
					}else {
						previewBackgroundToDraw++;
					}
				}
			}else if(trees.drawPreviewTree == true) {
				if(chooseFunctional==false) {
					if(previewTreeToDraw==4) {
						previewTreeToDraw=4;
					}else {
						previewTreeToDraw++;
					}
				}
			}
		}else if(chooseClicked.contains(click)) {
			System.out.println("choose");
			chooseFunctional = true;
			if(drawBackground==true) {
				backgrounds.keepBackground=true;
				realBackgroundToDraw = previewBackgroundToDraw;
			}
			if(drawTree==true) {
				trees.keepTree=true;
				realTreeToDraw = previewTreeToDraw;
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("hello");
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			currentState++;
			System.out.println(currentState);
			if(currentState>CRAFT_STATE) {
				currentState=CRAFT_STATE;
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("hello");
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("hello");
		
	}
}
