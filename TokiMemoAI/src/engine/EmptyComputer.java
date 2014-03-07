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
    Command command = Command.values()[random.nextInt(2)];
    int index = 0;
    switch (command) {
    case Training:
      index = random.nextInt(players.get(selfId).getParameters().size());
      break;
    case Dating:
      index = random.nextInt(heroines.size());
      break;
    }
    return new AbstractMap.SimpleEntry<>(command, index);
  }
}
