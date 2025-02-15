class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (checkPartition(i)) {
                result += i * i;
            }
        }
        return result;
    }
    
    private boolean checkPartition(int num) {
        String s = Integer.toString(num * num);
        return dfsPartition(s, num, 0, 0);
    }
    
    private boolean dfsPartition(String s, int num, int idx, int total) {
        if (idx == s.length()) {
            return total == num;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            int part = Integer.parseInt(s.substring(idx, i));
            if (total + part <= num && dfsPartition(s, num, i, total + part)) {
                return true;
            }
        }
        return false;
    }
}
