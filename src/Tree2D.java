import java.awt.Color;
import java.util.List;

public class Tree2D {
    private Division div;
    private Color color;
    private Tree2D R;
    private Tree2D L;
    private Point topLeft;
    private Point bottomRight;

    public Tree2D(int width, int height, int nbLeafsToDivide, int minCutDimension, Variants v, List<LineData> linesData) {
        this.topLeft = new Point(0, 0);
        this.bottomRight = new Point(width, height);
        this.color = Color.WHITE;
    }

    private Tree2D minWeight() {
        if (color != null) return this;
        else {
            Tree2D l = this.L.minWeight();
            Tree2D r = this.R.minWeight();
            if (Utils.getWeight(l.width(), l.height()) < Utils.getWeight(r.width(), r.height())) return l;
            else return r;
            }
    }

    public int width() {
        return this.bottomRight.x - this.topLeft.x;
    }

    public int height() {
        return this.bottomRight.y - this.topLeft.y;
    }

    private boolean isLeaf() {
        return color != null;
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
        this.colorImage(image, lineWidth/2, this.bottomRight.x, this.bottomRight.y);
        return image;
    }

    /**
     * Color an image recursively
     * @implNote O(n), n the number of pixels
     * <p>
     * @param image the image that we are constructing
     * @param halfLineWidth half the width for separation lines beetween rectangles
     * @param widthI the width of the entire image
     * @param heightI the height of the entire image
     */
    private void colorImage(Image image, int halfLineWidth, int widthI, int heightI) {
        if (this.isLeaf()) {
            this.L.colorImage(image, halfLineWidth, widthI, heightI);
            this.R.colorImage(image, halfLineWidth, widthI, heightI);
        } else {
            Point topLeftPoint;
            Point bottomRightPoint;
            // topLeftPoint
            if (this.topLeft.equals(0, 0)) topLeftPoint = this.topLeft;
            else {
                if (this.topLeft.x == 0) topLeftPoint = this.topLeft.addX(halfLineWidth);
                else if (this.topLeft.y == 0) topLeftPoint = this.topLeft.addY(halfLineWidth);
                else topLeftPoint = this.topLeft.add(halfLineWidth);
            }
            // bottomRightPoint
            if (this.bottomRight.equals(widthI, heightI)) bottomRightPoint = this.bottomRight;
            else {
                if (this.bottomRight.x == widthI) bottomRightPoint = this.bottomRight.subY(halfLineWidth);
                else if (this.bottomRight.y == heightI) bottomRightPoint = this.bottomRight.subX(halfLineWidth);
                else bottomRightPoint = this.bottomRight.sub(halfLineWidth);
            }

            image.setRectangle(topLeftPoint.x, topLeftPoint.y, bottomRightPoint.x, bottomRightPoint.y, this.color);
        }
    }
}
