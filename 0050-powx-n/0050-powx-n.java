class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                // to avoid overflow when taking the absolute value of n
                n = Integer.MAX_VALUE;
                x = 1/x * 1/x;
            } else {
                n = -n;
                x = 1/x;
            }
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}
