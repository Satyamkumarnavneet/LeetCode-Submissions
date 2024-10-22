class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1; // Return -1 if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        Map<Integer, Long> levelSums = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            levelSums.put(level, levelSums.getOrDefault(level, 0L) + levelSum);
            level++;
        }
        List<Long> sortedSums = new ArrayList<>(levelSums.values());
        Collections.sort(sortedSums, Collections.reverseOrder());

        return k <= sortedSums.size() ? sortedSums.get(k - 1) : -1;
    }
}