class Solution {
    public int numSteps(String s) {
        int n = s.length(), carry = 0, ans = 0;
        
        for (int i = n - 1; i >= 1; i--) {
            if ((s.charAt(i) - '0' + carry) % 2 == 1) {
                ans += 2;
                carry = 1;
            } else {
                ans += 1;
            }
        }
        return ans + carry;
    }
}