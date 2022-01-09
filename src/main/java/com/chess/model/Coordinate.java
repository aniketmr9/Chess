package com.chess.model;

public class Coordinate {
	private int x;
	private int y;
	private String originalColor;
	private String updatedColor;
	private boolean isOccupied;
	private Piece piece;	
	
	
	public Coordinate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Coordinate(int x, int y, String originalColor, String updatedColor, boolean isOccupied, Piece piece) {
		super();
		this.x = x;
		this.y = y;
		this.originalColor = originalColor;
		this.updatedColor = updatedColor;
		this.isOccupied = isOccupied;
		this.piece = piece;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOriginalColor() {
		return originalColor;
	}
	public void setOriginalColor(String originalColor) {
		this.originalColor = originalColor;
	}
	public String getUpdatedColor() {
		return updatedColor;
	}
	public void setUpdatedColor(String updatedColor) {
		this.updatedColor = updatedColor;
	}
	public boolean getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + ", originalColor=" + originalColor + ", updatedColor=" + updatedColor
				+ ", isOccupied=" + isOccupied + ", piece=" + piece + "]";
	}
	
	
}
