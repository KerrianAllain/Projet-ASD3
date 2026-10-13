import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private final File file;

    public FileReader(String path) {
        this.file = this.tryLoadFile(path);
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
    private File tryLoadFile(String path) {
        try {
            File pathFile = new File(path);

            if (!pathFile.isFile() || !pathFile.getName().contains(".txt"))
                throw new FileNotFoundException("Path: " + path + " does not lead to a valid text file.");

            return pathFile;
        } catch (FileNotFoundException | NullPointerException exception) {
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

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null)
                content.add(new LineData(line));

            return content;
        } catch (IOException | IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }
}
