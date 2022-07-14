package model.players;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PlayerCollection implements Collection<GamePlayer>{

	private final ArrayList<GamePlayer> players;
	
    public PlayerCollection() {
        this.players = new ArrayList<GamePlayer>();
    }
    
    public Iterator<GamePlayer> iterator() {
        return players.iterator();
    }
    
    public GamePlayer get(int index) {
    	return players.get(index);
    }
    
    public int size() {
    	return players.size();
    }
    
    public GamePlayer get(String playerType) {
    	GamePlayer result = null;
       for (GamePlayer player: players) {
    	   if (player.getPlayerName().equals(playerType)) {
    		   result = player;
    	   }
       }
       return result;  
    }
    
    public ArrayList<GamePlayer> getGamePlayers() {
    	return this.players;
    }
    
    public void sort() {
        this.players.sort(null);
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return players.isEmpty();
	}
//
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		try {
			GamePlayer g = (GamePlayer) o;
			return players.contains(o);
		} catch (ClassCastException e) {
			throw new ClassCastException("Error while Casting");
		}
	}
//
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return players.toArray();
	}
//
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return players.toArray(a);
	}
//
	@Override
	public boolean add(GamePlayer e) {
		// TODO Auto-generated method stub
		return players.add(e);
	}
//
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return players.remove(o);
	}
//
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return players.containsAll(c);
	}
//
	@Override
	public boolean addAll(Collection<? extends GamePlayer> c) {
		// TODO Auto-generated method stub
		return players.addAll(c);
	}
//
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return players.removeAll(c);
	}
//
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return players.retainAll(c);
	}
//
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		players.clear();	
	}

}