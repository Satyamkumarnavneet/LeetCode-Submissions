class Solution {
    public int maximumLength(String s) {
        int maxLength = -1;
        int n = s.length();
        
        for (int i = 0; i < n; ) {
            char current = s.charAt(i);
            int length = 0;
            
            while (i < n && s.charAt(i) == current) {
                length++;
                i++;
            }
            
            for (int l = 1; l <= length; l++) {
                String specialSubstring = String.valueOf(current).repeat(l);
                int count = 0;
                
                for (int j = 0; j <= n - l; j++) {
                    if (s.substring(j, j + l).equals(specialSubstring)) {
                        count++;
                    }
                }
                
                if (count >= 3) {
                    maxLength = Math.max(maxLength, l);
                }
            }
        }
        return maxLength;
    }
}
