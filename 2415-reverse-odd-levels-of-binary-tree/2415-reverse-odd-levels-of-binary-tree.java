class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<TreeNode>> levels = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(currentLevel);
        }

        for (int i = 1; i < levels.size(); i += 2) {
            List<TreeNode> oddLevelNodes = levels.get(i);
            int size = oddLevelNodes.size();
            for (int j = 0; j < size / 2; j++) {
                int temp = oddLevelNodes.get(j).val;
                oddLevelNodes.get(j).val = oddLevelNodes.get(size - 1 - j).val;
                oddLevelNodes.get(size - 1 - j).val = temp;
            }
        }
        return root;
    }
}
