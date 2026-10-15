import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            Utils.logError("Not enough arguments.");
            System.exit(1);
        }

        int strategy = Parser.parseIntParameter(args[1], "strategy");
        switch (strategy) {
            case 1:
                runStrategy1(args);
                break;

            case 2:
                runStrategy2(args);
                break;

            default:
                Utils.logError("Invalid strategy.");
                break;
        }
    }

    /**
     * Run the strategy given in the subject.
     *
     * @param args The list of arguments to run the strategy.
     */
    private static void runStrategy1(String[] args) {
        FileReader fr = new FileReader(args[0]);

        if (args.length < 8) {
            Utils.logError("Strategy 1 requires 8 arguments.");
            System.exit(1);
        }

        int width = Parser.parseIntParameter(args[2], "width");
        int height = Parser.parseIntParameter(args[3], "height");
        int nbLeafsToDivide = Parser.parseIntParameter(args[4], "nbLeafsToDivide");
        int minCutDimension = Parser.parseIntParameter(args[5], "minCutDimension");
        int lineWidth = Parser.parseIntParameter(args[6], "lineWidth");
        Variant variant = Parser.parseVariant(args[7]);

        List<LineData> lines = fr.readFile();
        Tree2D tree = new Tree2D(width, height, nbLeafsToDivide, minCutDimension, variant, lines);

        Image image = tree.toImage(lineWidth);

        String outputName = getFileNameWithoutExtension(args[0]);
        FileModule.saveToPNG(outputName, image);
    }

    /**
     * Run our own strategy.
     *
     * @param args The list of arguments to run the strategy.
     */
    private static void runStrategy2(String[] args) {
        Utils.logError("Strategy 2 is not implemented yet.");
    }

    /**
     * Determines the name of the input file for the output image.
     *
     * @param path The path of the file to process.
     * @return The cleaned file name.
     */
    private static String getFileNameWithoutExtension(String path) {
        String fileName = Paths.get(path).getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');

        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
}
