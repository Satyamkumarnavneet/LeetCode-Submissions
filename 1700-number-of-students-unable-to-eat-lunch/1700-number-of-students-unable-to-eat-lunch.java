class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandPtr = 0, stdPtr = 0, size = students.length;
        while(sandPtr < size){
            if(sandwiches[sandPtr] == students[stdPtr]){
                students[stdPtr] = -1;
                stdPtr = (stdPtr + 1 ) % size;
                sandPtr++;
            }else{
                int checkWithCnt  = 0;
                while(checkWithCnt < size && students[stdPtr] != sandwiches[sandPtr]){
                    stdPtr = (stdPtr + 1 ) % size;
                    checkWithCnt++;
                }
                if(checkWithCnt == size)break;
            }
        }
        return size - sandPtr;
    }
}