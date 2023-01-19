import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _L290_wordPattern {

    public static boolean wordPattern(String pattern, String s) {
        // go through all pattern letters
        // save every letter for every word
        // check order of words with letters

        if (pattern.length() == 1)
            return true;

        String[] strArr = s.split(" ");
        String[] patternArr = pattern.split("");

        int countStr = 0, countPattern = 0;
        for (int fr = 0; fr < patternArr.length; fr++) {
            for (int sc = 1; sc < patternArr.length; sc++) {
                if (patternArr[fr].equals(patternArr[sc]) && fr < sc) {
                    System.out.println("\npatternArr[fr]: " + patternArr[fr] + " : index fr: " + fr);
                    System.out.println("patternArr[sc]: " + patternArr[sc] + " : index sc : " + sc);
                    countPattern++;
                    if (strArr[fr].equals(strArr[sc])) {
                        System.out.println("\nstrArr[fr]: " + strArr[fr] + " : index fr: " + fr);
                        System.out.println("strArr[sc]: " + strArr[sc] + " : index sc : " + sc);
                        countStr++;
                        System.out.println(countStr);
                    }
                    if (countStr == strArr.length)
            return true;
                    
                }
                
            }
        }
        

        return false;
    }

    public static void main(String[] args) {

        String pattern = "abba", s = "dog cat cat dog";
        String pattern1 = "abba", s1 = "dog cat cat fish";
        String pattern2 = "aaaa", s2 = "dog cat cat dog";
        String pattern3 = "aba", s3 = "dog cat dog";
        String pattern4 = "abba", s4 = "dog dog dog dog";

        // System.out.println("abba return: " + wordPattern(pattern, s));
        // System.out.println("abba return: " + wordPattern(pattern1, s1));
        // System.out.println("aaaa return: " + wordPattern(pattern2, s2));
        System.out.println("aba return: " + wordPattern(pattern3, s3));
        // System.out.println("abba return: " + wordPattern(pattern4, s4));

    }
}
