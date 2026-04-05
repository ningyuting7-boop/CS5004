package gameCharactorCreaterSystem.factory;

import gameCharactorCreaterSystem.characters.GameCharacter;
import gameCharactorCreaterSystem.characters.Warrior;
import gameCharactorCreaterSystem.decorator.ArmorDecorator;
import gameCharactorCreaterSystem.decorator.Shield;

// Tank template: high HP and defense, low attack
public class TankFactory extends CharacterFactory {
  @Override
  public GameCharacter createCharacter() {
    GameCharacter base = new Warrior("Tank Warrior", 200, 15, 30);
    return new ArmorDecorator(base, new Shield("Iron Shield", 20));
  }
}