import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gui extends JPanel implements ActionListener{
	
	Image backgroundImgage;

	Image gameCharacterStandingForwardImage_01;
	Image gameCharacterStandingForwardImage_02;
	Image gameCharacterStandingForwardImage_03;
	Image gameCharacterStandingBackwardImage_01;
	Image gameCharacterStandingBackwardImage_02;
	Image gameCharacterStandingBackwardImage_03;
	Image gameCharacterRunningForwardImage_01;
	Image gameCharacterRunningForwardImage_02;
	Image gameCharacterRunningForwardImage_03;
	Image gameCharacterRunningBackwardImage_01;
	Image gameCharacterRunningBackwardImage_02;
	Image gameCharacterRunningBackwardImage_03;

	Timer reframeTimer;
	double xBackground;
	double xJump;
	int userKey;
	double run = 0;
	double defaultGameCharecterSpeed = 0.5;
	int newDirectionKey;
	int oldDirectionKey;
	int jumpKey = 0;
	int numberOfBackgroundImages = 2;
	int backgroundLenght = 1500; //the length of one background image in pixel
	int backgroundGround = 540; //The pixel value from the ground of the level
	int levelLength = numberOfBackgroundImages * backgroundLenght - backgroundLenght; //the length of the level in pixel minus one background length
	int gameCharacterXDefaultValue = 615; //TODO: I should make the default value dynamic
	int gameCharacterXMin = 0 - 50;
	int gameCharacterXMax = levelLength - 250; //TODO: I should make the 250 dynamic
	double gameCharacterY = backgroundGround;
	double gameCharacterX = gameCharacterXDefaultValue;
	double iterartionRun = 0;
	Boolean isOnGround = true;
	String jumpDirection; 
	int numberOfJumpIterations = 80;
	int iterationJump;
	int numberOfDrawingIterartions = 88;
	int numberOfMotionImages = 4;
	int iterationPerMotionImage = numberOfDrawingIterartions / numberOfMotionImages;
	boolean lockBackground = false;
	
	public gui(){
		setFocusable(true);
		
		//Load Images
		loadBackground();		
		loadNan();

		addKeyListener(new ActionKeyListenerPublic()); 
		
		//Create new timer
		reframeTimer = new Timer(5,this);
		reframeTimer.start();
	}


	public void paint(Graphics g){
		super.paint(g);
		Graphics2D background2DOne = (Graphics2D)g;
		Graphics2D background2DTwo = (Graphics2D)g;
		Graphics2D gameCharecer2D = (Graphics2D)g;
		
		//Draw the background
		background2DOne.drawImage(backgroundImgage, (int)xBackground, 0, null);
		background2DTwo.drawImage(backgroundImgage, (int)xBackground+backgroundLenght, 0, null);
		
		//Draw the character in right direction
		if(oldDirectionKey == -1 && newDirectionKey == 0 || oldDirectionKey == -1 && !isOnGround){ 
			if(isOnGround || !isOnGround && jumpDirection == "up"){
				if(iterartionRun <= iterationPerMotionImage){
					gameCharecer2D.drawImage(gameCharacterStandingForwardImage_01, (int)gameCharacterX, (int)gameCharacterY, null);
				}else if(iterartionRun <= 2 * iterationPerMotionImage){
					gameCharecer2D.drawImage(gameCharacterStandingForwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);	
				}else if(iterartionRun <= 3 * iterationPerMotionImage){
					gameCharecer2D.drawImage(gameCharacterStandingForwardImage_03, (int)gameCharacterX, (int)gameCharacterY, null);
				}else {
					gameCharecer2D.drawImage(gameCharacterStandingForwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);
				}
			}else if(!isOnGround && jumpDirection == "down"){//For falling down at jump
				gameCharecer2D.drawImage(gameCharacterStandingForwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);
			}
		}else if(oldDirectionKey == 1 && newDirectionKey == 0 || oldDirectionKey == 1 && !isOnGround){
			//Check if character isOnGround
			if(isOnGround || !isOnGround && jumpDirection == "up"){//For standing and jumping up TODO_LATER: I have to make another branch for jumping up
				if(iterartionRun <= iterationPerMotionImage){
					gameCharecer2D.drawImage(gameCharacterStandingBackwardImage_01, (int)gameCharacterX, (int)gameCharacterY, null);
				}else if(iterartionRun <= 2 * iterationPerMotionImage){
					gameCharecer2D.drawImage(gameCharacterStandingBackwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);	
				}else if(iterartionRun <= 3 * iterationPerMotionImage){
					gameCharecer2D.drawImage(gameCharacterStandingBackwardImage_03, (int)gameCharacterX, (int)gameCharacterY, null);
				}else {
					gameCharecer2D.drawImage(gameCharacterStandingBackwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);
				}
			}else if(!isOnGround && jumpDirection == "down"){//For falling down at jump
				gameCharecer2D.drawImage(gameCharacterStandingBackwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);
			}
		}else if(oldDirectionKey == -1){
			if(iterartionRun <= iterationPerMotionImage){
				gameCharecer2D.drawImage(gameCharacterRunningForwardImage_01, (int)gameCharacterX, (int)gameCharacterY, null);
			}else if(iterartionRun <= 2 * iterationPerMotionImage){
				gameCharecer2D.drawImage(gameCharacterRunningForwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);	
			}else if(iterartionRun <= 3 * iterationPerMotionImage){
				gameCharecer2D.drawImage(gameCharacterRunningForwardImage_03, (int)gameCharacterX, (int)gameCharacterY, null);
			}else {
				gameCharecer2D.drawImage(gameCharacterRunningForwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);
			}
		}else if(oldDirectionKey == 1){
			if(iterartionRun <= iterationPerMotionImage){
				gameCharecer2D.drawImage(gameCharacterRunningBackwardImage_01, (int)gameCharacterX, (int)gameCharacterY, null);
			}else if(iterartionRun <= 2 * iterationPerMotionImage){
				gameCharecer2D.drawImage(gameCharacterRunningBackwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);	
			}else if(iterartionRun <= 3 * iterationPerMotionImage){
				gameCharecer2D.drawImage(gameCharacterRunningBackwardImage_03, (int)gameCharacterX, (int)gameCharacterY, null);
			}else {
				gameCharecer2D.drawImage(gameCharacterRunningBackwardImage_02, (int)gameCharacterX, (int)gameCharacterY, null);
			}
		}
		
		if(iterartionRun++ > numberOfDrawingIterartions){
			iterartionRun = 0;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Check if the user pressed a key
		moveBackground();
		checkForJumpEvent();
		jump();
		repaint();

	}

	public void moveBackground(){
		newDirectionKey = ActionKeyListenerPublic.getKeyValue();
		
		//Exit the function if the user doesn't press a button
		if(newDirectionKey == 0){
			return;
		}
		
		//Check if the user presses the key longer
		if(newDirectionKey == oldDirectionKey){
			//Ensure the maximum speed of the character
			if(run <= 3.5 && run >= -3.5){
				run *= 1.02;
			}
		} else {
			run = newDirectionKey * defaultGameCharecterSpeed;
		}
		
		//Check if the background or the character has to move
		if((xBackground + run <= 0 && xBackground + run >= -levelLength) && !lockBackground){//Move the Background
			//System.out.println(xBackground + run );
			xBackground += run;
			oldDirectionKey = newDirectionKey;
		}else {//Move the character
			lockBackground = true;
			System.out.println(gameCharacterX);
			if(gameCharacterX - run >= gameCharacterXMin && gameCharacterX - run <= gameCharacterXMax){
				gameCharacterX -= run;
				oldDirectionKey = newDirectionKey;
			}else{
				System.out.println("STOP RUNNING");
			}
			//Check if the Character has his default position again
			if((gameCharacterX <= gameCharacterXDefaultValue + 1.8  && gameCharacterX >= gameCharacterXDefaultValue) || (gameCharacterX >= gameCharacterXDefaultValue - 1.8  && gameCharacterX < gameCharacterXDefaultValue) ){
				lockBackground = false;
				gameCharacterX = gameCharacterXDefaultValue;
			}
		}
		
	}
	
	public void checkForJumpEvent(){ //TODO:I have to create a return value to make my program saver
		jumpKey = ActionKeyListenerPublic.getJumpValue();
		
		if(jumpKey == 1 && isOnGround){
			xJump = 0;
			iterationJump = 0;
			isOnGround = false;
			jumpDirection = "up";
		}
	}
	
	private void jump(){
		
		if(!isOnGround && iterationJump <= numberOfJumpIterations){
			
			gameCharacterY = backgroundGround - ((-Math.cos(xJump))+1)*200 ;
		
			//Set the jump direction 
			if(iterationJump <= numberOfJumpIterations/2){
				jumpDirection = "up";
			}else{
				jumpDirection ="down";
			}
			
			//Set the value for the next jump iteration
			xJump += (2*Math.PI) / numberOfJumpIterations;
			iterationJump++;
		}else if(!isOnGround && iterationJump > numberOfJumpIterations){
			gameCharacterY = backgroundGround;
			isOnGround = true;
		}
		
		
	}
	

	private void loadBackground() {
		//Load the background
		ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("Images/Background_Mountain.png"));
		backgroundImgage = backgroundIcon.getImage();
	}
	
	private void loadForeground(){
		
	}
	
	
	private void loadNan() {

		//Load all running forward images for Nan
		ImageIcon gameCharecterRunningForwardIcon_01 = new ImageIcon(getClass().getResource("Images/NanRunningForward_01.png"));
		gameCharacterRunningForwardImage_01 = gameCharecterRunningForwardIcon_01.getImage();
		ImageIcon gameCharecterRunningForwardIcon_02 = new ImageIcon(getClass().getResource("Images/NanRunningForward_02.png"));
		gameCharacterRunningForwardImage_02 = gameCharecterRunningForwardIcon_02.getImage();
		ImageIcon gameCharecterRunningForwardIcon_03 = new ImageIcon(getClass().getResource("Images/NanRunningForward_03.png"));
		gameCharacterRunningForwardImage_03 = gameCharecterRunningForwardIcon_03.getImage();
		
		//Load all running backward images for Nan
		ImageIcon gameCharecterRunningBackwardIcon_01 = new ImageIcon(getClass().getResource("Images/NanRunningBackward_01.png"));
		gameCharacterRunningBackwardImage_01 = gameCharecterRunningBackwardIcon_01.getImage();
		ImageIcon gameCharecterRunningBackwardIcon_02 = new ImageIcon(getClass().getResource("Images/NanRunningBackward_02.png"));
		gameCharacterRunningBackwardImage_02 = gameCharecterRunningBackwardIcon_02.getImage();
		ImageIcon gameCharecterRunningBackwardIcon_03 = new ImageIcon(getClass().getResource("Images/NanRunningBackward_03.png"));
		gameCharacterRunningBackwardImage_03 = gameCharecterRunningBackwardIcon_03.getImage();
		
		//Load all standing forward images for Nan
		ImageIcon gameCharecterStandingForwardIcon_01 = new ImageIcon(getClass().getResource("Images/NanStandingForward_01.png"));
		gameCharacterStandingForwardImage_01 = gameCharecterStandingForwardIcon_01.getImage();
		ImageIcon gameCharecterStandingForwardIcon_02 = new ImageIcon(getClass().getResource("Images/NanStandingForward_02.png"));
		gameCharacterStandingForwardImage_02 = gameCharecterStandingForwardIcon_02.getImage();
		ImageIcon gameCharecterStandingForwardIcon_03 = new ImageIcon(getClass().getResource("Images/NanStandingForward_03.png"));
		gameCharacterStandingForwardImage_03 = gameCharecterStandingForwardIcon_03.getImage();
		
		//Load all standing backward images for Nan
		ImageIcon gameCharecterStandingBackwardIcon_01 = new ImageIcon(getClass().getResource("Images/NanStandingBackward_01.png"));
		gameCharacterStandingBackwardImage_01 = gameCharecterStandingBackwardIcon_01.getImage();
		ImageIcon gameCharecterStandingBackwardIcon_02 = new ImageIcon(getClass().getResource("Images/NanStandingBackward_02.png"));
		gameCharacterStandingBackwardImage_02 = gameCharecterStandingBackwardIcon_02.getImage();
		ImageIcon gameCharecterStandingBackwardIcon_03 = new ImageIcon(getClass().getResource("Images/NanStandingBackward_03.png"));
		gameCharacterStandingBackwardImage_03 = gameCharecterStandingBackwardIcon_03.getImage();
		
	}
	
}
	




