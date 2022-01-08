package com.chess.model;

import java.util.HashSet;
import java.util.Set;

public class Piece {
	private String id;
	private int x;
	private int y;
	private String name;
	private String color;
	private Set<Coordinate> possibleMoves;
	private Set<Coordinate> history;
	public Piece(String id, int x, int y, String name, String color, Set<Coordinate> possibleMoves,
			Set<Coordinate> history) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.name = name;
		this.color = color;
		this.possibleMoves = possibleMoves;
		this.history = history;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Set<Coordinate> getPossibleMoves() {
		return possibleMoves;
	}
	public void setPossibleMoves(Set<Coordinate> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}
	public Set<Coordinate> getHistory() {
		return history;
	}
	public void setHistory(Set<Coordinate> history) {
		this.history = history;
	}
	
}
