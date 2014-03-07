package engine;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import engine.api.Computer;
import engine.api.Heroine;
import engine.api.Player;
import engine.api.Player.Command;

public class HumanComputer implements Computer {
  GameEngine gameEngine;

  public HumanComputer() {
  }

  public void setGameEngine(GameEngine gameEngine) {
    this.gameEngine = gameEngine;
  }

  @Override
  public Entry<Command, Integer> doTurn(int selfId, List<Player> players, List<Heroine> heroines) {
    System.out.println("*** Player " + selfId + "'s turn.");
    System.out.println();

    gameEngine.outputStatus(false);
    gameEngine.outputPlayer(selfId);

    Scanner scanner = new Scanner(System.in);

    int command = -1;
    while (!(command == 0 || command == 1)) {
      System.out.println("Input your command (0: Training, 1: Dating):");
      command = scanner.nextInt();
    }

    int index = -1;
    while (!(index >= 0 && index < (command == 0 ? players.get(selfId).getParameters().size() : heroines.size()))) {
      System.out.println("Input the target index:");
      index = scanner.nextInt();
    }

    return new AbstractMap.SimpleEntry<>(Command.values()[command], index);
  }
}
