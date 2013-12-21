package engine;

import java.util.ArrayList;

import engine.api.Computer;
import engine.api.Player;

public class GameEngine {
  private ArrayList<InternalPlayer> internalPlayers;
  private ArrayList<Heroine> heroines;
  private ArrayList<Computer> computers;
  private int turn;

  public GameEngine() {
    turn = 0;
    internalPlayers = new ArrayList<InternalPlayer>();
    heroines = new ArrayList<Heroine>();
    for (int i = 0; i < 4; i++) {
      heroines.add(new Heroine());
    }
  }

  public void proceed() {
    turn++;
    ArrayList<Integer> mostFavoritePlayers = new ArrayList<Integer>();
    for (Heroine heroine : heroines) {
      mostFavoritePlayers.add(heroine.getMostFavoritePlayer(internalPlayers));
    }

    ArrayList<Player> players = new ArrayList<Player>();
    for (Player player : internalPlayers) {
      players.add(player);
    }

    for (int i = 0; i < computers.size(); i++) {
      int index = computers.get(i).doTurn(i, players, mostFavoritePlayers);
      internalPlayers.get(i).addParameter(index);
    }
  }

  public int getWinner() {
    int winner = 0;
    int winnerScore = 0;
    for (int i = 0; i < internalPlayers.size(); i++) {
      int score = 0;
      for (Heroine heroine : heroines) {
        score += heroine.getEvaluation(internalPlayers.get(i));
      }
      if (winnerScore < score) {
        winner = i;
        winnerScore = score;
      }
    }
    return winner;
  }

  public int getTurn() {
    return turn;
  }

  public void outputStatus() {
    System.out.println("Turn " + turn);

    System.out.println("Players' parameters:");
    for (int i = 0; i < internalPlayers.size(); i++) {
      System.out.print("player " + i + ": ");
      for (int j = 0; j < 3; j++) {
        System.out.print(internalPlayers.get(i).getParameter(j));
      }
    }

    System.out.println("");

    System.out.println("Heroines' coefficients:");
    for (int i = 0; i < heroines.size(); i++) {
      System.out.print("heroine " + i + ": ");
      for (int j = 0; j < internalPlayers.size(); j++) {
        System.out.print(heroines.get(i).getCoefficient(j));
      }
    }

    System.out.println("Heroines' favorite players:");
    for (int i = 0; i < heroines.size(); i++) {
      System.out.print("heroine " + i + ": ");
      int favoritePlayer = heroines.get(i).getMostFavoritePlayer(internalPlayers);
      System.out.print(favoritePlayer + " (" + heroines.get(i).getCoefficient(favoritePlayer) + " pts.)");
    }

    System.out.println("");
  }
}
