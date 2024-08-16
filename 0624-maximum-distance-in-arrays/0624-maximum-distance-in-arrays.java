class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            result = Math.max(result, Math.abs(array.get(array.size() - 1) - minVal));
            result = Math.max(result, Math.abs(maxVal - array.get(0)));
            minVal = Math.min(minVal, array.get(0));
            maxVal = Math.max(maxVal, array.get(array.size() - 1));
        }

        return result;
    }
}
