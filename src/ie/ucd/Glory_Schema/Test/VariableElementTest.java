package ie.ucd.Glory_Schema.Test;

import ie.ucd.Glory_Schema.VariableElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableElementTest {

    @Test
    public void testGetNameConstructor(){

        VariableElement element = new VariableElement("glory_game");

        assertEquals("glory_game", element.getName());

    }

    @Test
    public void testSetName(){

        VariableElement element = new VariableElement("a string");

        element.setName("another string");

        assertEquals("another string", element.getName());

    }

    @Test
    public void testGetName(){

        VariableElement element = new VariableElement("glory_game");

        element.setName("foobar");

        assertEquals("foobar", element.getName());

    }

    @Test
    public void testSetValue(){

        VariableElement element = new VariableElement("a string");

        element.setValue(42);

        assertEquals(42, element.getValue());

    }

    @Test
    public void testGetValue(){

        VariableElement element = new VariableElement("a string");

        element.setValue(42);

        assertEquals(42, element.getValue());

    }


}