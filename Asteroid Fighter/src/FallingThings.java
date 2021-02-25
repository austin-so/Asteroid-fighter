import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
/*
 * created by Austin So, ID 30021027
 */
public class FallingThings   {
	//Random number generator
	Random rand = new Random();
	int randNum = rand.nextInt();
	//instance variable of all falling things
	int fallingLocationX = rand.nextInt(600);
	int fallingLocationY = -100;
	protected ImageIcon image;
	protected int Speed;
	protected int hitboxX;
	protected int hitboxY;
	protected int Height;
	protected int Width;
	protected String type;
	private int hitNum = 0;
	//falling things' Y coordinate
	public int getfallingLocationY(){
    	return fallingLocationY;
	}
	//falling things' X coordinate
	public int getfallingLocationX(){
    	return fallingLocationX;
	}
	//changing falling things' Y
	public void setfallingLocationY(int speed){
    	fallingLocationY = fallingLocationY + speed;
	}
	//cahnging falling things' X
	public int setfallingLocationX(){
    	return fallingLocationX-1;
	}
	//get falling things speed
	public int getSpeed(){
    	return Speed;
	}
	//get falling things images
	public Image getImage(){
    	return image.getImage();
	}
	//setting falling things hitbox
	public void setHitbox(){
        	hitboxX = fallingLocationX +15;
        	hitboxY = fallingLocationY + 15;
	}
	//get the falling things' name
	public String getType(){
    	return type;
	}
	// check falling things' hitbox against ship
	public boolean checkHitboxForShip( int shipX, int shipY, int shipWidth, int shipHeight){
    	//check  boundaries of ship in between its height, then check left and right boundaries
    	//check ship's right side
     	if( ((hitboxY+Height) > shipY) && ((hitboxY+Height) < (shipY+shipHeight)) && ((hitboxX+ Width) > shipX) && (hitboxX < shipX)){
   		 hitNum++;
        	return true;
    	}
     	//check ship's left side
    	else if( ((hitboxY+Height) > shipY) && ((hitboxY+Height) < (shipY+shipHeight)) && (hitboxX < (shipX +shipWidth)) && ((hitboxX+Width)>(shipX+shipWidth))){
   		 hitNum++;
   		 return true;
    	}
     	//check ship is in the middle
    	else if( ((hitboxY+Height) > shipY) && ((hitboxY+Height) < (shipY+shipHeight)) && (hitboxX > shipX) && ((hitboxX+Width)<(shipX+shipWidth))){
   		 hitNum++;
   		 return true;
    	}
    	else{
   		 hitNum = 0;
   		 return false;
    	}
	}
	// check falling things' hitbox against bullets
	public boolean checkHitboxForBullet(int bulletX, int bulletY, int bulletWidth, int bulletHeight){
    	//check  boundaries of bullets in between its height, then check left and right boundaries
    	//System.out.println("hitbox X: " + hitboxX);
    	//System.out.println("hitbox Y: " + hitboxY);
    	//check bullet's right side
     	if( ((hitboxY+Height) > bulletY) && ((hitboxY+Height) < (bulletY+bulletHeight)) && ((hitboxX+ Width) > bulletX) && (hitboxX < bulletX)){
        	return true;
    	}
     	//check bullet's left side
    	else if( ((hitboxY+Height) > bulletY) && ((hitboxY+Height) < (bulletY+bulletHeight)) && (hitboxX < (bulletX +bulletWidth)) && ((hitboxX+Width)>(bulletX+bulletWidth))){
        	return true;
    	}
    	// check if bullet is in the middle
    	else if( ((hitboxY+Height) > bulletY) && ((hitboxY+Height) < (bulletY+bulletHeight)) && (hitboxX > bulletX) && ((hitboxX+Width)<(bulletX+bulletWidth))){
        	return true;
    	}
    	else{
        	return false;
    	}
	}
    public int getHitNum() {
   	 return hitNum;
    }    
}
 
 
 
 
 
