package engine.api;

import java.util.List;

public interface Computer {
  int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers);
}
