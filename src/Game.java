import java.util.Scanner;

public class Game {

    private int[][] field;
    private int height;
    private int width;
    private int attempts;


    public Game(int[][] field, int height, int width, int attempts) {
        this.field = field;
        this.height = height;
        this.width = width;
        this.attempts = attempts;
    }

    public Game() {

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

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите высоту поля: ");
        setHeight(scanner.nextInt());
        System.out.println("Введите ширину поля: ");
        setWidth(scanner.nextInt());
        System.out.println("Введите количество попыток: ");
        setAttempts(scanner.nextInt());

        FieldGenerator fieldGenerator = new FieldGenerator(height, width);
        int[][] gameField = fieldGenerator.generate();

        FieldPrinter fieldPrinter = new FieldPrinter(height);
        fieldPrinter.printField(gameField);

        Game game = new Game(gameField, height, width, attempts);
        game.play();

        fieldPrinter.printField(gameField);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;

        for (int i = 0; i < attempts; i++) {
            System.out.println("Координата по высоте: ");
            int first = scanner.nextInt();
            System.out.println("Координата по ширине: ");
            int second = scanner.nextInt();

            if (first < height && second < width && first >= 0 && second >= 0) {
                int shot = field[first][second];

                if (shot == 0) {
                    System.out.println("Промах");
                }
                else if (shot == 8) {
                    System.out.println("Корабль уже подбит");
                }
                else if (shot > 0 && shot < 5) {
                    counter++;
                    field[first][second] = 8;
                    System.out.println("Попадание!");
                }
            }
            else {
                System.out.println("Мимо поля");
            }

        }

        System.out.println("Ты уничтожил кораблей: " + counter);
    }

}
