package ie.ucd.ScoringSystem;

public interface IScorer {

    public int getPlayerRoundScore( int round, String playerId);
    public void setPlayerRoundScore(int round, String playerId, int score);
    public String getWnner();

}
