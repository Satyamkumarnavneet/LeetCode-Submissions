class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (deadSet.contains(current)) {
                    continue;
                }
                if (current.equals(target)) {
                    return moves;
                }
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] nextChars = current.toCharArray();
                        nextChars[j] = (char) (((nextChars[j] - '0' + k + 10) % 10) + '0');
                        String next = new String(nextChars);

                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
