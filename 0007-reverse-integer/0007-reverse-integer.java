class Solution {
    public int reverse(int x) {
        long reverseNum = 0;
        while(x!=0){
            int lastDig = x%10;
            reverseNum += lastDig;
            reverseNum = reverseNum*10;
            x= x/10;
        }
        reverseNum = reverseNum/10;
        if(reverseNum > Integer.MAX_VALUE || reverseNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*reverseNum);
        }
        return (int)reverseNum;
    }
}