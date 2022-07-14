package model.players;

import model.SoccerBall;

import java.awt.*;

public abstract class GamePlayer implements Comparable<GamePlayer> {

	protected final String playerName;

	protected final Color playerColor;

	protected Point playerPosition;

	protected final PlayerStatistics playerStatistics;

	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}

	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}

	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}

	public abstract void moveLeft();

	public abstract void moveRight();

	public abstract void moveUp();

	public abstract void moveDown();

	public abstract void shootBall();

	public String getPlayerName() {
		return playerName;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public Point getPlayerPosition() {
		return playerPosition;
	}

	public abstract void setInitialPosition();

	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}

	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}

	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}

	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}

	@Override
	public abstract String toString();
}
