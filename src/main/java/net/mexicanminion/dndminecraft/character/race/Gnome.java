package net.mexicanminion.dndminecraft.character.race;

import java.util.HashMap;

public class Gnome implements RaceType{

	String name;
	int subRace;
	String traits;
	String subRaceTraits;
	HashMap<String, Integer> abilityScoreIncrease = new HashMap<>();

	public Gnome(String name, int subRace) {
		this.name = name;
		this.subRace = subRace;
		abilityScoreIncrease.put("intelligence", 2);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSubRace() {
		return subRace;
	}

	@Override
	public HashMap getAbilityScoreIncrease(int subRace) {
		if (subRace == 2)
			abilityScoreIncrease.put("constitution", 1);
		return abilityScoreIncrease;
	}

	@Override
	public int getSize() {
		//size small
		return 1;
	}

	@Override
	public int getSpeed() {
		//walking speed 25 feet
		return 25;
	}

	@Override
	public int getDarkvision() {
		//darkvision 60 feet
		return 60;
	}
}
