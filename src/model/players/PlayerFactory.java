package model.players;

import java.awt.*;

public class PlayerFactory {
    public GamePlayer getPlayer(String type) {
        if (type.equalsIgnoreCase("striker")) {
            return new Striker("Striker", new Color(0, 0, 255));
        } else if (type.equalsIgnoreCase("goalkeeper")) {
            return new Goalkeeper("Goalkeeper", new Color(255, 200, 0));
        } else return null;
    }
}