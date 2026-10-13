
import java.util.Objects;

public class Utils {
    private static final String GREEN = "\033[32m";
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[31m";

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
    public static double getWeight(int w, int h) {
        return (w * h) / Math.pow(w + h, 1.5);
    }

    public static Tree2D maxWeightValue(Tree2D left, Tree2D right) {
        double rightWeight = getWeight(right.width(), right.height());
        double leftWeight = getWeight(left.width(), left.height());

        if (Objects.equals(leftWeight, rightWeight))
            return null;

        return (leftWeight > rightWeight) ? left : right;
    }

    public static int highestLeftCoordinate(Point p1, Point p2) {
        if (p1.x < p2.x)
            return -1;

        if (p1.x == p2.x && p1.y < p2.y)
            return -1;

        return 1;
    }

    /**
     * Determines the Axis to divide on, considering the variant used.
     *
     * <p>
     * <b>Complexity: O(1)</b>.
     * </p>
     *
     * @param v The variant used for the segmentation.
     * @param w The width of the leaf.
     * @param h The height of the leaf.
     * @return The axis to divide on.
     */
    public static Axis determineAxis(Variants v, int w, int h) {
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
     * Displays a success message for a completed action.
     *
     * <p>
     * <b>Complexity: O(1)</b>.
     * </p>
     *
     * @param action The description of the successfully completed operation.
     */
    protected static void logSuccess(String action) {
        System.out.printf("%s[SUCCESS]%s %s%n", GREEN, RESET, action);
    }

    /**
     * Displays an error message for an action.
     *
     * <p>
     * <b>Complexity: O(1)</b>.
     * </p>
     *
     * @param error The error that occurred during an operation.
     */
    protected static void logError(String error) {
        System.out.printf("%s[ERROR]%s %s%n", RED, RESET, error);
    }
}
