import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List getWordsOrderedAlphabetically() {
        String readLines = reader.readLines().replaceAll("\n", " ");
        String[] words = readLines.split(" ");
        Arrays.sort(words);
        System.out.println(Arrays.asList(words));

        return Arrays.asList(words);
    }

    public List getWordsContainingSubstring (String subString) {
        String readLines = reader.readLines().replaceAll("\n", " ");
        String[] words = readLines.split(" ");

        StringBuilder temp = new StringBuilder();

        for (String word : words) {
            if (word.contains(subString)) {
                temp.append(word);
                temp.append(" ");
            }
        }

        if (temp.toString().length() == 0) {
            return null;
        } else {
            return Arrays.asList(temp.toString().split(" "));
        }
    }

    public List getStringsWhichPallindrome() {
        String readLines = reader.readLines().replaceAll("\n", " ");
        String[] words = readLines.split(" ");

        StringBuilder tempResult = new StringBuilder();
        StringBuilder tempReverser = new StringBuilder();

        for (String word : words) {
            tempReverser.append(word).reverse();
            if (tempReverser.toString().equals(word)) {
                tempResult.append(word + " ");
            }
            tempReverser.delete(0, tempReverser.length()-1);
        }

        if (tempResult.toString().length() == 0) {
            return null;
        } else {
            return Arrays.asList(tempResult.toString().split(" "));
        }
    }
}
