package model;

import java.util.HashMap;
import java.util.Map;

public class Snakes {

	public static Map<Integer, Integer> snakes = new HashMap<>();
	
	public void addSnake(int sourcePosition, int destinationPosition) {
		snakes.put(sourcePosition, destinationPosition);
	}
}
