class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = nextUgly;

            if (nextUgly == factor2) {
                index2++;
                factor2 = ugly[index2] * 2;
            }
            if (nextUgly == factor3) {
                index3++;
                factor3 = ugly[index3] * 3;
            }
            if (nextUgly == factor5) {
                index5++;
                factor5 = ugly[index5] * 5;
            }
        }
        return ugly[n - 1];
    }
}
