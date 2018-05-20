package ie.ucd.GlorySchema.Test;

import ie.ucd.GlorySchema.ConstantElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantElementTest {

    @Test
    public void testGetValue()
    {
        int value = 3;

        ConstantElement constantElement = new ConstantElement(value);

        assertEquals(value, constantElement.getValue());

    }

}