import java.util.Scanner;

public class Game {

    private int[][] field;
    private int height;
    private int length;

    public Game(int[][] field) {
        this.field = field;
    }

    public Game() {

    }

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

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите высоту поля: ");
        setHeight(scanner.nextInt());
        System.out.println("Введите длину поля: ");
        setLength(scanner.nextInt());

        FieldGenerator fieldGenerator = new FieldGenerator(height, length);
        int[][] gameField = fieldGenerator.generate();

        FieldPrinter fieldPrinter = new FieldPrinter(height);
        fieldPrinter.printField(gameField);

        Game game = new Game(gameField);
        game.play();

        fieldPrinter.printField(gameField);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Координата по высоте: ");
            int first = scanner.nextInt();
            System.out.println("Координата по ширине: ");
            int second = scanner.nextInt();
            //todo заменить 10 на высоту и длину поля
            if (first < 5 && second < 5) {
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
