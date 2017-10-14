package dsv.inte2017g11.roguelib.Characters;

public class GamePlayer extends AbstractCharacter {

    public GamePlayer(String name, int health, int speed) {
        super(name, health, speed);
    }

    public GamePlayer(String name, int health) {
        super(name, health);
    }

    public GamePlayer(String name) {
        super(name);
    }
}
