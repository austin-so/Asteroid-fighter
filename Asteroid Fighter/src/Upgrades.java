import javax.swing.ImageIcon;
/*
 * created by Austin So, ID 30021027
 */
public class Upgrades extends FallingThings {
	//determining what kind of upgrade it will be
   	int RandomUpgrade = rand.nextInt(5);
	//constructor of upgrade
   	public Upgrades(){
       	if( RandomUpgrade ==0){
           	FiringRates();
           	image = new ImageIcon(Upgrades.class.getResource("World/FiringRate.png"));
       	}   	 
       	else if( RandomUpgrade ==1){
           	PlaneLives();
           	image = new ImageIcon(Upgrades.class.getResource("World/PlaneLives.jpg"));
       	}
       	else if( RandomUpgrade ==2){
           	PlaneSpeed();
           	image = new ImageIcon(Upgrades.class.getResource("World/PlaneSpeed.png"));
       	}
       	else if( RandomUpgrade ==3){
           	BulletSpeed();
           	image = new ImageIcon(Upgrades.class.getResource("World/BulletSpeed.jpg"));
       	}
       	else if( RandomUpgrade ==4){
           	BulletDamage();
           	image = new ImageIcon(Upgrades.class.getResource("World/BulletDamage.png"));
       	}
       	Width=60;
       	Height=55;
       	Speed = 1;   	 
   	}
   	public Upgrades(int x ,int y){
       	if( RandomUpgrade ==0){
           	FiringRates();
           	image = new ImageIcon(Upgrades.class.getResource("World/FiringRate.png"));
       	}   	 
       	else if( RandomUpgrade ==1){
           	PlaneLives();
           	image = new ImageIcon(Upgrades.class.getResource("World/PlaneLives.jpg"));
       	}
       	else if( RandomUpgrade ==2){
           	PlaneSpeed();
           	image = new ImageIcon(Upgrades.class.getResource("World/PlaneSpeed.png"));
       	}
       	else if( RandomUpgrade ==3){
           	BulletSpeed();
           	image = new ImageIcon(Upgrades.class.getResource("World/BulletSpeed.jpg"));
       	}
       	else if( RandomUpgrade ==4){
           	BulletDamage();
           	image = new ImageIcon(Upgrades.class.getResource("World/BulletDamage.png"));
       	}
       	Width=60;
       	Height=55;
       	Speed = 1;   	 
       	fallingLocationX = x;
       	fallingLocationY = y;
   	}
	public String getType()
	{
    	return type;
	}
   //set upgrade name to friring rates
	private void FiringRates(){
    	type = "FiringRates";
   	 
	}
   //set upgrade name to plane's lives    
	private void PlaneLives(){
    	type = "PlaneLives";
 
	}
   //set upgrade name to plane's speed
	private void PlaneSpeed(){
    	type = "PlaneSpeed";
 
	}
	//set upgrade name to bullet speed
	private void BulletSpeed(){
    	type = "BulletSpeed";
	}
	private void BulletDamage()
	{
   	 type = "Damage";
	}
}
 
 
 
 
 
