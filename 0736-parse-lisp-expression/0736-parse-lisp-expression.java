class Solution {
    int index;
    String expression;

    String getVariableName() {
        StringBuilder variableName = new StringBuilder();
        while (expression.charAt(index) != ' ' && expression.charAt(index) != ')') 
            variableName.append(expression.charAt(index++));
        return variableName.toString();
    }

    int evaluateExpression(Map<String, Integer> variables) {
        while (expression.charAt(index) == ' ' || expression.charAt(index) == ')') index++;
        String prefix = expression.substring(index);
        index += 5;
        if (prefix.startsWith("(a")) return evaluateExpression(variables) + evaluateExpression(variables);
        else if (prefix.startsWith("(m")) return evaluateExpression(variables) * evaluateExpression(variables);
        else if (prefix.startsWith("(l")) {
            Map<String, Integer> currentMap = new HashMap<>();
            currentMap.putAll(variables);
            while (true) {
                while (expression.charAt(index) == ' ' || expression.charAt(index) == ')') index++;
                char currentChar = expression.charAt(index);
                if (currentChar == '(' || currentChar == '-' || Character.isDigit(currentChar)) 
                    return evaluateExpression(currentMap);
                String variable = getVariableName();
                currentChar = expression.charAt(index);
                if (currentChar == ')') return currentMap.get(variable);
                currentMap.put(variable, evaluateExpression(currentMap));
            }
        }
        index -= 5;
        char currentChar = expression.charAt(index);
        if (!(currentChar == '-' || Character.isDigit(currentChar))) 
            return variables.get(getVariableName());
        String numericExpression = "";
        while (index < expression.length() && expression.charAt(index) != ')' && expression.charAt(index) != ' ') 
            numericExpression += expression.charAt(index++);
        return Integer.parseInt(numericExpression);
    }

    public int evaluate(String expression) {
        this.expression = expression;
        return evaluateExpression(new HashMap<>());
    }
}
