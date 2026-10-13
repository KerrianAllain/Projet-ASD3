import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private final File file;

    public FileReader(String path) {
        this.file = new File(path);
    }

    public List<LineData> readFile() {
        List<LineData> content = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                LineData lineContent = new LineData(line);
                content.add(lineContent);
            }
        } catch (IOException | IllegalArgumentException exception) {
            Utils.logError(exception.getMessage());
            System.exit(1);
        }

        return content;
    }
}
