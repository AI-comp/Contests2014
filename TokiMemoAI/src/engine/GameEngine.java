package engine;

import java.util.ArrayList;

import engine.api.Computer;
import engine.api.Player;

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
    ArrayList<Integer> mostFavoritePlayers = new ArrayList<Integer>();
    for (Heroine heroine : heroines) {
      int bestPlayer = 0;
      int bestEvaluation = 0;
      for (int i = 0; i < internalPlayers.size(); i++) {
        int evaluation = heroine.getEvaluation(internalPlayers.get(i));
        if (bestEvaluation < heroine.getEvaluation(internalPlayers.get(i))) {
          bestPlayer = i;
          bestEvaluation = evaluation;
        }
      }
      mostFavoritePlayers.add(bestPlayer);
    }

    ArrayList<Player> players = new ArrayList<Player>();
    for (Player player : internalPlayers) {
      players.add(player);
    }

    for (int i = 0; i < computers.size(); i++) {
      int index = computers.get(i).doTurn(i, players, mostFavoritePlayers);
      internalPlayers.get(i).addParameter(index);
    }
  }
}
