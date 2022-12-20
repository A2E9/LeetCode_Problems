public class L1704_halvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        int sLength = s.length();
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        char[] aa = s.substring(0, sLength / 2).toLowerCase().toCharArray();
        char[] bb = s.substring(sLength / 2).toLowerCase().toCharArray();

        int count = 0;
        int count2 = 0;
        for (int letter = 0; letter < sLength / 2; letter++) {
            for (int vowl = 0; vowl < vowels.length; vowl++) {
                if (aa[letter] == vowels[vowl]) {
                    count++;
                }
                if (bb[letter] == vowels[vowl]) {
                    count2++;
                }
            }
        }

        return (count == count2) ? true : false;

    }

    public static void main(String[] args) {
       System.out.println(halvesAreAlike("tkPAdxpMfJiltOerItiv")); 
    }
}
