import java.util.Hashtable;

public class L13_romanToInteger {
    public static int romanToInt(String str) {
        int sLength = str.length();
        char arr[] = new char[sLength];

        arr = str.toCharArray();

        Hashtable<Character, Integer> dict = new Hashtable<Character, Integer>();

        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int sum = 0;
        int s = 1;
        boolean skip1 = false;
        boolean skip2 = false;
        for (int f = 0; f < sLength; f++) {
            if (s < sLength) {
                if (dict.get(arr[f]) < dict.get(arr[s])) {
                    if ((arr[f] == 'I') && (arr[s] == 'V' || arr[s] == 'X')) {
                        sum--;
                        skip1 = true;
                        skip2 = true;
                    }
                    else if ((arr[f] == 'X') && (arr[s] == 'L' || arr[s] == 'C')) {
                        sum -= 10;
                        skip1 = true;
                        skip2 = true;
                    }
                    else if ((arr[f] == 'C') && (arr[s] == 'D' || arr[s] == 'M')) {
                        sum -= 100;
                        skip1 = true;
                        skip2 = true;
                    }
                    sum += dict.get(arr[s]);
                } else if (!skip2) {
                    sum += dict.get(arr[f]);
                }else{
                    skip1 = false;
                    skip2 = false;
                }
                s++;
                if (s > sLength)
                    return sum;
            } else if (sLength == 1) {
                sum += dict.get(arr[f]);
            } else if (!skip1) {
                sum += dict.get(arr[f]);
                skip1 = !skip1;
            }
        }
        return sum;
    }

    // I 1
    // V 5
    // X 10
    // L 50
    // C 100
    // D 500
    // M 1000
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
    }
}
