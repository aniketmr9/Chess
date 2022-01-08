package com.chess.model;

import java.util.List;

public class Player {
	private List<Piece> player1;
	private List<Piece> player2;
	public Player(List<Piece> player1, List<Piece> player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
	}
	public List<Piece> getPlayer1() {
		return player1;
	}
	public void setPlayer1(List<Piece> player1) {
		this.player1 = player1;
	}
	public List<Piece> getPlayer2() {
		return player2;
	}
	public void setPlayer2(List<Piece> player2) {
		this.player2 = player2;
	}
	
}
