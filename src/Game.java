import java.util.Scanner;

public class Game {

    private int[][] field;

    public Game(int[][] field) {
        this.field = field;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            if (first < 10 && second < 10 && first >= 0 && second >= 0) {
                int shot = field[first][second];

                if (shot == 0) {
                    System.out.println("Вы не попали");
                }
                else System.out.println("Вы попали");
            }
            else {
                System.out.println("Мимо поля");
            }
        }

        //подсчет очков
        //тут как-то нужно играть
    }

}
