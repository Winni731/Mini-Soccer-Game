package test;

import model.players.PlayerFactory;
import model.players.Goalkeeper;
import model.players.Striker;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerFactoryTest {
    @Test
    public void gamePlayerEqualsStriker_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        Striker striker = new Striker("Striker", new Color(0, 0, 255));
        assertEquals(playerFactory.getPlayer("Striker").toString(), striker.toString());
    }

    @Test
    public void gamePlayerEqualsStriker_False() {
        PlayerFactory playerFactory = new PlayerFactory();
        Goalkeeper goalkeeper = new Goalkeeper("Goalkeeper", new Color(255, 200, 0));
        assertNotEquals(playerFactory.getPlayer("Striker").toString(), goalkeeper.toString());
    }

    @Test
    public void gamePlayerEqualsGoalkeeper_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        Goalkeeper goalkeeper = new Goalkeeper("Goalkeeper", new Color(255, 200, 0));
        assertEquals(playerFactory.getPlayer("Goalkeeper").toString(), goalkeeper.toString());
    }

    @Test
    public void gamePlayerEqualsGoalkeeper_False() {
        PlayerFactory playerFactory = new PlayerFactory();
        Striker striker = new Striker("Striker", new Color(0, 0, 255));
        assertNotEquals(playerFactory.getPlayer("Goalkeeper").toString(), striker.toString());
    }

    @Test
    public void gamePlayerEqualsNull_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        assertNull(playerFactory.getPlayer("Defender"));
    }

    @Test
    public void gamePlayerEqualsNull_False() {
        PlayerFactory playerFactory = new PlayerFactory();
        assertNotNull(playerFactory.getPlayer("Striker"));
    }
}
