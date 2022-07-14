package test;

import model.players.PlayerFactory;
import model.SoccerBall;
import model.players.GamePlayer;
import model.players.Goalkeeper;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void gamePlayerGetColour_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer player = playerFactory.getPlayer("Striker");
        assertEquals(player.getPlayerColor(), new Color(0, 0, 255));
    }

    @Test
    public void gamePlayerCompareToZero_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer player = playerFactory.getPlayer("Striker");
        assertEquals(player.compareTo(player), 0);
    }

    @Test
    public void gamePlayerCompareToOne_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer player1 = playerFactory.getPlayer("Striker");
        GamePlayer player2 = playerFactory.getPlayer("Goalkeeper");
        player2.setPlayerStatistics(10);
        assertEquals(player1.compareTo(player2), 1);
    }

    @Test
    public void gamePlayerCompareToNegativeOne_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer player1 = playerFactory.getPlayer("Striker");
        GamePlayer player2 = playerFactory.getPlayer("Goalkeeper");
        player2.setPlayerStatistics(10);
        assertEquals(player2.compareTo(player1), -1);
    }

    @Test
    public void gamePlayerGrabsBallElse_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer player = playerFactory.getPlayer("Striker");
        SoccerBall ball = SoccerBall.getSoccerBall();

        player.setPlayerPosition(new Point(ball.getPosition().x - 200, player.getPlayerPosition().y));
        player.grabsBall();
        assertEquals(ball.getPosition().x, player.getPlayerPosition().x + 20);
    }

    @Test
    public void strikerMoveLeft_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer striker = playerFactory.getPlayer("Striker");
        int originalPosition = striker.getPlayerPosition().x;
        striker.moveLeft();

        assertEquals(originalPosition - 5, striker.getPlayerPosition().x);
    }

    @Test
    public void goalkeeperMoveLeft_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer goalkeeper = playerFactory.getPlayer("Goalkeeper");
        int originalPosition = goalkeeper.getPlayerPosition().x;
        goalkeeper.moveLeft();

        assertEquals(originalPosition - 10, goalkeeper.getPlayerPosition().x);
    }

    @Test
    public void strikerMoveRight_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer striker = playerFactory.getPlayer("Striker");
        int originalPosition = striker.getPlayerPosition().x;
        striker.moveRight();

        assertEquals(originalPosition + 5, striker.getPlayerPosition().x);
    }

    @Test
    public void goalkeeperMoveRight_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer goalkeeper = playerFactory.getPlayer("Goalkeeper");
        int originalPosition = goalkeeper.getPlayerPosition().x;
        goalkeeper.moveRight();

        assertEquals(originalPosition + 10, goalkeeper.getPlayerPosition().x);
    }

    @Test
    public void strikerMoveUp_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer striker = playerFactory.getPlayer("Striker");
        int originalPosition = striker.getPlayerPosition().y;
        striker.moveUp();

        assertEquals(originalPosition - 5, striker.getPlayerPosition().y);
    }

    @Test
    public void goalkeeperMoveUp_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer goalkeeper = playerFactory.getPlayer("Goalkeeper");
        int originalPosition = goalkeeper.getPlayerPosition().y;
        goalkeeper.moveUp();

        assertEquals(originalPosition - 5, goalkeeper.getPlayerPosition().y);
    }

    @Test
    public void strikerMoveDown_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer striker = playerFactory.getPlayer("Striker");
        striker.setPlayerPosition(new Point(striker.getPlayerPosition().x, 200));
        int originalPosition = striker.getPlayerPosition().y;
        striker.moveDown();

        assertEquals(originalPosition + 5, striker.getPlayerPosition().y);
    }

    @Test
    public void goalkeeperMoveDown_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer goalkeeper = playerFactory.getPlayer("Goalkeeper");
        int originalPosition = goalkeeper.getPlayerPosition().y;
        goalkeeper.moveDown();

        assertEquals(originalPosition + 5, goalkeeper.getPlayerPosition().y);
    }

    @Test
    public void strikerShootBall_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer striker = playerFactory.getPlayer("Striker");
        SoccerBall ball = SoccerBall.getSoccerBall();
        ball.setPosition(new Point(200, 200));
        int y = ball.getPosition().y;
        striker.shootBall();
        assertNotEquals(y, ball.getPosition().y);
    }

    @Test
    public void goalkeeperShootBall_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        GamePlayer goalkeeper = playerFactory.getPlayer("Goalkeeper");
        SoccerBall ball = SoccerBall.getSoccerBall();
        int y = ball.getPosition().y;

        goalkeeper.shootBall();

        assertNotEquals(y, ball.getPosition().y);
    }

    @Test
    public void goalkeeperMoveRandomly_True() {
        PlayerFactory playerFactory = new PlayerFactory();
        Goalkeeper goalkeeper = (Goalkeeper) playerFactory.getPlayer("Goalkeeper");

        boolean moved = false;
        for (int i = 0; i < 100; i++) {
            Point original = goalkeeper.getPlayerPosition();
            goalkeeper.moveRandomly();
            if (!original.equals(goalkeeper.getPlayerPosition())) {
                moved = true;
            }
        }

        assertTrue(moved);
    }
}
