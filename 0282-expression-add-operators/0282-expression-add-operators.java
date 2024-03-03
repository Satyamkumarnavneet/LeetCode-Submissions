class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        
        backtrack(result, num, target, "", 0, 0, 0);
        
        return result;
    }
    
    private void backtrack(List<String> result, String num, int target, String path, int index, long eval, long multed) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            
            long currentNum = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                backtrack(result, num, target, path + currentNum, i + 1, currentNum, currentNum);
            } else {
                backtrack(result, num, target, path + "+" + currentNum, i + 1, eval + currentNum, currentNum);
                backtrack(result, num, target, path + "-" + currentNum, i + 1, eval - currentNum, -currentNum);
                backtrack(result, num, target, path + "*" + currentNum, i + 1, eval - multed + multed * currentNum, multed * currentNum);
            }
        }
    }
}
