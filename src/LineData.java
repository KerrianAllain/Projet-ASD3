import java.awt.Color;

public class LineData {
    public static final String SEPARATOR = " ";

    public final int k;
    public final double p;
    public final double q;
    public final Color g;
    public final Color d;

    public LineData(String line) {
        String[] content = line.split(SEPARATOR);

        this.k = Integer.parseInt(content[0]);
        this.p = Parser.parseCoordinate(content[1]);
        this.q = Parser.parseCoordinate(content[2]);
        this.g = Parser.parseColor(content[3]);
        this.d = Parser.parseColor(content[4]);
    }

    @Override
    public String toString() {
        return String.valueOf(k) + SEPARATOR +
                String.valueOf(p) + SEPARATOR +
                String.valueOf(q) + SEPARATOR +
                String.valueOf(g) + SEPARATOR +
                String.valueOf(d);
    }
}
