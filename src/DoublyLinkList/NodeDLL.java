package DoublyLinkList;

public class NodeDLL {
    public int data;
    public NodeDLL next;
    public NodeDLL previous;

    public NodeDLL(int data)
    {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
