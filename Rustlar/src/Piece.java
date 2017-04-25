
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
	protected ArrayList<Cell> neighbourCells = new ArrayList<Cell>();  //Protected (access from child classes)
	protected ArrayList<Move> possibleMoves2 = new ArrayList<Move>();  //Protected (access from child classes)
	public abstract ArrayList<Cell> move(Cell pos[][],int x,int y);  //Abstract Function. Must be overridden
	public abstract ArrayList<Move> move2(Cell pos[][],int x,int y);  //Abstract Function. Must be overridden

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
	
	/*
	public int howManyTouchingPiece(Cell c, Cell [][] b){
		
		 int result=0;
		 int color=c.getPiece().getColor();
		 int x=c.getXPoz();
		 int y=c.getYPoz();
		 
		 ArrayList<Cell> neighbours= new ArrayList<>();
		 
		 neighbours.addAll(c.getPiece().move(b, x, y));
		 
		 System.out.println("neighbours list"+neighbours);
		 
		 for(int i=0; i<neighbours.size(); i++){
			 if(neighbours.get(i).getPiece()!=null && neighbours.get(i).getPiece().getColor()==color){
				 result++;
			 }
		 }
		
		System.out.println("touching piece number = " +result);
		return result;
	}*/
	
 public ArrayList<Cell> findNeighbours(Cell [][] state, int x, int y){
		
		neighbourCells.clear();
	
		
		if(getColor()==0 || getColor()==1){
			//Defining a possible move for each cell. Because For each position they move differently 
			if(x<0 || y<0 || x>6 || y>6)
				neighbourCells.clear();
			
			else if((x==0 && y==2) || (x==2 && y==0)){ // Position 0,2 - 2,0
				neighbourCells.add(state[x][y+1]);
				neighbourCells.add(state[x+1][y]);
							
			}
			else if((x==0 && y==3) || (x==2 && y==1) || (x==2 && y==5)){ // Position 0,3 - 2,1 - 2,5
				neighbourCells.add(state[x][y+1]);
				neighbourCells.add(state[x+1][y]);
				neighbourCells.add(state[x][y-1]);
				
				
			}
			else if((x==0 && y==4) || (x==2 && y==6)){ // Position 0,4 - 2,6
				
				neighbourCells.add(state[x+1][y]);
				neighbourCells.add(state[x][y-1]);
				
			}
			
			else if((x==1 && y==2) || (x==3 && y==0) || (x==5 && y==2)){ // Position 1,2 - 3,0 - 5,2
				neighbourCells.add(state[x][y+1]);
				neighbourCells.add(state[x+1][y]);
				neighbourCells.add(state[x-1][y]);
				
			}
			
			else if((x==1 && y==4) || (x==3 && y==6) || (x==5 && y==4)){ // Position 1,4 - 3,6 - 5,4
				neighbourCells.add(state[x-1][y]);
				neighbourCells.add(state[x+1][y]);
				neighbourCells.add(state[x][y-1]);
				
					 				
			}
			
			else if((x==4 && y==0) || (x==6 && y==2)){ // Position 4,0 - 6,2
				neighbourCells.add(state[x-1][y]);	
				neighbourCells.add(state[x][y+1]);
					
			}
			
			else if((x==4 && y==1) || (x==6 && y==3) || (x==4 && y==5)){ // Position 4,1- 4,5 - 6,3
				neighbourCells.add(state[x][y+1]);
				neighbourCells.add(state[x-1][y]);
				neighbourCells.add(state[x][y-1]);
					      
				
			}
			else if((x==4 && y==6) || (x==6 && y==4)){ // Position 4,6 - 6,4
			
				neighbourCells.add(state[x-1][y]);
				neighbourCells.add(state[x][y-1]);
				
				
			}
			else { //middle positions
				neighbourCells.add(state[x][y+1]);
				neighbourCells.add(state[x+1][y]);
				neighbourCells.add(state[x][y-1]);
				neighbourCells.add(state[x-1][y]);
								
			}	
		}
		
		return neighbourCells;
	}
	
	public boolean isinDanger(Cell c, Cell [][]b){
		
		ArrayList<Cell> neighbours= new ArrayList<>();
		 
		neighbours=c.getPiece().findNeighbours(b, c.getXPoz(), c.getYPoz());
		
		if(c.howManyTouching(b)==0){
			for(int i=0; i<neighbours.size(); i++){
				if (neighbours.get(i).getPiece().getColor()==0 && neighbours.get(i).getPiece() instanceof Horse ) {
					return true;
				}
			}	
		}
		return false;
	}
	
	
	
	
}
