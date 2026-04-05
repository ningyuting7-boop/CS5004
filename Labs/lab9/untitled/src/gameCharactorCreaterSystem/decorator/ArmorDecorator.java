package gameCharactorCreaterSystem.decorator;

import gameCharactorCreaterSystem.characters.GameCharacter;

// Decorator that equips armor, boosting defense
public class ArmorDecorator extends CharacterDecorator {
  private final Equipment armor;

  public ArmorDecorator(GameCharacter character, Equipment armor) {
    super(character);
    this.armor = armor;
  }

  @Override protected int getEquipmentAttackBonus()  { return armor.getAttackBonus(); }
  @Override protected int getEquipmentDefenseBonus() { return armor.getDefenseBonus(); }

  @Override
  public GameCharacter clone() {
    return new ArmorDecorator(wrapped.clone(), armor);
  }

  @Override
  public String getDescription() {
    return wrapped.getDescription() + " + [Armor: " + armor.getDescription() + "]";
  }
}