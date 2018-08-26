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
        String[] saSentences = s.split("[.]");
        for (String saSentence : saSentences) {
            String[] saWords = saSentence.split("[\\s]");
            for (int j = 0; j < saWords.length; j++) {
                if (saWords[j].length() > 0)
                    sbNewText.append(saWords[j].substring(0, 1).toUpperCase());
                sbNewText.append(saWords[j].substring(1).toLowerCase());
                if (j < saWords.length - 1)
                    sbNewText.append(" ");
            }
//            if(i < saSentences.length - 1)
            sbNewText.append(".");
        }
        return sbNewText.toString();
    }


}