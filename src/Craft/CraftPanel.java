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
	public static BufferedImage endScreenBackground;
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
	boolean chooseFunctional;
	boolean exitFunctional;
	boolean deleteObjectFunctional;
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
	Buildings buildings = new Buildings();
	Animals animals = new Animals();
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
			endScreenBackground = ImageIO.read(this.getClass().getResource("end screen background.jpg"));
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
		resetCraftState();
		g.drawImage(instructionBackground, 0, 0, 1920, 1080, this);
		g.setColor(Color.PINK);
		g.setFont(instructionFont);
		g.drawString("Welcome to the Create A World Game!", 450, 150);
		g.setFont(instructionFont);
		g.drawString("The point of this game is to create an image.", 50, 350);
		g.setColor(Color.BLACK);
		g.drawString("You just click on the buttons, choose the image you want, and add it.", 50, 450);
		g.setColor(Color.PINK);
		g.drawString("You can move the images around, but only if you are in that images draw mode", 50, 550);
		g.setColor(Color.BLACK);
		g.drawString("That means that if you are in add tree mode, you can only move a tree.", 50, 650);
		g.setColor(Color.PINK);
		g.drawString("The 'choose bg' button allows you to choose the background.", 50, 750);
		g.setColor(Color.BLACK);
		g.drawString("Press enter to continue.", 50, 850);
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
		if(backgrounds.drawPreviewBackground==true) {
			if(previewBackgroundToDraw!=0&&previewBackgroundToDraw!=backgrounds.maximumBackground) {
				arrows.drawLeftArrow = true;
				arrows.drawRightArrow = true;
				arrows.drawArrows(g);
			}else if(previewBackgroundToDraw==0) {
				arrows.drawLeftArrow=false;
				arrows.drawRightArrow = true;
				arrows.drawArrows(g);
			}else if(previewBackgroundToDraw==backgrounds.maximumBackground) {
				arrows.drawRightArrow=false;
				arrows.drawLeftArrow=true;
				arrows.drawArrows(g);
			}
			choose.addChoose();
			choose.drawChoose(g);
			backgrounds.drawPreviewBackground(g, previewBackgroundToDraw);
		}
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
		}else if(buildings.drawPreviewBuilding==true) {
			if(previewBuildingToDraw!=0&&previewBuildingToDraw!=buildings.maximumBuilding) {
				arrows.drawLeftArrow = true;
				arrows.drawRightArrow = true;
				arrows.drawArrows(g);
			}else if(previewBuildingToDraw==0) {
				arrows.drawLeftArrow=false;
				arrows.drawRightArrow = true;
				arrows.drawArrows(g);
			}else if(previewBuildingToDraw==buildings.maximumBuilding) {
				arrows.drawRightArrow=false;
				arrows.drawLeftArrow=true;
				arrows.drawArrows(g);
			}
			choose.addChoose();
			choose.drawChoose(g);
			buildings.drawPreviewBuilding(g, previewBuildingToDraw);
		}else if(characters.drawPreviewCharacter==true) {
			if(previewCharacterToDraw!=0&&previewCharacterToDraw!=characters.maximumCharacter) {
				arrows.drawLeftArrow=true;
				arrows.drawRightArrow=true;
				arrows.drawArrows(g);
			}else if(previewCharacterToDraw==0) {
				arrows.drawLeftArrow=false;
				arrows.drawRightArrow=true;
				arrows.drawArrows(g);
			}else if(previewCharacterToDraw==characters.maximumCharacter) {
				arrows.drawRightArrow=false;
				arrows.drawLeftArrow=true;
				arrows.drawArrows(g);
			}
			choose.addChoose();
			choose.drawChoose(g);
			characters.drawPreviewCharacter(g, previewCharacterToDraw);
		}else if(animals.drawPreviewAnimal==true) {
			if(previewAnimalToDraw!=0&&previewAnimalToDraw!=animals.maximumAnimal) {
				arrows.drawLeftArrow=true;
				arrows.drawRightArrow=true;
				arrows.drawArrows(g);
			}else if(previewAnimalToDraw==0) {
				arrows.drawLeftArrow=false;
				arrows.drawRightArrow=true;
				arrows.drawArrows(g);
			}else if(previewAnimalToDraw==animals.maximumAnimal) {
				arrows.drawRightArrow=false;
				arrows.drawLeftArrow=true;
				arrows.drawArrows(g);
			}
			choose.addChoose();
			choose.drawChoose(g);
			animals.drawPreviewAnimal(g, previewAnimalToDraw);
		}
		if(backgrounds.drawRealBackground==true) {
			backgrounds.drawRealBackground(g, realBackgroundToDraw);
		}
		if(buildings.drawRealBuilding==true) {
			buildings.drawRealBuilding(g, realBuildingToDraw);
		}
		if(trees.drawRealTree==true) {
			trees.drawrealTree(g, realTreeToDraw);
		}
		if(characters.drawRealCharacter==true) {
			characters.drawRealCharacter(g, realCharacterToDraw);
		}
		if(animals.drawRealAnimal==true) {
			animals.drawRealAnimal(g, realAnimalToDraw);
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
		g.drawImage(endScreenBackground, 0, 0, 1920, 1080, this);
		g.setFont(titleFont);
		g.setColor(Color.PINK);
		g.drawString("Thanks for playing!", 350, 300);
		g.drawImage(seeInstructions, 740, 430, this);
		g.drawImage(playAgain, 950, 430, this);
	}
	void resetCraftState() {
		animals = new Animals();
		previewAnimalToDraw = 0;
		realAnimalToDraw = 0;
		characters = new Characters();
		previewCharacterToDraw = 0;
		realAnimalToDraw = 0;
		backgrounds = new Backgrounds();
		previewBackgroundToDraw = 0;
		realBackgroundToDraw = 0;
		trees = new Trees();
		previewTreeToDraw = 0;
		realTreeToDraw = 0;
		buildings = new Buildings();
		previewBuildingToDraw = 0;
		realBuildingToDraw = 0;
		choose = new Choose();
		exitgame = new ExitGame();
		arrows = new Arrows();
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
		Rectangle addCharacterClicked = new Rectangle(90, 75, 200, 30);
		Rectangle addAnimalClicked = new Rectangle(110, 105, 200, 30);
		Rectangle addBuildingClicked = new Rectangle(20, 145, 200, 30);
		Rectangle addTreeClicked = new Rectangle(20, 185, 200, 30);
		Rectangle chooseBackgroundClicked = new Rectangle(20, 215, 200, 30);
		Rectangle exitGameClicked = new Rectangle(30, 255, 200, 30);
		Rectangle yesClicked = new Rectangle(730, 465, 200, 30);
		Rectangle noIllStayClicked = new Rectangle(960, 465, 200, 30);
		Rectangle leftArrowClicked = new Rectangle(1475, 180, 50, 50);
		Rectangle rightArrowClicked = new Rectangle(1830, 175, 50, 50);
		Rectangle chooseClicked = new Rectangle(1570, 395, 200, 30);
		Rectangle deleteObjectClicked = new Rectangle(1570,435, 200, 30);
		Rectangle seeInstructionsClicked = new Rectangle(740, 455, 200, 30);
		Rectangle playAgainClicked = new Rectangle(950, 455, 200, 30);
		if(currentState==CRAFT_STATE) {
			if(addCharacterClicked.contains(click)) {
				backgrounds.drawPreviewBackground = false;
				trees.drawPreviewTree = false;
				buildings.drawPreviewBuilding = false;
				characters.drawPreviewCharacter = true;
				animals.drawPreviewAnimal = false;
				deleteObjectFunctional = true;
			}else if(addAnimalClicked.contains(click)) {
				backgrounds.drawPreviewBackground = false;
				trees.drawPreviewTree = false;
				buildings.drawPreviewBuilding = false;
				characters.drawPreviewCharacter = false;
				animals.drawPreviewAnimal = true;
				deleteObjectFunctional = true;
			}else if(addBuildingClicked.contains(click)) {
				backgrounds.drawPreviewBackground = false;
				trees.drawPreviewTree = false;
				buildings.drawPreviewBuilding = true;
				characters.drawPreviewCharacter = false;
				animals.drawPreviewAnimal = false;
				deleteObjectFunctional = true;
			}else if(addTreeClicked.contains(click)) {
				backgrounds.drawPreviewBackground = false;
				trees.drawPreviewTree = true;
				characters.drawPreviewCharacter = false;
				buildings.drawPreviewBuilding = false;
				animals.drawPreviewAnimal = false;
				deleteObjectFunctional = true;
			}else if(chooseBackgroundClicked.contains(click)) {
				backgrounds.drawPreviewBackground = true;
				trees.drawPreviewTree = false;
				characters.drawPreviewCharacter = false;
				buildings.drawPreviewBuilding = false;
				animals.drawPreviewAnimal = false;
				deleteObjectFunctional = true;
			}else if(exitGameClicked.contains(click)) {
				drawAreYouSure = true;
				deleteExitGame = false;
				exitFunctional = true;
			}else if(yesClicked.contains(click)) {
				if(exitFunctional == true) {
					currentState = END_STATE;
				}
			}else if(noIllStayClicked.contains(click)) {
				deleteExitGame = true;
				drawAreYouSure = false;
				exitFunctional = false;
			}else if(leftArrowClicked.contains(click)) {
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
				}else if(buildings.drawPreviewBuilding == true) {
					if(chooseFunctional==false) {
						if(previewBuildingToDraw==0) {
							previewBuildingToDraw=0;
						}else {
							previewBuildingToDraw--;
						}
					}
				}else if(characters.drawPreviewCharacter == true) {
					if(chooseFunctional==false) {
						if(previewCharacterToDraw==0) {
							previewCharacterToDraw=0;
						}else {
							previewCharacterToDraw--;
						}
					}
				}else if(animals.drawPreviewAnimal == true) {
					if(chooseFunctional==false) {
						if(previewAnimalToDraw==0) {
							previewAnimalToDraw=0;
						}else {
							previewAnimalToDraw--;
						}
					}
				}
			}else if(rightArrowClicked.contains(click)) {
				chooseFunctional = false;
				drawRight = true;
				drawLeft = false;
				if(backgrounds.drawPreviewBackground == true) {
					if(chooseFunctional==false) {
						if(previewBackgroundToDraw==backgrounds.maximumBackground) {
							previewBackgroundToDraw=backgrounds.maximumBackground;
						}else {
							previewBackgroundToDraw++;
						}
					}
				}else if(trees.drawPreviewTree == true) {
					if(chooseFunctional==false) {
						if(previewTreeToDraw==trees.maximumTree) {
							previewTreeToDraw=4;
						}else {
							previewTreeToDraw++;
						}
					}
				}else if(buildings.drawPreviewBuilding == true) {
					if(chooseFunctional==false) {
						if(previewBuildingToDraw==buildings.maximumBuilding) {
							previewBuildingToDraw=buildings.maximumBuilding;
						}else {
							previewBuildingToDraw++;
						}
					}
				}else if(characters.drawPreviewCharacter == true) {
					if(chooseFunctional==false) {
						if(previewCharacterToDraw==characters.maximumCharacter) {
							previewCharacterToDraw=characters.maximumCharacter;
						}else {
							previewCharacterToDraw++;
						}
					}
				}else if(animals.drawPreviewAnimal == true) {
					if(chooseFunctional==false) {
						if(previewAnimalToDraw==animals.maximumAnimal) {
							previewAnimalToDraw = animals.maximumAnimal;
						}else {
							previewAnimalToDraw++;
						}
					}
				}
			}else if(chooseClicked.contains(click)) {
				chooseFunctional = true;
				if(trees.drawPreviewTree==true) {
					trees.drawRealTree=true;
				}else if(buildings.drawPreviewBuilding==true) {
					buildings.drawRealBuilding=true;
				}else if(characters.drawPreviewCharacter==true) {
					characters.drawRealCharacter=true;
				}else if(animals.drawPreviewAnimal==true) {
					animals.drawRealAnimal=true;
				}
				if(backgrounds.drawPreviewBackground==true) {
					backgrounds.drawRealBackground=true;
					realBackgroundToDraw = previewBackgroundToDraw;
				}
				if(trees.drawRealTree==true) {
					trees.setX(trees.x);
					trees.setY(trees.y);
					realTreeToDraw = previewTreeToDraw;
				}
				if(buildings.drawRealBuilding==true) {
					buildings.setX(buildings.x);
					buildings.setY(buildings.y);
					realBuildingToDraw = previewBuildingToDraw;
				}
				if(characters.drawRealCharacter==true) {
					characters.setX(characters.x);
					characters.setY(characters.y);
					realCharacterToDraw = previewCharacterToDraw;
				}
				if(animals.drawRealAnimal==true) {
					animals.setX(animals.x);
					animals.setY(animals.y);
					realAnimalToDraw = previewAnimalToDraw;
				}
			}else if(deleteObjectClicked.contains(click)) {
				if(deleteObjectFunctional==true) {
					if(backgrounds.drawPreviewBackground==true) {
						backgrounds.drawRealBackground = false;
					}else if(characters.drawPreviewCharacter==true) {
						characters.drawRealCharacter = false;
					}else if(animals.drawPreviewAnimal==true) {
						animals.drawRealAnimal = false;
					}else if(trees.drawPreviewTree==true) {
						trees.drawRealTree = false;
					}else if(buildings.drawPreviewBuilding==true) {
						buildings.drawRealBuilding = false;
					}
				}
			}
		}else if(currentState==END_STATE) {
			if(seeInstructionsClicked.contains(click)) {
				currentState = INSTRUCTION_STATE;
			}else if(playAgainClicked.contains(click)) {
				currentState = CRAFT_STATE;
				resetCraftState();
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
		Point move = arg0.getPoint();
		Double moveX = move.getX();
		Double moveY = move.getY();
		int xSet = moveX.intValue(); 
		int ySet = moveY.intValue();
		Rectangle ableToMove = new Rectangle(270, 0, 1200, 1080);
		if(ableToMove.contains(move)) {
			if(trees.drawPreviewTree==true) {
				if(xSet - trees.trees.get(realTreeToDraw).getWidth()/2 < 270) {
					trees.setX(270);
				}else if(xSet + trees.trees.get(realTreeToDraw).getWidth()/2 > 1470) {
					trees.setX(1470 - trees.trees.get(realTreeToDraw).getWidth());
				}else {
					trees.setX(xSet - trees.trees.get(realTreeToDraw).getWidth()/2);
				}
				if(ySet - trees.trees.get(realTreeToDraw).getHeight()/2 < 0) {
					trees.setY(0);
				}else if(ySet - trees.trees.get(realTreeToDraw).getHeight()/2 > 1080) {
					trees.setY(1080 - trees.trees.get(realTreeToDraw).getHeight());
				}else {
					trees.setY(ySet - trees.trees.get(realTreeToDraw).getHeight()/2);
				}
			}else if(buildings.drawPreviewBuilding==true) {
				if(xSet - buildings.buildings.get(realBuildingToDraw).getWidth()/2 < 270) {
					buildings.setX(270);
				}else if(xSet + buildings.buildings.get(realBuildingToDraw).getWidth()/2 > 1470) {
					buildings.setX(1470 - buildings.buildings.get(realBuildingToDraw).getWidth());
				}else {
					buildings.setX(xSet - buildings.buildings.get(realBuildingToDraw).getWidth()/2);
				}if(ySet - buildings.buildings.get(realBuildingToDraw).getWidth()/2 < 0) {
					buildings.setY(0);
				}else if(ySet - buildings.buildings.get(realBuildingToDraw).getHeight()/2 > 1080) {
					buildings.setY(1080 - buildings.buildings.get(realBuildingToDraw).getHeight());
				}else {
					buildings.setY(ySet - buildings.buildings.get(realBuildingToDraw).getHeight()/2);
				}
				}else if(characters.drawPreviewCharacter==true) {
					if(xSet - characters.characters.get(realCharacterToDraw).getWidth()/2 < 270) {
						characters.setX(270);
					}else if(xSet + characters.characters.get(realCharacterToDraw).getWidth()/2 > 1470) {
						characters.setX(1470 - characters.characters.get(realCharacterToDraw).getWidth());
					}else {
						characters.setX(xSet - characters.characters.get(realCharacterToDraw).getWidth()/2);
					}if(ySet - characters.characters.get(realCharacterToDraw).getWidth()/2 < 0) {
						characters.setY(0);
					}else if(ySet - characters.characters.get(realCharacterToDraw).getHeight()/2 > 1080) {
						characters.setY(1080 - characters.characters.get(realCharacterToDraw).getHeight());
					}else {
						characters.setY(ySet - characters.characters.get(realCharacterToDraw).getHeight()/2);
					}
			}else if(animals.drawPreviewAnimal==true) {
				if(xSet - animals.animals.get(realAnimalToDraw).getWidth()/2 < 270) {
					animals.setX(270);
				}else if(xSet + animals.animals.get(realAnimalToDraw).getWidth()/2 > 1470) {
					animals.setX(1470 - animals.animals.get(realAnimalToDraw).getWidth());
				}else {
					animals.setX(xSet - animals.animals.get(realAnimalToDraw).getWidth()/2);
				}if(ySet - animals.animals.get(realCharacterToDraw).getWidth()/2 < 0) {
					animals.setY(0);
				}else if(ySet - animals.animals.get(realAnimalToDraw).getHeight()/2 > 1080) {
					animals.setY(1080 - animals.animals.get(realAnimalToDraw).getHeight());
				}else {
					animals.setY(ySet - animals.animals.get(realAnimalToDraw).getHeight()/2);
				}
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
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
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
