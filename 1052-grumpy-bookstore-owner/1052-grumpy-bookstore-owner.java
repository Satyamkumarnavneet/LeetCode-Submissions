class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int[] grumpySum = new int[grumpy.length];
    int satisfiedCustomers = 0;

    if (grumpy[0] == 1) {
        grumpySum[0] = customers[0];
    } else {
        satisfiedCustomers += customers[0];
    }

    for (int i = 1; i < grumpy.length; i++) {
        if (grumpy[i] == 1) {
            grumpySum[i] = grumpySum[i - 1] + customers[i];
        } else {
            grumpySum[i] = grumpySum[i - 1];
            satisfiedCustomers += customers[i];
        }
    }

    int maxCustomers = 0;
    for (int i = 0; i <= customers.length - minutes; i++) {
        if (i == 0) {
            maxCustomers = Math.max(maxCustomers, grumpySum[i + minutes - 1]);
        } else {
            maxCustomers = Math.max(maxCustomers, grumpySum[i + minutes - 1] - grumpySum[i - 1]);
        }
    }
    return satisfiedCustomers + maxCustomers;
}

}