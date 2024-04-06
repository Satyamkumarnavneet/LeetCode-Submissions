class Solution {
    public String minRemoveToMakeValid(String s) {
        // Convert the input string to a character array for easier manipulation
        char[] chars = s.toCharArray();
        // Initialize a stack to keep track of the indices of open parentheses
        Stack<Integer> stack = new Stack<>();
        // Iterate through the string to find the indices of parentheses to be removed
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);  // Push the index of open parenthesis onto the stack
            } else if (chars[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();  // Pop the index of the matching open parenthesis from the stack
                } else {
                    chars[i] = '*';  // Mark the closing parenthesis for removal
                }
            }
        }
        // Mark the unmatched open parentheses for removal
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '*';
        }
        // Construct the resulting string with removed parentheses
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                result.append(c);
            }
        }
        return result.toString();
    }
}
