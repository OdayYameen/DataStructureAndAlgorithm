package CircularDuoblyLinkList.Sorted;

import CircularDuoblyLinkList.CDLLNode;

public class SCDLLOperation {

    CDLLNode head;
    CDLLNode tail;
    int count = 0;

    public void insertNode(int data)
    {
        CDLLNode newNode = new CDLLNode(data);
        if (head == null && tail == null)
        {
            head = tail = newNode;
            head.next = newNode;
            head.prev = newNode;
            count++;
            return;
        }
        if (newNode.data <= head.data)
        {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            newNode.prev = tail;
            tail.next = head;
            count++;
            return;
        }
        if (newNode.data >= tail.data)
        {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            count++;
            return;
        }
        CDLLNode p = head;
        while (p != tail)
        {
            if (newNode.data <= p.data)
            {
                newNode.next = p;
                newNode.prev = p.prev;
                p.prev.next = newNode;
                p.prev = newNode;
                count++;
                return;
            }
            else
            {
                p = p.next;
            }
        }
    }

    public void deleteNode(int data)
    {
        if (head == null && tail == null)
        {
            System.out.println("Empty Sorted Circular Douly LL");
            return;
        }
        if (data < head.data || data > tail.data)
        {
            System.out.println("Not Found Element = " + data +
                    " , because either < head or > than tail");
            return;
        }
        if (head == tail && head.data == data)
        {
            head.next = null;
            head.prev = null;
            head = tail = null;
            count--;
            return;
        }
        if (head.data == data)
        {
            CDLLNode p = head;
            head = head.next;
            tail.next = head;
            head.prev = tail;
            p.next = null;
            p.prev = null;
            count--;
            return;
        }
        if (tail.data == data)
        {
            CDLLNode p = tail;
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            p.next = null;
            p.prev = null;
            count--;
            return;
        }
        CDLLNode p = head;
        while (p != tail)
        {
            if (p.data == data)
            {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                p.next = null;
                p.prev = null;
                count--;
                return;
            }
            else
            {
                p = p.next;
            }
        }
        System.out.println("Element not found to delete");
    }
    public void printCDLL()
    {
        if (head == null && tail == null)
        {
            System.out.println("CDLL is Empty,Cannot print");
            return;
        }
        CDLLNode temp = head;
        System.out.print("CSLL Nodes ==> ");
        while (temp != tail)
        {
            System.out.print(temp.data+" , ");
            temp = temp.next;
        }
        System.out.print(temp.data + "  <==Done");
        System.out.println();
    }
}
