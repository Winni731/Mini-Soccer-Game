package model.players;
import java.util.Iterator;

public class PlayerCollectionIterator implements Iterator<GamePlayer> {
	private Integer cursor;
	private final PlayerCollection players;
	
	public PlayerCollectionIterator(PlayerCollection players) {
		cursor = -1;
		this.players = players;
	}
	
	public boolean hasNext() {
		return cursor+1 < players.size();
	}
	
	public GamePlayer next() {
		cursor = cursor + 1;
		return players.get(cursor);
	}

}
