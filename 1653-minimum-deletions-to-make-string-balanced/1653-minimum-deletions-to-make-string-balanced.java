class Solution {
    public int minimumDeletions(String s) {
        int countA = 0;
        int countB = 0;
        int deletions = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (countB > 0) {
                    deletions++;
                    countB--;
                } else {
                    countA++;
                }
            } else { // c == 'b'
                countB++;
            }
        }
        return deletions;
    }
}
