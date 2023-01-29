class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        
        int startIdx = 0;
        int endIdx = s.length()-1;
        
        while(startIdx <= endIdx){
            if(s.charAt(startIdx) != s.charAt(endIdx)){
                return false;
            }
            startIdx++;
            endIdx--;
        }
        return true;
        
    }
}