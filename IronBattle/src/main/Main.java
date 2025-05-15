public class Main {
    public static void main(String[] args) {

        // 1. Create characters
        Warrior w = new Warrior("Aragorn", 150, 30, 8);
        Wizard  m = new Wizard ("Gandalf",  90, 25, 40);

        // 2. Launch the battle
        Battle duel = new Battle(w, m);
        Character winner = duel.fight();

        // 3. Display the result
        System.out.println("\nWINNER: " + winner.getName() + "!");
    }
}
