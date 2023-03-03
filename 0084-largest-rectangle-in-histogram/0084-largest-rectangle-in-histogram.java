class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int nextSmLeft [] = new int [heights.length];
        int nextSmRight [] = new int [heights.length];
        Stack<Integer> s  = new Stack<>();
        
        // Next smallest left
        for(int i = 0; i<heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            } 
            if(s.isEmpty()){
                nextSmLeft [i] = -1;
            } else {
                nextSmLeft[i] = s.peek();
            }
            s.push(i);
        }
        
        // Next Smallest Right
        s  = new Stack<>();
        for(int i = heights.length-1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmRight[i] = heights.length;
            } else{
                nextSmRight[i] = s.peek();
            }
            s.push(i);
        }
        
        // Current Area 
        for(int i = 0; i<heights.length; i++){
            int length = heights[i];
            int width = nextSmRight[i] - nextSmLeft[i] - 1;
            int currArea = length * width;
            maxArea = Math.max(currArea, maxArea);
        }
        
        return maxArea;
    }
}