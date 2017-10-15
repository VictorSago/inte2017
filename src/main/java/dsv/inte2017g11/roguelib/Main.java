package dsv.inte2017g11.roguelib;

public class Main {

/*
@startuml
    abstract class Tile {
        -fields
        +methods()
    }

    class OtherTile {
        -fields
        +methods()
    }

    class GameMap {
        -int sizeX
        -int sizeY
        #Tile[][] tiles
        +isValidPosition(int, int)
        +isFreePosition(int, int)
    }

    abstract class AbstractCharacter {
        -String name
        ..
        -int maxHealth
        -int currentHealth;
        ..
        -int speed;
        -int stepsLeft;
        ..
        -int posX;
        -int posY;
        --
        +setters()
        +getters()
        +otherMethods()
    }

    abstract class Item {
        -fields
        ...
        --
        +methods()
        ...
    }

    GameMap "1" *-d- "1..*" Tile : contains >
    Tile <|-- EmptyTile
    Tile <|-- "More Tile-types"
    Tile <|-- OtherTile
    AbstractCharacter "0..*" - "1" GameMap : is_on >
    AbstractCharacter <|-- Player
    AbstractCharacter <|-- Monster
    AbstractCharacter <|-- NPC

    Monster <|.. "Monster hierarchy"
    Item <|.. "Item hierarchy"
@enduml
*/
    public static void main(String[] args) {
        System.out.println("Rogue!");
    }
}
