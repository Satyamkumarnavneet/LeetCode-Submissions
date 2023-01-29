class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x<10){
            return true;
        }
        if(x % 10 == 0){
            return false;
        }
        int resv = 0;
        while(resv < x){
            int digit = x%10;
            resv = resv*10+digit;
            x /= 10;   
        }
        return resv == x || resv /10 == x;
    }
}