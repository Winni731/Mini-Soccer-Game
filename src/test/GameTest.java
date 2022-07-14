package test;

import model.SoccerBall;
import model.SoccerGame;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void soccerGameStarts_True() {
        SoccerGame game = new SoccerGame();
        assertNotNull(game);
    }

    @Test
    public void soccerGameUpdateTimeRemaining_True() {
        SoccerGame game = new SoccerGame();
        int original = game.getTimeRemaining();
        game.setTimeRemaining(original - 5);
        assertEquals(new Integer(original - 5), game.getTimeRemaining());
    }

    @Test
    public void soccerGameStartTimer_True() throws InterruptedException {
        SoccerGame game = new SoccerGame();

        // Update Game Time Every Interval
        int original = game.getTimeRemaining();
        TimeUnit.MILLISECONDS.sleep(1010);
        assertEquals(new Integer(original - 1), game.getTimeRemaining());

        // Update ball to inside of gate and check if is scored intervals occurs
        // do this by checking if soccer ball got reset to starting position.
        SoccerBall ball = SoccerBall.getSoccerBall();
        ball.setPosition(new Point(200, 20));
        assertTrue(game.isScored());
        TimeUnit.MILLISECONDS.sleep(1010);
        assertEquals(ball.getPosition(), new Point(480, 500));

        // Check if game over happens in startGame interval
        game = new SoccerGame();
        game.setTimeRemaining(0);
        TimeUnit.MILLISECONDS.sleep(1010);
        assertTrue(game.isOver());
    }

    @Test
    public void soccerGameGoalieCatchesBall_True() {
        SoccerGame game = new SoccerGame();
        SoccerBall ball = SoccerBall.getSoccerBall();

        int originalGoals = game.getGamePlayers().get("Goalkeeper").getPlayerStatistics();

        // Update ball to be on Goalkeepers side
        ball.setPosition(new Point(ball.getPosition().x, 190));
        game.automateGoalkeeper();

        int updatedGoals = game.getGamePlayers().get("Goalkeeper").getPlayerStatistics();
        assertEquals(originalGoals + 1, updatedGoals);
    }

    @Test
    public void ballGetColor_True() {
        SoccerBall ball = SoccerBall.getSoccerBall();
        assertEquals(ball.getColor(), new Color(255, 255, 255));
    }

    @Test
    public void ballMoveBallYNoMovement_True() {
        SoccerBall ball = SoccerBall.getSoccerBall();
        ball.setPosition(new Point(ball.getPosition().x, 520));
        Point original = ball.getPosition();
        ball.moveBallY(10);
        assertEquals(original, ball.getPosition());
    }
}