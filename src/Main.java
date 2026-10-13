import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LineData> lines = new FileReader("AllainAllain/docs/exemple1-50-50-12-2-1-A.txt").readFile();
        Tree2D t = new Tree2D(50, 50, 12, 2, Variants.A, lines);

        Image img = t.toImage(1);
        FileModule.saveToPNG("test", img);
    }
}
