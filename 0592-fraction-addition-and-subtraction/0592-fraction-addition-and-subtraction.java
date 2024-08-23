class Solution {
    public String fractionAddition(String expression) {
        String frs[] = expression.split("(?=[+-])");
        long num = 0, den = 1;
        for (String fr : frs) {
            String[] current = fr.split("/");
            long a = Long.parseLong(current[0]);
            long b = Long.parseLong(current[1]);
            num = num * b + a * den;
            den = den * b;

            long gcd = gcd(Math.abs(num), Math.abs(den));
            num /= gcd;
            den /= gcd;
        }
        return num + "/" + den;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
