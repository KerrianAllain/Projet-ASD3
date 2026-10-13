import java.awt.Color;

public class Parser {
    /**
     * Parses a Color value, that must be either "m", "r", "b", "n", "w" or "j".
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
        try {
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
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }

    /**
     * Parses a coordinate value, that must be within 0.2 and 0.8 bounds.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the value.
     * </p>
     *
     * @param value The value to parse.
     * @return The parsed coordinate.
     */
    public static double parseCoordinate(String value) {
        try {
            double coordinate = Double.parseDouble(value);

            if (coordinate < 0.2 || coordinate > 0.8)
                throw new IllegalArgumentException("Invalid coordinate.");

            return coordinate;
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return -1.0;
        }
    }

    /**
     * Parses an integer parameter from a string.
     *
     * @param value       The value to parse.
     * @param description The description of the value.
     * @return The parsed integer.
     */
    public static int parseIntParameter(String value, String description) {
        try {
            int parameter = Integer.parseInt(value);

            if (parameter <= 0)
                throw new IllegalArgumentException("Invalid parameter for `" + description + "` (must be positive).");

            return parameter;
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return -1;
        }
    }

    public static Variant parseVariant(String value) {
        try {
            switch (value) {
                case "A":
                    return Variant.A;
                case "B":
                    return Variant.B;
                default:
                    throw new IllegalArgumentException("Invalid variant `" + value + "`.");
            }
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }
}
