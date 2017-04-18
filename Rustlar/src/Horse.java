import java.util.ArrayList;


public class Horse extends Piece {
	
	Cell horseCell;
	ArrayList<Cell> horseEdgeList= new ArrayList<>();
	

	
	
	public Horse(String i, String p, int c) {
		// TODO Auto-generated constructor stub
		
			setId(i);
			setPath(p);
			setColor(c);
			
	}
	

	/*
	@Override
	public ArrayList<Cell> move(Cell[][] state, int x, int y) {
		//TODO Auto-generated method stub
		//King can move only one step. So all the adjacent 4 cells have been considered.
				possibleMoves.clear();
				int posx[]={x,x,x-1,x+1};
				int posy[]={y+1,y-1,y,y};
				
				for(int i=0;i<4;i++){
					//if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8)){
						if((state[posx[i]][posy[i]].getPiece()==null||state[posx[i]][posy[i]].getPiece().getColor()!=this.getColor()))
							possibleMoves.add(state[posx[i]][posy[i]]);
					//}	
				}	
				return possibleMoves;
	}*/
	
    public ArrayList<Cell> move(Cell [][] state, int x, int y){
		
		possibleMoves.clear();
	
		
		if(getColor()==0 || getColor()==1){
			//Defining a possible move for each cell. Because For each position they move differently 
			if(x<0 || y<0 || x>6 || y>6)
				possibleMoves.clear();
			
			else if((x==0 && y==2) || (x==2 && y==0)){ // Position 0,2 - 2,0
				if(state[x][y+1].getPiece()==null || isAlone(state[x][y+1], state))
					possibleMoves.add(state[x][y+1]);
				if(state[x+1][y].getPiece()==null || isAlone(state[x+1][y], state))
					possibleMoves.add(state[x+1][y]);	
							
			}
			else if((x==0 && y==3) || (x==2 && y==1) || (x==2 && y==5)){ // Position 0,3 - 2,1 - 2,5
				if(state[x+1][y].getPiece()==null || isAlone(state[x+1][y], state))
					possibleMoves.add(state[x+1][y]);
				if(state[x][y+1].getPiece()==null || isAlone(state[x][y+1], state)) 
					possibleMoves.add(state[x][y+1]);
				if(state[x][y-1].getPiece()==null || isAlone(state[x][y-1], state))	
					possibleMoves.add(state[x][y-1]);
			}
			else if((x==0 && y==4) || (x==2 && y==6)){ // Position 0,4 - 2,6
				if(state[x][y-1].getPiece()==null || isAlone(state[x][y-1], state)) 
					possibleMoves.add(state[x][y-1]);
				if(state[x+1][y].getPiece()==null || isAlone(state[x+1][y], state))
					possibleMoves.add(state[x+1][y]);
				
			}
			
			else if((x==1 && y==2) || (x==3 && y==0) || (x==5 && y==2)){ // Position 1,2 - 3,0 - 5,2
				if(state[x-1][y].getPiece()==null || isAlone(state[x-1][y], state))
					possibleMoves.add(state[x-1][y]);
				if(state[x][y+1].getPiece()==null || isAlone(state[x][y+1], state)) 
					possibleMoves.add(state[x][y+1]);
				if(state[x+1][y].getPiece()==null || isAlone(state[x+1][y], state))	
					possibleMoves.add(state[x+1][y]);
				
			}
			
			else if((x==1 && y==4) || (x==3 && y==6) || (x==5 && y==4)){ // Position 1,4 - 3,6 - 5,4
				if(state[x-1][y].getPiece()==null || isAlone(state[x-1][y], state))
					possibleMoves.add(state[x-1][y]);
				if(state[x+1][y].getPiece()==null || isAlone(state[x+1][y], state))
					possibleMoves.add(state[x+1][y]);
				if(state[x][y-1].getPiece()==null || isAlone(state[x][y-1], state))
					possibleMoves.add(state[x][y-1]);
					 				
			}
			
			else if((x==4 && y==0) || (x==6 && y==2)){ // Position 4,0 - 6,2
				if((state[x-1][y].getPiece()==null) || isAlone(state[x-1][y], state))
					possibleMoves.add(state[x-1][y]);
				if((state[x][y+1].getPiece()==null) || isAlone(state[x][y+1], state))
					possibleMoves.add(state[x][y+1]);
					
			}
			
			else if((x==4 && y==1) || (x==6 && y==3) || (x==4 && y==5)){ // Position 4,1- 4,5 - 6,3
				
				if((state[x][y+1].getPiece()==null) || isAlone(state[x][y+1], state)) 
					possibleMoves.add(state[x][y+1]);
				if((state[x-1][y].getPiece()==null) || isAlone(state[x-1][y], state))
					possibleMoves.add(state[x-1][y]);
				if((state[x][y-1].getPiece()==null) || isAlone(state[x][y-1], state))
					possibleMoves.add(state[x][y-1]);	      
				
			}
			else if((x==4 && y==6) || (x==6 && y==4)){ // Position 4,6 - 6,4
				if((state[x][y-1].getPiece()==null) || isAlone(state[x][y-1], state)) 
					possibleMoves.add(state[x][y-1]);
				if ((state[x-1][y].getPiece()==null) || isAlone(state[x-1][y], state))
					possibleMoves.add(state[x-1][y]);
				
			}
			else { //middle positions
				if(state[x-1][y].getPiece()==null || isAlone(state[x-1][y], state))
					possibleMoves.add(state[x-1][y]);
				if(state[x][y+1].getPiece()==null || isAlone(state[x][y+1], state)) 
					possibleMoves.add(state[x][y+1]);
				if(state[x][y-1].getPiece()==null || isAlone(state[x][y-1], state)) 
					possibleMoves.add(state[x][y-1]);
				if(state[x+1][y].getPiece()==null || isAlone(state[x+1][y], state))
					possibleMoves.add(state[x+1][y]);
								
			}	
		}
		
		return possibleMoves;
	}
    
	 public Cell findHorse(int color , Cell [][] boardState){
		 
		 for(int i=0; i<7; i++){
			 for(int j=0; j<7; j++){
				 if(boardState[i][j].getPiece() instanceof Horse && boardState[i][j].getPiece().getColor()==color){
					 horseCell = boardState[i][j];
					 break;
				 }
			 }
		 }
	
		 return horseCell;
	 }
	 
	 public boolean isSurrounded(Cell [][] state, int color){
		 
		 boolean result=false;
		 
		 Cell c1=findHorse(color, state);
		
		 int x=c1.getXPoz();
		 int y=c1.getYPoz();
		 
		    if(x<0 || y<0 || x>6 || y>6)
				horseEdgeList.clear();
			
			else if((x==0 && y==2) || (x==2 && y==0)){ // Position 0,2 - 2,0
				if((state[x][y+1].getPiece() instanceof Rider && state[x][y+1].getPiece().getColor()!=color) &&  
				   (state[x+1][y].getPiece() instanceof Rider && state[x+1][y].getPiece().getColor()!=color))
					result=true;	
							
			}
			else if((x==0 && y==3) || (x==2 && y==1) || (x==2 && y==5)){ // Position 0,3 - 2,1 - 2,5
				if((state[x+1][y].getPiece() instanceof Rider && state[x+1][y].getPiece().getColor()!=color) &&  
				   (state[x][y+1].getPiece() instanceof Rider && state[x][y+1].getPiece().getColor()!=color) &&
				   (state[x][y-1].getPiece() instanceof Rider && state[x][y-1].getPiece().getColor()!=color))
					result=true;	
									
			}
			else if((x==0 && y==4) || (x==2 && y==6)){ // Position 0,4 - 2,6
				if((state[x][y-1].getPiece() instanceof Rider && state[x][y-1].getPiece().getColor()!=color) &&  
				   (state[x+1][y].getPiece() instanceof Rider && state[x+1][y].getPiece().getColor()!=color))
					result=true;	
				
			}
			
			else if((x==1 && y==2) || (x==3 && y==0) || (x==5 && y==2)){ // Position 1,2 - 3,0 - 5,2
				if((state[x+1][y].getPiece() instanceof Rider && state[x+1][y].getPiece().getColor()!=color) &&  
				   (state[x][y+1].getPiece() instanceof Rider && state[x][y+1].getPiece().getColor()!=color) &&
				   (state[x-1][y].getPiece() instanceof Rider && state[x-1][y].getPiece().getColor()!=color))
					result=true;	
				
			}
			
			else if((x==1 && y==4) || (x==3 && y==6) || (x==5 && y==4)){ // Position 1,4 - 3,6 - 5,4
				if((state[x+1][y].getPiece() instanceof Rider && state[x+1][y].getPiece().getColor()!=color) &&  
						   (state[x][y-1].getPiece() instanceof Rider && state[x][y-1].getPiece().getColor()!=color) &&
						   (state[x-1][y].getPiece() instanceof Rider && state[x-1][y].getPiece().getColor()!=color))
							result=true;	
					 				
			}
			
			else if((x==4 && y==0) || (x==6 && y==2)){ // Position 4,0 - 6,2
				if((state[x][y+1].getPiece() instanceof Rider && state[x][y+1].getPiece().getColor()!=color) &&  
						   (state[x-1][y].getPiece() instanceof Rider && state[x-1][y].getPiece().getColor()!=color))
							result=true;	
					
			}
			
			else if((x==4 && y==1) || (x==6 && y==3) || (x==4 && y==5)){ // Position 4,1- 4,5 - 6,3
				if((state[x][y-1].getPiece() instanceof Rider && state[x][y-1].getPiece().getColor()!=color) &&  
						   (state[x][y+1].getPiece() instanceof Rider && state[x][y+1].getPiece().getColor()!=color) &&
						   (state[x-1][y].getPiece() instanceof Rider && state[x-1][y].getPiece().getColor()!=color))
							result=true;		      
				
			}
			else if((x==4 && y==6) || (x==6 && y==4)){ // Position 4,6 - 6,4
				if((state[x][y-1].getPiece() instanceof Rider && state[x][y-1].getPiece().getColor()!=color) &&  
						   (state[x-1][y].getPiece() instanceof Rider && state[x-1][y].getPiece().getColor()!=color))
							result=true;	
				
			}
			else { //middle positions
				if((state[x+1][y].getPiece() instanceof Rider && state[x+1][y].getPiece().getColor()!=color) &&  
						   (state[x][y-1].getPiece() instanceof Rider && state[x][y-1].getPiece().getColor()!=color) &&
						   (state[x-1][y].getPiece() instanceof Rider && state[x-1][y].getPiece().getColor()!=color) &&
						   (state[x][y+1].getPiece() instanceof Rider && state[x][y+1].getPiece().getColor()!=color))
							result=true;	
								
			}	
		
		 
		 return result;
	 }


	@Override
	public ArrayList<Move> move2(Cell[][] pos, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
   

}
