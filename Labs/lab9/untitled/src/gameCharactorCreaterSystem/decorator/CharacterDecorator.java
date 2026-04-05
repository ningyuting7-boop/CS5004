package gameCharactorCreaterSystem.decorator;

import gameCharactorCreaterSystem.characters.GameCharacter;

// Abstract base decorator: wraps a GameCharacter and delegates all stat queries to it.
// Subclasses override getAttack()/getDefense() to add equipment bonuses on top.
public abstract class CharacterDecorator extends GameCharacter {
  protected GameCharacter wrapped;

  public CharacterDecorator(GameCharacter character) {
    super(character.getName(), character.getHealth(), character.getAttack(), character.getDefense());
    this.wrapped = character;
  }

  // Delegate to wrapped so stacked decorators chain correctly
  @Override public String getName()  { return wrapped.getName(); }
  @Override public int getHealth()   { return wrapped.getHealth(); }
  @Override public int getAttack()   { return wrapped.getAttack() + getEquipmentAttackBonus(); }
  @Override public int getDefense()  { return wrapped.getDefense() + getEquipmentDefenseBonus(); }

  protected abstract int getEquipmentAttackBonus();
  protected abstract int getEquipmentDefenseBonus();
}