class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num2);
        int x = 0;
        
        for (int i = 30; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0 && count > 0) {
                x |= (1 << i);
                count--;
            }
        }
        
        for (int i = 0; i <= 30 && count > 0; i++) {
            if ((x & (1 << i)) == 0) {
                x |= (1 << i);
                count--;
            }
        }
        return x;
    }
}
