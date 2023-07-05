class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = cleanedString.length();
        for(int i = 0; i<n/2; i++){
            if(cleanedString.charAt(i) != cleanedString.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}

