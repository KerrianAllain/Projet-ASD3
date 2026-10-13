public class Division {
    public final Axis axis;
    public final int value;

    public Division(Axis axis, Point coordinates, LineData line, int width, int height) {
        this.axis = axis;
        switch (axis) {
            case X:
                this.value = coordinates.x + (int) (width * line.p);
                break;

            case Y:
                this.value = coordinates.y + (int) (height * line.q);
                break;

            default:
                throw new IllegalArgumentException("Invalid variant provided.");
        }
    }

    public Point bottomRightLeftChild(Point topLeft, Point bottomRight) {
        switch (this.axis) {
            case X:
                return new Point(value, bottomRight.y);

            case Y:
                return new Point(bottomRight.x, value);
        }
        return null;
    }

    public Point topLeftRightChild(Point topLeft, Point bottomRight) {
        switch (this.axis) {
            case X:
                return new Point(value, topLeft.y);

            case Y:
                return new Point(topLeft.x, value);
        }
        return null;
    }
}
