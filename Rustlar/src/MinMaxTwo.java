
/**
 * The MinMax class implements AI and defines an AI that uses the Minimax algorithm 
 * to figure out what moves to make.  This is a very complex class.
 * 
 * The makeMove(Board b) method takes a board, generates possible boards based on the 
 * possible moves of the AI, and has those boards evaluated by the evaluatePosition function.
 * The board that scores the highest becomes the next move, and the doMove(Board b, Move moveToMake)
 * method is invoked, which performs that move on the board.
 * 
 * The evaluatePosition function is recursive and generates a game tree which it searches to figure
 * out how advantageous a board it is.  It uses the MinMax algorithm with alpha-beta pruning to 
 * rate moves, and when a node at the depth specified by the constant DEPTH is reached,
 * the evaluate function is called to determine the ultimate worth of that board. This is
 * then propagated up through the game tree to determine how advantageous a move is.  
 * 
 * Note that all AI players are black
 */

import java.util.*;
import java.awt.*;
	
public class MinMaxTwo {
	private static final int DEPTH = 1;
	private int numTurns=0;
	
	/**
	 * The makeMove(Board b) method takes a board as a parameter and generates all the possible AI moves
	 * (note again that the AI is always black). It then calls the evaluatePosition function on each
	 * possible board to figure out the best move.  
	 * 
	 * @return a string describing the move that was made
	 */
	public Cell makeMove(Cell [][] b) {
		// TODO Auto-generated method stub
		//generate all legal moves
		Cell bestMove; //keeps track of the best possible move AI has available
		int bestMoveScore; //score of that best move
		
		ArrayList<Cell [][]> possibleBoards = new ArrayList<Cell [][]>(); //keeps track of the possible boards (boards with the possible moves made on them)
		ArrayList<Cell> moves  = new ArrayList<Cell>(); //keeps track of all possible moves 
		ArrayList<Cell> possibleMinMaxMoves  = new ArrayList<Cell>();
		
		/*
		 * iterates through board, generates all possible moves and saves them in moves
		 */
		for(int i = 0; i<7; i++){
			for(int j=0; j<7; j++){
				if(b[i][j].getPiece()!=null){
					Piece piece = b[i][j].getPiece();
					if(piece.getColor() == 1 && piece.isMovable(b[i][j], b) == true){ //black player
						possibleMinMaxMoves=piece.move(b, i, j);
						System.out.println(possibleMinMaxMoves);
								for(int k=0; k<possibleMinMaxMoves.size(); k++){ 
									Cell move = new Cell(possibleMinMaxMoves.get(k).getXPoz(), possibleMinMaxMoves.get(i).getYPoz(), piece);
									moves.add(move);
									//Board newBoard = new Board(b); //calls the copy constructor of the board class
									//doMove(newBoard, move); //performs move on the new board
									possibleBoards.add(b);
								}
								
					}
				}
			}
		}
		//initializes bestMove to the first move in the 
		bestMove = moves.get(0);
		bestMoveScore = evaluatePosition(possibleBoards.get(0), Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH, 0);
		
		//call evaluateposition on each move
		//keep track of the move with the best score
		if(numTurns>0){
			for(int i = 1; i<possibleBoards.size(); i++){
				System.out.println("Evaluating move: " + moves.get(i).toString());
				/*
				 * calls evaluatePosition on each possible board and if the score is higher than previous,
				 * reset the bestMove
				 */
				int j = evaluatePosition(possibleBoards.get(i), Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH, 0);
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
		return bestMove; //doMove performs the move on the original board and returns a string of that move

		
	}
	
	
	/*
	public String doMove(Board b, Move moveToMake){
		final String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"}; //used to print the row as a letter instead of a number
		Piece pieceToMove = moveToMake.getPiece();
		
		
		if(pieceToMove.getType().equals("King")){
			if(pieceToMove.getColor() == false){//case that it is white king
				if(b.hasPiece(7, 7)){
					if(b.getSquare(7,7).getType().equals("Rook")){
						if(moveToMake.getOldX() == 4 && moveToMake.getOldY() == 7 && moveToMake.getNewX() == 6 && moveToMake.getNewY() ==7){
							//if conditions for castling are correct, moves the correct pieces
							b.clearSquare(moveToMake.getOldX(), moveToMake.getOldY());
							b.setSquare(moveToMake.getNewX(), moveToMake.getNewY(), pieceToMove);
							pieceToMove.setLocation(moveToMake.getNewX(), moveToMake.getNewY());
							Piece rook = b.getSquare(7, 7);
							b.setSquare(5,7,rook);
							rook.setLocation(5, 7);
							b.clearSquare(7, 7);
							String text = "White castles. \n";
							return text;
						}
					}
				}
			}else if(pieceToMove.getColor() == true){ //case that it is black king
				if(b.hasPiece(7, 0)){
					if(b.getSquare(7, 0).getType().equals("Rook")){
						if(moveToMake.getOldX() == 4 && moveToMake.getOldY() == 0 && moveToMake.getNewX() == 6 && moveToMake.getNewY() ==0){
							//if conditions for castling are correct, moves the correct pieces
							b.clearSquare(moveToMake.getOldX(), moveToMake.getOldY());
							b.setSquare(moveToMake.getNewX(), moveToMake.getNewY(), pieceToMove);
							pieceToMove.setLocation(moveToMake.getNewX(), moveToMake.getNewY());
							Piece rook = b.getSquare(7, 0);
							b.setSquare(5, 0, rook);
							rook.setLocation(5, 0);
							b.clearSquare(7, 0);
							String text = "Black castles. \n";
							return text;
						}
					}
				}
			}
		}
		//clear square and reset the new square with the piece to be moved
		b.clearSquare(moveToMake.getOldX(), moveToMake.getOldY());
		b.setSquare(moveToMake.getNewX(), moveToMake.getNewY(), pieceToMove);
		pieceToMove.setLocation(moveToMake.getNewX(), moveToMake.getNewY());
		
		
		String text = pieceToMove.getType() + " was moved to: " + columns[moveToMake.getNewX()] +  (moveToMake.getNewY()+1) + "\n";
		return text;
	}*/
	
	
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
		System.out.println("Begin evaluating position: depth-" + depth + "for- "+ color);
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
			ArrayList<Cell> possibleMinMaxMoves  = new ArrayList<Cell>();

			/*
			 * Iterate through the board, collect all possible moves of the minimizing player
			 */
			for(int i = 0; i<7; i++){
				for(int j=0; j<7; j++){
					if(b[i][j].getPiece()!=null){
						if(b[i][j].getPiece().getColor() == color){
							Piece piece = b[i][j].getPiece();
							if(piece.getColor() == 1 && piece.isMovable(b[i][j], b) == true){ //black player
								possibleMinMaxMoves=piece.move(b, i, j);
								
										for(int k=0; k<possibleMinMaxMoves.size(); k++){ //k and l and multiplied by 62 because checkLegalMove takes the pixel positions as parameters
											Cell move = new Cell(possibleMinMaxMoves.get(k).getXPoz(), possibleMinMaxMoves.get(i).getYPoz(), piece);
											moves.add(move);
										
										}
										
							}
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
				//Board successorBoard = new Board(b); 
				//doMove(successorBoard, move);
				//newBeta = Math.min(newBeta, evaluatePosition(successorBoard, alpha, beta, depth -1, !color)); //think about how to change moves
				if(color==0)
					newBeta = Math.min(newBeta, evaluatePosition(b, alpha, beta, depth -1, 1)); //think about how to change moves
				if(color==1)
					newBeta = Math.min(newBeta, evaluatePosition(b, alpha, beta, depth -1, 0)); //think about how to change moves
				if(newBeta<= alpha) break;
			}
			return newBeta; //returns the highest score of the possible moves
		}else{ //maximizing player--this is the course of action determined if this is the maximizing player, or black
			ArrayList<Cell> moves = new ArrayList<Cell>();
			ArrayList<Cell> possibleMinMaxMoves  = new ArrayList<Cell>();

			/*
			 * These for loops iterate through the board and add all possible pieces to the ArrayList of
			 * moves.  
			 */
			for(int i = 0; i<7; i++){
				for(int j=0; j<7; j++){
					if(b[i][j].getPiece()!=null){
						if(b[i][j].getPiece().getColor() == color){
							Piece piece = b[i][j].getPiece();
							if(piece.getColor() == 1 && piece.isMovable(b[i][j], b) == true){ //black player
								possibleMinMaxMoves=piece.move(b, i, j);
								
										for(int k=0; k<possibleMinMaxMoves.size(); k++){ //k and l and multiplied by 62 because checkLegalMove takes the pixel positions as parameters
											Cell move = new Cell(possibleMinMaxMoves.get(k).getXPoz(), possibleMinMaxMoves.get(i).getYPoz(), piece);
											moves.add(move);
										
										}
										
							}
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
		for( Cell move : moves){ //for child in node
			System.out.println("Move to be evaluated: " + move.toString());
			/////Board successorBoard = new Board(b); 
			//doMove(successorBoard, move);
			//newAlpha = Math.max(newAlpha, evaluatePosition(b, alpha, beta, depth -1, !color)); //think about how to change moves
			if(color==0)
				newAlpha = Math.min(newAlpha, evaluatePosition(b, alpha, beta, depth -1, 1)); //think about how to change moves
			if(color==1)
				newAlpha = Math.min(newAlpha, evaluatePosition(b, alpha, beta, depth -1, 0)); //think about how to change moves
			if(beta<= newAlpha) break;
		}
		return newAlpha; //returns the highest score of the possible moves
		}
	}
	
	/**
	 * The evaluate(Board b) function is an evaluation function that returns a number based on
	 * how advantageous a board is for the maximizing, black in this case, player. This function
	 * simply iterates through the whole board and gives a weighted number to each piece on the board,
	 * kings naturally yielding the highest number, queens the second, and so on.  The total white score
	 * is subtracted from the total black score to give a full picture of how advantageous the board is 
	 * for a black player.  
	 * @param b
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
					System.out.println("working here");
					//System.out.print(i);
					//System.out.println(j);
					//System.out.println(b[i][j].getXPoz());
					//System.out.println(b[i][j].getYPoz());
					System.out.println(b[i][j].getPiece());

					if( b[i][j].getPiece() !=null && b[i][j].getPiece().getColor() == 0 && b[i][j].getPiece() instanceof Rider){ //case that piece is white
						
							whitescore += 10;
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
		System.out.println(whitescore);
		System.out.println(blackscore);
		return blackscore-whitescore; //returns blackscore-whitescore, black player tries to maximize, white player tries to minimize
	}

}
