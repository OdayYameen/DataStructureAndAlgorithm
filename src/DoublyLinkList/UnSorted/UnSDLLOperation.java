package DoublyLinkList.UnSorted;

import DoublyLinkList.NodeDLL;

public class UnSDLLOperation {
    NodeDLL head;
    NodeDLL tail;
    int count = 0;

    public NodeDLL getHead() {
        return head;
    }

    public void setHead(NodeDLL head) {
        this.head = head;
    }

    public void insertAtEnd(int data)
    {
        NodeDLL newNode = new NodeDLL(data);
        if (head == null && tail == null)
        {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        count++;
    }
    public void insertAtBeg(int data)
    {
        NodeDLL newNode = new NodeDLL(data);
        if (head == null && tail == null)
        {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        count++;
    }
    public int getSize()
    {
        return count;
    }
    public void insertAtPos(int data,int pos)
    {
        if (pos < 1 || pos > getSize() + 1)
        {
            System.out.println("Invalid Position "+pos+" to insert");
            return;
        }
        if (pos == 1)
        {
            insertAtBeg(data);
            return;
        }
        NodeDLL p = head;
        for (int i =1; i < pos - 1; i++)
        {
            p = p.next;
        }
        NodeDLL newNode = new NodeDLL(data);
        newNode.next = p.next;
        newNode.previous = p;
        if (p.next != null)//only when node p.next = null
        {
            p.next.previous = newNode;
        }
        else
        {
            tail = newNode;
        }
        p.next = newNode;
        count++;
    }
    public void insertAfterPos(int data,int pos)
    {
        if (pos < 1 || pos >= getSize() + 1)
        {
            System.out.println("Invalid Position "+pos+" to insert");
            return;
        }
        NodeDLL p = head;
        for (int i =1; i <= pos - 1; i++)
        {
            p = p.next;
        }
        NodeDLL newNode = new NodeDLL(data);
        newNode.next = p.next;
        newNode.previous = p;
        if (p.next != null)//only when node p.next = null
        {
            p.next.previous = newNode;
        }
        else
        {
            tail = newNode;
        }
        p.next = newNode;
        count++;
    }
    public void printDLL() {
        if (head == null) {
            System.out.println("Empty List, nothing to print");
            return;
        }
        NodeDLL p = head;
        System.out.print("DLL -> ");
        while (p != null) {
            System.out.print(p.data + " , ");
            p = p.next;
        }
        System.out.println("Done");
    }
    public void deleteAtBeg()
    {
        if (head == null && tail == null)
        {
            System.out.println("Nothing to deleted form empty DLL");
        }
        if (head == tail)
        {
            NodeDLL p = head;
            head = null;
            tail = null;
            p.next = null;
            p.previous = null;
            count--;
            return;
        }
        NodeDLL p = head;
        head = head.next;
        head.previous = null;
        p.next = null;
        p.previous = null;
        count--;
        return;

    }
    public void deleteAtEnd()
    {
        if (head == null && tail == null)
        {
            System.out.println("Nothing to deleted form empty DLL");
        }
        if (head == tail)
        {
            NodeDLL p = head;
            head = null;
            tail = null;
            p.next = null;
            p.previous = null;
            count--;
            return;
        }
        NodeDLL p = tail;
        tail = tail.previous;
        tail.next = null;
        p.next = null;
        p.previous = null;
        count--;
    }
    public void deleteAtPos(int pos)
    {
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
        NodeDLL p = head;
        for (int i =1; i < pos - 1; i++)
        {
            p = p.next;
        }
        NodeDLL current = p.next;
        p.next = current.next;
        if (current.next != null)
        {
            current.next.previous = p;
        }
        else
        {
            tail = p;
        }
        current.next = null;
        current.previous = null;
        count--;
    }
    public void deleteAfterPos(int pos)
    {
        if (pos < 1 || pos >= getSize())
        {
            System.out.println("Invalid Position to insert");
            return;
        }
        NodeDLL p = head;
        for (int i =1; i <= pos - 1; i++)
        {
            p = p.next;
        }
        NodeDLL current = p.next;
        p.next = current.next;
        if (current.next != null)
        {
            current.next.previous = p;
        }
        else
        {
            tail = p;
        }
        current.next = null;
        current.previous = null;
        count--;
    }
    public void reverseIterative()
    {
        NodeDLL current = head;
        NodeDLL nextNode;
        while (current != null)
        {
            nextNode = current.next;
            current.next = current.previous;
            current.previous = nextNode;
            current = nextNode;
        }
        current = head;
        head = tail;
        tail = current;
    }
    public NodeDLL reverseRec(NodeDLL node)
    {
        if (node == null)
        {
            return null;
        }
        NodeDLL temp = node.next;
        node.next = node.previous;
        node.previous = temp;
        if (node.previous == null)
        {
            return node;
        }
        return reverseRec(node.previous);
    }
    public int getCountRec(NodeDLL node, int count)
    {
        if (node == null)
            return count;
        return getCountRec(node.next, 1 + count);
    }

    public boolean searchRec(NodeDLL node, int data)
    {
        if (node == null)
        {
            return false;
        }
        if (node.data == data)
        {
            System.out.println("Element Found = " + data);
            return true;
        }
        return searchRec(node.next,data);
    }
    public boolean isPalindrome()
    {
        if (head == null)
        {
            return true;
        }
        NodeDLL left = head;
        NodeDLL right = tail;
        while (left != right && left.previous != right)
        {
            if (left.data != right.data)
            {
                return false;
            }
            left = left.next;
            right = right.previous;
        }
        return true;
    }
    public void deleteList()
    {
        while (head != null)
        {
            head = head.next;
            count--;
        }
        tail = null;
    }
    public void deleteNode(int data)
    {
        if (head == null && tail == null)
        {
            System.out.println("Nothing to delete from DLL, Empty List");
            return;
        }
        if (head.data == data)
        {
            deleteAtBeg();
            return;
        }
        if (tail.data == data)
        {
            deleteAtEnd();
            return;
        }

        NodeDLL p = head;
        while (p != null)
        {
            if (p.data == data)
            {
                p.previous.next = p.next;
                p.next.previous = p.previous;
                p.previous = null;
                p.next = null;
                count--;
                return;
            }
            else
            {
                p = p.next;
            }
        }
        System.out.println("Not Found Element = " + data);
    }
    public void reverseSwapApproach()
    {
        NodeDLL left = head;
        NodeDLL right = tail;
        while (left != right && left.previous != right)
        {
            int data = left.data;
            left.data = right.data;
            right.data = data;
            left = left.next;
            right = right.previous;
        }
    }
    public void printMiddle()
    {
        NodeDLL slow = head;
        NodeDLL fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                System.out.println("Loop detected, then no middle");
                return;
            }
        }
        System.out.println("Middle Element = " + slow.data);
    }
}
