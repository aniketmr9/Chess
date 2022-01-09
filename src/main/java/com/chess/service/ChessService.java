package com.chess.service;

import com.chess.model.Board;
import com.chess.model.Piece;

public interface ChessService {
	public Board populateBoard();
	public Piece populatePossibleMoves(Board board, Piece piece);
}
