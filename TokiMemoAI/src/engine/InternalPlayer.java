package engine;

import java.util.ArrayList;
import java.util.List;

import engine.api.Heroine;
import engine.api.Player;

public class InternalPlayer implements Player {
  private ArrayList<Integer> parameters;
  private int index;
  private Command command;

  public InternalPlayer(int index) {
    this(index, Command.Training);
  }

  public InternalPlayer(int index, Command command) {
    this.index = index;
    parameters = new ArrayList<Integer>();
    for (int i = 0; i < 3; i++) {
      parameters.add(0);
    }
    this.command = command;
  }

  @Override
  public int getParameter(int index) {
    return parameters.get(index);
  }

  public void train(int index) {
    this.parameters.set(index, parameters.get(index) + 1);
    this.command = Command.Training;
  }

  public void date() {
    this.command = Command.Dating;
  }

  @Override
  public List<Integer> getParameters() {
    return this.parameters;
  }

  @Override
  public int getIndex() {
    return index;
  }

  @Override
  public Command getCommand() {
    return command;
  }
}
