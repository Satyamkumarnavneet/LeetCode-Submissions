// class Solution {
//     public boolean isPalindrome(String s) {
//         int n = s.length();
//         s = s.toLowerCase();
//         for(int i = 0; i<n/2; i++){
//             if(s.charAt(i) != s.charAt(n-1-i)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = cleanedString.length();
        
        for (int i = 0; i < n/2; i++) {
            if (cleanedString.charAt(i) != cleanedString.charAt(n-1-i)) {
                return false;
            }
        }
        return true;
    }
}
