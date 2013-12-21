package exkazuu;

import java.util.List;

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
    int maxResult = -1;
    int maxIndex = -1;
    for (int i = 0; i < players.size(); i++) {
      Player player = players.get(i);
      int result = getFavoritePoint(params, player);
      if (maxResult < result) {
        maxResult = result;
        maxIndex = i;
      }
    }
    return maxIndex == mostFavoritePlayer;
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
          params[j] = 0;
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
    }
    return assumedParams;
  }

  @Override
  public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {

    return 0;
  }
}
