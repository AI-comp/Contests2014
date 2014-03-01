package engine.api;

import java.util.List;

public interface Player {
  public enum Command {
    Training, Dating,
  }

  public int getParameter(int index);

  public List<Integer> getParameters();

  public int getIndex();

  public Command getCommand();
}
