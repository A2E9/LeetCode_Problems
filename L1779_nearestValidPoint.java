public class L1779_nearestValidPoint {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int smallest = Integer.MAX_VALUE, smallestIndex = -1;
        for (int i = 0; i < points.length; i++)
            if (points[i][0] == x || points[i][1] == y) {
                int pointA = Math.abs(x - points[i][0]);
                int pointB = Math.abs(y - points[i][1]);
                int sumPoints = pointA + pointB;
                if (smallest > sumPoints) {
                    smallest = sumPoints;
                    if (sumPoints >= smallest) smallestIndex = i;
                }
            }
        return smallestIndex;
    }

    public static void main(String[] args) {

        int[][] points = { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } };
        int[][] points1 = { { 3, 4 } };
        int[][] points2 = { { 2, 3 } };
        int[][] points3 = { { 32, 10 }, { 3, 7 }, { 16, 65 }, { 57, 68 }, { 25, 14 }, { 82, 70 }, { 80, 2 }, { 34, 54 },
                { 62, 77 }, { 46, 33 }, { 1, 68 }, { 83, 77 }, { 56, 29 }, { 21, 66 }, { 79, 81 }, { 15, 50 },
                { 44, 36 }, { 67, 79 }, { 61, 59 }, { 59, 55 }, { 46, 21 }, { 66, 11 }, { 55, 33 }, { 48, 54 },
                { 41, 83 }, { 21, 2 }, { 81, 27 }, { 24, 35 }, { 50, 83 }, { 60, 27 }, { 45, 38 }, { 43, 36 },
                { 15, 34 }, { 33, 17 }, { 69, 31 }, { 13, 48 }, { 71, 66 }, { 53, 62 }, { 29, 12 }, { 22, 30 },
                { 24, 40 }, { 13, 11 }, { 22, 17 }, { 68, 46 }, { 17, 37 } };

        System.out.println("return: " + nearestValidPoint(3, 4, points));
        System.out.println("return: " + nearestValidPoint(3, 4, points1));
        System.out.println("return: " + nearestValidPoint(3, 4, points2));
        System.out.println("return: " + nearestValidPoint(71, 13, points3));

    }
}
