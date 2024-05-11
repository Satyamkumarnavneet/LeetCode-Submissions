class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length; 
        Worker[] workers = new Worker[N]; 
        for (int i = 0; i < N; ++i) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers); 
        
        double minCost = Double.MAX_VALUE; 
        int sumQuality = 0; 
        PriorityQueue<Integer> qualityPool = new PriorityQueue(); 
        for (Worker worker : workers) {
            qualityPool.offer(-worker.quality);
            sumQuality += worker.quality; 
            if (qualityPool.size() > K) {
                sumQuality += qualityPool.poll(); 
            }
            if (qualityPool.size() == K) {
                minCost = Math.min(minCost, sumQuality * worker.ratio());
            }
        }
        return minCost; 
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage; 
    public Worker(int q, int w) {
        this.quality = q; 
        this.wage = w; 
    }
    
    public double ratio() {
        return (double) wage / quality;
    }
    
    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio()); 
    }
}
