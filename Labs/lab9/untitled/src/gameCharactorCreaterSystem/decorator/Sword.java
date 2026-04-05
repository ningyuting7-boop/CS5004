package gameCharactorCreaterSystem.decorator;

// Concrete weapon equipment: adds attack bonus
public class Sword implements Equipment {
  private final String name;
  private final int attackBonus;

  public Sword(String name, int attackBonus) {
    this.name = name;
    this.attackBonus = attackBonus;
  }

  @Override public int getAttackBonus()  { return attackBonus; }
  @Override public int getDefenseBonus() { return 0; }
  @Override public String getDescription() { return name + "(+" + attackBonus + " ATK)"; }
}