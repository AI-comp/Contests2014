package enixer;

import java.util.List;
import java.util.Random;

import engine.api.Computer;
import engine.api.Player;

public class Ikemen implements Computer {
  private int turn;

  public Ikemen() {
    turn = 0;
  }

  @Override
  public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {
    turn++;
    return turn % players.get(0).getParameters().size();
  }

}
