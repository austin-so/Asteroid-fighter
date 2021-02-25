import java.awt.Image;
import javax.swing.ImageIcon;
/*  
 * created by Van Tran, ID 30031981
 * */
public class WorldBackground {
    static ImageIcon background = new ImageIcon(WorldBackground.class.getResource("World/World.jpg"));
    //getting the background image
    public static Image getBackground(){
   	 return background.getImage();
    }
}