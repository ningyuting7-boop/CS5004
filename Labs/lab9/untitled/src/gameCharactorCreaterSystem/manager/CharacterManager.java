package gameCharactorCreaterSystem.manager;

import gameCharactorCreaterSystem.characters.GameCharacter;
import gameCharactorCreaterSystem.decorator.ArmorDecorator;
import gameCharactorCreaterSystem.decorator.Shield;
import gameCharactorCreaterSystem.decorator.Sword;
import gameCharactorCreaterSystem.decorator.WeaponDecorator;

import java.util.ArrayList;
import java.util.List;

// Manages a roster of characters; demonstrates clone and decoration in one place
public class CharacterManager {
  private final List<GameCharacter> roster = new ArrayList<>();

  public void addCharacter(GameCharacter character) {
    roster.add(character);
  }

  // Prototype: clone an existing character and give it a new name
  public GameCharacter cloneAndRename(GameCharacter original, String newName) {
    GameCharacter copy = original.clone();
    copy.setName(newName);
    return copy;
  }

  // Equip a weapon on any character without modifying the original
  public GameCharacter equipWeapon(GameCharacter character, String weaponName, int attackBonus) {
    return new WeaponDecorator(character, new Sword(weaponName, attackBonus));
  }

  // Equip armor on any character without modifying the original
  public GameCharacter equipArmor(GameCharacter character, String armorName, int defenseBonus) {
    return new ArmorDecorator(character, new Shield(armorName, defenseBonus));
  }

  public void printRoster() {
    System.out.println("--- Current Roster ---");
    roster.forEach(c -> System.out.println(c.getDescription()));
  }
}