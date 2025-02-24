class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        post_map = {val: idx for idx, val in enumerate(postorder)}
        
        def build(pre_start, pre_end, post_start, post_end):
            if pre_start > pre_end:
                return None
                
            root = TreeNode(preorder[pre_start])
            
            if pre_start == pre_end:
                return root
                
            left_val = preorder[pre_start + 1]
            left_subtree_end = post_map[left_val]
            left_subtree_size = left_subtree_end - post_start + 1
            
            root.left = build(pre_start + 1, 
                            pre_start + left_subtree_size,
                            post_start,
                            left_subtree_end)
            
            root.right = build(pre_start + left_subtree_size + 1,
                             pre_end,
                             left_subtree_end + 1,
                             post_end - 1)
            
            return root
        
        return build(0, len(preorder) - 1, 0, len(postorder) - 1)