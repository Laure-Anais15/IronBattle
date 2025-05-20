package rpg;

import java.util.concurrent.ThreadLocalRandom;

public class Wizard extends Character implements Attacker {
    private int mana;          // 10-50
    final int intelligence;  //  1-50

    public Wizard(String name) {
        super(name, ThreadLocalRandom.current().nextInt(50,101)); //HP between 50 and 100
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        this.mana         = rnd.nextInt(10, 51);
        this.intelligence = rnd.nextInt(1, 51);
    }
    /*public int getMana()         { return mana; }
    public int getIntelligence() { return intelligence; } NEVER USED */

    public void setMana(int mana){
        this.mana = mana;
    }

    @Override
    public void attack(Character target) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        boolean fireballAttempt = rnd.nextBoolean();   // 50 % try fireball
        int damage = 0;

        if (fireballAttempt && mana >= 5) {            // Fireball
            damage = intelligence;
            mana  -= 5;
            log("Fireball ➜ %d damage (-5 mana)", damage);
        } else if (mana >= 1) {                        // Staff hit /has to be >=1 to have the "0 mana" option
            damage = 2;
            mana  += 1;
            log("Staff hit ➜ %d damage (+1 mana)", damage);
        } else {                                       // Sin mana
            mana += 2;
            log("No mana left ➜ 0 damage (+2 mana)");
        }
        target.setHp(target.getHp() - damage);
    }
    private void log(String fmt, Object... args) {
        System.out.println("[%s] ".formatted(getName()) + fmt.formatted(args));
    }

    @Override
    public String toString() {
        return String.format("%s [HP=%d, Mana=%d, Intelligence=%d, Alive=%b]",
                getName(), getHp(), mana, intelligence, isAlive());
    }
}