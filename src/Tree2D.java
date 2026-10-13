import java.awt.Color;
import java.util.List;

public class Tree2D {
    private Division div;
    private final Color color;
    private Tree2D R;
    private Tree2D L;
    private final Point topLeft;
    private final Point bottomRight;

    public Tree2D(int width, int height, int nbLeafsToDivide, int minCutDimension, Variants v, List<LineData> linesData) {
        this.topLeft = new Point(0, 0);
        this.bottomRight = new Point(width, height);
        this.color = Color.WHITE;
        this.build(nbLeafsToDivide, minCutDimension, v, linesData);
    }

    private Tree2D(Point topLeft, Point botomRight, Color color) {
        this.topLeft = topLeft;
        this.bottomRight = botomRight;
        this.color = color;
    }

    private void build(int nbLeafsToDivide, int minCutDimension, Variants v, List<LineData> linesData) {
        int divisions = 0;
        for (LineData line : linesData) {
            if (divisions == nbLeafsToDivide) break;

            Tree2D workingLeaf = this.maxWeight();

            Axis axis = Utils.determineAxis(v, workingLeaf.width(), workingLeaf.height());

            workingLeaf.div = new Division(axis, workingLeaf.topLeft, line, workingLeaf.width(), workingLeaf.height());

            // If line.d or line.d is null we use workingLeaf.color
            Color colorg = (line.g == null) ? workingLeaf.color : line.g;
            Color colord = (line.d == null) ? workingLeaf.color : line.d;

            workingLeaf.L = new Tree2D(topLeft, workingLeaf.div.bottomRightLeftChild(workingLeaf.topLeft, workingLeaf.bottomRight), colorg);
            workingLeaf.R = new Tree2D(workingLeaf.div.topLeftRightChild(workingLeaf.topLeft, workingLeaf.bottomRight), workingLeaf.bottomRight, colord);
            
            divisions++;
        }
    }

    private Tree2D maxWeight() {
        if (this.isLeaf()) return this;
        else {
            Tree2D l = this.L.maxWeight();
            Tree2D r = this.R.maxWeight();
            Tree2D res = Utils.maxWeightValue(l, r);

            if (res != null) return res;

            return (Utils.highestLeftCoordinate(l.topLeft, r.topLeft) == -1) ? l : r;
        }
    }

    public int width() {
        return this.bottomRight.x - this.topLeft.x;
    }

    public int height() {
        return this.bottomRight.y - this.topLeft.y;
    }

    private boolean isLeaf() {
        return this.L == null && this.R == null;
    }

    /**
     * Create the image represented by the tree
     * @implNote O(n), n the number of pixels
     * <p>
     * @param lineWidth the width for separation lines beetween rectangles
     * @return the image generated
     */
    public Image toImage(int lineWidth) {
        Image image = new Image(this.width(), this.height());
        return this.colorImage(image, lineWidth/2, this.bottomRight.x, this.bottomRight.y);
    }

    /**
     * Color an image recursively
     * @implNote O(n), n the number of pixels
     * <p>
     * @param image the image that we are constructing
     * @param halfLineWidth half the width for separation lines beetween rectangles
     * @param widthI the width of the entire image
     * @param heightI the height of the entire image
     *
     * @return the image
     */
    private Image colorImage(Image image, int halfLineWidth, int widthI, int heightI) {
        if (!this.isLeaf()) {
            image = this.L.colorImage(image, halfLineWidth, widthI, heightI);
            return this.R.colorImage(image, halfLineWidth, widthI, heightI);
        } else {
            image.setRectangle(this.topLeft.x, this.bottomRight.x, this.topLeft.y, this.bottomRight.y, this.color);
            return image;
        }
    }

    @Override
    public String toString() {
        String res = new String();

        if (this.L != null) res += "( " + this.L.toString() + " )";

        if (div != null) res += "( " + this.div.axis + ", " + this.div.value + " )";
        else res += "( " + this.color.getRed() + ", " + this.color.getGreen() + ", " + this.color.getBlue() + " )";

        if (this.R != null) res += "( " + this.R.toString() + " )";

        return res;
    }
}
