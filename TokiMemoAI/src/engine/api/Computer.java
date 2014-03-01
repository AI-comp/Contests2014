package engine.api;

import java.util.List;
import java.util.Map.Entry;

public interface Computer {
  Entry<Player.Command, Integer> doTurn(int selfId, List<Player> players, List<Heroine> heroines);
}
