package SingleLinkList.Sorted;

import SingleLinkList.NodeSLL;

public class SLLOperation {
    NodeSLL head = null;
    int count = 0;

    public NodeSLL getHead() {
        return head;
    }

    public void setHead(NodeSLL head) {
        this.head = head;
    }

    public void addNode(int data)
    {
        NodeSLL newNode = new NodeSLL(data);
        if (head == null)
        {
            head = newNode;
            count++;
            return;
        }
        if (newNode.data < head.data)
        {
            newNode.next = head;
            head = newNode;
            count++;
            return;
        }
        NodeSLL p1 = head,p2 = head;
        while (p2 != null )
        {
            if (newNode.data >= p2.data)
            {
                p1 = p2;
                p2 = p2.next;
            }
            else
            {
                newNode.next = p2;
                p1.next = newNode;
                count++;
                return;
            }
        }
        p1.next = newNode;
        count++;
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
    public void deleteNode(int data)
    {
        if (head == null)
        {
            System.out.println("Empty List-> nothing to delete");
            return;
        }
        if (data < head.data)
        {
            System.out.println("This data is less than first element.");
            return;
        }
        // head.data == data && head.next == null similar to below
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
    public void deleteList()
    {
        while (head != null)
        {
            head = head.next;
            count--;
        }
    }
    public void printNode(int data)
    {
        if (head == null)
        {
            System.out.println("You cannot print for Empty List");
            return;
        }
        NodeSLL p = head;
        while (p != null)
        {
            if (p.data == data)
            {
                System.out.println("Element found = "+p.data);
                return;
            }
            p = p.next;
        }
        System.out.println("This Element not found");
    }
    public int getSize()
    {
        return count;
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
        if (head.next.next == null)
        {
            return head;
        }
        NodeSLL newHeadNode = reverseRec(head.next);

        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }
    public void removeDuplicateFromSorted()
    {
        NodeSLL current = head;
        while (current != null && current.next != null)
        {
            if (current.data == current.next.data)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }
        }
    }
    public NodeSLL merge2Sorted(NodeSLL a, NodeSLL b)
    {
        if (a == null && b == null)
        {
            System.out.println("2 SLL is Empty , Can not merge");
            return null;
        }
        NodeSLL dummy = new NodeSLL(0);
        NodeSLL tail = dummy;
        while (a != null && b != null)
        {
            if (a.data < b.data)
            {
                tail.next = a;
                a = a.next;
            }
            else
            {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null)
        {
            tail.next = b;
        }
        else
        {
            tail.next = a;
        }
        return dummy.next;
    }
    public NodeSLL merge2SortedListRec(NodeSLL a, NodeSLL b)
    {
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data < b.data)
        {
            a.next = merge2SortedListRec(a.next,b);
            return a;
        }
        else
        {
            b.next = merge2SortedListRec(a,b.next);
            return b;
        }
    }
}
