package CircularDuoblyLinkList.UnSorted;

import CircularDuoblyLinkList.CDLLNode;
import DoublyLinkList.NodeDLL;

public class UnSCDLLOperation {
    CDLLNode head;
    CDLLNode tail;
    int count = 0;

    public void insertAtBeg(int data)
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
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = tail;
            tail.next = newNode;
            head = newNode;
            count++;
    }
    public void insertAtEnd(int data)
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
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail = newNode;
        count++;
    }
    public int getSize(){
        return count;
    }
    public void insertAtPos(int data, int pos)
    {
        if (pos < 1 || pos > getSize() + 1)
        {
            System.out.println("Invalid Position to insert");
            return;
        }
        if (pos == 1)
        {
            insertAtBeg(data);
            return;
        }
        CDLLNode temp = head;
        for (int i = 1;i < pos - 1; i++)
        {
            temp = temp.next;
        }
        CDLLNode newNode = new CDLLNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        if (temp == tail)
        {
            tail = newNode;
        }
        count++;
    }
    public void insertAfterPos(int data, int pos)
    {
        if (pos < 1 || pos >= getSize() + 1)
        {
            System.out.println("Invalid Position to insert");
            return;
        }
        CDLLNode temp = head;
        for (int i = 1;i <= pos - 1; i++)
        {
            temp = temp.next;
        }
        CDLLNode newNode = new CDLLNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        if (temp == tail)
        {
            tail = newNode;
        }
        count++;
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

    public void deleteFromBeg()
    {
        if (head == null && tail == null)
        {
            System.out.println("CDLL is Empty, Cannot delete from Beg");
            return;
        }
        CDLLNode p = head;
        if (p == p.next)
        {
            head = tail = null;
            p.next = null;
            p.prev = null;
            count--;
            return;
        }
        head = head.next;
        tail.next = head;
        head.prev = tail;
        p.next = null;
        p.prev = null;
        count--;
    }

    public void deleteFromEnd()
    {
        if (head == null && tail == null)
        {
            System.out.println("CDLL is Empty, Cannot delete from Beg");
            return;
        }
        CDLLNode p = tail;
        if (p == p.next)
        {
            head = tail = null;
            p.next = null;
            p.prev = null;
            count--;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        p.next = null;
        p.prev = null;
        count--;
    }

    public void deleteAtPos(int pos)
    {
        if (pos <1 || pos > getSize())
        {
            System.out.println("Invalid Pos to delete");
            return;
        }
        if (pos == 1)
        {
            deleteFromBeg();
            return;
        }
        CDLLNode p = head;
        for (int i = 1; i < pos - 1; i++)
        {
            p = p.next;
        }
        CDLLNode current = p.next;
        p.next = current.next;
        current.next.prev = p;
        current.next = null;
        current.prev = null;
        if (tail == current)
        {
            tail = p;
        }
        else if (head == current)
        {
            head = p.next;
        }
        count--;
    }
    public void deleteAfterPos(int pos)
    {
        if (pos <1 || pos >= getSize())
        {
            System.out.println("Invalid Pos to delete");
            return;
        }
        CDLLNode p = head;
        for (int i = 1; i <= pos - 1; i++)
        {
            p = p.next;
        }
        CDLLNode current = p.next;
        p.next = current.next;
        current.next.prev = p;
        current.next = null;
        current.prev = null;
        if (tail == current)
        {
            tail = p;
        }
        else if (head == current)
        {
            head = p.next;
        }
        count--;
    }
    public void reverseIterative()
    {
        CDLLNode current = head;
        CDLLNode nextNode;
        while (current != tail)
        {
            nextNode = current.next;
            current.next = current.prev;
            current.prev = nextNode;
            current = nextNode;
        }
        current.next = current.prev;
        current.prev = head;
        current = head;
        head = tail;
        tail = current;
    }
}
