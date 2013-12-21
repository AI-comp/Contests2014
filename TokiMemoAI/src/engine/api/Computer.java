package engine.api;

import engine.InternalPlayer;

public interface Computer {
  int doTurn(int selfId, InternalPlayer[] players, int[] mostFavoritePlayers);
}
