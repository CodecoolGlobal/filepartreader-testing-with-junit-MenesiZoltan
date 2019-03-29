import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {

    }


    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.toLine = toLine;
        this.fromLine = fromLine;
    }

    public String read() {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public String readLines() {
        String lines = read();
        String[] separateLines = lines.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = fromLine -1; i <= toLine; i++) {
            result.append(separateLines[i]);
            result.append(" ");
        }

        return result.toString();
    }

}
