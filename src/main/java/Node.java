public class Node <K, V> {
    private K key;
    private V val;

    private Node nextNode = null;
    private Node prevNode = null;

    public Node(K key, V val) {
        this.setKey(key);
        this.setValue(val);
    }

    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrev(Node prevNode) {
        this.prevNode = prevNode;
    }

    public V getValue() {
        return this.val;
    }

    public K getKey() {
        return this.key;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V val) {
        this.val = val;
    }

}