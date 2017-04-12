
import java.util.ArrayList;


/**
 * This is the Piece Class. It is an abstract class from which all the actual pieces are inherited.
 * It defines all the function common to all the pieces
 * The move() function an abstract function that has to be overridden in all the inherited class
 * It implements Cloneable interface as a copy of the piece is required very often
 */
public abstract class Piece implements Cloneable{

	//Member Variables
	private int color;
	private String id;
	private String path;
	protected ArrayList<Cell> possibleMoves = new ArrayList<Cell>();  //Protected (access from child classes)
	public abstract ArrayList<Cell> move(Cell pos[][],int x,int y);  //Abstract Function. Must be overridden
	
	//Id Setter
	public void setId(String id)
	{
		this.id=id;
	}
	
	//Path Setter
	public void setPath(String path)
	{
		this.path=path;
	}
	
	//Color Setter
	public void setColor(int c)
	{
		this.color=c;
	}
	
	//Path getter
	public String getPath()
	{
		return path;
	}
	
	//Id getter
	public String getId()
	{
		return id;
	}
	
	//Color Getter
	public int getColor()
	{
		return this.color;
	}
	
//	public String getType(){
//		return type;
//	}
	/**
	 * The draw method governs how to draw each piece
	 * @param g
	 */
	
	//Function to return the a "shallow" copy of the object. The copy has exact same variable value but different reference
	public Piece getcopy() throws CloneNotSupportedException
	{
		return (Piece) this.clone();
	}
	
	public boolean isAlone(Cell c, Cell [][] state){
		 boolean result=true;
		int color=c.getPiece().getColor();
		 int x=c.getXPoz();
		 int y=c.getYPoz();
		 
		 if(c.getPiece() instanceof Rider){
		 
		    if(x<0 || y<0 || x>6 || y>6)
				result=true;
			
			else if((x==0 && y==2) || (x==2 && y==0)){ // Position 0,2 - 2,0
				if((state[x][y+1].getPiece() !=null && state[x][y+1].getPiece().getColor() ==color) ||  
				   (state[x+1][y].getPiece() !=null && state[x+1][y].getPiece().getColor() ==color))
					result=false;	
							
			}
			else if((x==0 && y==3) || (x==2 && y==1) || (x==2 && y==5)){ // Position 0,3 - 2,1 - 2,5
				if((state[x+1][y].getPiece() !=null && state[x+1][y].getPiece().getColor() ==color) || 
				   (state[x][y+1].getPiece() !=null &&state[x][y+1].getPiece().getColor() ==color) ||
				   (state[x][y-1].getPiece() !=null &&state[x][y-1].getPiece().getColor() ==color))
					result=false;	
									
			}
			else if((x==0 && y==4) || (x==2 && y==6)){ // Position 0,4 - 2,6
				if((state[x][y-1].getPiece() != null && state[x][y-1].getPiece().getColor() ==color) || 
				   (state[x+1][y].getPiece() !=null && state[x+1][y].getPiece().getColor() ==color))
					result=false;	
				
			}
			
			else if((x==1 && y==2) || (x==3 && y==0) || (x==5 && y==2)){ // Position 1,2 - 3,0 - 5,2
				if((state[x+1][y].getPiece() !=null && state[x+1][y].getPiece().getColor() ==color) ||  
				   (state[x][y+1].getPiece() !=null && state[x][y+1].getPiece().getColor() ==color) ||
				   (state[x-1][y].getPiece() !=null && state[x-1][y].getPiece().getColor() ==color))
					result=false;	
				
			}
			
			else if((x==1 && y==4) || (x==3 && y==6) || (x==5 && y==4)){ // Position 1,4 - 3,6 - 5,4
				if((state[x+1][y].getPiece() !=null && state[x+1][y].getPiece().getColor() ==color) ||  
				   (state[x][y-1].getPiece() !=null &&state[x][y-1].getPiece().getColor() ==color) ||
			       (state[x-1][y].getPiece() !=null &&state[x-1][y].getPiece().getColor() ==color))
					result=false;	
					 				
			}
			
			else if((x==4 && y==0) || (x==6 && y==2)){ // Position 4,0 - 6,2
				if((state[x][y+1].getPiece() !=null && state[x][y+1].getPiece().getColor() ==color) ||  
				   (state[x-1][y].getPiece() !=null && state[x-1][y].getPiece().getColor() ==color))
					result=false;	
					
			}
			
			else if((x==4 && y==1) || (x==6 && y==3) || (x==4 && y==5)){ // Position 4,1- 4,5 - 6,3
				if((state[x][y-1].getPiece() !=null && state[x][y-1].getPiece().getColor() ==color) ||  
				   (state[x][y+1].getPiece() !=null && state[x][y+1].getPiece().getColor() ==color) ||
				   (state[x-1][y].getPiece() !=null && state[x-1][y].getPiece().getColor() ==color))
					result=false;		      
				
			}
			else if((x==4 && y==6) || (x==6 && y==4)){ // Position 4,6 - 6,4
				if((state[x][y-1].getPiece() !=null && state[x][y-1].getPiece().getColor() ==color) ||  
				   (state[x-1][y].getPiece() !=null && state[x-1][y].getPiece().getColor() ==color))
					result=false;	
				
			}
			else { //middle positions
				if((state[x+1][y].getPiece() !=null && state[x+1][y].getPiece().getColor() ==color) ||  
				   (state[x][y-1].getPiece() !=null && state[x][y-1].getPiece().getColor() ==color) ||
				   (state[x-1][y].getPiece() !=null && state[x-1][y].getPiece().getColor() ==color) ||
				   (state[x][y+1].getPiece() !=null && state[x][y+1].getPiece().getColor() ==color))
					result=false;	
								
			}
		 }else{
			 result=false;
		 }
		
		 
		 return result;
	}
	
	public boolean isMovable(Cell c, Cell [][] state){
		 boolean result=true;
		
		 int x=c.getXPoz();
		 int y=c.getYPoz();
		 
		    if(x<0 || y<0 || x>6 || y>6)
				result=false;
			
			else if((x==0 && y==2) || (x==2 && y==0)){ // Position 0,2 - 2,0
				if((state[x][y+1].getPiece() !=null) &&  
				   (state[x+1][y].getPiece() !=null))
					result=false;	
							
			}
			else if((x==0 && y==3) || (x==2 && y==1) || (x==2 && y==5)){ // Position 0,3 - 2,1 - 2,5
				if((state[x+1][y].getPiece() !=null) &&  
				   (state[x][y+1].getPiece() !=null) &&
				   (state[x][y-1].getPiece() !=null))
					result=false;	
									
			}
			else if((x==0 && y==4) || (x==2 && y==6)){ // Position 0,4 - 2,6
				if((state[x][y-1].getPiece() !=null) &&  
				   (state[x+1][y].getPiece() !=null))
					result=false;	
				
			}
			
			else if((x==1 && y==2) || (x==3 && y==0) || (x==5 && y==2)){ // Position 1,2 - 3,0 - 5,2
				if((state[x+1][y].getPiece() !=null) &&  
				   (state[x][y+1].getPiece() !=null) &&
				   (state[x-1][y].getPiece() !=null))
					result=false;	
				
			}
			
			else if((x==1 && y==4) || (x==3 && y==6) || (x==5 && y==4)){ // Position 1,4 - 3,6 - 5,4
				if((state[x+1][y].getPiece() !=null) &&  
				   (state[x][y-1].getPiece() !=null) &&
			       (state[x-1][y].getPiece() !=null))
					result=false;	
					 				
			}
			
			else if((x==4 && y==0) || (x==6 && y==2)){ // Position 4,0 - 6,2
				if((state[x][y+1].getPiece() !=null) &&  
				   (state[x-1][y].getPiece() !=null))
					result=false;	
					
			}
			
			else if((x==4 && y==1) || (x==6 && y==3) || (x==4 && y==5)){ // Position 4,1- 4,5 - 6,3
				if((state[x][y-1].getPiece() !=null) &&  
				   (state[x][y+1].getPiece() !=null) &&
				   (state[x-1][y].getPiece() !=null))
					result=false;		      
				
			}
			else if((x==4 && y==6) || (x==6 && y==4)){ // Position 4,6 - 6,4
				if((state[x][y-1].getPiece() !=null) &&  
				   (state[x-1][y].getPiece() !=null))
					result=false;	
				
			}
			else { //middle positions
				if((state[x+1][y].getPiece() !=null) &&  
						   (state[x][y-1].getPiece() !=null) &&
						   (state[x-1][y].getPiece() !=null) &&
						   (state[x][y+1].getPiece() !=null))
							result=false;	
								
			}	
		
		 
		 return result;
	}
	
}