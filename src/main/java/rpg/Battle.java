package rpg;

import java.util.Random;

public class Battle {
    private final Character a;
    private final Character b;
    private static final Random RND = new Random();

    public Battle(Character a, Character b) {
        this.a = a;
        this.b = b;
    }
    public Character fight() {
        System.out.println("\n*** LET THE BATTLE BEGIN! ***");
        int round = 1;

        while (true) {
            System.out.printf("\n-- Round %d --%n", round++);
            a.attack(b);
            b.attack(a);

            System.out.printf("Status: %s | %s%n", a, b);

            if (!a.isAlive() && !b.isAlive()) {
                System.out.println("\nDraw! Resetting battle…");
                resetStats(a);
                resetStats(b);
                round = 1;
                continue;
            }
            if (!a.isAlive()) return b;
            if (!b.isAlive()) return a;
        }
    }

    private void resetStats(Character c) {
        if (c instanceof Warrior w) {
            w.setHp(100 + RND.nextInt(101));
            w.setStamina(10 + RND.nextInt(41));
        }
        if (c instanceof Wizard  m) {
            m.setHp(50  + RND.nextInt(51));
            m.setMana(10 + RND.nextInt(41));
        }
        c.setAlive(true);
    }
}