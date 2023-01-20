public class L520_detectCapitalUse {
    public static boolean detectCapitalUse(String word) {
        // all capitals
        // all not capitals
        // first capital

        // if (word.toLowerCase().equals(word) || word.toUpperCase().equals(word))
        // return true;
        // if (word.charAt(0) == word.toUpperCase().charAt(0)) {
        // String subSeq = word.subSequence(1, word.length()).toString();
        // if (subSeq.toLowerCase().equals(subSeq) ||
        // subSeq.toUpperCase().equals(subSeq))
        // return true;
        // }

        boolean allUpperCase = true;
        boolean allLowerCase = true;
        boolean firstUpperCase = true;
        for (int i = 0; i < word.length(); i++) {
            if (allUpperCase && !Character.isUpperCase(word.charAt(i)))
                allUpperCase = false;

            if (allLowerCase && !Character.isLowerCase(word.charAt(i)))
                allLowerCase = false;

            if ((i > 0
                    && firstUpperCase)) {
                if (!Character.isUpperCase(word.charAt(0)))
                    firstUpperCase = false;
                for (int j = 1; j < word.length(); j++) {
                    if (!Character.isLowerCase(word.charAt(j))) {
                        firstUpperCase = false;
                        break;
                    }
                }
            }
        }
        if (allLowerCase || allUpperCase || firstUpperCase)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
        System.out.println(detectCapitalUse("ffffffffffffffffffffF"));

    }
}
