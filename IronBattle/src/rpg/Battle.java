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
        System.out.println("\n*** ¡COMIENZA EL DUELO! ***");
        int round = 1;

        while (true) {
            System.out.printf("\n-- Ronda %d --%n", round++);
            // Ambos calculan su acción ANTES de aplicar daño
            a.attack(b);
            b.attack(a);

            System.out.printf("Estado: %s | %s%n", a, b);

            if (!a.isAlive() && !b.isAlive()) {
                System.out.println("\n¡Empate! Se reinicia el combate");
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
            w.setStamina(10 + RND.nextInt(41)); // delete?
        }
        if (c instanceof Wizard  m) {
            m.setHp(50  + RND.nextInt(51));
            m.setMana(10 + RND.nextInt(41)); //delete?
        }
        c.setAlive(true); // delete?
    }
}