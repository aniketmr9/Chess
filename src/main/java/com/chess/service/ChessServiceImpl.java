package com.chess.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chess.constant.ChessConstant;
import com.chess.constant.PiecesEnum;
import com.chess.model.Board;
import com.chess.model.Coordinate;
import com.chess.model.Piece;
import com.chess.rule.Moves;
import com.chess.rule.Rules;

@Service
public class ChessServiceImpl implements ChessService {

	@Autowired
	private Moves moves;
	
	@Override
	public Board populateBoard() {
		// Load empty board
		Board board = new Board(loadEmptyChessBoard());
		// populating white pieces
		populatePieces(board, "1", ChessConstant.WHITE_STARTING_X,ChessConstant.WHITE);
		populatePieces(board, "2", ChessConstant.BLACK_STARTING_X,ChessConstant.BLACK);
		//testingBoard(board);
		populatePossibleMoves(board);
		// Player player = new Player(populatePieces(ranksWhite,
		// ChessConstant.WHITE),populatePieces(ranksBlack, ChessConstant.BLACK));						
		return board;
	}

	public void testingBoard(Board board){
		//test moves
		testPiece(board, 4, 4, "BISHOP", ChessConstant.WHITE.toString());
		//vertical & horizontal
		/*
		 * testPiece(board, 4, 2, "PAWN", ChessConstant.BLACK.toString());
		 * testPiece(board, 6, 4, "PAWN", ChessConstant.BLACK.toString());
		 * testPiece(board, 4, 6, "PAWN", ChessConstant.BLACK.toString());
		 * testPiece(board, 2, 4, "PAWN", ChessConstant.BLACK.toString());
		 */
		//diagonal
		
		  testPiece(board, 2, 2, "PAWN", ChessConstant.BLACK.toString());
		  testPiece(board, 6, 2, "PAWN", ChessConstant.BLACK.toString());
		  testPiece(board, 6, 6, "PAWN", ChessConstant.BLACK.toString());
		  testPiece(board, 2, 6, "PAWN", ChessConstant.BLACK.toString());
		 
		//knight pawn dummies
		
		  testPiece(board, 2, 3, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 3, 2, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 5, 2, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 6, 3, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 6, 5, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 5, 6, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 3, 6, "PAWN", ChessConstant.WHITE.toString());
		  testPiece(board, 2, 5, "PAWN", ChessConstant.WHITE.toString());
		 
	}
	
	private void testPiece(Board board, int x, int y, String pieceName, String color) {
		// TODO Auto-generated method stub
		board.getCoordinates().get(x).get(y).setPiece(new Piece("1", x, y, pieceName, color, new HashSet<Coordinate>(), null));
		board.getCoordinates().get(x).get(y).setOccupied(true);
	}
	
	private void populatePossibleMoves(Board board) {
		for (List<Coordinate> coordinates : board.getCoordinates()) {
			for(Coordinate coordinate: coordinates) {				
				if(coordinate != null && coordinate.getPiece() !=null && coordinate.getPiece().getName() != null) {
					switch (coordinate.getPiece().getName()) {					
					case "PAWN":
						moves.populatePawnPossibleMoves(board.getCoordinates(), coordinate.getPiece());
						break;
					case "ROOK":
						moves.populatePossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getVerticalHorizontalMovesCoordinate());
						break;
					case "BISHOP":
						moves.populatePossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getDiagonalMovesCoordinate());
						break;					
					case "KNIGHT":
						moves.populateKnigtPossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getKnightMovesCoordinate());
						break;
					case "QUEEN":
						moves.populatePossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getVerticalHorizontalMovesCoordinate());
						moves.populatePossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getDiagonalMovesCoordinate());
						break;
					case "KING":
						moves.populatePossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getVerticalHorizontalMovesCoordinate());
						moves.populatePossibleMoves(board.getCoordinates(), coordinate.getPiece(), Rules.getDiagonalMovesCoordinate());
						break;
					default:
						break;
					}					
				}
			}
		}
	}

	private List<List<Coordinate>> loadEmptyChessBoard() {
		List<List<Coordinate>> coordinates = new ArrayList<List<Coordinate>>();		
		String color;
		boolean isBlack = true;
		boolean colorSwitch = true;
		for (int x : ChessConstant.X) {
			ArrayList<Coordinate> coordinate = new ArrayList<Coordinate>();
			isBlack = colorSwitch;
			for (int y : ChessConstant.Y) {
				color = isBlack ? ChessConstant.BLACK : ChessConstant.WHITE;
				coordinate.add(new Coordinate(x, y, color, color, false, null));
				isBlack = !isBlack;
			}
			colorSwitch = !colorSwitch;
			coordinates.add(coordinate);
		}
		return coordinates;
	}

	private void populatePieces(Board board, String id, int[] startingX, String color) {
		String pieceName;
		String pawnPiece;
		for (int x = 0; x < ChessConstant.X.length; x++) {
			pieceName = PiecesEnum.fromString(ChessConstant.PIECE_POSITIONS[x]);
			pawnPiece = PiecesEnum.fromString(ChessConstant.PAWN);
			for (List<Coordinate> coordinates : board.getCoordinates()) {
				for(Coordinate coordinate: coordinates) {
					if (coordinate.getY() == x && coordinate.getX() == startingX[color.equals(ChessConstant.WHITE) ? 0 : 1]) {
						coordinate.setPiece(new Piece(id, coordinate.getX(), coordinate.getY(), pieceName, color, new HashSet<Coordinate>(), null));						
						coordinate.setOccupied(true);
					}
					if (coordinate.getY() == x && coordinate.getX() == startingX[color.equals(ChessConstant.WHITE) ? 1 : 0]) {						
						coordinate.setPiece(new Piece(id, coordinate.getX(), coordinate.getY(), pawnPiece, color, new HashSet<Coordinate>(), null));
						coordinate.setOccupied(true);		
					}
				}						
			}			
		}
	}	
}
