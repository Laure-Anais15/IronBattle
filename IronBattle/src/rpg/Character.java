package rpg;

import java.util.UUID;

public abstract class Character implements Attacker {
    final String id;
    final String name;
    private int hp;
    private boolean isAlive = true;

    public Character (String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        //this.isAlive = true;
    }

    public String getName() {
        return name;
    }
    /*public void setName (String name) {
        this.name = name;
    } NEVER USED */

    public int getHp() {
        return hp;
    }
    public void setHp (int hp) {
        this.hp = hp;
        if (this.hp <= 0){
            this.hp = 0;
            this.isAlive = false;
        }
    }

    public boolean isAlive(){
        return isAlive;
    }
    public void setAlive(boolean alive){
        isAlive = alive;
    }

    @Override
    public String toString() {
        return String.format("%s [HP=%d, Alive=%b]", name, hp, isAlive);
    }
}
