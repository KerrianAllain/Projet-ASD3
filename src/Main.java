public class Main {
    public static void main(String[] args) {
        FileReader fr = new FileReader(args[0]);
        int strategy = Parser.parseIntParameter(args[1], "strategy");

        switch (strategy) {
            case 1:
                int width = Parser.parseIntParameter(args[2], "width");
                int height = Parser.parseIntParameter(args[3], "height");
                int nbLeafsToDivide = Parser.parseIntParameter(args[4], "nbLeafsToDivide");
                int minCutDimension = Parser.parseIntParameter(args[5], "minCutDimension");
                int lineWidth = Parser.parseIntParameter(args[6], "lineWidth");
                Variant variant = Parser.parseVariant(args[7]);

                Tree2D tree = new Tree2D(width, height, nbLeafsToDivide, minCutDimension, variant, fr.readFile());

                Image image = tree.toImage(lineWidth);
                FileModule.saveToPNG("test", image);

            case 2:
                break;

            default:
                Utils.logError("Invalid strategy.");
                break;
        }
    }
}
