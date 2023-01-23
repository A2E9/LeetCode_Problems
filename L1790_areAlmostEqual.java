import java.util.HashMap;

public class L1790_areAlmostEqual {
    public static boolean areAlmostEqual(String s1, String s2) {

        // check if string have the same character set
        HashMap<Character, Integer> map = new HashMap<>();
        int strLength = s2.length();
        for (int i = 0; i < strLength; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < strLength; i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count == 1)
                    map.remove(c);
                else
                    map.put(c, count - 1);
            }else return false;
        }

        // check if two characters are replacable in strings or are the same
        int count = 0;
        for (int i = 0; i < strLength; i++)
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        return (count == 2 || count == 0);

    }

    public static void main(String[] args) {

        System.out.println(areAlmostEqual("kanb", "bank"));
        System.out.println(areAlmostEqual("caa", "aaz"));

    }
}
