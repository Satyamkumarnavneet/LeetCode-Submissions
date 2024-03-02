class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node leftMost = root;
        while(leftMost.left != null){
            Node current = leftMost;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
