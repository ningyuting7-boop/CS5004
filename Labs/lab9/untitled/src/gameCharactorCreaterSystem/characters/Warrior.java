package gameCharactorCreaterSystem.characters;

public class Warrior extends GameCharacter {
  public Warrior(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  // Prototype: create a deep copy of this warrior
  @Override
  public GameCharacter clone() {
    return new Warrior(this.name, this.health, this.attack, this.defense);
  }

  @Override
  public String getDescription() {
    return "[Warrior] " + name + " | HP: " + health + " | ATK: " + attack + " | DEF: " + defense;
  }
}