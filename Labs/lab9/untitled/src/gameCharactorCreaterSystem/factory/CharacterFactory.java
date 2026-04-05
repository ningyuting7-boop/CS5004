package gameCharactorCreaterSystem.factory;

import gameCharactorCreaterSystem.characters.GameCharacter;

// Factory Method pattern: each subclass decides which concrete character to create
public abstract class CharacterFactory {
  public abstract GameCharacter createCharacter();
}