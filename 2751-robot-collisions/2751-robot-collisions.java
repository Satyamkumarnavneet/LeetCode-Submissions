class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> robotIndices = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robotIndices.add(i);
        }
        Collections.sort(robotIndices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Stack<Integer> rightMovingRobots = new Stack<>();

        for (int i : robotIndices) {
            char dir = directions.charAt(i);
            if (dir == 'L') {
                while (!rightMovingRobots.isEmpty()) {
                    int r = rightMovingRobots.peek();
                    if (healths[i] == healths[r]) {
                        healths[i] = 0;
                        healths[r] = 0;
                        rightMovingRobots.pop();
                        break;
                    } else if (healths[i] > healths[r]) {
                        healths[r] = 0;
                        healths[i]--;
                        rightMovingRobots.pop();
                    } else {
                        healths[r]--;
                        healths[i] = 0;
                        break;
                    }
                }
            } else {
                rightMovingRobots.push(i);
            }
        }

        List<Integer> remainingHealths = new ArrayList<>();
        for (int h : healths) {
            if (h != 0) {
                remainingHealths.add(h);
            }
        }
        return remainingHealths;
    }
}
