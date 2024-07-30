package model;

import java.util.Random;

public class Board {
	
	int row=-1,col=-1;
	PlayingOptions board[][];
	Random random;
	int size;
	
	public Board(int size) {
		this.size = size;
		board = new PlayingOptions[size][size];
		random = new Random();
	}
	
	public boolean addChance(Players player) {
		while(true) {
		int dice = random.nextInt(5)+1;
		System.out.println(dice);
		
		try {
			if(dice+player.playingOptions.position>100) {
				throw new IllegalArgumentException();
			}
			
			row = player.playingOptions.position/10;
			if(player.playingOptions.position%10==0)
				row-=1;
			
			if(player.playingOptions.position%10 == 0)
				col = 10;
			else
				col = player.playingOptions.position%10;
			
			if(row%2==0) {
				col -= 1;
			}
			else {
				col = 10-col;
			}
			
			if(row!=-1)
			board[row][col]=null;
			
			player.playingOptions.position += dice;
			
			row = player.playingOptions.position/10;
			if(player.playingOptions.position%10==0)
				row-=1;
			
			
			if(player.playingOptions.position%10 == 0)
				col = 10;
			else
				col = player.playingOptions.position%10;
			
			
			if(row%2==0) {
				col -= 1;
			}
			else {
				col = 10-col;
			}
			
			board[row][col] = player.playingOptions;
			
			if(Ladders.ladders.get(player.playingOptions.position)!=null) {
				board[row][col] = null;
				player.playingOptions.position = Ladders.ladders.get(player.playingOptions.position);
				row = player.playingOptions.position/10;
				if(player.playingOptions.position%10==0)
					row-=1;
				
				if(player.playingOptions.position%10 == 0)
					col = 10;
				else
					col = player.playingOptions.position%10;
				
				
				if(row%2==0) {
					col -= 1;
				}
				else {
					col = 10-col;
				}
				
				board[row][col] = player.playingOptions;
			}
			
			else if(Snakes.snakes.get(player.playingOptions.position)!=null) {
				board[row][col] = null;
				player.playingOptions.position = Snakes.snakes.get(player.playingOptions.position);
				row = player.playingOptions.position/10;
				if(player.playingOptions.position%10==0)
					row-=1;
				
				if(player.playingOptions.position%10 == 0)
					col = 10;
				else
					col = player.playingOptions.position%10;
				
				
				if(row%2==0) {
					col -= 1;
				}
				else {
					col = 10-col;
				}
				
				board[row][col] = player.playingOptions;
			}
				
			
		}
		catch(IllegalArgumentException e) {
			System.out.println("Board cell exceeded");
			break;
		}
		
		if(dice != 6) {
			break;
		}
		}
		
		if(player.playingOptions.position==100)
			return true;
		else
		    return false;
	}
	
	public void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]!=null)
					System.out.print(board[i][j].option.name().toUpperCase().charAt(0)+"|");
				else
					System.out.print("_|");
			}
			System.out.println();
		}
	}
}
