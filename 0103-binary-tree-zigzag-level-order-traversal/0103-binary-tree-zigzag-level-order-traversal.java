class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight = true; // Flag to track the traversal direction

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Depending on the traversal direction, add the node value to the level list accordingly
                if (isLeftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val); // Insert at the beginning to reverse the order
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Toggle the direction for the next level
            isLeftToRight = !isLeftToRight;
            result.add(level);
        }
        return result;
    }
}
