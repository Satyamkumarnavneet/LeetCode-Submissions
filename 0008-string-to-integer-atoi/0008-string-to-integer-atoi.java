class Solution {
    public int myAtoi(String s) {
        s=s.strip();
        if(s.isEmpty()){
            return 0;
        }
        boolean isNeg= s.charAt(0) == '-';
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        long ans=0;
        for (char ch:s.toCharArray()) {
            if(!(Character.isDigit(ch))){
                break;
            }
            if(isNeg){
                ans=(ans*10)-(ch-'0');
            }else{
                ans=(ans*10)+(ch-'0');
            }
            if (ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        return (int)ans;
    }
}