class Solution(object):
    def largestTriangleArea(self, points):
        def area(p1, p2, p3):
            return 0.5 * abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]))
        
        max_area = 0
        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                for k in range(j + 1, len(points)):
                    max_area = max(max_area, area(points[i], points[j], points[k]))
        
        return max_area
