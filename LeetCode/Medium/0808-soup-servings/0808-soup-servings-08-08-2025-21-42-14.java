class Solution {
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;

        Map<String, Double> memo = new HashMap<>();

        return helper(n, n, memo);
    }

    private double helper(int a, int b, Map<String, Double> memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double result = 0.25 * (
            helper(a - 100, b, memo) +
            helper(a - 75, b - 25, memo) +
            helper(a - 50, b - 50, memo) +
            helper(a - 25, b - 75, memo)
        );

        memo.put(key, result);
        return result;
    }
}
