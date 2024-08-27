import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<SimpleEntry<Integer, Double>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new SimpleEntry<>(b, prob));
            graph.get(b).add(new SimpleEntry<>(a, prob));
        }

        PriorityQueue<SimpleEntry<Double, Integer>> queue = new PriorityQueue<>(Comparator.comparingDouble(SimpleEntry::getKey));

        double[] probabilities = new double[n];
        probabilities[start] = 1.0;
        queue.offer(new SimpleEntry<>(-1.0, start));

        while (!queue.isEmpty()) {
            SimpleEntry<Double, Integer> pair = queue.poll();
            double currentProbability = pair.getKey();
            currentProbability *= -1;
            int currentNode = pair.getValue();

            for (SimpleEntry<Integer, Double> neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.getKey();
                double edgeProbability = neighbor.getValue();

                if (probabilities[nextNode] < probabilities[currentNode] * edgeProbability) {
                    probabilities[nextNode] = probabilities[currentNode] * edgeProbability;
                    queue.offer(new SimpleEntry<>(-probabilities[nextNode], nextNode));
                }
            }
        }

        return probabilities[end];
    }
}
