import java.awt.Color;

public class Parser {
    /**
     * Parses a Color value ("m", "r", "b", "n", "w" or "j").
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the value.
     * </p>
     *
     * @param value The character string value representing a color.
     * @return The corresponding {@link Color}, or {@code null} if "m".
     */
    public static Color parseColor(String value) {
        try {
            if (value == null)
                throw new IllegalArgumentException("Color value cannot be null.");

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
                    throw new IllegalArgumentException("Invalid color character.");
            }
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }

    /**
     * Parses a coordinate value bounded between 0.2 and 0.8 included.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the value.
     * </p>
     *
     * @param value The coordinate string to parse.
     * @return The parsed double coordinate.
     */
    public static double parseCoordinate(String value) {
        try {
            double coordinate = Double.parseDouble(value);

            if (coordinate < 0.2 || coordinate > 0.8)
                throw new IllegalArgumentException("Coordinate out of bounds [0.2; 0.8].");

            return coordinate;
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return -1.0;
        }
    }

    /**
     * Parses a strictly positive integer parameter.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the string.
     * </p>
     *
     * @param value       The string value to parse.
     * @param description Parameter name for error reporting.
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

    /**
     * Parses a variant value.
     *
     * <p>
     * <b>Complexity: O(n)</b>, where {@code n} is the length of the string.
     * </p>
     *
     * @param value The variant string to parse.
     * @return The corresponding {@link Variant}.
     */
    public static Variant parseVariant(String value) {
        try {
            if (value == null)
                throw new IllegalArgumentException("Variant cannot be null.");

            return Variant.valueOf(value);
        } catch (IllegalArgumentException exception) {
            Utils.logException(exception);
            System.exit(1);
            return null;
        }
    }
}
