import javax.swing.ImageIcon;
/*
 * created by Austin So, ID 30021027
 */
public class Rock extends FallingThings {
    
	//instance variable of Rock in Falling things
	private int RockHealth;
	private int RockSpeed;
	private int hitboxX;
	private int hitboxY;
	//constructor of rock
	public Rock(){
    	RockHealth = RockHealth();
    	RockSpeed = getRockSpeed();
    	Width = 80;
    	Height = 50;
    	image = new ImageIcon(Rock.class.getResource("World/Rock.png"));
    	Speed = getRockSpeed();
   	 
	}
	// initializing health of rock
	private int RockHealth(){
    	return rand.nextInt(4-1)+1;
	}
	//getting rock falling speed
	public int getRockSpeed(){
    	RockSpeed =  rand.nextInt(3-1)+1;
    	return RockSpeed;
	}
	//getting rock's health
	public int getHealth(){
    	return RockHealth;
	}
   	//changing rocks' health when hit
	public void minusHealth(int damage){
     	RockHealth = RockHealth-damage;
	}
	//getting the Height of rock image
	public int getHeight(){
    	return Height;
   	 
	}
	//getting the width of rock image
	public int getwidth(){
    	return Width;   	 
	}
	//getting the X coordinate of rock's hitbox
	public int getHitboxX(){
    	return hitboxX;
	}
	//getting the Y coordinate of rock's hitbox
	public int getHitboxY(){
    	return hitboxY;
	}
}