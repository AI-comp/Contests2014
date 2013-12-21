package engine;

import java.util.ArrayList;

import engine.api.Computer;

public class GameEngine {
	private ArrayList<InternalPlayer> internalPlayers;
	private ArrayList<Heroine> heroines;
	private ArrayList<Computer> computers;

	public GameEngine() {
		internalPlayers = new ArrayList<InternalPlayer>();
		heroines = new ArrayList<Heroine>();
		for (int i = 0; i < 4; i++) {
			heroines.add(new Heroine());
		}
	}

	public void proceed() {
		
		for (Computer computer: computers) {
//			computer.doTurn(selfId, players, mostFavoritePlayers)
		}
		
//		for (InternalPlayer player : internalPlayers) {
//			
//		}
	}
}
