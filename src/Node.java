public class Node {
    private int val;

    private Node nextNode = null;
    private Node prevNode = null;

    public Node(int val) {
        this.setValue(val);
    }

    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrev(Node prevNode) {
        this.prevNode = prevNode;
    }

    public int getValue() {
        return this.val;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public void setValue(int val) {
        this.val = val;
    }

}