package ie.ucd.GlorySchema.Test;

import ie.ucd.GlorySchema.VariableElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableElementTest {

    @Test
    public void testGetName(){

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