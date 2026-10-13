import java.util.Objects;

/**
 * All Utils functions are in {@code O(1)} time.
 * As there is only comparisons and calculations.
 */
public class Utils {
    private static final String GREEN = "\033[32m";
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[31m";

    /**
     * Determines the Axis to divide on, considering the variant used.
     *
     * @param v The variant used for the segmentation.
     * @param w The width of the leaf.
     * @param h The height of the leaf.
     * @return The axis to divide on.
     */
    public static Axis determineAxis(Variant v, int w, int h) {
        switch (v) {
            case A:
                if ((w / h) > 1)
                    return Axis.X;
                return Axis.Y;

            case B:
                if ((w / h) > 2 || (h / w) <= 2)
                    return Axis.X;
                return Axis.Y;

            default:
                throw new IllegalArgumentException("Invalid variant provided.");
        }
    }

    /**
     * Determines the point with the highest left coordinate following the
     * lexicographic order.
     * Reminder: (a, b) < (a', b') iff either a < a' or a = 'a and b < b'.
     *
     * @param p1 The first Point.
     * @param p2 The second Point.
     * @return -1 if the first point matches the previous contract, 1 otherwise.
     */
    public static int highestLeftCoordinate(Point p1, Point p2) {
        if (p1.x < p2.x)
            return -1;

        if (p1.x == p2.x && p1.y < p2.y)
            return -1;

        return 1;
    }

    /**
     * Determines the maximum weight value of two Tree2D.
     *
     * @param left  The left Tree2D.
     * @param right The right Tree2D.
     * @return The tree with the highest weight.
     */
    public static Tree2D maxWeightValue(Tree2D left, Tree2D right) {
        double rightWeight = getWeight(right.width(), right.height());
        double leftWeight = getWeight(left.width(), left.height());

        if (Objects.equals(leftWeight, rightWeight))
            return null;

        return (leftWeight > rightWeight) ? left : right;
    }

    /**
     * Determines the weight of the leaf.
     *
     * <p>
     * <b>Complexity: O(1)</b>.
     * </p>
     *
     * @param w The width of the leaf.
     * @param h The height of the leaf.
     * @return The leaf's weight.
     */
    private static double getWeight(int w, int h) {
        return (w * h) / Math.pow(w + h, 1.5);
    }

    /**
     * Displays a success message for a completed action.
     *
     * @param action The description of the successfully completed operation.
     */
    public static void logSuccess(String action) {
        System.out.printf("%s[SUCCESS]%s %s%n", GREEN, RESET, action);
    }

    /**
     * Displays an error message for an action.
     *
     * @param error The error that occurred during the operation.
     */
    public static void logError(String error) {
        System.out.printf("%s[ERROR]%s %s%n", RED, RESET, error);
    }

    /**
     * Displays an error message from an exception.
     *
     * @param exception The exception to display.
     */
    public static void logException(Exception exception) {
        System.out.printf("%s[ERROR]%s %s%n", RED, RESET, exception.getMessage());
    }
}
