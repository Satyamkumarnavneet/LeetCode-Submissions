class Solution {
    public long minEnd(int n, int x) {
        long result = x;   // The first element is x
        long current = x + 1; // Start looking for the next elements from x + 1
        
        // We need to find n - 1 additional elements
        for (int i = 1; i < n; i++) {
            // Directly construct a valid number greater than x
            // Without requiring to individually check the AND condition
            while ((current & x) != x) {
                current++; // Increment until we can satisfy the AND condition
            }
            result = current; // Assign the valid element to result
            current++; // Move to the next integer for the next iteration
        }

        return result;
    }
}
