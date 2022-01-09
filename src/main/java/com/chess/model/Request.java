package com.chess.model;

public class Request {
	private Board board;
	private Piece piece;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}
