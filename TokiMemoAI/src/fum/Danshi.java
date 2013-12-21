package fum;

import java.util.ArrayList;
import java.util.List;

import engine.GameEngine;
import engine.api.Computer;
import engine.api.Player;


public class Danshi implements Computer{
	
	private int getParameterRank(Player mfp, List<Player> players) {
		int paramID = 0;
		int i, j;
		int mostGoodRank = players.size();
		int tmpRank = 0;
		List<Integer> params = mfp.getParameters();
		for(i=0; i<params.size(); i++) {
			tmpRank = 0;
			for(j=0; j<players.size(); j++) {
				if(params.get(i) < players.get(j).getParameter(i)) {
					tmpRank++;
				}
			}
			if(mostGoodRank > tmpRank) {
				mostGoodRank = tmpRank;
				paramID = i;
			}
		}
		return paramID;
	}
	
	private int getFinalParam(List<Integer> results, int paramNumber){
		int paramID = 0;
		int tmpParamCount = 0;
		int paramCount = 0;
		int i, j;
		for(i=0; i<paramNumber; i++) {
			tmpParamCount = 0;
			for(j=0; j<results.size(); j++) {
				if(i == results.get(j)){
					tmpParamCount++;
				}
			}
			if(paramCount < tmpParamCount) {
				paramCount = tmpParamCount;
				paramID = i;
			}
		}
		return paramID;
	}
	
	public int doTurn(int selfId, List<Player> players, List<Integer> mostFavoritePlayers) {
		int i;
		int paramNumber = 0;
		List<Integer> results = new ArrayList<Integer>();
		for(i = 0; i < mostFavoritePlayers.size(); i++) {
			Player mfp = players.get(mostFavoritePlayers.get(i));
			paramNumber = mfp.getParameters().size();
			results.add(getParameterRank(mfp, players));
		}
		return getFinalParam(results, paramNumber);
	}
	
	public static void main(String[] args) {
	    GameEngine gameEngine = new GameEngine();
	    do {
	      gameEngine.proceed();
	      gameEngine.outputStatus();
	    } while (gameEngine.getTurn() < 20);

	    int winner = gameEngine.getWinner();
	    System.out.println("Winner is player " + winner);
	  }
}
