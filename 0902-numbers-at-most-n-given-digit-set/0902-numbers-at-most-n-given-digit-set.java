class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr = String.valueOf(n);
        int len = nStr.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        
        for (int i = len - 1; i >= 0; i--) {
            int currentDigit = nStr.charAt(i) - '0';
            for (String digit : digits) {
                int d = Integer.parseInt(digit);
                if (d < currentDigit) {
                    dp[i] += Math.pow(digits.length, len - i - 1);
                } else if (d == currentDigit) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        
        for (int i = 1; i < len; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }
}
