package ie.ucd.Glory_Schema.Test;

import ie.ucd.Glory_Schema.LetterValueElement;
import ie.ucd.Glory_Schema.WordElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordElementTest {

    @Test
    void addLetterValue() {
        WordElement wordElement = new WordElement();
        LetterValueElement element = new LetterValueElement('q', 10);


    }

    @Test
    void getLetterValueElementAt() {
        WordElement wordElement = new WordElement();
        LetterValueElement element = new LetterValueElement('q', 10);
    }
}