package engine;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import engine.api.Computer;
import engine.api.Heroine;
import engine.api.Player;
import engine.api.Player.Command;

public class GameEngine {
  private ArrayList<InternalPlayer> internalPlayers;
  private ArrayList<InternalHeroine> internalHeroines;
  private List<Computer> computers;
  private int turn;

  public GameEngine() {
    this(Arrays.<Computer> asList(new EmptyComputer(), new EmptyComputer(), new EmptyComputer(), new EmptyComputer()));
  }

  public GameEngine(Computer... computers) {
    this(Arrays.asList(computers));
  }

  public GameEngine(List<Computer> computers) {
    this.turn = 0;
    this.computers = computers;

    internalPlayers = new ArrayList<InternalPlayer>();
    for (int i = 0; i < computers.size(); i++) {
      internalPlayers.add(new InternalPlayer(i));
    }

    internalHeroines = new ArrayList<InternalHeroine>();
    for (int i = 0; i < 6; i++) {
      InternalHeroine heroine = new InternalHeroine();
      List<Integer> score = new ArrayList<Integer>();
      for (Player player : internalPlayers) {
        score.add(0);
      }
      heroine.setScore(score);
      internalHeroines.add(heroine);
    }
  }

  public void proceed() {
    turn++;

    ArrayList<Player> players = new ArrayList<Player>();
    for (int i = 0; i < internalPlayers.size(); i++) {
      Player player = internalPlayers.get(i);
      if (player.getCommand() == Command.Dating) {
        players.add(player);
      } else {
        players.add(new InternalPlayer(i));
      }
    }

    ArrayList<Heroine> heroines = new ArrayList<Heroine>();
    for (Heroine heroine : internalHeroines) {
      heroines.add(heroine);
    }

    for (int i = 0; i < computers.size(); i++) {
      Entry<Command, Integer> move;
      try {
        move = computers.get(i).doTurn(i, players, heroines);
      } catch (Exception e) {
        System.out.println(e);
        move = new AbstractMap.SimpleEntry<>(Command.Training, 0);
      }

      InternalPlayer player = internalPlayers.get(i);
      switch (move.getKey()) {
      case Training:
        player.train(move.getValue());
        break;
      case Dating:
        player.date();
        internalHeroines.get(move.getValue()).date(player);
        break;
      }
    }
  }

  public int getWinner() {
    List<Integer> star = new ArrayList<Integer>();
    for (int i = 0; i < internalPlayers.size(); i++) {
      star.add(0);
    }

    for (InternalHeroine heroine : internalHeroines) {
      int bestPlayer = heroine.getBestPlayer();
      star.set(bestPlayer, star.get(bestPlayer) + 1);
    }

    int winner = 0;
    int winnerScore = 0;
    for (int i = 0; i < star.size(); i++) {
      if (winnerScore < star.get(i)) {
        winner = i;
        winnerScore = star.get(i);
      }
    }
    // TODO:tie-break

    return winner;
  }

  public int getTurn() {
    return turn;
  }

  public void outputStatus() {
    System.out.println("Turn " + turn);

    System.out.println("Players' parameters:");
    for (int i = 0; i < internalPlayers.size(); i++) {
      System.out.print("player " + i + ":");
      for (int j = 0; j < 3; j++) {
        System.out.print(" " + internalPlayers.get(i).getParameter(j));
      }
      System.out.println();
    }

    System.out.println("");

    System.out.println("Heroines' coefficients and volatility:");
    for (int i = 0; i < internalHeroines.size(); i++) {
      System.out.print("heroine " + i + ":");
      for (int j = 0; j < 3; j++) {
        System.out.print(" " + internalHeroines.get(i).getCoefficient(j));
      }
      System.out.print(" " + internalHeroines.get(i).getVolatility());
      System.out.println();
    }

    System.out.println("");

    System.out.println("Score:");
    for (int i = 0; i < internalHeroines.size(); i++) {
      System.out.print("heroine " + i + ":");
      for (int j = 0; j < internalPlayers.size(); j++) {
        System.out.print(" " + internalHeroines.get(i).getScore(internalPlayers.get(j)));
      }
      System.out.println("");
    }

    System.out.println("");
    System.out.println("");
  }
}
