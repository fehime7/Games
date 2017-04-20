

import java.awt.*;

import javax.swing.*;

//import pieces.*;

/**
 * This is the Cell Class. It is the token class of our GUI.
 * There are total of 49 cells, only 33 of them belong to Rustler Board
 *
 */
public class Cell extends JPanel implements Cloneable{
	
	//Member Variables
	private static final long serialVersionUID = 1L;
	private boolean isPossibleDestination;
	private JLabel content;
	private Piece piece;
	int xPoz,yPoz;                             //is public because this is to be accessed by all the other class
	private boolean isSelected=false;
	private boolean isActive;
	
	
	//Constructors
	public Cell(int xPoz,int yPoz,Piece p)
	{		
		this.xPoz=xPoz;
		this.yPoz=yPoz;
		
		setLayout(new BorderLayout());
	
	 
		
		if ((xPoz<2 && xPoz>-1 && yPoz <2 && yPoz>-1) || (xPoz<7 && xPoz>4 && yPoz<2 && yPoz>-1) || (xPoz<2 && xPoz>-1 && yPoz<7 && yPoz>4) || (xPoz<7 && xPoz>4 && yPoz<7 && yPoz>4) )
			setBackground(Color.WHITE);
		else if((xPoz+yPoz)%2==0)
			setBackground(new Color(113,198,113));
	
		else
			setBackground(Color.pink);
	 
		if(p!=null)
			setPiece(p);
	}
	
	//A constructor that takes a cell as argument and returns a new cell will the same data but different reference
	public Cell(Cell cell) throws CloneNotSupportedException
	{
		this.xPoz=cell.xPoz;
		this.yPoz=cell.yPoz;
		setLayout(new BorderLayout());
		if((xPoz+yPoz)%2==0)
			setBackground(new Color(113,198,113));
		else if ((xPoz<2 && xPoz>-1 && yPoz <2 && yPoz>-1) || (xPoz<7 && xPoz>4 && yPoz<2 && yPoz>-1) || (xPoz<2 && xPoz>-1 && yPoz<7 && yPoz>4) || (xPoz<7 && xPoz>4 && yPoz<7 && yPoz>4) )
			setBackground(Color.WHITE);
		else
			setBackground(Color.BLACK);
		
		
		if(cell.getPiece()!=null)
		{
			setPiece(cell.getPiece().getcopy());
		}
		else
			piece=null;
	}
	
	public void setPiece(Piece p)    //Function to inflate a cell with a piece
	{
		
		piece=p;
		ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content=new JLabel(img);
		this.add(content);
		
	}
	
	public void setXPoz(int xPoz){
		this.xPoz=xPoz;
	}
	
	public void setYPoz(int yPoz){
		this.yPoz=yPoz;
	}
	
	public void removePiece()      //Function to remove a piece from the cell
	{
			piece=null;
			this.remove(content);
		
	}
	
	
	public Piece getPiece()    //Function to access piece of a particular cell
	{
		return this.piece;
	}
	
	public void select()       //Function to mark a cell indicating it's selection
	{
		this.setBorder(BorderFactory.createLineBorder(Color.red,6));
		this.isSelected=true;
	}
	
	public boolean isSelected()   //Function to return if the cell is under selection
	{
		return this.isSelected;
	}
	
	public void deselect()      //Function to delselect the cell
	{
		this.setBorder(null);
		this.isSelected=false;
	}
	
	public void setPossibleDestination()     //Function to highlight a cell to indicate that it is a possible valid move
	{
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.isPossibleDestination=true;
	}
	
	public void removePossibleDestination()      //Remove the cell from the list of possible moves
	{
		this.setBorder(null);
		this.isPossibleDestination=false;
	}
	
	public boolean isPossibleDestination()    //Function to check if the cell is a possible destination 
	{
		return this.isPossibleDestination;
	}

	public int getXPoz() {
		return xPoz;
	}

	public int getYPoz() {
		return yPoz;
	}
	
	/*
	public void setcheck()     //Function to highlight the current cell as checked (For King)
	{
		this.setBackground(Color.RED);
		this.ischeck=true;
	}
	
	public void removecheck()   //Function to deselect check
	{
		this.setBorder(null);
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		this.ischeck=false;
	}
	
	public boolean ischeck()    //Function to check if the current cell is in check
	{
		return ischeck;
	}
	*/
}

