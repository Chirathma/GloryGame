package ie.ucd.Glory_Schema.Test;

import ie.ucd.Glory_Schema.InitialLetterValueElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InitialLetterValueElementTest {

    @Test
    void testConstructorGreaterInitialPosition(){
        assertThrows(Exception.class, () -> {
            new InitialLetterValueElement('q',10, 3);
        });
    }

    @Test
    void testConstructorLesserInitialPosition(){
        assertThrows(Exception.class, () -> {
            new InitialLetterValueElement('q',10, -1);
        });
    }

    @Test
    void testGetInitialPosition() {
        InitialLetterValueElement element = null;
        try {
            element = new InitialLetterValueElement('q', 10, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(0, element.getInitialPosition());
    }
}