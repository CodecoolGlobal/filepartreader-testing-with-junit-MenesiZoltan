import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
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

    @Test
    void testPallindromeReturnTypeIsList () {
        testReader.setup("resources/testingfile.txt",
                4, 4);
        assertTrue(testAnalyzer.getStringsWhichPallindrome() instanceof List);
    }

    @Test
    void testPallindromeIsResultCorrect() {
        testReader.setup("resources/testingfile.txt",
                4, 4);
        List expectedResult = Arrays.asList("xxx", "ttt", "rrr", "qqq", "lll");
        assertEquals(expectedResult, testAnalyzer.getStringsWhichPallindrome());
    }

    @Test
    void testPallindromeReturnsNull() {
        testReader.setup("resources/testingfile.txt",
                1, 3);
        List expectedResult = null;
        assertEquals(expectedResult, testAnalyzer.getStringsWhichPallindrome());
    }

    @Test
    void testFileReaderHasIllegalFilePath() {
        testReader.setup("resources/testingfile/invalidpath.txt",
                1, 3);
        assertThrows(IllegalArgumentException.class, testAnalyzer::getStringsWhichPallindrome);
    }

}