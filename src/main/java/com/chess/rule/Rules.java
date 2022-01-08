package com.chess.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chess.constant.ChessConstant;

public final class Rules {
	private static List<List<Integer>> horizontals; //= {{0,1},{0,-1}};
	private static List<List<Integer>> verticals; //{{1,0},{-1,0}};
	private static List<List<Integer>> diagonal; //[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	private static List<List<List<Integer>>> knight; //[][];
	private static List<List<Integer>> queen;
	private static List<List<Integer>> whitePawnRules;
	private static List<List<Integer>> blackPawnRules;
	private static List<List<Integer>> verticalHorizontalRules;
	
	public static List<List<Integer>> getHorizontalMovesCoordinate(){
		if(horizontals == null) {
			horizontals = new ArrayList<List<Integer>>();
			horizontals.add(Arrays.asList(0,1));
			horizontals.add(Arrays.asList(0,-1));
		}
		return horizontals;
	}
	
	public static List<List<Integer>> getVerticalsMovesCoordinate(){
		if(verticals == null) {
			verticals = new ArrayList<List<Integer>>();
			verticals.add(Arrays.asList(1,0));
			verticals.add(Arrays.asList(-1,0));
		}
		return verticals;
	}
	
	public static List<List<Integer>> getDiagonalMovesCoordinate(){
		if(diagonal == null) {
			diagonal = new ArrayList<List<Integer>>();
			diagonal.add(Arrays.asList(1,1));
			diagonal.add(Arrays.asList(1,-1));
			diagonal.add(Arrays.asList(-1,-1));
			diagonal.add(Arrays.asList(-1,1));
		}
		return diagonal;
	}
	
	public static List<List<List<Integer>>> getKnightMovesCoordinate(){
		if(knight == null) {
			knight = new ArrayList<List<List<Integer>>>();
			knight.add(Arrays.asList(Arrays.asList(0,1),Arrays.asList(1,1)));
			knight.add(Arrays.asList(Arrays.asList(0,1),Arrays.asList(-1,1)));			
			knight.add(Arrays.asList(Arrays.asList(0,-1),Arrays.asList(1,-1)));			
			knight.add(Arrays.asList(Arrays.asList(0,-1),Arrays.asList(-1,-1)));			
			knight.add(Arrays.asList(Arrays.asList(1,0),Arrays.asList(1,1)));
			knight.add(Arrays.asList(Arrays.asList(1,0),Arrays.asList(1,-1)));			
			knight.add(Arrays.asList(Arrays.asList(-1,0),Arrays.asList(-1,1)));			
			knight.add(Arrays.asList(Arrays.asList(-1,0),Arrays.asList(-1,-1)));			
		}
		return knight;
	}
		
	public static List<List<Integer>> getPawnMovesCoordinate(String color){
		if(color.equals(ChessConstant.WHITE)) {
			if(whitePawnRules == null) {
				whitePawnRules = new ArrayList<List<Integer>>();
				whitePawnRules.add(Arrays.asList(1,0));
				whitePawnRules.add(Arrays.asList(1,1));
				whitePawnRules.add(Arrays.asList(1,-1));
			}
		}
		else {
			if(blackPawnRules == null) {
				blackPawnRules = new ArrayList<List<Integer>>();
				blackPawnRules.add(Arrays.asList(-1,0));
				blackPawnRules.add(Arrays.asList(-1,-1));
				blackPawnRules.add(Arrays.asList(-1,1));
			}
		}		
		return color.equals(ChessConstant.WHITE) ? whitePawnRules : blackPawnRules;
	}
	
	public static List<List<Integer>> getVerticalHorizontalMovesCoordinate(){
		if(verticalHorizontalRules == null) {
			verticalHorizontalRules = new ArrayList<List<Integer>>();
			verticalHorizontalRules = Stream.concat(getHorizontalMovesCoordinate().stream(), getVerticalsMovesCoordinate().stream()).collect(Collectors.toList());
		}
		return verticalHorizontalRules;
	}	
}
