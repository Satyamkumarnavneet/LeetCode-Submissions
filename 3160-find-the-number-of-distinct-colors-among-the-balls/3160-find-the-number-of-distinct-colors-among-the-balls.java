class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballToColor.containsKey(ball)) {
                int prevColor = ballToColor.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                }
            }
            ballToColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            result[i] = colorCount.size();
        }
        
        return result;
    }
}
