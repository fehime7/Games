import java.util.ArrayList;


public class Rider extends Piece {
	
	
	public Rider(String i, String p, int c) {
		// TODO Auto-generated constructor stub
		
			setId(i);
			setPath(p);
			setColor(c);
			
	}
	

	/*
	
	@Override
	public ArrayList<Cell> move (Cell[][] state, int x, int y) {
		
		possibleMoves.clear();
		
		if(getColor()==0)
		{
			if(x==0)
				return possibleMoves;
			
			if(state[x-1][y].getPiece()==null)
			{
				possibleMoves.add(state[x-1][y]);
				if(x==6)
				{
					if(state[4][y].getPiece()==null)
						possibleMoves.add(state[4][y]);
				}
			}
			if((y>0)&&(state[x-1][y-1].getPiece()!=null)&&(state[x-1][y-1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x-1][y-1]);
			if((y<7)&&(state[x-1][y+1].getPiece()!=null)&&(state[x-1][y+1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x-1][y+1]);
		}
		else
		{
			if(x==8)
				return possibleMoves;
			if(state[x+1][y].getPiece()==null)
			{
				possibleMoves.add(state[x+1][y]);
				if(x==1)
				{
					if(state[3][y].getPiece()==null)
						possibleMoves.add(state[3][y]);
				}
			}
			if((y>0)&&(state[x+1][y-1].getPiece()!=null)&&(state[x+1][y-1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x+1][y-1]);
			if((y<7)&&(state[x+1][y+1].getPiece()!=null)&&(state[x+1][y+1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x+1][y+1]);
		}
		return possibleMoves;
	}
	
	*/
	
	
	
	public ArrayList<Cell> move(Cell [][] state, int x, int y){
		
		possibleMoves.clear();
	
		
		if(getColor()==0 || getColor()==1){
			//Defining a possible move for each cell. Because For each position they move differently 
			if(x<0 || y<0 || x>6 || y>6)
				possibleMoves.clear();
			
			else if((x==0 && y==2) || (x==2 && y==0)){ // Position 0,2 - 2,0
				if(state[x][y+1].getPiece()==null) 
					possibleMoves.add(state[x][y+1]);
				if(state[x+1][y].getPiece()==null)
					possibleMoves.add(state[x+1][y]);	
							
			}
			else if((x==0 && y==3) || (x==2 && y==1) || (x==2 && y==5)){ // Position 0,3 - 2,1 - 2,5
				if(state[x+1][y].getPiece()==null)
					possibleMoves.add(state[x+1][y]);
				if(state[x][y+1].getPiece()==null) 
					possibleMoves.add(state[x][y+1]);
				if(state[x][y-1].getPiece()==null)	
					possibleMoves.add(state[x][y-1]);
			}
			else if((x==0 && y==4) || (x==2 && y==6)){ // Position 0,4 - 2,6
				if(state[x][y-1].getPiece()==null) 
					possibleMoves.add(state[x][y-1]);
				if(state[x+1][y].getPiece()==null)
					possibleMoves.add(state[x+1][y]);
				
			}
			
			else if((x==1 && y==2) || (x==3 && y==0) || (x==5 && y==2)){ // Position 1,2 - 3,0 - 5,2
				if(state[x-1][y].getPiece()==null)
					possibleMoves.add(state[x-1][y]);
				if(state[x][y+1].getPiece()==null) 
					possibleMoves.add(state[x][y+1]);
				if(state[x+1][y].getPiece()==null)	
					possibleMoves.add(state[x+1][y]);
				
			}
			
			else if((x==1 && y==4) || (x==3 && y==6) || (x==5 && y==4)){ // Position 1,4 - 3,6 - 5,4
				if(state[x-1][y].getPiece()==null)
					possibleMoves.add(state[x-1][y]);
				if(state[x+1][y].getPiece()==null)
					possibleMoves.add(state[x+1][y]);
				if(state[x][y-1].getPiece()==null)
					possibleMoves.add(state[x][y-1]);
					 				
			}
			
			else if((x==4 && y==0) || (x==6 && y==2)){ // Position 4,0 - 6,2
				if((state[x-1][y].getPiece()==null))
					possibleMoves.add(state[x-1][y]);
				if((state[x][y+1].getPiece()==null))
					possibleMoves.add(state[x][y+1]);
					
			}
			
			else if((x==4 && y==1) || (x==6 && y==3) || (x==4 && y==5)){ // Position 4,1- 4,5 - 6,3
				
				if((state[x][y+1].getPiece()==null)) 
					possibleMoves.add(state[x][y+1]);
				if((state[x-1][y].getPiece()==null))
					possibleMoves.add(state[x-1][y]);
				if((state[x][y-1].getPiece()==null))
					possibleMoves.add(state[x][y-1]);	      
				
			}
			else if((x==4 && y==6) || (x==6 && y==4)){ // Position 4,6 - 6,4
				if((state[x][y-1].getPiece()==null)) 
					possibleMoves.add(state[x][y-1]);
				if ((state[x-1][y].getPiece()==null))
					possibleMoves.add(state[x-1][y]);
				
			}
			else { //middle positions
				if(state[x-1][y].getPiece()==null)
					possibleMoves.add(state[x-1][y]);
				if(state[x][y+1].getPiece()==null) 
					possibleMoves.add(state[x][y+1]);
				if(state[x][y-1].getPiece()==null) 
					possibleMoves.add(state[x][y-1]);
				if(state[x+1][y].getPiece()==null)
					possibleMoves.add(state[x+1][y]);
								
			}	
		}
		
		return possibleMoves;
	}
	
	public boolean checkLegalMove(Board b, int x, int y){
		
		
		return false;
	}

}
