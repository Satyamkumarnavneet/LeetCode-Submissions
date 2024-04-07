class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> stackOpening = new ArrayDeque<>(); // Store indices of '('
        Deque<Integer> stackAsterisk = new ArrayDeque<>(); // Store indices of '*'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stackOpening.push(i);
            } else if (c == '*') {
                stackAsterisk.push(i);
            } else { // c == ')'
                if (!stackOpening.isEmpty()) {
                    stackOpening.pop(); // Match ')' with '('
                } else if (!stackAsterisk.isEmpty()) {
                    stackAsterisk.pop(); // Match ')' with '*'
                } else {
                    return false; // No matching '(' or '*' found
                }
            }
        }

        while (!stackOpening.isEmpty() && !stackAsterisk.isEmpty()) {
            if (stackOpening.peek() > stackAsterisk.peek()) {
                return false; // '*' occurs before '('
            }
            stackOpening.pop();
            stackAsterisk.pop();
        }

        return stackOpening.isEmpty();
    }
}
