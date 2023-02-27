class Solution {
     public double myPow(double x, int n) {
         if(n==0){
            return 1;
        }
        // if(n<0){
        //     n=-n;
        //     x=1/x;
        // }
         if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                // to avoid overflow when taking the absolute value of n
                n = Integer.MAX_VALUE;
                x = 1/x * 1/x;
            } else {
                n = -n;
                x = 1/x;
            }
        }
        double halfpower=myPow(x,n/2);
        double halfpowsq=halfpower*halfpower;
        if(n%2!=0){
            halfpowsq=x*halfpower*halfpower;
        }
        return halfpowsq;
    }
}