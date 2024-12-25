class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 1;
            int currentMax = 0;

            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if (deltaX == 0 && deltaY == 0) {
                    duplicates++;
                    continue;
                }

                int gcd = getGCD(deltaX, deltaY);
                deltaX /= gcd;
                deltaY /= gcd;

                String slope = deltaX + "/" + deltaY;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, currentMax + duplicates);
        }

        return maxPoints;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}