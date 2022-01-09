package com.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chess.model.Board;
import com.chess.model.Piece;
import com.chess.model.Request;
import com.chess.service.ChessService;

@CrossOrigin
@RestController
@RequestMapping("/chess/board")
public class ChessController {
	@Autowired
	private ChessService chessService;
	
	@GetMapping(value = "/populate")
	public Board populateBoard(){
		return chessService.populateBoard();
	}
	
	@PostMapping(value = "/getPossibleMove")
	public Piece getPossibleMove(@RequestBody Request request){
		return chessService.populatePossibleMoves(request.getBoard(), request.getPiece());
	}
	
	/*
	 * @PostMapping(value = "/updateBoard") public Piece updateBoard(@RequestBody
	 * Board board){ return chessService.populatePossibleMoves(board); }
	 */
}
