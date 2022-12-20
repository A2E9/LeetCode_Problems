public class L14_longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        // take first word, first letter
        // check that letter with other words
        // if one leter doesnt contain that, ake last saved word
        // search for the first letter in all words
        // if true put in string else return ""
        int count = 0;
        String prefix = "";
        String longestPrefix = "";
        for (int letter = 1; letter <= strs[0].length(); letter++) {
            for (int word = 0; word < strs.length; word++) {
                String fWord = strs[0].substring(0, letter);
                String sWord = "";
                if ((strs[word].length() >= letter))
                    sWord = strs[word].substring(0, letter);
                if (fWord.equals(sWord)) {
                    count++;
                    prefix = fWord;
                    if (strs.length == count) {
                        count = 0;
                        if (prefix.length() > longestPrefix.length()) {
                            longestPrefix = prefix;
                            prefix = "";
                        }
                    }
                } else if (prefix.length() > 0) {
                    prefix = "";
                    count = 0;
                    break;
                }
            }
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flowht", "flowe" };

        System.out.println(longestCommonPrefix(strs));
        // System.out.println(longestPrefix(strs));

    }

    public static String longestPrefix(String[] strs) {
        // Word length 0-200
        // Array length 1-200

        // 2 Dimensional array
        // column for prefixes
        // row for count

        // check every word with all words
        // count how much prfx containing all words

        // [row][column]
        String[][] prefCounter = new String[2][350];// lazy to create dynamic length

        if (strs.length == 1)
            return strs[0];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 350; j++)
                prefCounter[i][j] = "";
        }

        int countOccurrence = 1;
        int newColumn = 0;
        for (int currWord = 0; currWord < strs.length; currWord++) {
            if (!strs[currWord].trim().isEmpty())
                for (int letter = 0; letter < strs[currWord].length(); letter++) {
                    String strLetter = strs[currWord].substring(0, letter + 1);
                    String arrayLetter = prefCounter[0][letter];
                    if (!strLetter.equals(arrayLetter)) {
                        prefCounter[0][newColumn] += strLetter;
                        for (int nextWord = 0; nextWord <= strs.length - 1; nextWord++) {
                            if (!(nextWord == currWord))
                                if (strs[nextWord].startsWith(prefCounter[0][newColumn]))
                                    countOccurrence++;
                        }
                        prefCounter[1][newColumn] = Integer.toString(countOccurrence);
                        countOccurrence = 1;
                        newColumn++;
                    }
                }
        }

        int biggest = 0;
        int index = 0;
        for (int i = 0; i < newColumn; i++) {
            if (biggest <= Integer.parseInt(prefCounter[1][i])) {
                biggest = Integer.parseInt(prefCounter[1][i]);
                index = i;
            }
        }
        if (biggest <= 1)
            return "";
        return prefCounter[0][index];
    }
}
