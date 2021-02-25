import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/*   
 * created by Van Tran, ID 30031981
 * */
@SuppressWarnings({ "unused", "serial" })
public class Board extends JPanel implements ActionListener{
	//instance variables
	Timer time;
	static Graphics2D Drawer;
	//create arraylist of bullet and falling things
	FallingThings things[] = new FallingThings[15];
	Bullet bullet[] = new Bullet[10];
	//store the starting time
	long startTime = System.currentTimeMillis();
	int numOfThings =2;
	int bulletOut = 0;
	int prevDeltaTime;
	int score = 0;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	//constructor of board
	public Board(){
    	//listen to key from InputKeyEvent class
    	addKeyListener(new Menu());
    	setFocusable(true);
        	//initialize the falling things
    	for( int x = 0; x<15;x++)
    	{
         	if(x%4 ==0 && x !=0){
             	things[x]= new Upgrades();
         	}
         	else{
             	things[x] = new Rock();
         	}
         	 
    	}
    	//initialize bullets
    	for( int x = 0; x<10;x++)
    	{
         	bullet[x] = new Bullet(0,-1000);
    	}
        	//create a time loop
    	time = new Timer(10, this);
    	//start the timer to perform actions
    	time.start();
	}
	//repaint every time an action takes place
	public void actionPerformed(ActionEvent e){
    	repaint();
	}
	@SuppressWarnings("static-access")
	public void paint(Graphics g){
    	Ship.setHitbox(Ship.getX(), Ship.getY());
    	//draw the image on frame
    	Drawer = (Graphics2D) g;
    	 
    	//draw the background on frame
    	Drawer.drawImage(WorldBackground.getBackground(),0,0,null);
    	 
    	//draw ship
    	Drawer.drawImage(Ship.getImage(),Ship.getX(),Ship.getY(),null);
    	 
    	//set rendering field for text
    	Drawer.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	 
    	//create object font
    	Font font = new Font("Serif", Font.PLAIN, 30);
    	 
    	//set text to font attributes
    	Drawer.setFont(font);
    	 
    	//set colour of text
    	Drawer.setColor(Color.WHITE);
    	 
    	//draw string of plane's lives on board
    	Drawer.drawString("Plane's lives: " + Ship.getHealth(), 0, 30);
    	 
    	//draw string of score on board
    	Drawer.drawString("Score: " + score,520 , 30);
    	 
    	//store current time
    	long currentTime = System.currentTimeMillis();
    	 
    	//take the difference of current time and start time, then divide by 1000 for difference in second
    	int DeltaTime = (int)(currentTime-startTime)/1000;
    	 
    	//every 5 second and number of things on board is less than 15 and previous time is not current
    	if(DeltaTime%5==0 && numOfThings<15 && prevDeltaTime!=DeltaTime)
    	{
        	Random r = new Random();
        	int i = r.nextInt(2);
        	//50% chance number of things will increase
        	if(i == 1)
        	{
            	numOfThings++;
        	}
    	}
        	//run through arraylist of falling things
    	for(int i = 0; i<numOfThings; i++)
    	{
    	//create 10 rocks
        	if(things[i].getfallingLocationY() > screenSize.height-20 && i%7 !=0 || i==0)
        	{
            	things[i] = new Rock();
        	}
        	//create 5 upgrades
        	else if(things[i].getfallingLocationY()>screenSize.height-20 && i%7 == 0 && i!= 0){
            	things[i] = new Upgrades();
        	}
        	//draw the image of falling things
        	Drawer.drawImage(things[i].getImage(), things[i].getfallingLocationX(), things[i].getfallingLocationY(), null);
        	//test statement to show falling things' location
        	//System.out.println(things[i].getfallingLocationX() + " " + things[i].getfallingLocationY());
        	//make falling things fall
        	things[i].setfallingLocationY(things[i].getSpeed());
        	//set and update hitbox for all falling things
        	things[i].setHitbox();
          	//test statement to show hitbox is working
        	if(things[i].checkHitboxForShip(Ship.getHitboxX(),Ship.getHitboxY(),Ship.getWidth(),Ship.getHeight()) == true){
            	if(things[i].getType() != null && things[i].getHitNum() == 1){
                	Bullet.upgrade(things[i]);
                	Ship.upgrade(things[i]);
                	System.out.println("Got Upgrade: " + things[i].getType());
                	score+=50;
                	things[i] = new Upgrades(-200,0);
            	}
            	else{
           		 if(things[i].getHitNum() == 1)
           		 {
                    	Ship.downLife();
 
           		 }
           		 System.out.println("hit plane, rock " + i);
                	if(Ship.getHealth()==0){
                    	Drawer.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                    	Font endfont = new Font("Serif", Font.PLAIN, 100);
                    	Drawer.setFont(endfont);
                    	Drawer.setColor(Color.WHITE);
                    	Drawer.drawString("GAME OVER" ,80, 515);
                    	Drawer.drawString("Score: "+ score ,150, 615);
 
                    	time.stop();
                	}
            	}
        	}
 
    	}
    	//run through arraylist of bullets
    	for(int i = 0; i< Bullet.getFireRate(); i++)
    	{
   		 
    	//check if ship fires and if the bullet hit the top of the board
        	if(Ship.getFire() == true && bullet[i].getY() < 0)
        	{
             	//set the firing location of bullet back to its origin
            	bullet[i].setX(Ship.getX()+55);
            	bullet[i].setY(Ship.getY());
            	break;
        	}
        	//move bullet upwards
        	bullet[i].move();
        	//draw and update the bullet's image on board
        	Drawer.drawImage(bullet[i].getImage(),bullet[i].getX(),bullet[i].getY(),null);
        	//set and update the hitbox of bullet
        	bullet[i].setHitbox(bullet[i].getX(), bullet[i].getY());
        	//run through arraylist of bullets
        	for(int n=0; n<numOfThings; n++){
            	//check if bullet hit a falling thing
            	if(things[n].checkHitboxForBullet(bullet[i].getHitboxX(), bullet[i].getHitboxY(), bullet[i].getWidth(), bullet[i].getHeight()) == true){
                	//check if things has a type, if not then it must be rock
                	if(things[n].getType() == null){
                    	//test statement, check which bullet hit which rock
                     	System.out.printf("bullet %d hit rock %d%n" , i ,n );
                     	//set rock health minus one
                     	((Rock) things[n]).minusHealth(Bullet.getDamage());
                     	System.out.println("bullet damage "+Bullet.getDamage() + " rock health " + ((Rock)things[n]).getHealth()  );
                     	//check if rock health is zero
                     	if(((Rock) things[n]).getHealth()<=0){
                         	//set rock to new rock
                         	things[n] = new Rock();
                         	//score goes up
                         	score += 10;
                     	}
                     	//set bullet away from board prepared to be fire again
                    	bullet[i] = new Bullet(-500, -500);
                	}
            	}
        	}
    	}
    	//stop firing automatically
    	Ship.stopFire();
    	//update the time
    	prevDeltaTime = DeltaTime;
	}
}
 
 
 
 
 
