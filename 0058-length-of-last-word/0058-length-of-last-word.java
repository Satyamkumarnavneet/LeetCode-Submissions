class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == ' '){ // Hello world
                len = 0;
                continue;
            } else{
                len++;
            }
        }
        return len;
    }
}