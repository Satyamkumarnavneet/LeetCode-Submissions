class Solution {
    public int pivotInteger(int n) {
        double x = Math.sqrt((n * (n + 1)) / 2);
        if (x % 1 == 0) {
            return (int) x;
        } else {
            return -1;
        }
    }
}