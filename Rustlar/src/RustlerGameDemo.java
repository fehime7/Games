import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 
public class RustlerGameDemo extends JFrame implements MouseListener, MouseMotionListener {
  JLayeredPane layeredPane;
  JPanel rustlerBoard;
  JLabel gamePiece, gamePieceHorse, gamePieceRider;
  int xAdjustment;
  int yAdjustment;
 
  public RustlerGameDemo(){
  Dimension boardSize = new Dimension(600, 600);
 
  //  Use a Layered Pane for this application
  	layeredPane = new JLayeredPane();
  	getContentPane().add(layeredPane);
  	layeredPane.setPreferredSize(boardSize);
  	layeredPane.addMouseListener(this);
  	layeredPane.addMouseMotionListener(this);
 
  //Add a board to the Layered Pane 
 
  	rustlerBoard = new JPanel();
  	layeredPane.add(rustlerBoard, JLayeredPane.DEFAULT_LAYER);
  	rustlerBoard.setLayout( new GridLayout(7, 7) );
  	rustlerBoard.setPreferredSize( boardSize );
  	rustlerBoard.setBounds(0, 0, boardSize.width, boardSize.height);
 
  	for (int i = 0; i < 49; i++) {
  		JPanel square = new JPanel( new BorderLayout() );
  		rustlerBoard.add( square );
 
  		int row = (i / 7) % 2;
  		if (i == 0 || i==1 || i==5 || i==6 || i == 7 || i==8 || i==12 || i==13
  				|| i == 35 || i==36 || i==40 || i==41 || i == 42 || i==43 || i==47 || i==48)
  			square.setBackground(Color.WHITE);  
  		//square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
  		else if (i == 2 || i==4 || i==10 || i==14 || i == 16 || i==18 || i==20 || i==22
			 || i == 24 || i==26 || i==28 || i==30 || i == 32 || i==34 || i==38 || i==44 || i==46)
  			square.setBackground(Color.BLUE);  
  		else 
  			square.setBackground(Color.PINK);
  		//square.setBackground( i % 2 == 0 ? Color.white : Color.blue );
  	}
 
  //Add pieces to the board
 
  	JLabel piece = new JLabel( new ImageIcon("/Users/fggi/Desktop/7th Semester Material/Black_Pawn.png") );
  	JPanel panel = (JPanel)rustlerBoard.getComponent(2);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/Black_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(4);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/Black_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(14);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/Black_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(28);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/Black_Horse.png"));
  	panel = (JPanel)rustlerBoard.getComponent(16);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/White_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(20);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/White_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(34);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/White_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(44);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/White_Pawn.png"));
  	panel = (JPanel)rustlerBoard.getComponent(46);
  	panel.add(piece);
  	piece = new JLabel(new ImageIcon("/Users/fggi/Desktop/7th Semester Material/White_Horse.png"));
  	panel = (JPanel)rustlerBoard.getComponent(32);
  	panel.add(piece);
 
  }
  

 
  public void mousePressed(MouseEvent e){
	  gamePiece = null;
	  Component c =  rustlerBoard.findComponentAt(e.getX(), e.getY());
 
	 // if (c instanceof JPanel) 
		//  return;
 
	  Point parentLocation = c.getParent().getLocation();
	  xAdjustment = parentLocation.x - e.getX();
	  yAdjustment = parentLocation.y - e.getY();
	  gamePiece = (JLabel)c;
	  gamePiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
	  gamePiece.setSize(gamePiece.getWidth(), gamePiece.getHeight());
	  layeredPane.add(gamePiece, JLayeredPane.DRAG_LAYER);
  }
 
  //Move the game piece around
  
  public void mouseDragged(MouseEvent me) {
	  if (gamePiece == null) return;
	  	gamePiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
 }
 
  //Drop the game piece back onto the chess board
 
  public void mouseReleased(MouseEvent e) {
	  if(gamePiece == null) return;
 
	  gamePiece.setVisible(false);
	  Component c =  rustlerBoard.findComponentAt(e.getX(), e.getY());
 
	  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( gamePiece );
	  }
	  else {
		  Container parent = (Container)c;
		  parent.add( gamePiece );
	  }
 
	  gamePiece.setVisible(true);
  }
 
  public void mouseClicked(MouseEvent e) {
  
  }
  public void mouseMoved(MouseEvent e) {
 }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
 
  public static void main(String[] args) {
	  JFrame frame = new RustlerGameDemo();
	  frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
 }
}
