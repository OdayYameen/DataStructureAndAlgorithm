package CircularSinglyLinkList.UnSorted;

import CircularSinglyLinkList.CSLLNode;

public class UnSCSLLOperation {

    CSLLNode tail;

    int count = 0;

    public void insertAtBeg(int data)
    {
        CSLLNode newNode = new CSLLNode(data);
        if (tail == null)
        {
            tail = newNode;
            tail.next = newNode;
            count++;
            return;
        }

            newNode.next = tail.next;
            tail.next = newNode;
            count++;
    }
    public void insertAtEnd(int data)
    {
        CSLLNode newNode = new CSLLNode(data);
        if (tail == null)
        {
            tail = newNode;
            tail.next = newNode;
            count++;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
        count++;
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
    public int getSize()
    {return count;}
    public void insertAtPos(int data, int pos)
    {
        if (pos < 1 || pos > getSize() + 1) {
            System.out.println("Invalid pos to insert in CSLL");
            return;
        }
        if (pos == 1)
        {
            insertAtBeg(data);
            return;
        }
        CSLLNode p = tail.next;
        for (int i = 1; i < pos -1; i++)
        {
            p = p.next;
        }
        CSLLNode newNode = new CSLLNode(data);
        CSLLNode current  = p.next;
        newNode.next = current;
        p.next = newNode;
        if (p == tail)
        {
            tail = newNode;
        }
        count++;
    }
    public void insertAfterPos(int data, int pos)
    {
        if (pos < 1 || pos >= getSize() + 1) {
            System.out.println("Invalid pos to insert in CSLL");
            return;
        }
        CSLLNode p = tail.next;
        for (int i = 1; i <= pos - 1; i++)
        {
            p = p.next;
        }
        CSLLNode newNode = new CSLLNode(data);
        CSLLNode current  = p.next;
        newNode.next = current;
        p.next = newNode;
        if (p == tail)
        {
            tail = newNode;
        }
        count++;
    }
    public void deleteAtBeg()
    {
        if (tail == null)
        {
            System.out.println("CSLL is Empty,Cannot delete from beg");
            return;
        }
        CSLLNode temp = tail.next;
        if (temp.next == temp)
        {
            tail = null;
            count--;
            return;
        }
        tail.next = temp.next;
        temp.next = null;
        count--;
    }
    public void deleteAtEnd()
    {
        if (tail == null)
        {
            System.out.println("CSLL is Empty,Cannot delete from end");
            return;
        }
        if (tail.next == tail)
        {
            tail = null;
            count--;
            return;
        }
        CSLLNode prevNode = null;
        CSLLNode currentNode = tail.next;
        while (currentNode.next != tail.next)
        {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        prevNode.next = tail.next;
        tail = prevNode;
        currentNode.next = null;
        count--;


    }
    public void deleteAtPos(int pos)
    {
        if (pos < 1 || pos > getSize())
        {
            System.out.println("Invalid pos to delete from CSLL");
            return;
        }
        if (pos == 1)
        {
            deleteAtBeg();
            return;
        }
        CSLLNode p = tail.next;
        for (int i = 1; i < pos - 1; i++)
        {
            p = p.next;
        }
        CSLLNode current = p.next;
        p.next = current.next;
        current.next = null;
        if (current == tail)
        {
            tail = p;
        }
        count--;
    }
    public void deleteAfterPos(int pos)
    {
        if (pos < 1 || pos >= getSize())
        {
            System.out.println("Invalid pos to delete from CSLL");
            return;
        }
        CSLLNode p = tail.next;
        for (int i = 1; i <= pos - 1; i++)
        {
            p = p.next;
        }
        CSLLNode current = p.next;
        p.next = current.next;
        current.next = null;
        if (current == tail)
        {
            tail = p;
        }
        count--;
    }
    public void reverseCSLLIterative()
    {
        if (tail == null)
        {
            System.out.println("CSLL is Empty, Cannot reverse.");
            return;
        }
        if (tail == tail.next)
        {
            System.out.println("CSLL have one element, Cannot reverse.");
            return;
        }
        CSLLNode prevNode = null, currentNode = tail.next, nextNode = currentNode.next;
        while (currentNode != tail)
        {
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;
            currentNode.next = prevNode;
        }
        nextNode.next = tail;
        tail = nextNode;
    }

    public static void main(String[] args) {

        UnSCSLLOperation unSCSLLOperation = new UnSCSLLOperation();
        unSCSLLOperation.insertAtBeg(5);
        unSCSLLOperation.insertAtEnd(8);
        unSCSLLOperation.insertAtBeg(4);
        unSCSLLOperation.insertAtEnd(9);
        unSCSLLOperation.printCSLL();
        System.out.println("Size= " + unSCSLLOperation.getSize());
        unSCSLLOperation.insertAtPos(10,4);
        unSCSLLOperation.insertAtPos(2,1);
        unSCSLLOperation.insertAtPos(3,2);
        unSCSLLOperation.printCSLL();
        unSCSLLOperation.insertAtBeg(5);
        unSCSLLOperation.insertAtPos(4,1);
        unSCSLLOperation.printCSLL();
        unSCSLLOperation.deleteAtPos(1);
        unSCSLLOperation.deleteAtPos(8);
        unSCSLLOperation.deleteAtEnd();
        unSCSLLOperation.printCSLL();
        unSCSLLOperation.deleteAtBeg();
        unSCSLLOperation.printCSLL();
        unSCSLLOperation.reverseCSLLIterative();
        unSCSLLOperation.printCSLL();
    }
}
