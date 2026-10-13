import java.util.Objects;

public class Test_Utils {
    private static void testGetWeight() {
        assert Math.round(Utils.getWeight(1, 1) * 1e6) == 353553L;
        assert Math.round(Utils.getWeight(3, 1) * 1e6) == 375000L;
        assert Math.round(Utils.getWeight(1, 3) * 1e6) == 375000L;
        assert Math.round(Utils.getWeight(4, 4) * 1e6) == 707107L;
        assert Math.round(Utils.getWeight(100, 100) * 1e6) == 3535534L;
        assert Math.round(Utils.getWeight(0, 5) * 1e6) == 0L;
        assert Math.round(Utils.getWeight(5, 0) * 1e6) == 0L;
    }

    private static void testDetermineAxis() {
        assert Objects.equals(Utils.determineAxis(Variants.A, 200, 50), Axis.X);
        assert Objects.equals(Utils.determineAxis(Variants.A, 50, 50), Axis.Y);

        assert Objects.equals(Utils.determineAxis(Variants.B, 200, 50), Axis.X);
        assert Objects.equals(Utils.determineAxis(Variants.B, 50, 200), Axis.Y);
    }

    private static void testHighestLeftCoordinate() {
        assert Objects.equals(Utils.highestLeftCoordinate(new Point(1, 50), new Point(50, 50)), -1);
        assert Objects.equals(Utils.highestLeftCoordinate(new Point(1, 50), new Point(1, 75)), -1);
        assert Objects.equals(Utils.highestLeftCoordinate(new Point(1, 50), new Point(1, 25)), 1);
    }

    public static void main(String[] args) {
        testGetWeight();
        testDetermineAxis();
        testHighestLeftCoordinate();
    }
}
