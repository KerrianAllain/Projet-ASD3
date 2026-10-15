import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private final Path filePath;

    public FileReader(String path) {
        this.filePath = this.tryLoadFile(path);
    }

    /**
     * Loads the file from the given path. It must be a valid text file.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the path.
     * </p>
     *
     * @param path The path to the file to load.
     * @return The loaded file.
     */
    private Path tryLoadFile(String path) {
        try {
            if (path == null)
                throw new IllegalArgumentException("File path cannot be null.");

            Path file = Paths.get(path);

            if (!Files.isRegularFile(file) || !file.getFileName().toString().endsWith(".txt"))
                throw new IllegalArgumentException("Path: " + path + " is not a valid text file.");

            return file;
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }

    /**
     * Reads the file content and builds a list of data for each line.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the number of rows in the file.
     * </p>
     *
     * @return Each file line into a LineData class to use to build the tree.
     */
    public List<LineData> readFile() {
        List<LineData> content = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(this.filePath)) {
            String line;

            while ((line = br.readLine()) != null)
                if (!line.trim().isEmpty())
                    content.add(new LineData(line));

            return content;
        } catch (IOException | IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }
}
