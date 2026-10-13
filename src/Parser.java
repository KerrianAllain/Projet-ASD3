import java.awt.Color;

public class Parser {
    /**
     * Parses a coordinate value, that must be within 0.2 and 0.8 bounds.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the value.
     * </p>
     *
     * @param value The value to parse.
     * @return The parsed coordinate.
     *
     * @throws IllegalArgumentException If the coordinate exceeds bounds.
     */
    public static double parseCoordinate(String value) {
        double coordinate = Double.parseDouble(value);

        if (coordinate < 0.2 || coordinate > 0.8)
            throw new IllegalArgumentException("Invalid coordinate.");

        return coordinate;
    }

    /**
     * Parses a Color value, that must be either "m", "r", "b", "n", "w", "j".
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the value.
     * </p>
     *
     * @param value The value to parse.
     * @return The parsed Color.
     *
     * @throws IllegalArgumentException If the value is not one of the above.
     */
    public static Color parseColor(String value) {
        switch (value) {
            case "m":
                return null;
            case "r":
                return Color.RED;
            case "b":
                return Color.BLUE;
            case "n":
                return Color.BLACK;
            case "w":
                return Color.WHITE;
            case "j":
                return Color.YELLOW;

            default:
                throw new IllegalArgumentException("Invalid color provided.");
        }
    }
}
