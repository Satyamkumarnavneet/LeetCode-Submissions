class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0, dir = 0, maxDist = 0;

        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + dx[dir];
                    int newY = y + dy[dir];
                    if (!obstacleSet.contains(newX + " " + newY)) {
                        x = newX;
                        y = newY;
                        maxDist = Math.max(maxDist, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return maxDist;
    }
}
