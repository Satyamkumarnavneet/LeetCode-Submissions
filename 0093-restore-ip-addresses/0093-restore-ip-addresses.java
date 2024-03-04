class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(String s, List<String> result, List<String> current, int start) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        
        for (int end = start + 1; end <= Math.min(start + 3, s.length()); end++) {
            String segment = s.substring(start, end);
            if (isValidSegment(segment)) {
                current.add(segment);
                backtrack(s, result, current, end);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isValidSegment(String segment) {
        if (segment.length() > 3 || segment.length() == 0 || (segment.charAt(0) == '0' && segment.length() > 1)) {
            return false;
        }
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}
