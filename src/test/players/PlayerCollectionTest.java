package test.players;

import model.players.PlayerFactory;
import model.players.GamePlayer;
import model.players.PlayerCollection;
import model.players.PlayerCollectionIterator;
import model.players.PlayerStatistics;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerCollectionTest {
    @Test
    public void playersSizeEqualsOne_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));

        assertEquals(playerCollection.size(), 1);
    }

    @Test
    public void playersSizeNotEqualsOne_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));
        playerCollection.add(playerFactory.getPlayer("Striker"));

        assertNotEquals(playerCollection.size(), 1);
    }

    @Test
    public void playersEmpty_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        GamePlayer striker = playerFactory.getPlayer("Striker");
        playerCollection.add(striker);
        playerCollection.remove(striker);

        assertTrue(playerCollection.isEmpty());
    }

    @Test
    public void playersEmpty_False() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        GamePlayer striker = playerFactory.getPlayer("Striker");
        playerCollection.add(striker);

        assertFalse(playerCollection.isEmpty());
    }

    @Test
    public void playersContains_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        GamePlayer striker = playerFactory.getPlayer("Striker");
        playerCollection.add(striker);

        assertTrue(playerCollection.contains(striker));
    }

    @Test
    public void playersContains_False() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        GamePlayer striker = playerFactory.getPlayer("Striker");
        playerCollection.add(striker);

        assertFalse(playerCollection.contains(playerFactory.getPlayer("Goalkeeper")));
    }

    @Test
    public void playersContainsNull_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();
        assertFalse(playerCollection.contains(playerFactory.getPlayer("Defender")));
    }

    @Test
    public void playersContainsWrongInstance_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        assertFalse(playerCollection.contains(new PlayerStatistics()));
    }

    @Test
    public void playerCollectionHasIterator_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        Iterator<GamePlayer> iterator = playerCollection.iterator();
        assertTrue(iterator instanceof PlayerCollectionIterator);
    }

    @Test
    public void playerCollectionObjectArray_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));
        Object[] array = playerCollection.toArray();
        assertNotNull(array);
    }

    @Test
    public void playerCollectionGenericArray_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));
        GamePlayer[] array = playerCollection.toArray(new GamePlayer[0]);

        assertNotNull(array);
    }

    @Test
    public void playerCollectionRemoveNull_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();
        assertFalse(playerCollection.remove(playerFactory.getPlayer("Defender")));
    }

    @Test
    public void playerCollectionRemoveWrongInstance_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        assertFalse(playerCollection.remove(new PlayerStatistics()));
    }

    @Test
    public void playerCollectionRemove_False() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();
        assertFalse(playerCollection.remove(playerFactory.getPlayer("Striker")));
    }

    @Test
    public void playerCollectionContainsAll_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        List<GamePlayer> list = new ArrayList<>();
        GamePlayer player = playerFactory.getPlayer("Striker");
        playerCollection.add(player);
        list.add(player);

        assertTrue(playerCollection.containsAll(list));
    }

    @Test
    public void playerCollectionContainsAll_False() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        List<GamePlayer> list = new ArrayList<>();
        GamePlayer player = playerFactory.getPlayer("Striker");
        GamePlayer player2 = playerFactory.getPlayer("Goalkeeper");
        playerCollection.add(player);
        list.add(player2);

        assertFalse(playerCollection.containsAll(list));
    }

    @Test
    public void playerCollectionAddAll_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        List<GamePlayer> list = new ArrayList<>();
        GamePlayer player = playerFactory.getPlayer("Striker");
        list.add(player);

        assertTrue(playerCollection.addAll(list));
    }

    @Test
    public void playerCollectionRemoveAll_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        List<GamePlayer> list = new ArrayList<>();
        GamePlayer player = playerFactory.getPlayer("Striker");
        playerCollection.add(player);
        list.add(player);

        playerCollection.removeAll(list);
        assertTrue(playerCollection.isEmpty());
    }

    @Test
    public void playerCollectionRetainAll_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        List<GamePlayer> list = new ArrayList<>();
        GamePlayer player = playerFactory.getPlayer("Striker");
        GamePlayer player2 = playerFactory.getPlayer("Goalkeeper");

        playerCollection.add(player);
        playerCollection.add(player2);
        list.add(player);

        assertTrue(playerCollection.retainAll(list));
    }

    @Test
    public void playerCollectionClear_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));

        playerCollection.clear();
        assertTrue(playerCollection.isEmpty());
    }

    @Test
    public void playerCollectionGamePlayerGetIndex_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));

        assertNotNull(playerCollection.get(0));
    }

    @Test
    public void playerCollectionGamePlayerGet_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));

        assertNotNull(playerCollection.get("Striker"));
    }

    @Test
    public void playerCollectionGamePlayerGet_False() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        playerCollection.add(playerFactory.getPlayer("Striker"));

        assertNull(playerCollection.get("Goalkeeper"));
    }

    @Test
    public void playerCollectionSort_True() {
        PlayerCollection playerCollection = new PlayerCollection();
        PlayerFactory playerFactory = new PlayerFactory();

        GamePlayer goalkeeper = playerFactory.getPlayer("Goalkeeper");
        GamePlayer striker = playerFactory.getPlayer("Striker");

        goalkeeper.setPlayerStatistics(2);
        striker.setPlayerStatistics(10);

        playerCollection.add(goalkeeper);
        playerCollection.add(striker);

        playerCollection.sort();

        assertTrue(playerCollection.get(0).equals(striker) && playerCollection.get(1).equals(goalkeeper));
    }
}