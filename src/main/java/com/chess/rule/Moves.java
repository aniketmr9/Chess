package com.chess.rule;

import java.util.List;
import org.springframework.stereotype.Component;
import com.chess.constant.ChessConstant;
import com.chess.model.Coordinate;
import com.chess.model.Piece;

@Component
public class Moves {
	public void populatePawnPossibleMoves(List<List<Coordinate>> coordinates, Piece piece, List<List<Integer>> possibleCoordinatesRules) {		
		Coordinate coordinate = null;
		int verticalMoves = piece.getHistory().size() < 1 ? 2 : 1;
		for(int i = 0; i < verticalMoves; i++) {
			int x = piece.getX()+possibleCoordinatesRules.get(0).get(0);
			x = piece.getColor().equals(ChessConstant.WHITE) ? x + i : x - i;
			int y = piece.getY()+possibleCoordinatesRules.get(0).get(1);
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
				coordinate = coordinates.get(x).get(y);			
				if(!coordinate.getIsOccupied()) {
					piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.GREEN, false, null));
				}
				else {
					break;
				}
			}
		}
		for(int i = 1; i < possibleCoordinatesRules.size(); i++) {
			int x = piece.getX()+possibleCoordinatesRules.get(i).get(0);
			int y = piece.getY()+possibleCoordinatesRules.get(i).get(1);
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
				coordinate = coordinates.get(x).get(y);
				if(coordinate != null && coordinate.getIsOccupied() && coordinate.getPiece() != null && !coordinate.getPiece().getColor().equals(piece.getColor())) {
					piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.RED, false, null));
				}
			}			
		}		
	}
	
	public Coordinate getPossibleCoordinate(List<List<Coordinate>> coordinates, List<List<Integer>> possibleCoordinatesRules, Coordinate coordinate, int index) {
		int x = coordinate.getX()+possibleCoordinatesRules.get(index).get(0);
		int y = coordinate.getY()+possibleCoordinatesRules.get(index).get(1);
		//System.out.println("Piece :("+coordinate.getX()+","+coordinate.getY()+")");
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			Coordinate newCoordinate = coordinates.get(x).get(y);
			//System.out.println("newCoordinate :("+newCoordinate.getX()+","+newCoordinate.getY()+")");
			return newCoordinate;
		}
		return null;
	}
	
	public void populatePossibleMoves(List<List<Coordinate>> coordinates, Piece piece, List<List<Integer>> possibleCoordinatesRules) {		
		//List<List<Integer>> possibleCoordinatesRules = Rules.getRookMovesCoordinate();		
		for(int ruleIndex = 0; ruleIndex < 2; ruleIndex++) {
			int index = 0;
			Coordinate coordinate = new Coordinate(piece.getX(), piece.getY());
			while(coordinate != null) {
				if(piece.getName().equals(ChessConstant.KING) && index == 1) {
					break;
				}
				coordinate = getPossibleCoordinate(coordinates, possibleCoordinatesRules, coordinate, ruleIndex);
				if(coordinate != null) {
					if(!coordinate.getIsOccupied()) {
						piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.GREEN, false, null));
					}
					if(coordinate != null && coordinate.getIsOccupied() && coordinate.getPiece() != null) {						
						if(coordinate.getPiece().getColor().equals(piece.getColor())) {
							break;
						}
						piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.RED, false, null));
						break;
					}
					index++;
				}
				else {
					break;
				}				
			}
		}		
		for(int ruleIndex = 2; ruleIndex < 4; ruleIndex++) {
			Coordinate coordinate = new Coordinate(piece.getX(), piece.getY());
			int index = 0;
			while(coordinate != null) {
				if(piece.getName().equals(ChessConstant.KING) && index == 1) {
					break;
				}
				coordinate = getPossibleCoordinate(coordinates, possibleCoordinatesRules, coordinate, ruleIndex);
				if(coordinate != null) {
					if(!coordinate.getIsOccupied()) {
						piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.GREEN, false, null));
					}
					if(coordinate != null && coordinate.getIsOccupied() && coordinate.getPiece() != null){
						if(coordinate.getPiece().getColor().equals(piece.getColor())) {
							break;
						}
						piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.RED, false, null));
						break;
					}
					index++;
				}
				else {
					break;
				}
			}
		}		
	}
	
	public void populateKnigtPossibleMoves(List<List<Coordinate>> coordinates, Piece piece, List<List<List<Integer>>> possibleCoordinatesRules) {						
		for(int possibleRuleIndex = 0; possibleRuleIndex < possibleCoordinatesRules.size(); possibleRuleIndex++) {
			Coordinate coordinate = new Coordinate(piece.getX(), piece.getY());
			boolean legalMove = false;
			for(int possibleCoordinateIndex = 0; possibleCoordinateIndex < possibleCoordinatesRules.get(possibleRuleIndex).size(); possibleCoordinateIndex++) {
				coordinate = getPossibleCoordinate(coordinates, possibleCoordinatesRules.get(possibleRuleIndex), coordinate, possibleCoordinateIndex);
				if(coordinate != null) {
					if(!coordinate.getIsOccupied() && legalMove) {
						piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.GREEN, false, null));
					}
					if(coordinate != null && coordinate.getIsOccupied() && coordinate.getPiece() != null && legalMove){
						if(coordinate.getPiece().getColor().equals(piece.getColor())) {
							break;
						}
						piece.getPossibleMoves().add(new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getOriginalColor(), ChessConstant.RED, false, null));
						break;
					}
					legalMove = !legalMove;
				}
				else {
					break;
				}
			}		
		}
	}
	
	public Coordinate getPossibleCoordinateForKnight(List<List<Coordinate>> coordinates, Coordinate coordinate, List<Integer> possibleMoves) {
		int x = coordinate.getX()+possibleMoves.get(0);
		int y = coordinate.getY()+possibleMoves.get(1);
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			Coordinate newCoordinate = coordinates.get(x).get(y);
			return newCoordinate;
		}
		return null;
	}
}
