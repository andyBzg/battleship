import java.util.Random;

public class FieldGenerator {

    private int length;
    private int width;

    public FieldGenerator(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int[][] generate() {
        Random random = new Random();
        int[][] field = new int[length][width];

        for (int i = 0; i < 4; i++) {
            int a = random.nextInt(0, length);
            int b = random.nextInt(0, width);

            if (field[a][b] == 1) {
                i--;
            }
            field[a][b] = 1;
        }

        return field;
    }
}
