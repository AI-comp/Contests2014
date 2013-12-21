package engine;

import java.util.ArrayList;

public class GameEngine {
	private ArrayList<Player> players;
	private ArrayList<Heroine> heroines;

	public GameEngine() {
		players = new ArrayList<Player>();
		heroines = new ArrayList<Heroine>();
		for (int i = 0; i < 4; i++) {
			heroines.add(new Heroine());
		}
	}

	public void proceed() {
		for (Player player : players) {

		}
	}
}
