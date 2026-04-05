package gameCharactorCreaterSystem.decorator;

import gameCharactorCreaterSystem.characters.GameCharacter;

// Decorator that equips a weapon, boosting attack
public class WeaponDecorator extends CharacterDecorator {
  private final Equipment weapon;

  public WeaponDecorator(GameCharacter character, Equipment weapon) {
    super(character);
    this.weapon = weapon;
  }

  @Override protected int getEquipmentAttackBonus()  { return weapon.getAttackBonus(); }
  @Override protected int getEquipmentDefenseBonus() { return weapon.getDefenseBonus(); }

  // Clone the inner character first, then re-wrap with the same weapon
  @Override
  public GameCharacter clone() {
    return new WeaponDecorator(wrapped.clone(), weapon);
  }

  @Override
  public String getDescription() {
    return wrapped.getDescription() + " + [Weapon: " + weapon.getDescription() + "]";
  }
}