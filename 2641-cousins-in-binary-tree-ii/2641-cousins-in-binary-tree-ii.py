class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        
        prevsum = root.val
        q = collections.deque([root])
        
        while q:
            qlen = len(q)
            sumy = 0
            
            for i in range(qlen):
                node = q.popleft()
                
                # Update node's value based on previous sum
                node.val = prevsum - node.val
                
                # Calculate sum for the current node's children
                children_sum = 0
                if node.left: children_sum += node.left.val
                if node.right: children_sum += node.right.val
                
                # Update children's values and enqueue them
                if node.left:
                    node.left.val = children_sum
                    q.append(node.left)
                if node.right:
                    node.right.val = children_sum
                    q.append(node.right)
                
                # Accumulate the sum for the next level
                sumy += children_sum
            
            # Update prevsum for the next level
            prevsum = sumy
        
        return root