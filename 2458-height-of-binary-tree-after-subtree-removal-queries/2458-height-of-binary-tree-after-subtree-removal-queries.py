# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        ans = [0] * len(queries)
        pos = defaultdict(list)
        for idx, num in enumerate(queries):
            pos[num].append(idx)

        rec = defaultdict(list)

        def findHeight(root, level):
            nonlocal rec
            if not root:
                return 0

            h = max(findHeight(root.left, level + 1), findHeight(root.right, level + 1)) + 1
            heappush(rec[level], (-h, root.val))
            return h

        findHeight(root, 0)
        
        travel = deque()
        travel.append((root, 0))

        while travel:
            if len(pos.keys()) == 0:
                break
            node, level = travel.popleft()
            l = None
            r = None

            if node.left:
                travel.append((node.left, level + 1))
                l = node.left.val

            if node.right:
                travel.append((node.right, level + 1))
                r = node.right.val

            if l or r:
                h, v = rec[level + 1][0]
                if l != None and l in pos.keys():
                    if l == v:
                        heappop(rec[level + 1])
                        for idx in pos[l]:
                            ans[idx] = -rec[level + 1][0][0] + level if rec[level + 1] else level
                        heappush(rec[level + 1], (h, v))
                        
                    else:
                        for idx in pos[l]:
                            ans[idx] = -rec[level + 1][0][0] + level if rec[level + 1] else level
                    del pos[l]

                if r != None and r in pos.keys():
                    if r == v:
                        heappop(rec[level + 1])
                        for idx in pos[r]:
                            ans[idx] = -rec[level + 1][0][0] + level if rec[level + 1] else level
                        heappush(rec[level + 1], (h, v))
                        
                    else:
                        for idx in pos[r]:
                            ans[idx] = -rec[level + 1][0][0] + level if rec[level + 1] else level
                    del pos[r]

        return ans