package engine;

import java.util.ArrayList;
import java.util.Random;

public class Heroine {
  private ArrayList<Integer> coefficients;

  public Heroine() {
    coefficients = new ArrayList<Integer>();
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      coefficients.add(random.nextInt(16) - 5);
    }
  }

  public int getEvaluation(InternalPlayer player) {
    int evaluation = 0;
    for (int i = 0; i < coefficients.size(); i++) {
      evaluation += player.getParameter(i) * coefficients.get(i);
    }
    return evaluation;
  }

  public int getCoefficient(int index) {
    return coefficients.get(index);
  }

  public int getMostFavoritePlayer(ArrayList<InternalPlayer> players) {
    int bestPlayer = 0;
    int bestEvaluation = 0;
    for (int i = 0; i < players.size(); i++) {
      int evaluation = getEvaluation(players.get(i));
      if (bestEvaluation < getEvaluation(players.get(i))) {
        bestPlayer = i;
        bestEvaluation = evaluation;
      }
    }
    return bestPlayer;
  }
}
