import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    static final FilePartReader testReader = new FilePartReader();
    static final FileWordAnalyzer testAnalyzer = new FileWordAnalyzer(testReader);

    @Test
    void testAlphabeticOrder1() {
        testReader.setup("resources/testingfile.txt",
                1, 2);
        List expectedResult = Arrays.asList("Aaa", "Bbb", "Ccc");
        assertEquals(expectedResult, testAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void testAlphabeticOrder2() {
        testReader.setup("resources/testingfile2.txt",
                1, 2);
        List expectedResult = Arrays.asList("Aaa", "Bbb", "Ccc");
        assertEquals(expectedResult, testAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void testGetWordsContainingSubstring() {
        testReader.setup("resources/testingfile.txt",
                1, 2);
        List expectedResult = Arrays.asList("Aaa");
        assertEquals(expectedResult, testAnalyzer.getWordsContainingSubstring("a"));
    }

    @Test
    void testStringDoesNotContainSubstring() {
        testReader.setup("resources/testingfile.txt",
                1, 2);
        List expectedResult = null;
        assertEquals(expectedResult, testAnalyzer.getWordsContainingSubstring("x"));
    }

}