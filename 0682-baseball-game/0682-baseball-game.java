class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack();
        for(String ope: operations){
            if(ope.equals("+")){
                int top = s.pop();
                int newTop = top + s.peek();
                s.push(top);
                s.push(newTop);
            } else if(ope.equals("C")){
                s.pop();
            } else if(ope.equals("D")){
                s.push(2*s.peek());
            } else {
                s.push(Integer.valueOf(ope));
            }
        }
        int ans = 0;
        while(!s.isEmpty()){
            ans += s.pop();
        }
        return ans;
        
        
    }
}