/**
 * Класс, реализующий невнятное ТЗ )
 * Так как в задании очевидно синтетическое происхождение строк, то я буду полагаться на это.
 * В реальной жизни я бы уточнил много моментов. Например, по 1:
 * Будут ли строки, состоящие из более одного предложения?
 * Всегда ли слова разделены в точности одним пробелом?
 * Если слово в предложении состоит из одной буквы, нужно ли повышать регистр?
 * Бывают ли предложения, не разделенные пробелами? Если да, то, следует ли в этом случае повышать
 * регистр первого слова предложения?
 * Нужно ли обрабатывать каким-либо образом другие знаки препинания?
 * Нужно ли реорганизовывать предложение(-я), убирая дубликаты знаков препинания, добавляя пробелы,
 * где это необходимо?
 * и т.д.
 * <p>
 * Поэтому решение задания построено на анализе указанных входных и выходных данных, их синтетичности
 * и количество проверок минимизировано ))
 * <p>
 * ЗАДАНИЕ 1) На вход подается строка, состоящая одного предложения, каждое слово разделено
 * ровно одним пробелом. Требуется повысить регистр первой буквы каждого слова и понизить регистр
 * оставшихся букв.
 * <p>
 * Окончание предложения символом "." навело на мысль что надо бы учесть тот факт, что предложений
 * может быть несколько, но было решено не усложнять себе жизнь, так как если бы возможно было
 * несколько предложений, то по аналогии с заданием 2, и было бы указано несколько предложений.
 * Для решения задания 1 был написан метод
 * firstLetterOfEveryWordHaveToBeBigThroughStringSplit
 * <p>
 * Также, в качестве выпендрежства, было написано еще два метода для решения этой же задачи,
 * firstLetterOfEveryWordHaveToBeBigThroughCharAnalysis
 * needToMakeUpper
 * которые гораздо более универсальны, и выполняют задачу на основе анализа текущего символа,
 * предыдущего символа, а также как вариант расширения возможностей возможен для анализа следующий
 * символ (в настоящем варианте никак не анализиреутся).
 * <p>
 * ЗАДАНИЕ 2) На вход подается строка, состоящая из правильных предложений. Необходимо посимвольно
 * развернуть каждое предожение, повысить регистр первой буквы и понизить регистр всех остальных
 * букв предложения.
 * Для решения задания 2 был написан метод
 * everySentenceHaveToBeRevertedAndAfterThatFirstLetterHaveToBeBig
 *
 * Также, есть тестовые методы для проверки указанных методов
 */
public class Practice2 {

    private static boolean needToMakeUpper(char prev, char cur, char next) {
        if (Character.isAlphabetic(cur)) {
            return prev == '.' || prev == ' ' || prev == 0 ||
                    prev == '(' || prev == ')' || prev == '-' ||
                    prev == '\r' || prev == '\n';
        }
        return false;
    }

    public static String firstLetterOfEveryWordHaveToBeBigThroughCharAnalysis(String s) {
        char previousChar = 0;
        char nextChar = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        do {
            if (i == sb.length() - 1) {
                nextChar = 0;
            } else {
                nextChar = sb.charAt(i + 1);
            }
            if (needToMakeUpper(previousChar, sb.charAt(i), nextChar)) {
                previousChar = Character.toUpperCase(sb.charAt(i));
            } else {
                previousChar = Character.toLowerCase(sb.charAt(i));
            }
            sb.setCharAt(i, previousChar);
        } while (++i < sb.length());
        return sb.toString();
    }

    public static String firstLetterOfEveryWordHaveToBeBigThroughStringSplit(String s) {
        StringBuilder sbNewText = new StringBuilder();
        String[] saWords = s.split("[\\s]");
        for (int j = 0; j < saWords.length; j++) {
            sbNewText.append(saWords[j].substring(0, 1).toUpperCase());
            if (saWords[j].length() > 1) {
                sbNewText.append(saWords[j].substring(1).toLowerCase());
            }
            if (j < saWords.length - 1)
                sbNewText.append(" ");
        }

        return sbNewText.toString();
    }

    public static String everySentenceHaveToBeRevertedAndAfterThatFirstLetterHaveToBeBig(String s) {
        StringBuilder sbNewText = new StringBuilder();
        String[] saSentences = s.split("[.]");
        for (int i = 0; i < saSentences.length; i++) {
            String saSentence = saSentences[i].trim();
            StringBuilder sb = new StringBuilder(saSentence);
            sb.reverse();
            sbNewText.append(sb.substring(0, 1).toUpperCase());
            if (sb.length() > 1) {
                sbNewText.append(sb.substring(1).toLowerCase());
            }
            sbNewText.append(".");
            if (i < saSentences.length - 1)
                sbNewText.append(" ");
        }
        return sbNewText.toString();
    }
}
