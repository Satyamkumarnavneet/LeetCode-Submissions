class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                double benefitA = (double)(a[0] + 1) / (a[1] + 1) - (double)a[0] / a[1];
                double benefitB = (double)(b[0] + 1) / (b[1] + 1) - (double)b[0] / b[1];
                return Double.compare(benefitB, benefitA);
            }
        });

        for (int[] cls : classes) {
            pq.offer(cls);
        }
        
        for (int i = 0; i < extraStudents; i++) {
            int[] bestClass = pq.poll();
            bestClass[0]++;
            bestClass[1]++;
            pq.offer(bestClass);
        }

        double totalPassRatio = 0.0;
        for (int[] cls : pq) {
            totalPassRatio += (double)cls[0] / cls[1];
        }
        return totalPassRatio / classes.length;
    }
}