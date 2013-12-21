package engine;

import java.util.List;

import engine.api.Computer;
import engine.api.Player;

public class EmptyComputer implements Computer {

  @Override
  public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {
    return 0;
  }

}
