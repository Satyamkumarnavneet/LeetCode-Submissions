class Solution {
    public int passThePillow(int n, int time) {
        int currentPerson = 1;
        boolean forward = true; // flag to indicate the direction of passing

        for (int t = 1; t <= time; t++) {
            if (forward) {
                currentPerson++;
                if (currentPerson == n) {
                    forward = false;
                }
            } else {
                currentPerson--;
                if (currentPerson == 1) {
                    forward = true;
                }
            }
        }
        return currentPerson;
    }
}
