package ie.ucd.GlorySchema.Test;

import ie.ucd.GlorySchema.InitialLetterValueElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InitialLetterValueElementTest {

    @Test
    void testGetInitialPosition() {
        InitialLetterValueElement element = new InitialLetterValueElement('q', 10, 0);

        assertEquals(0, element.getInitialPosition());
    }
}