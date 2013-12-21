package engine.api;

import java.util.ArrayList;

import engine.api.Player;

public interface Computer {
  int doTurn(int selfId, ArrayList<Player> players, ArrayList<Integer> mostFavoritePlayers);
}
