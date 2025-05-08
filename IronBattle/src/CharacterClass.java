public abstract class Character {
    private String id;
    private String name;
    private int hp; //add random hp limits depending on wizard/warrior
    private boolean isAlive = true;

    public Character (String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp (int hp) {
        this.hp = hp;
    }
}
