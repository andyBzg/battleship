import java.util.Random;

public class FieldGenerator {

    private int height;
    private int length;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public FieldGenerator(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public int[][] generate() {
        Random random = new Random();
        int[][] field = new int[height][length];

        //simpleShip - одна клетка х 4
        //destroyer - 2 клетки х 3
        //cruiser - 3 клетки х 2
        //battleship - 4 клетки х 1

        int destroyer = 0;
        while (destroyer < 3) {
            int a = random.nextInt(0, height);
            int b = random.nextInt(0, length - 1);

            if (field[a][b] == 0) {
                field[a][b] = 2;
                destroyer++;
            }
        }

        for (int i = 0; i < field.length; i++) {        //идём по строчкам
            for (int j = 0; j < field[i].length; j++) { //по каждому элементу в строчке

                if (field[i][j] == 2) {
                    j++;
                    field[i][j] = 2;
                }
            }
        }

        int simpleShip = 0;
        while (simpleShip < 4) {
            int a = random.nextInt(0, height);
            int b = random.nextInt(0, length);

            if (field[a][b] == 0) {
                field[a][b] = 1;
                simpleShip++;
            }

        }
        return field;
    }
}
