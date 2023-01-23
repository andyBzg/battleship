import java.util.Random;

public class FieldGenerator {

    private int height;
    private int width;


    public FieldGenerator(int height, int width) {
        this.height = height;
        this.width = width;
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

        //simpleShip - одна клетка х 4
        //destroyer - 2 клетки х 3
        //cruiser - 3 клетки х 2
        //battleship - 4 клетки х 1

        int battleship = 0;
        while (battleship < 1) {
            int a = random.nextInt(0, height - 3);
            int b = random.nextInt(0, width - 3);

            if (field[a][b] == 0) {
                field[a][b] = 4;
                battleship++;
            }
        }

        boolean battleshipRotation = random.nextBoolean();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 4 && battleshipRotation) {
                    for (int k = 0; k < 3; k++) {
                        j++; // rotation == true - горизонтальное отображение
                        field[i][j] = 4;
                    }
                }
                else if (field[i][j] == 4 && !battleshipRotation) {
                    for (int k = 0; k < 3; k++) {
                        i++; // rotation == false - вертикальное отображение
                        field[i][j] = 4;
                    }
                }
            }
        }

        int destroyer = 0;
        while (destroyer < 4) {
            int a = random.nextInt(0, height);
            int b = random.nextInt(0, width - 1);

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
        while (simpleShip < 6) {
            int a = random.nextInt(0, height);
            int b = random.nextInt(0, width);

            if (field[a][b] == 0) {
                field[a][b] = 1;
                simpleShip++;
            }

        }
        return field;
    }
}
