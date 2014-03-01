package engine;

import java.util.AbstractMap;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

import engine.api.Computer;
import engine.api.Heroine;
import engine.api.Player;
import engine.api.Player.Command;

public class EmptyComputer implements Computer {

  @Override
  public Entry<Player.Command, Integer> doTurn(int selfId, List<Player> players, List<Heroine> heroines) {
    Random random = new Random();
    return new AbstractMap.SimpleEntry<>(Command.values()[random.nextInt(2)], random.nextInt(3));
  }

}
