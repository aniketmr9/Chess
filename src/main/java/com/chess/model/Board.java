package com.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<List<Coordinate>> coordinates;

	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(List<List<Coordinate>> coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public List<List<Coordinate>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<Coordinate>> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Board [coordinates=" + coordinates + "]";
	}

	
}
