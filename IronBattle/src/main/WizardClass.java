import java.util.concurrent.ThreadLocalRandom;
public class Wizard extends Character implements Attacker {
    private int mana;          // 10-50
    private int intelligence;  //  1-50
    public Wizard(String name) {
        super(name);
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        setHp(rnd.nextInt(50, 101));       // 50-100
        this.mana         = rnd.nextInt(10, 51);
        this.intelligence = rnd.nextInt(1, 51);
    }
    public int getMana()         { return mana; }
    public int getIntelligence() { return intelligence; }
    @Override
    public void attack(Character target) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        boolean fireballAttempt = rnd.nextBoolean();   // 50 % intentar fireball
        int damage = 0;
        if (fireballAttempt && mana >= 5) {            // Fireball
            damage = intelligence;
            mana  -= 5;
            log("Fireball   ➜ %d daño (-5 mana)", damage);
        } else if (mana >= 1) {                        // Staff hit /has to be >=1 to have the "0 mana" option
            damage = 2;
            mana  += 1;
            log("Staff hit  ➜ %d daño (+1 mana)", damage);
        } else {                                       // Sin mana
            mana += 2;
            log("Sin mana     0 daño (+2 mana)");
        }
        target.setHp(target.getHp() - damage);
    }
    private void log(String fmt, Object... args) {
        System.out.println("[%s] ".formatted(getName()) + fmt.formatted(args));
    }
}