import java.awt.Image;
import javax.swing.ImageIcon;
/*
 * Created by Carl Lyss 30025962
 */
public class Bullet
{
	//instance variable of bullets
	private static ImageIcon Bullet = new ImageIcon(Bullet.class.getResource("World/Bullet.png"));
	private static int speed=5;
	private static int damage=1;
	private static int fireRate = 5;
	private int xCoord;
	private int yCoord;
	private int Width =19;
	private int Height =47;
	private int hitboxX;
	private int hitboxY;
	//constructor of bullet
	public Bullet(int xCoord, int yCoord)
	{
    	this.xCoord = xCoord;
    	this.yCoord = yCoord;
	}
	//get X coordinate of bullet
	public int getX()
	{
    	return xCoord;
	}
	//get Y coordinate of bullet
	public int getY()
	{
    	return yCoord;
	}
	//change X coordinate of bullet
	public void setX(int i)
	{
    	xCoord=i;
	}
	//change Y coordinate of bullet
	public void setY(int i)
	{
    	yCoord=i;
	}
	//move bullet upwards
	public void move()
	{
    	yCoord-=speed;
	}
	//get bullet's speed
	public int getSpeed()
	{
    	return speed;
	}
	//changing the moving speed of bullet
	public static void changeSpeed()
	{
    	speed += 5;
	}
	//get the damage value of bullet
	public static int getDamage()
	{
    	return damage;
	}
	//change the damage value of bullet
	public static void changeDamage()
	{
    	damage+=1;
	}
	//get the firing rate of the bullet
	public static  int getFireRate()
	{
    	return fireRate;
	}
	//changing the firing rate
	public static void changeFireRate()
	{
    	fireRate+=1;
	}
	//set hitbox origin of bullet
	public  void setHitbox(int bulletX, int bulletY){
    	hitboxX = bulletX ;
    	hitboxY = bulletY ;
	}
	//get the bullet's hitbox's X coordinate
	public int getHitboxX(){
    	return hitboxX;
	}
	//get the bullet's hitbox's Y coordinate
	public int getHitboxY(){
    	return hitboxY;
	}
	//get the bullet's Width
	public int getWidth(){
    	return Width;
	}
	//changing the status of the bullet according to the upgrade's name
	public static void upgrade(FallingThings things)
	{
    	//upgrade bullet speed
    	if(things.getType() == "bulletSpeed" && speed<50)
    	{
        	changeSpeed();
    	}
    	//upgrade the bullet's damage
    	else if(things.getType() == "Damage" && damage<4)
    	{
        	changeDamage();
    	}
    	//upgrade the bullet's firing rates
    	else if(things.getType() == "FireRate" && fireRate<=10)
    	{
        	changeFireRate();
    	}
	}
	//get the image of bullet
	public static Image getImage()
	{
    	return Bullet.getImage();
	}
	//changing the bullet firing location
	public void setfiringLocationY(int speed)
	{
    	yCoord -= speed;
	}
	//get the height of bullet
	public int getHeight() {
    	return Height;
	}
}
 
 
 
 
 
