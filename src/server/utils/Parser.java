package server.utils;

import java.util.ArrayList;
import java.util.List;

import server.game.entities.Entity;
import server.game.entities.Player;

public class Parser {

	public static List<Entity> parsePlayerList(List<Player> players){
		
		List<Entity> entities = new ArrayList<Entity>();
		
		for(Player player : players){
			entities.add(player);
		}
		
		return entities;
	}
}
