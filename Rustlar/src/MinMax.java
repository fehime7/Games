import java.util.*;
import java.awt.*;
	
public class MinMax {
	private static final int DEPTH = 1;
	public Cell [][] board;
	public Cell bestMove;
	public Piece playingPiece;
	//public Cell [][] newBoard = new Cell [7][7]; 
	//public Move bestmove=null;
	public Cell cellToclean=null;
	public Move bestmove;

	
	/**
	 * The makeMove method takes a board as a parameter and generates all the possible AI moves
	 * (note again that the AI is always black). It then calls the evaluatePosition function on each
	 * possible board to figure out the best move.  
	 * 
	 */
	
	//coding after April
	
	public Cell takeNewCellFromScore(Cell [][] b){
		
		int x=bestmove.getNewX();
		int y=bestmove.getNewY();
		
		System.out.println("THE BEST MOVE IN THE END"+bestmove);
		return b[x][y];		
	}
	
	public Cell takeOldCellFromScore(Cell [][] b){
		int score=minimaxnaive(b, 2, 1);
		int x=bestmove.getOldX();
		int y=bestmove.getOldY();
		
		
		
		return b[x][y];		
	}
	
	
	
	public int minimaxnaive(Cell [][]b , int depth, int color ){
		
		int bestscore=0;
		
		ArrayList<Move> moves  = new ArrayList<Move>(); //keeps track of all possible moves 
		
		Cell [][] newBoard = new Cell [7][7]; 
		for(int i=0;i<7; i++){
			for(int j=0; j<7; j++){
				newBoard[i][j]=null;
			}
		}
		

		
		if(depth==0 ){
			bestscore=newEvaluate(b); // this is correct dont erase
			//bestscore=evalRand(b);
		    return bestscore;

		}
		else{
			if(color==1){ //max player so black player in my game
				int score=Integer.MIN_VALUE;
				moves=findAllLegalMoves(b,1);
				System.out.println(moves.size());
				//System.exit(1);
				for(Move move : moves){
					System.out.println("move in max  "+ move);
					newBoard=doMove(b,move);
					
					printBoard(newBoard);

					bestscore=minimaxnaive(newBoard, depth-1, 0);
					//int score=evaluate(newBoard);
					System.out.println("Score for evaluate new board black = "+score);

//					System.out.println(score);
					if(bestscore>score){ //black maximizes its score
						score=bestscore;
						//if(move.getPiece().getColor()==0)
						bestmove=move;
						System.out.println("After cheking best score black= "+score);
						//System.exit(1);
					}
				}
				return bestscore;
				
			}
			else{//min player so white player in my game
				int score=Integer.MAX_VALUE;
				moves=findAllLegalMoves(b,0);
				for(Move move : moves){
					System.out.println("move in min  "+move);
					newBoard=doMove(b,move);
//					System.out.println("The new board = "+newBoard);
					printBoard(newBoard);
					bestscore=minimaxnaive(newBoard, depth-1,1);
					//int score=evaluate(newBoard);
					System.out.println("Score for evaluate new board white = "+score);
					if(score>bestscore){ //white minimizes its score
						score=bestscore;
						//if(move.getPiece().getColor()==1)
						bestmove=move;
						System.out.println("After cheking min score white= "+ score);
						//System.exit(1);
						//return bestmove2;
					}
				}
				
				return bestscore;


				
			}
			
		}
		
	}
	
public int minimaxnaiveforwhite(Cell [][]b , int depth, int color ){
		
		int bestscore=0;
		
		ArrayList<Move> moves  = new ArrayList<Move>(); //keeps track of all possible moves 
		
		Cell [][] newBoard = new Cell [7][7]; 
		for(int i=0;i<7; i++){
			for(int j=0; j<7; j++){
				newBoard[i][j]=null;
			}
		}
		

		
		if(depth==0 ){
			bestscore=newEvaluate(b); // this is correct dont erase
			//bestscore=evalRand(b);
		    return bestscore;

		}
		else{
			if(color==0){ //max player so white player in my game
				int score=Integer.MAX_VALUE;
				moves=findAllLegalMoves(b,0);
				System.out.println(moves.size());
				//System.exit(1);
				for(Move move : moves){
					System.out.println("move in max  "+ move);
					newBoard=doMove(b,move);
					
					printBoard(newBoard);

					bestscore=minimaxnaive(newBoard, depth-1, 1);
					//int score=evaluate(newBoard);
					System.out.println("Score for evaluate new board black = "+score);

//					System.out.println(score);
					if(bestscore<score){ //black maximizes its score
						score=bestscore;
						//if(move.getPiece().getColor()==0)
						bestmove=move;
						System.out.println("After cheking best score black= "+score);
						//System.exit(1);
					}
				}
				return bestscore;
				
			}
			else{//min player so white player in my game
				int score=Integer.MIN_VALUE;
				moves=findAllLegalMoves(b,1);
				for(Move move : moves){
					System.out.println("move in min  "+move);
					newBoard=doMove(b,move);
//					System.out.println("The new board = "+newBoard);
					printBoard(newBoard);
					bestscore=minimaxnaive(newBoard, depth-1,0);
					//int score=evaluate(newBoard);
					System.out.println("Score for evaluate new board white = "+score);
					if(score<bestscore){ //white minimizes its score
						score=bestscore;
						//if(move.getPiece().getColor()==1)
						bestmove=move;
						System.out.println("After cheking min score white= "+ score);
						//System.exit(1);
						//return bestmove2;
					}
				}
				
				return bestscore;


				
			}
			
		}
		
	}

public Cell takeOldCellFromScoreForWhite(Cell [][] b){
	int score=minimaxnaiveforwhite(b, 2, 0);
	int x=bestmove.getOldX();
	int y=bestmove.getOldY();
	
	
	
	return b[x][y];		
}
	
	
	
	public Cell [][] doMove(Cell [][]oldBoard, Move moveToMake){
		
		Cell [][] minimaxBoard= new Cell [7][7];
		
		Cell cell;
		Piece pi;
		
		for(int i=0;i<7; i++){
			for(int j=0; j<7; j++){
				pi=null;
				if(i==moveToMake.getNewX() && j==moveToMake.getNewY())
					pi=moveToMake.getPiece();
				else if(i!=moveToMake.getOldX() && j!= moveToMake.getOldY() && oldBoard[i][j].getPiece()!=null )
					pi=oldBoard[i][j].getPiece();
				
				cell = new Cell(i, j, pi);
				minimaxBoard[i][j]=cell;
			}
		}
		
		
		return minimaxBoard;
	}
	
	public ArrayList<Move> findOnlyFirstMove(Cell [][]b){
		Move result=null;
		ArrayList<Move> moves  = new ArrayList<Move>(); //keeps track of all possible moves 

		
		for(int i = 0; i<1; i++){
			for(int j=0; j<7; j++){
				
				if(b[i][j].getPiece() !=null){
					
					
					moves.addAll(b[i][j].getPiece().move2(b, i, j));
					break;
						
				}
			}
		}
	
		return moves;
	}
	
	public ArrayList<Move> findAllLegalMoves(Cell [][]b , int color ){
		
		ArrayList<Move> moves  = new ArrayList<Move>(); //keeps track of all possible moves 
		
		for(int i = 0; i<7; i++){
			for(int j=0; j<7; j++){
				
				if(b[i][j].getPiece() !=null && b[i][j].getPiece().getColor()==color){
					
					moves.addAll(b[i][j].getPiece().move2(b, i, j));
						
				}
			}
		}
		
		return moves;

	}
	
	
	
	//Old codings
	
	public Cell makeMinMaxMove(Cell [][] b) {
		// TODO Auto-generated method stub
		//generate all legal moves
		Cell bestMove; //keeps track of the best possible move AI has available
		int bestMoveScore; //score of that best move
		
		ArrayList<Cell [][]> possibleBoards = new ArrayList<Cell [][]>(); //keeps track of the possible boards (boards with the possible moves made on them)
		ArrayList<Cell> moves  = new ArrayList<Cell>(); //keeps track of all possible moves
		//ArrayList<Move> moves  = new ArrayList<Move>(); //keeps track of all possible moves 
		
		/*
		 * iterates through board, generates all possible moves and saves them in moves
		 */
		for(int i = 0; i<7; i++){
			for(int j=0; j<7; j++){
				
				if(b[i][j].getPiece() !=null && b[i][j].getPiece().getColor()==1){
					
						moves.addAll(b[i][j].getPiece().move(b, i, j));
						possibleBoards.add(b);
					
						//Board newBoard = new Board(b); //calls the copy constructor of the board class
						//doMove(newBoard, move); //performs move on the new board
						
				}
			}
		}
			
		
		
		System.out.println("First method moves number : "+moves.size());
			
	
		//initializes bestMove to the first move in the 
		bestMove = moves.get(0);
		bestMoveScore = evaluatePosition(possibleBoards.get(0), Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH, bestMove.getPiece().getColor());
		int numTurns=1;
		//call evaluateposition on each move
		//keep track of the move with the best score
		if(numTurns>0){
			for(int i = 1; i<possibleBoards.size(); i++){
				System.out.println("Evaluating move: " + moves.get(i).toString());
				/*
				 * calls evaluatePosition on each possible board and if the score is higher than previous,
				 * reset the bestMove
				 */
				int j = evaluatePosition(possibleBoards.get(i), Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH, bestMove.getPiece().getColor());
				if(j >= bestMoveScore){
					bestMove = moves.get(i);
					bestMoveScore = j;
				}
	
			}
		}else{
			Random generator = new Random();
			int index = generator.nextInt(moves.size());
			bestMove = moves.get(index);
		}
		System.out.println(bestMove.toString());
		numTurns++;
		
		return bestMove; //doMove performs the move on the original board and returns a the cell of that move
	
	}
	
	
	
	/**
	 * The evaluatePosition function takes a board, initial alpha, initial beta, depth, and color as parameters
	 * and computes a number that describes how advantageous for the AI a particular board is.  The function is 
	 * recursive, and every time it evaluates itself it decreases the depth by 1.  When the depth reaches 0, the
	 * function returns the result of running the evaluate function on the board.  If the depth is not 0, the function
	 * generates all possible moves from that position for the color specified, and then runs evaluatePosition for 
	 * each of the boards generated by each possible move. 
	 * @param b
	 * @param alpha
	 * @param beta 
	 * @param depth
	 * @param color
	 * @return an int giving a score of how good a particular board is, with higher numbers corresponding to better boards for the AI
	 */
	public int evaluatePosition(Cell [][] b, int alpha, int beta, int depth, int color){
		
		System.out.println("Begin evaluating position: depth-" + depth + " for- "+ color);
		/*
		 * Base case: when depth is decremented to 0, evaluatePosition simply returns the result
		 * of the evaluate function
		 */
		if(depth == 0){
			int evaluation = evaluate(b);
			System.out.println("Evaluated to: " + evaluation);
			return evaluation;
		}
		
		if(color == 0){ //minimizing player--sequence of events that occurs
			ArrayList<Cell> moves = new ArrayList<Cell>(); //this arraylist keeps track of possible moves from the given position
			/*
			 * Iterate through the board, collect all possible moves of the minimizing player
			 */
			for(int i = 0; i<7; i++){
				for(int j=0; j<7; j++){
					if(b[i][j].getPiece()!=null){
						if(b[i][j].getPiece().getColor() == color){
							Piece piece = b[i][j].getPiece();
							moves=piece.move(b, i, j);
							
						}
					}
				}
			}
			/*
			 * This for loop goes through all possible moves and calls evaluatePosition on them,
			 * changing the color.  Alpha-beta pruning is used here to remove obviously poor moves.
			 * These are determined by the variables alpha and beta.  All moves where the beta,
			 * which is the score of the minimizing (in this case white player) is less than or
			 * equal to alpha are discarded.  
			 */
			int newBeta = beta;
			for(Cell move : moves){ //for child in node
				System.out.println("Move to be evaluated: " + move.toString());
				Cell [][] successorBoard = new Cell [b.length][b[0].length]; 
				//doMove(successorBoard, move);
				if(color==0)
					newBeta = Math.min(newBeta, evaluatePosition(successorBoard, alpha, beta, depth -1, 1)); //think about how to change moves
				if(color==1)
					newBeta = Math.min(newBeta, evaluatePosition(successorBoard, alpha, beta, depth -1, 0)); //think about how to change moves
				if(newBeta<= alpha) break;
			}
			return newBeta; //returns the highest score of the possible moves
		}else{ //maximizing player--this is the course of action determined if this is the maximizing player, or black
			ArrayList<Cell> moves = new ArrayList<Cell>();
			/*
			 * These for loops iterate through the board and add all possible pieces to the ArrayList of
			 * moves.  
			 */
			for(int i = 0; i<7; i++){
				for(int j=0; j<7; j++){
					if(b[i][j].getPiece()!=null){
						if(b[i][j].getPiece().getColor() == color){
							Piece piece = b[i][j].getPiece();
							moves=piece.move(b, i, j);
							
						}
					}
				}
			}
		
		/*
		 * This for loop cycles through all possible moves and 
		 * calculates a new alpha if the successor board evaluates
		 * to a higher number than what is currently the highest score,
		 * which is stored in alpha.  
		 */
		int newAlpha = alpha;
		for(Cell move : moves){ //for child in node
			System.out.println("Move to be evaluated: " + move.toString());
			Cell [][] successorBoard = new Cell [b.length][b[0].length];
			//doMove(successorBoard, move);
			if(color==0)
				newAlpha = Math.max(newAlpha, evaluatePosition(successorBoard, alpha, beta, depth -1, 1)); //think about how to change moves
			if(color==1)
				newAlpha = Math.max(newAlpha, evaluatePosition(successorBoard, alpha, beta, depth -1, 0)); //think about how to change moves

			if(beta<= newAlpha) break;
		}
		return newAlpha; //returns the highest score of the possible moves
		}
	}
	
	/**
	 * The evaluate(Cell [][]b) function is an evaluation function that returns a number based on
	 * how advantageous a board is for the maximizing, black in this case, player. This function
	 * simply iterates through the whole board and gives a weighted number to each piece on the board,
	 * horse naturally yielding the highest number and riders are second. The total white score
	 * is subtracted from the total black score to give a full picture of how advantageous the board is 
	 * for a black player.  
	 * @param Cell [][] 
	 * @return int that represents how advantageous a board is
	 */
	public int evaluate(Cell [][] b){
		
		
		int whitescore = 0;
		int blackscore = 0;

		/*
		 * Iterates through entire board.   
		 */
		for(int i=0; i<7; i++){
			for(int j=0; j<7; j++){	

					if( b[i][j].getPiece() !=null && b[i][j].getPiece().getColor() == 0 && b[i][j].getPiece() instanceof Rider){ //case that piece is white
						
							whitescore += 0;
					}		
				    else if(b[i][j].getPiece() !=null && b[i][j].getPiece().getColor() == 0 && b[i][j].getPiece() instanceof Horse){
							whitescore += 100;
					}
					else if(b[i][j].getPiece() !=null && b[i][j].getPiece().getColor() == 1 && b[i][j].getPiece() instanceof Rider){ //case that piece is black
						
							blackscore += 10;
					}		
					else if(b[i][j].getPiece() !=null && b[i][j].getPiece().getColor() == 1 && b[i][j].getPiece() instanceof Horse){
							blackscore += 200;
						
					}				
			}
		}
		//System.out.println(whitescore);
		//System.out.println(blackscore);
		return blackscore-whitescore; //returns blackscore-whitescore, black player tries to maximize, white player tries to minimize
	}
	
	public int evalRand(Cell [][] b){
		Random r=new Random();
		int x=r.nextInt(10000);
		return x;
	}
	
	public int newEvaluate(Cell [][]b){
		int score = 0;
		
		
		for(int i=0; i<7 ; i++){
			for(int j=0 ; j<7 ; j++){
				
			if(b[i][j].getPiece()!=null && b[i][j].getPiece().getColor()==1){
				int numoftouchingpiece=b[i][j].howManyTouching(b);
				if(numoftouchingpiece==1) // checking touching 2 pieces
					score+=40;
				else if(numoftouchingpiece==2) // making them keep pairs
					score+=900;
				else if(numoftouchingpiece==3)
					score+=160;
				else if(numoftouchingpiece==4)
					score+=250;
				else 
					score+=10;
			
			}
			
			
			else if(b[i][j].getPiece()!=null && b[i][j].getPiece().getColor()==0){
				int numoftouchingpiece=b[i][j].howManyTouching(b);
				if(numoftouchingpiece==1)
					score-=40;
				else if(numoftouchingpiece==2)
					score-=900;
				else if(numoftouchingpiece==3)
					score-=160;
				else if(numoftouchingpiece==4)
					score-=250;
				else 
					score-=10;
			}	
			
			else if (b[i][j].getPiece()!=null && b[i][j].getPiece().getColor()==1 && b[i][j].getPiece().isinDanger(b[i][j], b)) {
				score-=100000;
				
			}
			else if(b[i][j].getPiece()!=null && b[i][j].getPiece() instanceof Horse){
				
				Horse horse= new Horse(b[i][j].getPiece().getId(),b[i][j].getPiece().getPath() , b[i][j].getPiece().getColor());
				if(horse.canEat(b, b[i][j])){
					score+=100000;
				}
			}
			
		}
		}
		
		return score;
		
	}
	
	public int determinePriorities(Cell [][] b){
		int score = 0;
		
		
		
		for(int i=0; i<7 ; i++){
			for(int j=0 ; j<7 ; j++){
				
				
				
				
			}
		}
		return score;
		
	}
	
public ArrayList<Cell> findAllBlacks(Cell [][] board){
	
	 ArrayList<Cell> blackPieces = new ArrayList<Cell>();

		
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
	
	public void printBoard(Cell [][] b){
		
		for(int i=0; i<7; i++){
			for(int j=0; j<7; j++){	
				if(b[i][j].getPiece()!=null)
					System.out.print("  pp  "+b[i][j].getPiece().getId());
				else
					System.out.print("  pp null");
			}
		}
		System.out.println(" ");
		
		
	}
	
	}	




