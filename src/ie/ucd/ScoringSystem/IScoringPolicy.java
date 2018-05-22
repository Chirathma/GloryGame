package ie.ucd.ScoringSystem;

import ie.ucd.Glory_Schema.WordElement;

public interface IScoringPolicy {

    public int getScore(WordElement word);

    public int getGloryScore(WordElement word);
}
