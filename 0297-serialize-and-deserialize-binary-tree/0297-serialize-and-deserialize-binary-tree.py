# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def preorder(node):
            if not node:
                vals.append('#')  # Represent null nodes as '#'
            else:
                vals.append(str(node.val))
                preorder(node.left)
                preorder(node.right)

        vals = []
        preorder(root)  # Perform preorder traversal
        return ' '.join(vals)  # Return the serialized string

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def build_tree():
            val = next(vals)  # Get the next value from the iterator
            if val == '#':
                return None
            node = TreeNode(int(val))
            node.left = build_tree()
            node.right = build_tree()
            return node

        vals = iter(data.split())  # Convert the serialized string to an iterator
        return build_tree()  # Return the deserialized binary tree
