package rpg;

import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character implements Attacker {
    private int stamina; //random between 10-50
    final int strength; // random between 1 and 10

    public Warrior (String name) {
        super(name, ThreadLocalRandom.current().nextInt(100, 201));
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        this.stamina = rnd.nextInt(10, 51);
        this.strength = rnd.nextInt(1, 11);
    }

    /*public int getStamina() {
        return stamina;
    } NEVER USED */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /* public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    } NEVER USED */

    @Override
    public void attack(Character target) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        boolean heavyAttempt = rnd.nextBoolean();

        int damage = 0;
        if (heavyAttempt && stamina >= 5) {
            damage  = strength;
            stamina -= 5;
            log("Heavy attack ⇒ %d dmg (-5 stamina)", damage);
        } else if (stamina >= 1) {
            damage  = strength / 2;
            stamina += 1;
            log("Weak attack ⇒ %d dmg (+1 stamina)", damage);
        } else {
            stamina += 2;
            log("Exhausted ⇒ 0 dmg (+2 stamina)");
        }

        target.setHp(target.getHp() - damage);
    }

    private void log(String fmt, Object... args) {
        System.out.println("[" + getName() + "] " + fmt.formatted(args));
    }

    @Override
    public String toString() {
        return String.format("%s [HP=%d, Stamina=%d, Strength=%d, Alive=%b]",
                getName(), getHp(), stamina, strength, isAlive());
    }
}
