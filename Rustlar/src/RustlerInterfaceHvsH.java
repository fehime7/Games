
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import javax.swing.*;

public class RustlerInterfaceHvsH extends JFrame implements MouseListener{
	
	static Rider br1,br2,br3,br4, wr1, wr2, wr3,wr4;
	static Horse bh, wh;
	Cell c, previous, horseCell, aiCell;
	private Cell boardState[][];
	public ArrayList<Cell> destinationlist = new ArrayList<Cell>();
	Player whitePlayer, blackPlayer, winner;
	static String move;
	private JPanel board;
	JLabel player1, player2, whosTurn, minimaxBestScore;
	boolean isplayed=false, isfinished=false;
	RandomPlayer randomPlayer = new RandomPlayer();
	MinMax mm=new MinMax();
	MinMaxTwo mm2=new MinMaxTwo();
	int lastPlayedColor;
	
	public static void main(String[] args) {
   
		
		RustlerInterfaceHvsH rustler=new RustlerInterfaceHvsH();
	
	}		
	
	public RustlerInterfaceHvsH(){
		
		
		setSize(900,650);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		wr1 = new Rider("WR1", "White_Pawn.png", 0);
		wr2 = new Rider("WR2", "White_Pawn.png", 0);
		wr3 = new Rider("WR3", "White_Pawn.png", 0);
		wr4 = new Rider("WR4", "White_Pawn.png", 0);
		wh = new Horse("WH", "White_Horse.png", 0);
		br1 = new Rider("BR1", "Black_Pawn.png", 1);
		br2 = new Rider("BR2", "Black_Pawn.png", 1);
		br3 = new Rider("BR3", "Black_Pawn.png", 1);
		br4 = new Rider("BR4", "Black_Pawn.png", 1);
		bh = new Horse("BH", "Black_Horse.png", 1);
		
		Cell cell;
		Piece P;
		board=new JPanel(new GridLayout(7,7));
		//board.setBorder(BorderFactory.createLoweredBevelBorder());
		board.setBounds(0,0,600,600);
		board.setLocation(20,20);
		
		boardState= new Cell [7][7];
		
		for(int i=0;i<7;i++)
			for(int j=0;j<7;j++)
			{	
				P=null;
				if(i==0&&j==2)
					P=br1;
				else if(i==0&&j==4)
					P=br2;
				else if(i==2&&j==0)
					P=br3;
				else if(i==4&&j==0)
					P=br4;
				else if(i==2&&j==2)
					P=bh;
				else if(i==6&&j==4)
					P=wr1;
				else if(i==6&&j==2)
					P=wr2;
				else if(i==2&&j==6)
					P=wr3;
				else if(i==4&&j==6)
					P=wr4;
				else if(i==4&&j==4)
					P=wh;
				 
				cell=new Cell(i,j,P);
				cell.addMouseListener(this);
				board.add(cell);
				boardState[i][j]=cell;
			}
		
		player1= new JLabel("Player 1: Human Player - White");
		player1.setLocation(650, 50);
		player1.setSize(200, 50);
		
		player2= new JLabel("Player 2: Human Player - Black");
		player2.setLocation(650, 450);
		player2.setSize(200, 50);
		
		minimaxBestScore= new JLabel("Best score for the move: ");
		minimaxBestScore.setLocation(650, 550);
		minimaxBestScore.setSize(200, 50);
		
		whosTurn= new JLabel("Turn : Black Player");
		whosTurn.setLocation(650, 250);
		whosTurn.setSize(200, 50);
		
		
		add(board);
		add(player1);
		add(player2);
		//add(minimaxBestScore);
		add(whosTurn);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D ) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.DARK_GRAY);
		
		
	}	
	
	
		
	
	 private void cleanDestinations(ArrayList<Cell> destList)      //Function to clear the last move's destinations
	    {
	    	ListIterator<Cell> it = destList.listIterator();
	    	while(it.hasNext())
	    		it.next().removePossibleDestination();
	    }
	 
	//A function that indicates the possible moves by highlighting the Cells
	    private void highlightDestinations(ArrayList<Cell> destList)
	    {
	    	ListIterator<Cell> it = destList.listIterator();
	    	while(it.hasNext())
	    		it.next().setPossibleDestination();
	    }
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		c=(Cell)e.getSource();
		if (previous==null && isfinished==false)
		{
			if(c.getPiece()!=null && lastPlayedColor!=c.getPiece().getColor())
			{
				c.select();
				previous=c;
				destinationlist.clear();
				destinationlist=c.getPiece().move(boardState, c.xPoz, c.yPoz);
				
				
			}
			
			else
			{
				
				
			}
			highlightDestinations(destinationlist);
		}	
		else
		{
			if(c.xPoz==previous.xPoz && c.yPoz==previous.yPoz)
			{
				c.deselect();
				cleanDestinations(destinationlist);
				destinationlist.clear();
				previous=null;
				
			}
			else if(c.getPiece()==null || previous.getPiece().getColor()!=c.getPiece().getColor()) {	
				if(c.isPossibleDestination()){
					if(c.getPiece()!=null){
						c.removePiece();
					}
					c.setPiece(previous.getPiece());
					lastPlayedColor=c.getPiece().getColor();
					previous.removePiece();
					if(lastPlayedColor==1)
						whosTurn.setText("Turn : White Player");
					else
						whosTurn.setText("Turn: Black Player");
					
				}
				
				if(previous!=null)
				{
					previous.deselect();
					previous=null;
				}
				cleanDestinations(destinationlist);
				destinationlist.clear();
				
				
				
			}else if(previous.getPiece().getColor()==c.getPiece().getColor())				
			{	
				previous.deselect();
				cleanDestinations(destinationlist);
				destinationlist.clear();
				c.select();
				previous=c;
				destinationlist=c.getPiece().move(boardState, c.xPoz, c.yPoz);
				
			}
			highlightDestinations(destinationlist);
		}
		if(wh.isSurrounded(boardState, 0)==true){
			JOptionPane.showMessageDialog(null, "Game is finished.The winner is black player!!!");
			System.out.println("isSurrounded works correct");
			isfinished=true;
			

		}
		else if(bh.isSurrounded(boardState, 1)){
			JOptionPane.showMessageDialog(null, "Game is finished.The winner is white player!!!");
			System.out.println("isSurrounded works correct");  
			isfinished=true;
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

