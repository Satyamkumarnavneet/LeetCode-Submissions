class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] index = new int[n];
        for (int[] edge : edges) {
            index[edge[1]]++;
        }
        int champion = -1;
        int countZeroIndegree = 0;
        for (int i = 0; i < n; i++) {
            if (index[i] == 0) {
                countZeroIndegree++;
                champion = i;
            }
        }
        return countZeroIndegree == 1 ? champion : -1;
    }
}
