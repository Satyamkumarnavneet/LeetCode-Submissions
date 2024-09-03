class Solution {
   public int getLucky(String s, int k) {
       StringBuilder sb = new StringBuilder();
       
       for(char c : s.toCharArray()){
           int position = c - 'a' + 1;
           sb.append(position);
       }
       
       for(int i = 0; i < k; i++){
           int sum = 0;
           for(char c : sb.toString().toCharArray()){
               sum += Character.getNumericValue(c);
           }
           sb = new StringBuilder(String.valueOf(sum));
       }
       return Integer.parseInt(sb.toString());
   }
}
