package gameCharactorCreaterSystem.builder;

import gameCharactorCreaterSystem.characters.Archer;
import gameCharactorCreaterSystem.characters.GameCharacter;
import gameCharactorCreaterSystem.characters.Mage;
import gameCharactorCreaterSystem.characters.Warrior;
import gameCharactorCreaterSystem.decorator.ArmorDecorator;
import gameCharactorCreaterSystem.decorator.Equipment;
import gameCharactorCreaterSystem.decorator.WeaponDecorator;

import java.util.ArrayList;
import java.util.List;

// Builder pattern: assembles a character step-by-step before creating the final object.
// Allows flexible creation without a constructor explosion.
public class CharacterBuilder {
  private String name    = "Hero";
  private int health     = 100;
  private int attack     = 10;
  private int defense    = 10;
  private String type    = "warrior"; // "warrior" | "mage" | "archer"
  private final List<Equipment> equipmentList = new ArrayList<>();

  public CharacterBuilder setName(String name)     { this.name = name;       return this; }
  public CharacterBuilder setHealth(int health)    { this.health = health;   return this; }
  public CharacterBuilder setAttack(int attack)    { this.attack = attack;   return this; }
  public CharacterBuilder setDefense(int defense)  { this.defense = defense; return this; }
  public CharacterBuilder setType(String type)     { this.type = type;       return this; }

  // Collect equipment to wrap as decorators during build()
  public CharacterBuilder addEquipment(Equipment equipment) {
    equipmentList.add(equipment);
    return this;
  }

  public GameCharacter build() {
    // Create the base character by type
    GameCharacter character;
    switch (type.toLowerCase()) {
      case "mage":   character = new Mage(name, health, attack, defense);   break;
      case "archer": character = new Archer(name, health, attack, defense); break;
      default:       character = new Warrior(name, health, attack, defense);
    }

    // Wrap each piece of equipment as a decorator
    for (Equipment eq : equipmentList) {
      if (eq.getAttackBonus() >= eq.getDefenseBonus()) {
        character = new WeaponDecorator(character, eq);
      } else {
        character = new ArmorDecorator(character, eq);
      }
    }
    return character;
  }
}