class Skiplist {
    private static final int MAX_LEVEL = 7;
    private final Node head = new Node(-1, MAX_LEVEL);
    private int level = 1;
    private final Random random = new Random();

    public boolean search(int target) {
        Node current = head;
        for (int i = level - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < target) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current != null && current.value == target;
    }

    public void add(int num) {
        int newLevel = randomLevel();
        Node update[] = new Node[MAX_LEVEL];
        Node current = head;

        for (int i = level - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < num) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        
        current = current.forward[0];

        if (current == null || current.value != num) {
            if (newLevel > level) {
                for (int i = level; i < newLevel; i++) {
                    update[i] = head;
                }
                level = newLevel;
            }
            Node newNode = new Node(num, newLevel);
            for (int i = 0; i < newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    public boolean erase(int num) {
        Node update[] = new Node[MAX_LEVEL];
        Node current = head;

        for (int i = level - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < num) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        
        current = current.forward[0];

        if (current != null && current.value == num) {
            for (int i = 0; i < level; i++) {
                if (update[i].forward[i] != current) {
                    break;
                }
                update[i].forward[i] = current.forward[i];
            }

            while (level > 0 && head.forward[level - 1] == null) {
                level--;
            }
            return true;
        }
        return false;
    }

    private int randomLevel() {
        int newLevel = 1;
        while (random.nextInt() % 2 == 0) {
            newLevel++;
        }
        return Math.min(newLevel, MAX_LEVEL);
    }

    class Node {
        int value;
        Node[] forward;

        public Node(int value, int level) {
            this.value = value;
            this.forward = new Node[level];
        }
    }
}
