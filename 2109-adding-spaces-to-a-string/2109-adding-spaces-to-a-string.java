class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int spaceIndex = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                ans.append(' ');
                spaceIndex++;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
