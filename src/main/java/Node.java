public class Node <T> {
    private T val;

    private Node nextNode = null;
    private Node prevNode = null;

    public Node(T val) {
        this.setValue(val);
    }

    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrev(Node prevNode) {
        this.prevNode = prevNode;
    }

    public T getValue() {
        return this.val;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public void setValue(T val) {
        this.val = val;
    }

}