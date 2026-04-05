package gameCharactorCreaterSystem.factory;

import gameCharactorCreaterSystem.characters.Archer;
import gameCharactorCreaterSystem.characters.GameCharacter;
import gameCharactorCreaterSystem.decorator.Sword;
import gameCharactorCreaterSystem.decorator.WeaponDecorator;

// DPS template: high attack, medium HP, low defense
public class DpsFactory extends CharacterFactory {
  @Override
  public GameCharacter createCharacter() {
    GameCharacter base = new Archer("DPS Archer", 120, 35, 10);
    return new WeaponDecorator(base, new Sword("Eagle Bow", 20));
  }
}