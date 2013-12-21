package exkazuu;

import java.util.ArrayList;
import java.util.List;

import engine.EmptyComputer;
import engine.GameEngine;
import engine.api.Computer;
import engine.api.Player;

public class ComputerGrandma implements Computer {

  private static int minValue = -5;
  private static int maxValue = 10;

  private int getFavoritePoint(int[] params, Player player) {
    int result = 0;
    for (int i = 0; i < params.length; i++) {
      result += params[i] * player.getParameter(i);
    }
    return result;
  }

  private boolean isAcceptable(int[] params, List<Player> players, int mostFavoritePlayer) {
    ArrayList<Integer> maxIndices = new ArrayList<Integer>();
    int maxResult = -1;
    int maxIndex = -1;
    for (int i = 0; i < players.size(); i++) {
      Player player = players.get(i);
      int result = getFavoritePoint(params, player);
      if (maxResult <= result) {
        if (maxResult != result) {
          maxIndices.clear();
        }
        maxResult = result;
        maxIndices.add(i);
      }
    }
    return maxIndices.contains(mostFavoritePlayer);
  }

  public int[] assumeCoefficient(List<Player> players, int mostFavoritePlayer) {
    int paramCount = players.get(0).getParameters().size();
    int[] params = new int[paramCount];
    for (int i = 0; i < params.length; i++) {
      params[i] = minValue;
    }
    int[] assumedParams = new int[paramCount];
    int assumedCount = 0;

    int count = (int) (Math.pow(maxValue - minValue, paramCount) + 0.5);
    for (int i = 0; i < count; i++) {
      params[0]++;
      for (int j = 0; j < params.length; j++) {
        if (params[j] > maxValue && j + 1 < params.length) {
          params[j] = minValue;
          params[j + 1]++;
        }
      }

      if (isAcceptable(params, players, mostFavoritePlayer)) {
        for (int j = 0; j < params.length; j++) {
          assumedParams[j] += params[j];
        }
        assumedCount++;
      }
    }
    for (int j = 0; j < params.length; j++) {
      assumedParams[j] /= assumedCount;
      System.out.print(assumedParams[j] + ", ");
    }
    System.out.println();
    return assumedParams;
  }

  @Override
  public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {
    int[] params = new int[players.get(0).getParameters().size()];
    for (Integer mostFavoritePlayer : mostFavoritePlayers) {
      int[] assumeCoefficient = assumeCoefficient(players, mostFavoritePlayer);
      for (int i = 0; i < params.length; i++) {
        params[i] += assumeCoefficient[i];
      }
    }

    int maxValue = -1;
    int maxIndex = -1;
    for (int i = 0; i < params.length; i++) {
      if (maxValue < params[i]) {
        maxValue = params[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  public static void main(String[] args) {
    GameEngine gameEngine = new GameEngine(new EmptyComputer(), new EmptyComputer(), new EmptyComputer(),
        new ComputerGrandma());
    do {
      gameEngine.proceed();
      gameEngine.outputStatus();
    } while (gameEngine.getTurn() < 20);

    int winner = gameEngine.getWinner();
    System.out.println("Winner is player " + winner);
  }
}
