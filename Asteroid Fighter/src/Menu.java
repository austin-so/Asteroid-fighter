import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
 
/*
* Stephen Booth, 10057103,
*/
 
@SuppressWarnings("serial")
public class Menu extends JFrame implements KeyListener{
		 
	// Frames for main menu and instruction menu
    private JFrame mainMenu;
    private JFrame instructionMenu;
    
    // Setup panels and labels
    private JPanel panel, instructionPanel;
    private JLabel bgLabel = new JLabel();
    private JLabel bgInstructionPanel = new JLabel();
    
    // Buttons for main menu
    private JButton playButton = new JButton("Play Game");
    private JButton instructButton = new JButton("Instructions");
    private JButton backButton = new JButton("Back"); 
    
    // Screen setup
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Main Method
    public static void main(String[] args)
    {
   	 	// Error exceptions for layout
    	try {
   		 UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    	} catch (UnsupportedLookAndFeelException ex) {
   		 ex.printStackTrace();
    	} catch (IllegalAccessException ex) {
   		 ex.printStackTrace();
    	} catch (InstantiationException ex) {
   		 ex.printStackTrace();
    	} catch (ClassNotFoundException ex) {
   		 ex.printStackTrace();
    	}
    	
    	// Remove "bold metal" presets
   	 UIManager.put("swing.boldMetal", Boolean.FALSE);
   	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
   		 public void run() {
   			 Menu menu = new Menu(); 
   			 menu.createAndShowGUI();
   			 menu.start();
        	}
    	});
	}
	 
    
    // Start method so that the main menu is visible
	private void start()
	{
   	 mainMenu.setVisible(true);
	}
    
	// Window listener to close unused JFrames
	private static WindowListener closeWindow = new WindowAdapter()
	{
    	public void windowClosing(WindowEvent e)
    	{
        	e.getWindow().dispose();
    	}
	};
    
	// Title Text Pane
	private JTextPane createTitlePane()
	{
   	 String[] initString =
   		 {
   			 "\n Asteroid Fighter \n \n"
   		 }; // TextPane text
   	 
   	 String[] initStyles =
   		 {
   			 "title"
   		 }; // TextPane style
   	 
   	 JTextPane titleArea = new JTextPane();
   	 StyledDocument doc = titleArea.getStyledDocument();
   	 addStylesToDocument(doc);
   	
   	 
   	 // iterate through String and Style arrays and match both up
   	  try {
         	for (int i=0; i < initString.length; i++) {
             	doc.insertString(doc.getLength(), initString[i],
           			  doc.getStyle(initStyles[i]));
         	}
     	} catch (BadLocationException ble) {
         	System.err.println("Couldn't insert initial text into text pane.");
     	}
 
     	return titleArea;
	}
    
	
	// Instructions Text Pane
	private JTextPane createTextPane()
	{
   	 String[] initString =
   		 {
            	"\n Press A - Move player to the left \n \n" +
            	"Press W - Move player up \n \n" +
            	"Press D - Move player to the right \n \n" +
            	"Press S - Move player down \n \n" +
            	"Press Space - Fire Missiles \n \n" +
            	"Collect upgrades to improve your ship! \n \n"
   		 }; // TextPane text
   	 
   	 String[] initStyles =
   		 {
   			 "regular"
   		 }; // TextPane Style
   	 
   	 JTextPane textArea = new JTextPane();
   	  StyledDocument doc = textArea.getStyledDocument();
     	addStylesToDocument(doc);
    	 
     // iterate through String and Style arrays and match both up
     	try {
         	for (int i=0; i < initString.length; i++) {
             	doc.insertString(doc.getLength(), initString[i],
           			  doc.getStyle(initStyles[i]));
         	}
     	} catch (BadLocationException ble) {
         	System.err.println("Couldn't insert initial text into text pane.");
     	}
 
     	return textArea;
	}
    
	
	// method to add appropriate style 
	private void addStylesToDocument(StyledDocument doc)
	{
   	 
	// Default style for regular to inherit	
		Style def = StyleContext.getDefaultStyleContext().
             	getStyle(StyleContext.DEFAULT_STYLE);
   	
   	 
   	 // Regular style for instruction menu
   	 Style regular = doc.addStyle("regular", def);
   	 StyleConstants.setFontFamily(def, "SansSerif");
   	 StyleConstants.setForeground(def, Color.white);
   	 StyleConstants.setFontSize(def, 35);
   	 
   	 // Title style for main menu
   	 Style title = doc.addStyle("title", regular);
   	 StyleConstants.setFontFamily(title, "SansSerif");
   	 StyleConstants.setForeground(title, Color.white);
   	 StyleConstants.setFontSize(title, 85);
	}

	
	// method for run() that creates and shows the GUI
	private void createAndShowGUI()
	{
		// JFrame for main menu
		mainMenu = new JFrame("AsteroidFighter");
    	mainMenu.setBounds(600, 0, 750, screenSize.height-40);
    	mainMenu.addWindowListener(closeWindow);

    	//create panel and set flow layout
    	panel = new JPanel();
    	panel.setOpaque(false);
    	panel.setLayout(new FlowLayout());

    	bgLabel.setLayout(new FlowLayout());

    	//set background for panel
    	bgLabel.setIcon(new ImageIcon(WorldBackground.getBackground()));
    	bgLabel.setLayout(new BorderLayout());
      	 
    	//add ActionListener for each button
    	playButton.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e)
   		 {
   			 mainMenu.setVisible(false);
   			 play();
   		 }
    	});
   	 
    	instructButton.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e)
   		 {
   			 instructionMenu.setVisible(true);
   			 mainMenu.setVisible(false);
   		 }
    	});
   	 
    	// Title pane for "Asteroid Fighter"
    	JTextPane titleArea = createTitlePane();
    	titleArea.setEditable(false);
    	titleArea.setOpaque(false);
   	 
    	// add buttons to panel
    	panel.add(titleArea);
    	panel.add(playButton);
    	panel.add(instructButton);

    	bgLabel.add(panel); // add panel to label 

    	mainMenu.add(bgLabel); // add label to JFrame
   	 
   	 	// JFrame for instruction menu
    	instructionMenu = new JFrame("Asteroid Fighter");
    	instructionMenu.setBounds(600, 0, 750, screenSize.height-40);
    	instructionMenu.addWindowListener(closeWindow);
   	 
    	// create panel and set flow layout
    	instructionPanel = new JPanel();
    	instructionPanel.setOpaque(false);
    	instructionPanel.setLayout(new FlowLayout());
   	 
    	// set background for panel
    	bgInstructionPanel.setLayout(new FlowLayout());
    	bgInstructionPanel.setIcon(new ImageIcon(WorldBackground.getBackground()));
    	bgInstructionPanel.setLayout(new BorderLayout());
   	 
    	// add action listener for back button 
    	backButton.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e)
   		 {
   			 instructionMenu.setVisible(false);
   			 mainMenu.setVisible(true);
   		 }
    	});
   	 
    	
    	// text pane for instructions
    	JTextPane textArea = createTextPane();
   		    
    	textArea.setEditable(false);
    	textArea.setOpaque(false);
   	 
    	// add text pane and button to label 
    	instructionPanel.add(textArea);  
    	instructionPanel.add(backButton); 
   	 
    	// add panel to instruction menu
    	bgInstructionPanel.add(instructionPanel);
    	instructionMenu.add(bgInstructionPanel);
	}
    
	/*  
 	* created by Van Tran, ID 30031981
 	* */
	public void play(){
	//show the name of the game
	JFrame frame = new JFrame("Asteroid Game");
	//does not focus on the frame
    	frame.setFocusable(true);
    	//setting the size of the frame
    	frame.setSize(750,screenSize.height-40);
    	//showing the frame
    	frame.setVisible(true);
    	//set the program to stop running when close frame
    	frame.setDefaultCloseOperation(3);
    	//does not allow resizing
    	frame.setResizable(false);
    	//set the frame location on the screen
    	frame.setLocation(600,0);
    	//creating object board
    	Board board = new Board();
    	//add board on top of frame
    	frame.add(board);
    	//when click on the frame every image will remain focus on the frame
    	board.requestFocus(true);
    	//set the frame size to remain the same
    	frame.setSize(750,1030);
 	}
	//Check if a key was pressed
	public void keyPressed(KeyEvent e){
	//a variable to store a pressed key
    	int keys = e.getKeyCode();
    	//check if key A is pressed if so go left until hitting bound
    	if (keys == KeyEvent.VK_A && Ship.getX()>0)
    	{
        	Ship.setX(Ship.getX()-Ship.getSpeed());
    	}
    	//check if key D is pressed if so go right until hitting bound
    	else if (keys == KeyEvent.VK_D && Ship.getHitboxX()+Ship.getWidth()<730)
    	{
        	Ship.setX(Ship.getX()+Ship.getSpeed());
    	}
    	//check if key W is pressed if so go up until hitting bound
    	else if (keys == KeyEvent.VK_W && Ship.getY()>0)
    	{
        	Ship.setY(Ship.getY()-Ship.getSpeed());
    	}
    	//check if key S is pressed if so go down until hitting bound
    	else if (keys == KeyEvent.VK_S && Ship.getHitboxY()+Ship.getHeight() < screenSize.height-40)
    	{
        	Ship.setY(Ship.getY()+Ship.getSpeed());
    	}
 
	}
    
	public void keyReleased(KeyEvent e) {
   	 
	int keys = e.getKeyCode();
        	//check if key Space is pressed if so fire
       	if (keys == KeyEvent.VK_SPACE)
        	{
            	Ship.fire();
        	}
	}

	public void keyTyped(KeyEvent arg0) {
   	 
	}
}
 
 
 
 



