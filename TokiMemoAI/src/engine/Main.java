package engine;

public class Main {
  public static void main(String par[]) {
    GameEngine gameEngine = new GameEngine();
    for (int i = 0; i < 20; i++) {
      gameEngine.proceed();
    }
    int winner = gameEngine.getWinner();
    System.out.println("Winner is player " + winner);
  }
}
