package gumfum;

import java.util.List;
import java.util.Random;

import engine.api.Computer;
import engine.api.Player;

public class Saboteur implements Computer {
  private int turn, vote;

  public Saboteur() {
    turn = 0;
  }

  public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {
    if (turn == 0) {
      vote = new Random().nextInt(players.get(0).getParameters().size());
    } else if (turn == 1) {
      int hp[] = new int[players.size()];
      for (Integer i : mostFavoritePlayers) {
        hp[i]++;
      }
      int maxPlayer = -1, maxHp = -1;
      for (int i = 0; i < mostFavoritePlayers.size(); i++) {
        if (maxHp < hp[i]) {
          maxHp = hp[i];
          maxPlayer = i;
        }
      }
      List<Integer> list = players.get(maxPlayer).getParameters();
      for(int i = 0; i < list.size(); i++) {
        if(list.get(i) == 1) {
          vote = i;
          break;
        }
      }
    }
    turn++;

    return vote;
  }
}
