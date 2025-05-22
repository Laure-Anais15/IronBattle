package rpg;

import java.util.*;
import java.net.URL;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("💥🔥 IRON BATTLE 🔥💥\n");
        System.out.println("1) Quick battle (Warrior vs Wizard)");
        System.out.println("2) Fully random battle");
        System.out.println("3) Custom battle (You decide)");
        System.out.print("Choose an option (1-3): ");

        int choice = readOption(1, 3);

        Character p1, p2;

        switch (choice) {
            case 1 -> {
                p1 = new Warrior("Aragorn");
                p2 = new Wizard("Gandalf");
            }
            case 2 -> {
                System.out.println("\n--- Loading characters ---");
                List<Character> loaded = CharacterLoader.loadCharactersFromCSV("characters.csv");

                if (loaded.size() < 2) {
                    System.out.println("❌ Error: Not enough characters in CSV.");
                    return;
                }

                Collections.shuffle(loaded);
                p1 = loaded.get(0);
                p2 = loaded.get(1);

                System.out.println("Character 1: " + p1.getName() + " (" + p1.getClass().getSimpleName() + ")");
                System.out.println("Character 2: " + p2.getName() + " (" + p2.getClass().getSimpleName() + ")");
            }
            case 3 -> {
                System.out.println("\n--- Character 1 ---");
                p1 = createCharacter();

                System.out.println("\n--- Character 2 ---");
                p2 = createCharacter();
            }
            default -> throw new IllegalStateException("Unexpected option: " + choice);
        }

        System.out.println("\n" + p1.getName() + " 🤜 vs 🤛 " + p2.getName());

        Battle battle = new Battle(p1, p2);
        Character winner = battle.fight();

        System.out.println("\n🎆🎇 " + winner.getName() + " has won the battle! 🎇🎆");
    }

    private static int readOption(int min, int max) {
        int option;
        do {
            while (!input.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                input.next();
            }
            option = input.nextInt();
            if (option < min || option > max) {
                System.out.print("Enter a number between " + min + " and " + max + ": ");
            }
        } while (option < min || option > max);
        input.nextLine(); // consume leftover newline
        return option;
    }

    private static Character createCharacter() {
        System.out.print("Enter character name: ");
        String name = input.nextLine().trim();
        if (name.isBlank()) name = "Anonymous";

        System.out.println("Choose class:");
        System.out.println("1) Warrior");
        System.out.println("2) Wizard");
        System.out.print("Option: ");
        int type = readOption(1, 2);

        return (type == 1)
                ? new Warrior(name)
                : new Wizard(name);
    }
}
