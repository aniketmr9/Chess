package com.chess.constant;

public enum PiecesEnum {
	PAWN("PAWN"),
	BISHOP("BISHOP"),
	KNIGHT("KNIGHT"),
	ROOK("ROOK"),
	QUEEN("QUEEN"),
	KING("KING");
	
	private final String value;

	private PiecesEnum(String value) {
		this.value = value;
	}
	
	public static String fromString(String value) {
		for (PiecesEnum piece : values()) {
	        if (piece.value.equals(value)) {
	            return piece.toString();
	        }
	    }    
	    throw new IllegalArgumentException(value);
	}
}
