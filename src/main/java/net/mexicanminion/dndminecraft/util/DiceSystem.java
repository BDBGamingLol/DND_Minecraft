package net.mexicanminion.dndminecraft.util;

public class DiceSystem {

	int result;
	int amount;
	int dice;

	public DiceSystem() {
		result = 0;
		amount = 0;
		dice = 0;
	}

	public int rollDie(int dice) {
		int result = (int) (Math.random() * dice) + 1;
		return result;
	}

	private boolean checkDice(int dice) {
		return dice == 4 || dice == 6 || dice == 8 || dice == 10 || dice == 12 || dice == 20 || dice == 100;
	}

	public int rollDice(int amount, int dice) {
		result = 0;
		if (!checkDice(dice)) {
			throw new RuntimeException("Invalid dice value");
		}

		for (int i = 0; i < amount; i++) {
			result += rollDie(dice);
		}
		return result;
	}

}
