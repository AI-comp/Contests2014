package engine;

public class Main {
  public static void main(String par[]) {
    GameEngine gameEngine = new GameEngine();
    do {
      gameEngine.proceed();
      gameEngine.outputStatus();
    } while (gameEngine.getTurn() < 20);

    int winner = gameEngine.getWinner();
    System.out.println("Winner is player " + winner);
  }
}
