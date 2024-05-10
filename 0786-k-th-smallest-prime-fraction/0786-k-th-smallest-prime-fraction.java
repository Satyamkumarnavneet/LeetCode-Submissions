class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1.0;

        while (left < right) {
            double mid = (left + right) / 2;
            int[] countResult = countFractions(arr, mid);
            if (k < countResult[0]) {
                right = mid;
            } else if (k > countResult[0]) {
                left = mid;
            } else {
                return new int[]{countResult[1], countResult[2]};
            }
        }
        return null;
    }

    static int[] countFractions(int[] arr, double target) {
        int count = 0, i = 0, n = arr.length, numerator = arr[0], denominator = arr[n - 1];

        for (int j = 1; j < n; j++) {
            while (arr[i] <= arr[j] * target) {
                i++;
            }
            count += i;
            if (i > 0 && arr[i - 1] * denominator > arr[j] * numerator) {
                numerator = arr[i - 1];
                denominator = arr[j];
            }
        }
        return new int[]{count, numerator, denominator};
    }
}
