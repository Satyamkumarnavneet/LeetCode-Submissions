class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        return (int)((power(5, evenCount, mod) * power(4, oddCount, mod)) % mod);
    }

    private long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
