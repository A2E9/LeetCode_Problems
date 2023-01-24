import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class _L997_findJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 1, count2 = 1;
        for (int i = 0; i < trust.length; i++) {
            int temp = trust[i][1];

            if (map.containsKey(temp)) {
                if (count2 == 2) {
                    count++;
                    count2 = 1;
                }
                map.put(temp, count++);
System.arraycopy(trust, i, map, temp, n);
            } else {
                // if (!map.containsKey(trust[i][0]))
                    map.put(temp, count2++);
                // else
                //     map.put(temp, -1);
            }

        }
        System.out.print("\nBefore: " + map.toString()+"\n");

        for (int i = 0; i < trust.length; i++) {
            System.out.println("[0] "+trust[i][0]);
            System.out.println("[1] "+trust[i][1]);
            if (map.containsKey(trust[i][0])) {
                map.put(trust[i][0], -1);
            }
        }
        System.out.print("\nAfter: " + map.toString() + "\n");

        AtomicInteger atomic = new AtomicInteger(0);
        AtomicInteger atomicKey = new AtomicInteger(-1);
        map.entrySet().forEach(entry -> {
            if (entry.getValue() > atomic.get()) {
                atomic.set(entry.getValue());
                atomicKey.set(entry.getKey());
            }
        });

        return atomicKey.get();
    }

    public static void main(String[] args) {
        int[][] trust = { { 1, 2 } };
        int[][] trust1 = { { 1, 3 }, { 2, 3 } }; // 3
        int[][] trust2 = { { 1, 3 }, { 2, 3 }, { 3, 1 } }; // -1
        int[][] trust3 = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        int[][] trust4 = { { 1, 3 }, { 1, 4 }, { 2, 3 } };

        System.out.println("\n---return: " + findJudge(2, trust));
        System.out.println("\n---return: " + findJudge(3, trust1));
        System.out.println("\n---return: " + findJudge(3, trust2));
        System.out.println("\n---return: " + findJudge(3, trust3));
        System.out.println("\n---return: " + findJudge(4, trust4));// must -1 ??????????????????????????? returns 4
        // findJudge(2, trust);
        // findJudge(3, trust1);
        // findJudge(3, trust2);
        // findJudge(3, trust3);
    }
}
