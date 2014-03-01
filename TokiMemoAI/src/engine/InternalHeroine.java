package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import engine.api.Heroine;
import engine.api.Player;

public class InternalHeroine implements Heroine {
  private ArrayList<Integer> coefficients;
  private int volatility;
  private List<Integer> score;

  public InternalHeroine() {
    coefficients = new ArrayList<Integer>();
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      coefficients.add(random.nextInt(10) + 1);
    }
    volatility = 10;
  }

  public void setScore(List<Integer> score) {
    this.score = score;
  }

  public int getEvaluation(InternalPlayer player) {
    int evaluation = 0;
    for (int i = 0; i < coefficients.size(); i++) {
      evaluation += player.getParameter(i) * coefficients.get(i);
    }
    return evaluation;
  }

  @Override
  public int getCoefficient(int index) {
    return coefficients.get(index);
  }

  @Override
  public List<Integer> getCoefficients() {
    return coefficients;
  }

  @Override
  public int getVolatility() {
    return volatility;
  }

  @Override
  public int getScore(Player player) {
    return score.get(player.getIndex());
  }

  public void date(InternalPlayer player) {
    score.set(player.getIndex(), score.get(player.getIndex()) + getEvaluation(player));
    if (volatility > 1) {
      volatility--;
    }
  }

  public int getBestPlayer() {
    int bestPlayer = 0;
    int bestScore = 0;
    for (int i = 0; i < score.size(); i++) {
      if (bestScore < score.get(i)) {
        bestPlayer = i;
        bestScore = score.get(i);
      }
    }
    return bestPlayer;
  }
}
