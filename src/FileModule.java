import java.io.File;
import java.io.IOException;

public class FileModule {
    private static final String PROJECT_DIRECTORY = "AllainAllain/";
    private static final String TARGET = PROJECT_DIRECTORY + "target/";

    /**
     * Saves an ImagePNG to a PNG file to the TARGET directory.
     * The image is saved to a sub-folder to make it clearer.
     *
     * <p>
     * <b>Complexity:</b> depends on {@link Image#save(String)}.
     * </p>
     *
     * @param filename The file name without the extension.
     * @param image    The image to save.
     */
    public static void saveToPNG(String filename, Image image) {
        String path = TARGET + filename + "/" + filename + ".png";

        if (!createTargetDirectory(filename))
            return;

        try {
            image.save(path);
            Utils.logSuccess(path + " saved successfully.");
        } catch (IOException exception) {
            Utils.logError("An IO exception occurred while saving the image: " + exception.getMessage());
        }
    }

    /**
     * Creates the required target directory if it does not exist.
     *
     * <p>
     * <b>Complexity: O(1)</b>.
     * </p>
     *
     * @param path The path of the directory to create.
     */
    private static boolean createTargetDirectory(String path) {
        File targetDirectory = new File(TARGET + path);

        if (targetDirectory.isDirectory() || targetDirectory.mkdirs())
            return true;

        Utils.logError("Unable to create directory: " + path);
        return false;
    }
}
