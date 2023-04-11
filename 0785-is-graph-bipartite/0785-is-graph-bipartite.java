class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i=0;i<graph.length; i++){
            if(color[i]==-1)
                if(bfs(i,graph,color)==false) 
                    return false;
        }
       
        return true;
    }
    
    public boolean bfs(int start, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            
            for(int adjacent: graph[node]){
                if(color[adjacent]==-1){
                    queue.offer(adjacent);
                    color[adjacent] = 1 - color[node];
                } 
                else if(color[adjacent]==color[node]){
                    return false;
                }
            }
        }
        return true;    
    }
}