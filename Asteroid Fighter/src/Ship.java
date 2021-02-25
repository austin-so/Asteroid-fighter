import java.awt.Image;
import javax.swing.ImageIcon;
/*
 * Created by Carl Lyss 30025962
 */
public class Ship
{
	//instance variables of ship
	private static ImageIcon ship = new ImageIcon(Ship.class.getResource("World/Plane.png"));
	private static int xCoord= 320;
	private static int yCoord = 850;
	private static int speed = 10;
	private static int Width= 80;
	private static int Height = 120;
	private static int hitboxX ;
	private static int hitboxY ;
	private static boolean fire = false;
	private static int lives = 3;
	//get X coordinate of ship
	public static int getX()
	{
    	return xCoord;
	}
	//get Y coordinate of ship
	public static int getY()
	{
    	return yCoord;
	}
	//change X coordinate of ship
	public static void setX(int i)
	{
    	xCoord = i;
	}
	//change Y coordinate of ship
	public static void setY(int i)
	{
    	yCoord = i;
	}
	//change number of lives of plane
	private static void changeLives()
	{
    	lives += 1;
	}
	public static void downLife() {
   	 lives--;
    }
	//get number of lives on plane
	public static int getHealth()
	{
    	return lives;
	}
	//get the planes moving speed
	public static int getSpeed()
	{
    	return speed;
	}
	//changing the speed of plane
	private static void changeSpeed()
	{
    	speed += 5;
	}
	//set plane is firing
	public static void fire()
	{
    	fire = true;
	}
	//set plane is not firing
	public static void stopFire()
	{
    	fire =false;
	}
	//get plane's firing status
	public static boolean getFire()
	{
    	return fire;
	}
	//get plane's image
	public static Image getImage()
	{
    	return ship.getImage();
	}
	//setting the origin of plane's hitbox
	public static void setHitbox(int ShipX, int ShipY){
    	hitboxX = ShipX +30;
    	hitboxY = ShipY +30;
	}
	//get plane's hitbox's X coordinate
	public static int getHitboxX(){
    	return hitboxX;
	}
	//get plane's hitbox's Y coordinate
	public static int getHitboxY(){
    	return hitboxY;
	}
	//get plane's Width
	public static int getWidth(){
    	return Width;
	}
	//get plane's Height
	public static int getHeight(){
    	return Height;
	}
	//get receiving upgrade type
	public static void upgrade(FallingThings things)
	{
    	if(things.getType() == "PlaneSpeed" && speed<40)
    	{
   		 changeSpeed();
    	}
    	else if(things.getType() == "PlaneLives")
    	{
        	changeLives();
    	}
	}
}