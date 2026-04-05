package gameCharactorCreaterSystem.decorator;

// Concrete armor equipment: adds defense bonus
public class Shield implements Equipment {
  private final String name;
  private final int defenseBonus;

  public Shield(String name, int defenseBonus) {
    this.name = name;
    this.defenseBonus = defenseBonus;
  }

  @Override public int getAttackBonus()  { return 0; }
  @Override public int getDefenseBonus() { return defenseBonus; }
  @Override public String getDescription() { return name + "(+" + defenseBonus + " DEF)"; }
}