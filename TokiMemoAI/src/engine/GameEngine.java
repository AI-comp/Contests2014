package engine;

import java.util.ArrayList;

public class GameEngine {
	private ArrayList<InternalPlayer> players;
	private ArrayList<Heroine> heroines;

	public GameEngine() {
		players = new ArrayList<InternalPlayer>();
		heroines = new ArrayList<Heroine>();
		for (int i = 0; i < 4; i++) {
			heroines.add(new Heroine());
		}
	}

	public void proceed() {
		for (InternalPlayer player : players) {

		}
	}
}
