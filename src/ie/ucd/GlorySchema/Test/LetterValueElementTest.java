package ie.ucd.GlorySchema.Test;

import ie.ucd.GlorySchema.LetterValueElement;
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