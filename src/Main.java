public class Main {
    public static void main(String[] args) {

        FieldGenerator fieldGenerator = new FieldGenerator(10, 10);
        int[][] field = fieldGenerator.generate();

        FieldPrinter fieldPrinter = new FieldPrinter(10);
        fieldPrinter.printField(field);

        Game game = new Game(field);
        game.start();

    }
}