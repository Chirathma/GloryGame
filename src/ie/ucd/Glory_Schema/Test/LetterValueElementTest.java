package ie.ucd.Glory_Schema.Test;

import ie.ucd.Glory_Schema.LetterValueElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterValueElementTest {

    @Test
    void testGetLetter() {

        LetterValueElement element = new LetterValueElement('q',10 );

        assertEquals('q', element.getLetter());

    }

    @Test
    void testGetValue() {
        LetterValueElement element = new LetterValueElement('q',10 );

        assertEquals(10, element.getValue());
    }
}