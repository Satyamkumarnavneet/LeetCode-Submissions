public class Solution {
    public int countPairs(TreeNode root, int distance) {
        int[] count = new int[1];
        traverse(root, distance, count);
        return count[0];
    }

    private List<Integer> traverse(TreeNode node, int distance, int[] count) {
        if (node == null) {
            return new ArrayList<>();
        }
        
        if (node.left == null && node.right == null) {
            List<Integer> leaf = new ArrayList<>();
            leaf.add(1);
            return leaf;
        }
        
        List<Integer> left = traverse(node.left, distance, count);
        List<Integer> right = traverse(node.right, distance, count);
        
        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance) {
                    count[0]++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int l : left) {
            if (l + 1 < distance) {
                result.add(l + 1);
            }
        }

        for (int r : right) {
            if (r + 1 < distance) {
                result.add(r + 1);
            }
        }
        return result;
    }
}
