package SingleLinkList.UnSorted;

import SingleLinkList.NodeSLL;

public class UnSSLLOperation {
    NodeSLL head = null;
    int count = 0;

    public NodeSLL getHead() {
        return head;
    }

    public void setHead(NodeSLL head) {
        this.head = head;
    }

    public void insertAtEnd(int data)
    {
        NodeSLL newNode  = new NodeSLL(data);
        if (head == null)
        {
            head = newNode;
            count++;
            return;
        }
        NodeSLL p = head;
        while (p.next != null)
        {
            p = p.next;
        }
        p.next = newNode;
        count++;
    }
    public void insertAtBeg(int data)
    {
        NodeSLL newNode = new NodeSLL(data);
        newNode.next = head;
        head = newNode;
        count++;
    }
    public int getSize()
    {
        return count;
    }
    public void insertAfterPos(int data, int pos)
    {
        if (pos < 1 || pos >= getSize() + 1) {
            System.out.println("Invalid Position to insert");
            return;
        }
        NodeSLL newNode = new NodeSLL(data);
        NodeSLL temp = head;
        for (int i =1; i <= pos - 1; i++)
        {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        count++;
    }
    public void insertAtPos(int data, int pos)
    {
        if (pos < 1 || pos > getSize() + 1) {
            System.out.println("Invalid Position to insert");
            return;
        }

        if (pos == 1)
        {
            insertAtBeg(data);
            return;
        }
        NodeSLL newNode = new NodeSLL(data);
        NodeSLL temp = head;
        for (int i =1; i < pos - 1; i++)
        {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        count++;
    }
    public void deleteAtBeg()
    {
        if (head == null)
        {
            System.out.println("Nothing to delete, Empty List");
            return;
        }
        if (head.next == null)
        {
            head = null;
            count--;
            return;
        }
        head = head.next;
        count--;
    }
    public void deleteNode(int data)
    {
        if (head == null)
        {
            System.out.println("Empty List-> nothing to delete");
            return;
        }
        if (head.data == data)
        {
            head = head.next;
            count--;
            return;
        }
        NodeSLL p1 = head,p2 = head;
        while (p2 != null)
        {
            if (p2.data == data)
            {
                p1.next = p2.next;
                count--;
                return;
            }
            else
            {
                p1 = p2;
                p2 = p2.next;
            }
        }
        System.out.println("Element not found.");
    }
    public void deleteAtEnd()
    {
        if (head == null)
        {
            System.out.println("Nothing to delete, Empty List");
            return;
        }
        if (head.next == null)
        {
            head = null;
            count--;
            return;
        }
        NodeSLL p1 = head,p2 = head;
        while (p2.next != null)
        {
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = p2.next;//null
        count--;
    }
    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > getSize())
        {
            System.out.println("Invalid Position to insert");
            return;
        }
        if (pos == 1)
        {
            deleteAtBeg();
            return;
        }
        NodeSLL prevNode = head;
        for (int i = 1; i < pos - 1; i++)
        {
            prevNode = prevNode.next;
        }
        NodeSLL nextNode = prevNode.next;
        prevNode.next = nextNode.next;
        count--;
    }
    public void deleteAfterPos(int pos) {
        if (pos < 1 || pos >= getSize())
        {
            System.out.println("Invalid Position to insert");
            return;
        }
        NodeSLL prevNode = head;
        for (int i = 1; i <= pos - 1; i++)
        {
            prevNode = prevNode.next;
        }
        NodeSLL nextNode = prevNode.next;
        prevNode.next = nextNode.next;
        count--;
    }
    public void printSLL()
    {
        if (head == null)
        {
            System.out.println("Empty List, nothing to print");
            return;
        }
        NodeSLL p = head;
        System.out.print("SLL -> ");
        while (p != null)
        {
            System.out.print(p.data + " , ");
            p = p.next;
        }
        System.out.println("Done");
    }
    public void reverseIterative()
    {
        NodeSLL prevNode = null,currentNode = head, nextNode = head;
        while (nextNode != null)
        {
            nextNode = nextNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
    }
    public NodeSLL reverseRec(NodeSLL head)
    {
        if (head == null)
        {
            return head;
        }
        if (head.next == null)
        {
            return head;
        }
        NodeSLL newHeadNode = reverseRec(head.next);

        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }
    public void findNthNodeFromEnd(int n)
    {
        NodeSLL mainPtr = head;
        NodeSLL refPtr = head;
        int count = 0;
        while (count< n && refPtr != null)
        {
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null)
        {

            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        System.out.println("Nth Node From End  = "+ mainPtr.data);
    }
    public boolean detectLoop()
    {
        NodeSLL slow = head;
        NodeSLL fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                return true;
            }
        }
        return false;
    }
    public NodeSLL findStartingNodeForLoop()
    {
        NodeSLL slow = head;
        NodeSLL fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                return getStartNodeLoop(slow);
            }
        }
        return null;
    }

    private NodeSLL getStartNodeLoop(NodeSLL slow) {
        NodeSLL temp = head;
        while (slow != temp)
        {
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
    public void removeLoopFromList()
    {
        NodeSLL slow = head;
        NodeSLL fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                removeLoop(slow);
                return;
            }
        }
    }

    private void removeLoop(NodeSLL slow)
    {
        NodeSLL temp = head;
        while (temp.next != slow.next)
        {
            temp = temp.next;
            slow = slow.next;
        }
        slow.next = null;
    }

    public static void main(String[] args) {

        UnSSLLOperation unSSLLOperation = new UnSSLLOperation();
        unSSLLOperation.insertAfterPos(1,0);
        unSSLLOperation.insertAfterPos(2,1);
        unSSLLOperation.insertAfterPos(3,1);
        unSSLLOperation.insertAfterPos(4,1);
        unSSLLOperation.insertAfterPos(5,1);
        unSSLLOperation.insertAfterPos(6,3);
        unSSLLOperation.insertAfterPos(7,3);
        unSSLLOperation.insertAfterPos(8,2);
        unSSLLOperation.insertAfterPos(9,1);
        unSSLLOperation.insertAtBeg(8);
        unSSLLOperation.insertAtPos(4,0);
        unSSLLOperation.insertAtPos(4,1);
        unSSLLOperation.insertAtPos(5,1);
        unSSLLOperation.insertAtPos(7,1);
        unSSLLOperation.insertAtPos(22,2);
        unSSLLOperation.insertAtPos(1,12);
        unSSLLOperation.insertAtEnd(10);
        unSSLLOperation.insertAtBeg(11);
        unSSLLOperation.insertAtEnd(12);
        unSSLLOperation.insertAtBeg(15);
        unSSLLOperation.insertAtEnd(17);
        unSSLLOperation.printSLL();
        unSSLLOperation.deleteAtPos(1);
        unSSLLOperation.deleteAtEnd();
        unSSLLOperation.deleteAtPos(20);
        unSSLLOperation.deleteAtPos(5);
        unSSLLOperation.printSLL();
        unSSLLOperation.insertAtBeg(8);
        unSSLLOperation.insertAtEnd(10);
        unSSLLOperation.insertAtBeg(11);
        unSSLLOperation.insertAtEnd(12);
        unSSLLOperation.insertAtBeg(15);
        unSSLLOperation.insertAtEnd(17);
        unSSLLOperation.printSLL();
        unSSLLOperation.reverseIterative();
        unSSLLOperation.printSLL();
        unSSLLOperation.setHead(unSSLLOperation.reverseRec(unSSLLOperation.getHead()));
        unSSLLOperation.printSLL();
    }
}
