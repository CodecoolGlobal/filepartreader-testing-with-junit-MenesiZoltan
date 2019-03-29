import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List getWordsOrderedAlphabetically() {
        String[] words = reader.readLines().split(" ");
        Arrays.sort(words);
        return Arrays.asList(words);
    }

    public List getWordsContainingSubstring (String subString) {
        String[] words = reader.readLines().split(" ");
        StringBuilder temp = new StringBuilder();

        for (String word : words) {
            if (word.contains(subString)) {
                temp.append(word);
                temp.append(" ");
            }
        }
        return Arrays.asList(temp.toString().split(" "));
    }

    public List getStringsWhichPallindrome() {
        String[] words = reader.readLines().split(" ");
        StringBuilder tempResult = new StringBuilder();
        StringBuilder tempReverser = new StringBuilder();

        for (String word : words) {
            tempReverser.append(word).reverse();
            if (tempReverser.toString().equals(word)) {
                tempResult.append(word + " ");
            }
            tempReverser.delete(0, tempReverser.length()-1);
        }
        return Arrays.asList(tempResult.toString().split(" "));
    }
}
