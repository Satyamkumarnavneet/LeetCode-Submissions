class Solution {
    public int finalValueAfterOperations(String[] operations) {
       int count=0;
       for(String str : operations){
       if(str.charAt(1)=='+'){
       count++;           
    }  else count--;
           
           }        
           return count;
    }
}