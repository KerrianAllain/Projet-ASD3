import java.util.Objects;

public class Test_Utils {
    private static void testDetermineAxis() {
        assert Objects.equals(Utils.determineAxis(Variant.A, 200, 50), Axis.X);
        assert Objects.equals(Utils.determineAxis(Variant.A, 50, 50), Axis.Y);

        assert Objects.equals(Utils.determineAxis(Variant.B, 200, 50), Axis.X);
        assert Objects.equals(Utils.determineAxis(Variant.B, 50, 200), Axis.Y);
    }

    private static void testHighestLeftCoordinate() {
        assert Objects.equals(Utils.highestLeftCoordinate(new Point(1, 50), new Point(50, 50)), -1);
        assert Objects.equals(Utils.highestLeftCoordinate(new Point(1, 50), new Point(1, 75)), -1);
        assert Objects.equals(Utils.highestLeftCoordinate(new Point(1, 50), new Point(1, 25)), 1);
    }

    // TODO: testMaxWeightValue

    public static void main(String[] args) {
        testDetermineAxis();
        testHighestLeftCoordinate();
        // testMaxWeightValue();
    }
}
