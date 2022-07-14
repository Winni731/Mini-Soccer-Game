package test.players;

import model.players.PlayerStatistics;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PlayerStatisticsTest {
    @Test
    public void initializedToZero_True() {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        assertEquals(playerStatistics.getStatistics(), new Integer(0));
    }

    @Test
    public void initializedToNotZero_False() {
        PlayerStatistics playerStatistics = new PlayerStatistics();

        Random random = new Random();
        int number = random.nextInt() + 1;

        assertNotEquals(playerStatistics.getStatistics(), new Integer(number));
    }

    @Test
    public void getStatisticsEqualsOne_True() {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        playerStatistics.setStatistics(1);
        assertEquals(playerStatistics.getStatistics(), new Integer(1));
    }

    @Test
    public void getStatisticsNotEqualsOne_False() {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        assertNotEquals(playerStatistics.getStatistics(), new Integer(1));
    }

    @Test
    public void toStringEqualsOne_True() {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        playerStatistics.setStatistics(1);
        assertEquals(playerStatistics.toString(), "1");
    }

    @Test
    public void toStringNotEqualsOne_False() {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        playerStatistics.setStatistics(2);
        assertNotEquals(playerStatistics.toString(), "1");
    }

    @Test
    public void compareToEqualsZero_True() {
        PlayerStatistics playerStatistics1 = new PlayerStatistics();
        PlayerStatistics playerStatistics2 = new PlayerStatistics();

        assertEquals(playerStatistics1.compareTo(playerStatistics2), 0);
    }

    @Test
    public void compareToEqualsZero_False() {
        PlayerStatistics playerStatistics1 = new PlayerStatistics();
        PlayerStatistics playerStatistics2 = new PlayerStatistics();

        playerStatistics1.setStatistics(1);

        assertNotEquals(playerStatistics1.compareTo(playerStatistics2), 0);
    }

    @Test
    public void compareToEqualsNegativeOne_True() {
        PlayerStatistics playerStatistics1 = new PlayerStatistics();
        PlayerStatistics playerStatistics2 = new PlayerStatistics();

        playerStatistics2.setStatistics(1);

        assertEquals(playerStatistics1.compareTo(playerStatistics2), -1);
    }

    @Test
    public void compareToEqualsNegativeOne_False() {
        PlayerStatistics playerStatistics1 = new PlayerStatistics();
        PlayerStatistics playerStatistics2 = new PlayerStatistics();

        playerStatistics2.setStatistics(1);

        assertEquals(playerStatistics1.compareTo(playerStatistics2), -1);
    }

    @Test
    public void compareToEqualsOne_True() {
        PlayerStatistics playerStatistics1 = new PlayerStatistics();
        PlayerStatistics playerStatistics2 = new PlayerStatistics();

        playerStatistics1.setStatistics(1);

        assertEquals(playerStatistics1.compareTo(playerStatistics2), 1);
    }

    @Test
    public void compareToEqualsOne_False() {
        PlayerStatistics playerStatistics1 = new PlayerStatistics();
        PlayerStatistics playerStatistics2 = new PlayerStatistics();

        playerStatistics1.setStatistics(1);

        assertEquals(playerStatistics1.compareTo(playerStatistics2), 1);
    }
}