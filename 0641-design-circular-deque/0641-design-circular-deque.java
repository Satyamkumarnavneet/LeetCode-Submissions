class MyCircularDeque {
    int[] arr;
    int front, rear, size, k;

    public MyCircularDeque(int k) {
        this.k = k;
        this.arr = new int[k];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + k) % k;
        arr[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % k;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + k) % k;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }

    public int getRear() {
    if (isEmpty()) {
        return -1; 
    } else {
        return rear == -1 ? arr[arr.length - 1] : arr[rear]; 
    }
}
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
