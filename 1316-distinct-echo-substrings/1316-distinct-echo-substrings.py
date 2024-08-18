class Solution:
    def distinctEchoSubstrings(self, text: str) -> int:
        def get_hash(start, end):
            return (h[end] - h[start - 1] * p[end - start + 1]) % mod

        n = len(text)
        base = 131
        mod = int(1e9) + 7
        h = [0] * (n + 10)
        p = [1] * (n + 10)

        for i, c in enumerate(text):
            t = ord(c) - ord('a') + 1
            h[i + 1] = (h[i] * base) % mod + t
            p[i + 1] = (p[i] * base) % mod

        seen = set()
        for i in range(n - 1):
            for j in range(i + 1, n, 2):
                k = (i + j) >> 1
                a = get_hash(i + 1, k + 1)
                b = get_hash(k + 2, j + 1)
                if a == b:
                    seen.add(a)

        return len(seen)
