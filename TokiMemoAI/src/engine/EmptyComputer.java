package engine;

import java.util.List;
import java.util.Random;

import engine.api.Computer;
import engine.api.Player;

public class EmptyComputer implements Computer {

  @Override
  public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {
    Random random = new Random();
    return random.nextInt(3);
  }

}
