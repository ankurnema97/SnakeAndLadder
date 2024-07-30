package model;

import java.util.HashMap;
import java.util.Map;

public class Ladders {
	
	public static Map<Integer, Integer> ladders = new HashMap<>();
	
	public void addLadder(int sourcePosition, int destinationPosition) {
		ladders.put(sourcePosition, destinationPosition);
	}
}
