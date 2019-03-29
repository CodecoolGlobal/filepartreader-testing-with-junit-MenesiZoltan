import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testSetupInvalidPath() {
        FilePartReader testReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material/hubblebubble/.txt",
                15, 10);});
    }

    @Test
    public void testSetupFromLineIsZero() {
        FilePartReader testReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                0, 10);});
    }

    @Test
    public void testSetupFromLineIsNegative() {
        FilePartReader testReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                -15, 10);});
    }

    @Test
    public void testSetupToLineZero() {
        FilePartReader testReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                2, 0);});
    }

    @Test
    public void testSetupToLineNegative() {
        FilePartReader testReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                2, -10);});
    }

}