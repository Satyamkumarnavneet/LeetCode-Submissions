class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> part1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(expression.substring(i + 1));
                for (int p1 : part1) {
                    for (int p2 : part2) {
                        if (c == '+') {
                            result.add(p1 + p2);
                        } else if (c == '-') {
                            result.add(p1 - p2);
                        } else if (c == '*') {
                            result.add(p1 * p2);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}
