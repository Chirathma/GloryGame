package ie.ucd.ScoringSystem;

import ie.ucd.Glory_Schema.WordElement;

public class ScoringService implements IScoringService{
    private IScoringPolicy scoringPolicy;
    private IScorer scorer;

    @Override
    public void setScore(int round, WordElement word, String id) {

    }

    @Override
    public int getScore(int round, String id) {
        return 0;
    }

    @Override
    public String getWinter() {
        return null;
    }
}
