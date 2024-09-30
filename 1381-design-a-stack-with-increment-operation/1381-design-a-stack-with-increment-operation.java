class CustomStack {

    private int[] array;
    private int topIndex;
    private int stackSize;

    public CustomStack(int maxSize) {
        stackSize = maxSize;
        array = new int[maxSize];
        topIndex = -1;
    }
    
    public void push(int element) {
        if (topIndex < stackSize - 1) {
            array[++topIndex] = element;
        }
    }
    
    public int pop() {
        if (topIndex > -1) {
            return array[topIndex--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int elementsToIncrement = Math.min(k, topIndex + 1);
        for (int i = 0; i < elementsToIncrement; i++) {
            array[i] += val;
        }
    }
}
