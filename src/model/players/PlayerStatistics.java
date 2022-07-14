package model.players;

public class PlayerStatistics implements Comparable<PlayerStatistics> {
    private Integer statistics;

    public PlayerStatistics() {
        statistics = 0;
    }

    public Integer getStatistics() {
        return statistics;
    }

    public void setStatistics(Integer statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return String.valueOf(this.statistics);
    }

	@Override
	public int compareTo(PlayerStatistics o) {
		// TODO Auto-generated method stub
		return getStatistics().compareTo(o.getStatistics());
	}
}