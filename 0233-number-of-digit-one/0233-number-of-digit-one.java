class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long position = 1;
        long digit;
        long high, low, current;
        high = n;
        
        while (high > 0) {
            high = n / (position * 10);
            current = (n / position) % 10;
            low = n - (n / position) * position;
            if (current == 0) {
                count += high * position;
            } else if (current == 1) {
                count += high * position + low + 1;
            } else {
                count += (high + 1) * position;
            }
            position *= 10;
        }
        return count;
    }
}
