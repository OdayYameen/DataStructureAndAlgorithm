package CircularDuoblyLinkList;

public class CDLLNode {

    public int data;
    public CDLLNode next;
    public CDLLNode prev;

    public CDLLNode(int data)
    {
        this.data = data;
        next = null;
        prev = null;
    }
}
