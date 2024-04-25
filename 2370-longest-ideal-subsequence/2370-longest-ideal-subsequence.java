class Solution {
    public int longestIdealString(String inputString, int maxDifference) {
        int strLength = inputString.length();
        int[] dp = new int[27]; // Array to store the lengths of ideal strings for each character
        
        for (int i = strLength - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);
            int charIndex = currentChar - 'a';
            int maxLength = Integer.MIN_VALUE;
            int leftBound = Math.max((charIndex - maxDifference), 0);
            int rightBound = Math.min((charIndex + maxDifference), 26);
            
            for (int j = leftBound; j <= rightBound; j++) {
                maxLength = Math.max(maxLength, dp[j]);
            }
            dp[charIndex] = maxLength + 1;
        }

        int maxIdealLength = Integer.MIN_VALUE;
        for (int length : dp) {
            maxIdealLength = Math.max(length, maxIdealLength);
        }
        return maxIdealLength;
    }
}
