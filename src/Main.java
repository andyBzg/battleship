import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Info.showGameRules();
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите высоту поля: ");
        game.setHeight(scanner.nextInt());
        System.out.println("Введите ширину поля: ");
        game.setWidth(scanner.nextInt());
        System.out.println("Введите количество попыток: ");
        game.setAttempts(scanner.nextInt());

        game.start();

    }
}