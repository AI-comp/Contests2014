package engine.api;

import engine.api.Player;

public interface Computer {
  int doTurn(int selfId, Player[] players, int[] mostFavoritePlayers);
}
