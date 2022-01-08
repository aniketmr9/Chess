package com.chess.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chess.model.Board;
import com.chess.model.Piece;
import com.chess.model.Player;

@CrossOrigin
@RestController
@RequestMapping("/chess")
public class ChessController {
	@Autowired
	private ChessService chessService;
	
	@GetMapping(value = "/populate")
	public Board populateBoard(){
		return chessService.populateBoard();
	}
}
