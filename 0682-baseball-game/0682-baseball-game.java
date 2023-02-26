class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s  = new Stack();
        
        for(String oper: operations){
            if(oper.equals("+")){
                int top = s.pop();
                int newTop = top + s.peek();
                s.push(top);
                s.push(newTop);
            } else if(oper.equals("C")){
                s.pop();
            } else if(oper.equals("D")){
                s.push(2*(s.peek()));
            } else {
                s.push(Integer.valueOf(oper));
            } 
        }
        int ans = 0;
        while(!s.isEmpty()){
            ans+= s.pop();
        }
        return ans;        
    }
}