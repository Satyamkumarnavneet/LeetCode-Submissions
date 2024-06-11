class Solution {
   public int[] relativeSortArray(int[] arr1, int[] arr2) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int num : arr1) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }
       
       int[] result = new int[arr1.length];
       int index = 0;
       
       for (int i = 0; i < arr2.length; i++) {
           int num = arr2[i];
           int count = map.get(num);
           while (count > 0) {
               result[index] = num;
               index++;
               count--;
           }
           map.remove(num);
       }
       
       List<Integer> list = new ArrayList<>();
       for (int key : map.keySet()) {
           int count = map.get(key);
           while (count > 0) {
               list.add(key);
               count--;
           }
       }
       
       Collections.sort(list);
       for (int num : list) {
           result[index] = num;
           index++;
       }
       
       return result;
   }
}
