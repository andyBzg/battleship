import java.util.Arrays;

public class FieldPrinter {

    private int height;

    public FieldPrinter(int height) {
        this.height = height;
    }

    public void printField(int[][] field) {
        for (int i = 0; i < height; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
    }
}
