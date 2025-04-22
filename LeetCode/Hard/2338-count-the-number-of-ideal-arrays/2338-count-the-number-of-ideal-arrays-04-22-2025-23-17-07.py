MAX_VAL = 10 ** 4
freq = [ [(x, 1) for x in range(1, MAX_VAL + 1)] ]
for _ in range(MAX_VAL.bit_length() - 1):
    next_freq = defaultdict(int)
    for x, v in freq[-1]:
        for m in range(2, MAX_VAL // x + 1):
            next_freq[m * x] += v
    freq.append(sorted(next_freq.items(), key=lambda x: x[0]))

vals = [[a for a, _ in f] for f in freq]
acc_freq = [list(accumulate(b for _, b in f)) for f in freq]

class Solution:
    def idealArrays(self, n: int, maxValue: int) -> int:
        ans = maxValue
        for k in range(1, maxValue.bit_length()):
            ans += comb(n - 1, k) * acc_freq[k][bisect_right(vals[k], maxValue) - 1]
        return ans % 1_000_000_007
