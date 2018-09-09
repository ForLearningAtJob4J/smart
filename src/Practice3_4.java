import java.util.Scanner;

public class Practice3_4 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ls = System.lineSeparator();

    private String playerOne, playerTwo;
    private Boolean winnerIsPlayerOne = null;
    private int generatedNumber;

    void getNamesAndGenerateNumber() {
        String message = "УГАДАЙ ЧИСЛО" + ls
                + "После ввода имен игроков компьютер генерирует случайное целое число" + ls
                + "из диапазона от 1 до 1000." + ls
                + "Игроки по очереди вводят свои варианты числа, компьютер сообщает," + ls
                + "вариант игрока больше или меньше сгенерированного числа." + ls
                + "Выигрывает тот, кто угадывает число." + ls
                + "Иггрок, который хочет сдаться вводит -1." + ls;
        System.out.println(message);
        ////////////////////////////////////////////////////
        System.out.print("Игроки, введите свои имена."
                + ls + "Игрок 1: ");
        playerOne = scanner.next();

        System.out.print("Игрок 2: ");
        playerTwo = scanner.next();

        generatedNumber = 1 + (int) (Math.random() * 1000);
        //System.out.println(generatedNumber);
    }

    void showResults() {
        char[] charPair = Character.toChars(0x1F386);
        String symbol = new String(charPair);

        if (winnerIsPlayerOne == null) {
            System.out.println("Выигравший еще неизвестен!");
        } else {
            System.out.println("ВЫИГРАЛ ИГРОК " + (winnerIsPlayerOne ? playerOne : playerTwo)
                    + " " + symbol + symbol + symbol);
        }
    }

    private boolean makeTurn(boolean isFirstPlayer) {
        boolean isItTheEnd = false;
        String name = isFirstPlayer ? playerOne : playerTwo;

        int guess;
        try {
            System.out.println(name + ", введите свой вариант: ");
            guess = Integer.parseInt(scanner.next());
            if (guess == -1) {
                winnerIsPlayerOne = !isFirstPlayer;
                isItTheEnd = true;
            } else if (guess == generatedNumber) {
                winnerIsPlayerOne = isFirstPlayer;
                isItTheEnd = true;
            } else if (guess < generatedNumber)
                System.out.println("Ваш вариант меньше загаданного числа.");
            else
                System.out.println("Ваш вариант больше загаданного числа.");
        } catch (Exception e) {
            System.out.println(name + ", Вы вводите что-то не то. "
                    + ls + "Вас нужно жестоко наказать, но в этой игре Вы просто пропускаете ход..."
                    + ls + "Вводите целое число из дапазона от 1 до 1000 или -1 чтобы сдаться!!!");
        }
        return isItTheEnd;
    }

    void run() {
        do {
            if (makeTurn(true))
                break;
            if (makeTurn(false))
                break;
        } while (true);
    }

    public static void main(String[] args) {
        Practice3_4 p = new Practice3_4();
        p.getNamesAndGenerateNumber();
        p.run();
        p.showResults();
    }
}
