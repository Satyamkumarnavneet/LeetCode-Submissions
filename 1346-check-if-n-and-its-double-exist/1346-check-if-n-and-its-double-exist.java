class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int number : arr) {
            if (seen.contains(number * 2) || (number % 2 == 0 && seen.contains(number / 2))){
                return true;
            }
            seen.add(number);
        }
        return false;
    }
}