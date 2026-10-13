public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    public Point add(int val) {
        return new Point(x + val, y + val);
    }

    public Point sub(int val) {
        return new Point(x - val, y - val);
    }

    public Point addX(int val) {
        return new Point(x + val, y);
    }

    public Point addY(int val) {
        return new Point(x, y + val);
    }

    public Point subX(int val) {
        return new Point(x - val, y);
    }

    public Point subY(int val) {
        return new Point(x, y - val);
    }
}
