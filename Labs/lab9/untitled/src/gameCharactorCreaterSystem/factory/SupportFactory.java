package gameCharactorCreaterSystem.factory;

import gameCharactorCreaterSystem.characters.GameCharacter;
import gameCharactorCreaterSystem.characters.Mage;

// Support template: balanced stats, no heavy equipment
public class SupportFactory extends CharacterFactory {
  @Override
  public GameCharacter createCharacter() {
    return new Mage("Support Mage", 100, 20, 20);
  }
}