class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return 0;
        }
        
        int n = timePoints.size();
        List<Integer> minutes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = timePoints.get(i).split(":");
            minutes.add(Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]));
        }
        
        Collections.sort(minutes);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }
        
        minDiff = Math.min(minDiff, 24 * 60 - (minutes.get(n - 1) - minutes.get(0)));
        return minDiff;
    }
}
