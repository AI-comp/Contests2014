package engine;

import java.util.ArrayList;

import engine.api.Player;

public class InternalPlayer implements Player {
	private ArrayList<Integer> parameters;

	public InternalPlayer() {
		parameters = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			parameters.add(0);
		}
	}

	public int getParameter(int index) {
		return parameters.get(index);
	}

	public void addParameter(int index) {
		this.parameters.set(index, parameters.get(index) + 1);
	}

}
