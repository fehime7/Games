import java.util.ArrayList;
import java.util.Random;


public class RandomPlayer  {
	
	public ArrayList<Cell> blackPieces = new ArrayList<Cell>();
	public ArrayList<Cell> possibleRandomMoves = new ArrayList<Cell>();
	Piece p;
	Random r= new Random();
	int playingPiece;
	public Cell randomSelectedCell , randomMove;
	Thread t;
	
	
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
	
	public ArrayList<Cell> findAllBlacks(Cell [][] board){
		
		for( int i=0 ; i<7 ; i++){
			for( int j=0; j<7 ; j++ ){
				if (board[i][j].getPiece() instanceof Rider && board[i][j].getPiece().getColor()==1 &&
						(isMovable(board[i][j], board)==true)){
					blackPieces.add(board[i][j]);
				}
				if (board[i][j].getPiece() instanceof Horse && board[i][j].getPiece().getColor()==1 &&
						(isMovable(board[i][j], board)==true)){
					blackPieces.add(board[i][j]);
				}
			}
		}
		
		System.out.println("number of black pieces= " +blackPieces.size());
		
		return blackPieces;
	}

	
	public ArrayList<Cell> highLightRandomMoves(Cell [][] board){
		
		playingPiece=r.nextInt(blackPieces.size()); 
		randomSelectedCell=blackPieces.get(playingPiece);
		p=blackPieces.get(playingPiece).getPiece();
		
		possibleRandomMoves= p.move(board, blackPieces.get(playingPiece).xPoz, blackPieces.get(playingPiece).yPoz);
		
		
		//System.out.println(blackPieces);
		//System.out.println("Possible random moves = "+possibleRandomMoves);
		System.out.println("possible moves sizes= "+possibleRandomMoves.size());
		
		return possibleRandomMoves;
	}
	
	public Cell makeRandomMove(){
		
		int move=r.nextInt(possibleRandomMoves.size());
		
		System.out.println(possibleRandomMoves.get(move));
		
		return possibleRandomMoves.get(move);
	}
	
	public void clearLists(){
		blackPieces.clear();
		possibleRandomMoves.clear();
	}
	
}
