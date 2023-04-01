package net.mexicanminion.dndminecraft.character;

public class CharStats {

	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;

	public CharStats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}

	public int getModifier(int stat){
		return (int) Math.floor((stat - 10) / 2);
	}

	public int getSavingThrow(int stat, boolean proficient){
		if (proficient){
			return getModifier(stat) + getProficiencyBonus();
		}
		return getModifier(stat);
	}

	public int getProficiencyBonus(){
		//TODO: Implement this
		//https://roll20.net/compendium/dnd5e/Character%20Advancement#content
		return 2;
	}

	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

}
