class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] lastOccurrence = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastOccurrence[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastOccurrence[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastOccurrence[d]];
                    digits[lastOccurrence[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}
