public class Warrior extends Character implements Attacker {
    private int stamina; //random between 10-50
    private int strength; // random between 1 and 10

    public Warrior (String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

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
}
