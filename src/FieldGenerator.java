import java.util.Random;

public class FieldGenerator {

    private int height;
    private int width;
    private int shipsPerField;


    public FieldGenerator(int height, int width, int shipsPerField) {
        this.height = height;
        this.width = width;
        this.shipsPerField = shipsPerField;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] generate() {
        Random random = new Random();
        int[][] field = new int[height][width];

        //simpleShip - одна клетка
        //destroyer - 2 клетки
        //cruiser - 3 клетки
        //battleship - 4 клетки

        int battleship = 0;

        while (battleship < 1) {
            int a = random.nextInt(0, height - 3);
            int b = random.nextInt(0, width - 3);
            boolean battleshipRotationHorizontal = random.nextBoolean();
            if (battleshipRotationHorizontal) {
                if (checkBattleshipCollision(field, a, b)) {
                    field[a][b] = 4;
                    field[a][b + 1] = 4;
                    field[a][b + 2] = 4;
                    field[a][b + 3] = 4;
                    battleship++;
                }
            }
            else {
                if (checkBattleshipCollision(field, a, b)) {
                    field[a][b] = 4;
                    field[a + 1][b] = 4;
                    field[a + 2][b] = 4;
                    field[a + 3][b] = 4;
                    battleship++;
                }
            }
        }

        int cruiser = 0;

        while (cruiser < 3) {
            int a = random.nextInt(0, height - 2);
            int b = random.nextInt(0, width - 2);
            boolean cruiserRotationHorizontal = random.nextBoolean();
            if (cruiserRotationHorizontal) {
                if (checkCollision(field, a, b)) {
                    field[a][b] = 3;
                    field[a][b + 1] = 3;
                    field[a][b + 2] = 3;
                    cruiser++;
                }
            }
            else {
                if (checkCollision(field, a, b)) {
                    field[a][b] = 3;
                    field[a + 1][b] = 3;
                    field[a + 2][b] = 3;
                    cruiser++;
                }
            }
        }

        int destroyer = 0;
        while (destroyer < shipsPerField) {
            int a = random.nextInt(0, width - 2);
            int b = random.nextInt(0, width - 2);
            boolean horizontal = random.nextBoolean();

            if (horizontal) {
                if (checkCollision(field, a, b)) {
                    field[a][b] = 2;
                    field[a][b + 1] = 2;
                    destroyer++;
                }
            }
            else {
                if (checkCollision(field, a, b)) {
                    field[a][b] = 2;
                    field[a + 1][b] = 2;
                    destroyer++;
                }
            }

        }

        int simpleShip = 0;
        while (simpleShip < shipsPerField) {
            int a = random.nextInt(0, height);
            int b = random.nextInt(0, width);

            if (field[a][b] == 0) {
                field[a][b] = 1;
                simpleShip++;
            }
        }

        return field;
    }

    private boolean checkCollision(int[][] field, int a, int b) {
        return field[a][b] == 0 && field[a][b + 1] == 0 && field[a + 1][b] == 0 &&
                field[a + 1][b + 1] == 0 && field[a][b + 2] == 0 && field[a + 2][b] == 0 &&
                field[a + 2][b + 2] == 0;
    }

    private boolean checkBattleshipCollision(int[][] field, int a, int b) {
        return field[a][b] == 0 &&
                field[a][b + 1] == 0 && field[a + 1][b] == 0 &&
                field[a + 1][b + 1] == 0 && field[a][b + 2] == 0 && field[a + 2][b] == 0 &&
                field[a + 2][b + 2] == 0 && field[a][b + 3] == 0 && field[a + 3][b] == 0 &&
                field[a + 3][b + 3] == 0;
    }
}
