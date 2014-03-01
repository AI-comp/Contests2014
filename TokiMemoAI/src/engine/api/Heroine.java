package engine.api;

import java.util.List;

public interface Heroine {
  public int getCoefficient(int index);

  public List<Integer> getCoefficients();
  
  public int getVolatility();
  
  public int getScore(Player player);
}
