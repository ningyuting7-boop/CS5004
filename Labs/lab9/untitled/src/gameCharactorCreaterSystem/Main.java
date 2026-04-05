package gameCharactorCreaterSystem;

import gameCharactorCreaterSystem.builder.CharacterBuilder;
import gameCharactorCreaterSystem.characters.GameCharacter;
import gameCharactorCreaterSystem.decorator.Shield;
import gameCharactorCreaterSystem.decorator.Sword;
import gameCharactorCreaterSystem.factory.CharacterFactory;
import gameCharactorCreaterSystem.factory.DpsFactory;
import gameCharactorCreaterSystem.factory.SupportFactory;
import gameCharactorCreaterSystem.factory.TankFactory;
import gameCharactorCreaterSystem.manager.CharacterManager;

public class Main {
  public static void main(String[] args) {

    CharacterManager manager = new CharacterManager();

    // --- Factory Method Pattern ---
    // Each factory subclass decides which character archetype to create
    System.out.println("=== Factory Method Pattern ===");
    CharacterFactory tankFactory    = new TankFactory();
    CharacterFactory dpsFactory     = new DpsFactory();
    CharacterFactory supportFactory = new SupportFactory();

    GameCharacter tank    = tankFactory.createCharacter();
    GameCharacter dps     = dpsFactory.createCharacter();
    GameCharacter support = supportFactory.createCharacter();

    System.out.println(tank.getDescription());
    System.out.println(dps.getDescription());
    System.out.println(support.getDescription());

    // --- Builder Pattern ---
    // Build a custom character step-by-step, including equipment
    System.out.println("\n=== Builder Pattern ===");
    GameCharacter customMage = new CharacterBuilder()
        .setType("mage")
        .setName("Gandalf")
        .setHealth(90)
        .setAttack(50)
        .setDefense(15)
        .addEquipment(new Sword("Staff of Power", 25))
        .addEquipment(new Shield("Arcane Ward", 10))
        .build();

    System.out.println(customMage.getDescription());
    System.out.println("  Final ATK: " + customMage.getAttack() + " | Final DEF: " + customMage.getDefense());

    // --- Prototype Pattern ---
    // Clone an existing character and give the copy a different name
    System.out.println("\n=== Prototype Pattern ===");
    GameCharacter tankClone = manager.cloneAndRename(tank, "Clone Warrior");
    System.out.println("Original: " + tank.getDescription());
    System.out.println("Clone:    " + tankClone.getDescription());
    System.out.println("Different objects: " + (tank != tankClone));

    // --- Decorator Pattern ---
    // Layer equipment on a character at runtime without changing its class
    System.out.println("\n=== Decorator Pattern ===");
    System.out.println("Base support:          " + support.getDescription());

    GameCharacter geared = manager.equipWeapon(support, "Healing Rod", 10);
    System.out.println("With weapon:           " + geared.getDescription());

    GameCharacter fullyGeared = manager.equipArmor(geared, "Mage Robe", 15);
    System.out.println("With weapon + armor:   " + fullyGeared.getDescription());
    System.out.println("  Final ATK: " + fullyGeared.getAttack() + " | Final DEF: " + fullyGeared.getDefense());

    // --- Final Roster ---
    System.out.println("\n=== Final Roster ===");
    manager.addCharacter(tank);
    manager.addCharacter(dps);
    manager.addCharacter(customMage);
    manager.addCharacter(fullyGeared);
    manager.printRoster();
  }
}