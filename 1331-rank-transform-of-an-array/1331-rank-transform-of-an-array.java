class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}

/* 
To transform the given array, the approach involves first creating a copy of the original array and sorting it in ascending order. This sorted array is then traversed to assign ranks to each unique element, storing the ranks in a map. While assigning ranks, if an element is encountered more than once, it receives the same rank as the first occurrence, ensuring that identical elements are assigned the same rank. After completing the rank assignment, the original array is traversed, and each element is replaced with its corresponding rank from the map. This process ensures that the modified array contains ranks in place of the original elements, meeting the specified problem requirements and adhering to the given limitations.
*/