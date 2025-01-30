class UnionFind:
    def __init__(self, nodes):
        self.parents = list(range(nodes))
        self.ranks = [0] * nodes

    def find(self, p):
        if p != self.parents[p]:
            self.parents[p] = self.find(self.parents[p])
        return self.parents[p]
    
    def union(self, p, q):
        root_p = self.find(p)
        root_q = self.find(q)

        if root_p != root_q:
            if self.ranks[root_p] > self.ranks[root_q]:
                self.parents[root_q] = root_p
            elif self.ranks[root_p] < self.ranks[root_q]:
                self.parents[root_p] = root_q
            else:
                self.parents[root_q] = root_p
                self.ranks[root_p] += 1

    def get_components(self):
        return set(self.parents)

class Solution:
    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        graph = {i: [] for i in range(n)}
        uf = UnionFind(n)
        for u, v in edges:
            graph[u - 1].append(v - 1)
            graph[v - 1].append(u - 1)
            uf.union(u - 1, v - 1)
        
        comp_layer_map = {i: 0 for i in uf.get_components()}
        for i in range(n):
            layer = self.bfs(graph, i)
            if layer == -1:
                return -1
            else:
                comp_root = uf.find(i)
                comp_layer_map[comp_root] = max(layer, comp_layer_map[comp_root])
        
        return sum(comp_layer_map.values())

    def bfs(self, graph, start_node):
        layer_comp = [-1] * len(graph)
        layer_comp[start_node] = 1
        q = deque([start_node])
        layer = 2
        while q:
            for _ in range(len(q)):
                node = q.popleft()
                for adj in graph[node]:
                    if layer_comp[adj] == -1:
                        layer_comp[adj] = layer
                        q.append(adj)
                    else:
                        if abs(layer_comp[node] - layer_comp[adj]) == 1:
                            continue
                        else:
                            return -1
            layer += 1
        
        return max(layer_comp)
