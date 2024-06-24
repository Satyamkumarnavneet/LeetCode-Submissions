
class Solution {
    public int minKBitFlips(int[] nums, int k) {
         Queue<Integer> q=new LinkedList<>();

	      int count=0;
          
	      for(int i=0;i<nums.length;i++) {
	    	  int curflips=q.size();
	    	  int conv=-1;
	    	  if(curflips%2==0) conv=1;
	    	  else conv=0;
	    	  if(nums[i]!=conv) {
	    		  q.add(i+k-1);
	    		  count++;
	    	  }
	    	  if(!q.isEmpty()&&q.peek()<=i)
	    		  q.poll();
	      }
	      if(!q.isEmpty()) return -1;
	      return count;
    }
}