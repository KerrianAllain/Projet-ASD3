import java.awt.Color;
import java.util.Objects;

public class Test_Parser {
    private static boolean catchException(String value, String parser) {
        try {
            switch (parser) {
                case "coordinate":
                    Parser.parseCoordinate(value);
                    return false;
                case "color":
                    Parser.parseColor(value);
                    return false;

                default:
                    return true;
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void testParseCoordinate() {
        assert catchException("0.0", "coordinate");
        assert Objects.equals(Parser.parseCoordinate("0.2"), 0.2);
        assert Objects.equals(Parser.parseCoordinate("0.5"), 0.5);
        assert Objects.equals(Parser.parseCoordinate("0.8"), 0.8);
        assert catchException("1.0", "coordinate");
    }

    private static void testParseColor() {
        assert catchException("a", "color");
        assert Objects.equals(Parser.parseColor("b"), Color.BLUE);
        assert Objects.equals(Parser.parseColor("j"), Color.YELLOW);
        assert Objects.equals(Parser.parseColor("m"), null);
        assert Objects.equals(Parser.parseColor("n"), Color.BLACK);
        assert Objects.equals(Parser.parseColor("r"), Color.RED);
        assert Objects.equals(Parser.parseColor("w"), Color.WHITE);
        assert catchException("z", "color");
    }

    public static void main(String[] args) {
        testParseCoordinate();
        testParseColor();
    }
}
