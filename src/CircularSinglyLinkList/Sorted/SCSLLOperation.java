package CircularSinglyLinkList.Sorted;


import CircularSinglyLinkList.CSLLNode;

public class SCSLLOperation {

    CSLLNode tail;
    int count = 0;

    public void insertNode(int data)
    {
        CSLLNode newNode = new CSLLNode(data);
        if (tail == null)
        {
            tail = newNode;
            tail.next = newNode;
            count++;
            return;
        }
        CSLLNode p = tail.next;
        if (newNode.data <= p.data)
        {
            newNode.next = p;
            tail.next = newNode;
            count++;
            return;
        }
        if (newNode.data >= tail.data)
        {
            newNode.next = p;
            tail.next = newNode;
            tail = newNode;
            count++;
            return;
        }
        CSLLNode p1 = p,p2 = p;
        p= null;
        while (p2 != tail)
        {
            if (newNode.data <= p2.data)
            {
                newNode.next = p2;
                p1.next = newNode;
                count++;
                return;
            }
            else
            {
                p1 = p2;
                p2 = p2.next;
            }
        }
    }
    public void deleteNode(int data)
    {
        if (tail == null)
        {
            System.out.println("Empty Sorted Circular Singly LL");
            return;
        }
        if (data < tail.next.data || data > tail.data)
        {
            System.out.println("Not Found Element = " + data +
                    " , because either < head or > than tail");
            return;
        }
        if (tail.data == data && tail.next == tail)
        {
            tail.next = null;
            tail = null;
            count--;
            return;
        }
        if (data == tail.next.data)
        {
            CSLLNode p = tail.next;
            tail.next = p.next;
            p.next = null;
            count--;
            return;
        }
        CSLLNode p1 = tail.next, p2 = tail.next;
        while (p2 != tail)
        {
            if (p2.data == data)
            {
                p1.next = p2.next;
                p2.next = null;
                count--;
                return;
            }
            else
            {
                p1 = p2;
                p2 = p2.next;
            }
        }
        if (p2.data == data)
        {
            p1.next = p2.next;
            tail = p1;
            p2.next = null;
            count--;
            return;
        }
        System.out.println("Element not found to delete");
    }
    public void printCSLL()
    {
        if (tail == null)
        {
            System.out.println("Empty CSLL, nothing to print");
            return;
        }
        CSLLNode p = tail.next;
        System.out.print("CSLL Nodes ==> ");
        while (p.next != tail.next){
            System.out.print(p.data+" , ");
            p = p.next;
        }
        System.out.print(p.data + "  <==Done");
        System.out.println();
    }
}