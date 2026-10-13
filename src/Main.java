
public class Main {
    public static void main(String[] args) {
        FileReader fr = new FileReader(args[0]);
        int width = Parser.parseIntParameter(args[1], "width");
        int height = Parser.parseIntParameter(args[2], "height");
        int nbLeafsToDivide = Parser.parseIntParameter(args[3], "nbLeafsToDivide");
        int minCutDimension = Parser.parseIntParameter(args[4], "minCutDimension");
        int lineWidth = Parser.parseIntParameter(args[5], "lineWidth");
        Variant variant = Parser.parseVariant(args[6]);

        Tree2D tree = new Tree2D(width, height, nbLeafsToDivide, minCutDimension, variant, fr.readFile());

        Image image = tree.toImage(lineWidth);
        FileModule.saveToPNG("test", image);
    }
}
