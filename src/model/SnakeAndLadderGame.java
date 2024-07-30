package model;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeAndLadderGame {

	Board board;
	Deque<Players> deque;
	
	public SnakeAndLadderGame() {
		PlayingOptions playingOptions1 = new Option1();
		Players player1 = new Players("ABC", playingOptions1);
		
		PlayingOptions playingOptions2 = new Option2();
		Players player2 = new Players("XYZ", playingOptions2);
		
		board = new Board(10);
		deque = new LinkedList<>();
		
		deque.add(player1);
		deque.add(player2);
		
		}
	
	public String startGame() {
		String Winner;
		board.printBoard();
		while(true) {
			Players chance = deque.getFirst();
			System.out.println("Throw Dice");
			if(board.addChance(chance)) {
				Winner = chance.name;
				break;
			}
			board.printBoard();
			Players pop = deque.peek();
			deque.pop();
			deque.add(pop);
		}
		
		return Winner;
	}
}
