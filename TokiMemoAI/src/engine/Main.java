package engine;

import java.util.ArrayList;
import java.util.List;

import engine.api.Computer;

public class Main {
  public static void main(String par[]) {
    List<Computer> computers = new ArrayList<Computer>();
    List<HumanComputer> humanComputers = new ArrayList<HumanComputer>();
    for (int i = 0; i < 1; i++) {
      HumanComputer humanComputer = new HumanComputer();
      humanComputers.add(humanComputer);
      computers.add(humanComputer);
    }
    for (int i = 0; i < 3; i++) {
      computers.add(new EmptyComputer());
    }

    GameEngine gameEngine = new GameEngine(computers);

    for (HumanComputer humanComputer : humanComputers) {
      humanComputer.setGameEngine(gameEngine);
    }

    do {
      gameEngine.proceed();
      gameEngine.outputStatus(true);
    } while (gameEngine.getTurn() < 20);

    int winner = gameEngine.getWinner();
    System.out.println("Winner is player " + winner);
  }
}
