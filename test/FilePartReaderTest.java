import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    static final FilePartReader testReader = new FilePartReader();

    @Test
    public void testSetupInvalidPath() {
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material/hubblebubble/.txt",
                15, 10);});
    }

    @Test
    public void testSetupFromLineIsZero() {
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                0, 10);});
    }

    @Test
    public void testSetupFromLineIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                -15, 10);});
    }

    @Test
    public void testSetupToLineZero() {
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                2, 0);});
    }

    @Test
    public void testSetupToLineNegative() {
        assertThrows(IllegalArgumentException.class, () ->
        {testReader.setup("resources/material.txt",
                2, -10);});
    }

    @Test
    void testReadReturnType() {
        testReader.setup("resources/material.txt",
                1, 10);
        assertTrue(testReader.read() instanceof String);
    }

    @Test
    void testReadReturnsNotNull() {
        testReader.setup("resources/material.txt",
                1, 10);
        assertNotNull(testReader.read());
    }

    @Test
    void testReadLinesReturnType() {
        testReader.setup("resources/material.txt",
                1, 10);
        assertTrue(testReader.readLines() instanceof String);
    }


    @Test
    void testReadLinesNotNull() {
        testReader.setup("resources/material.txt",
                1, 10);
        assertNotNull(testReader.readLines());
    }

    @Test
    void testReadLinesCorrectNumberOfLines () {
        testReader.setup("resources/material.txt",
                1, 3);
        assertEquals(3, testReader.readLines().split("\n").length);
    }

}