class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        graph = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            graph[a].append(b)
        
        isPrerequisite = [[False] * numCourses for _ in range(numCourses)]
        
        def dfs(course, start):
            for next_course in graph[course]:
                if not isPrerequisite[start][next_course]:
                    isPrerequisite[start][next_course] = True
                    dfs(next_course, start)
        
        for i in range(numCourses):
            dfs(i, i)
        
        return [isPrerequisite[u][v] for u, v in queries]