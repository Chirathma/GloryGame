package ie.ucd.ScoringSystem;

import ie.ucd.Glory_Schema.WordElement;

public interface IScoringService {

    public void setScore(int round, WordElement word,String id);
    public int getScore(int round, String id);
    public String getWinter();


}
