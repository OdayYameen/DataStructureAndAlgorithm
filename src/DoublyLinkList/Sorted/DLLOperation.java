package DoublyLinkList.Sorted;


import DoublyLinkList.NodeDLL;

public class DLLOperation {
    NodeDLL head;
    NodeDLL tail;
    int count = 0;

    public NodeDLL getHead() {
        return head;
    }

    public void setHead(NodeDLL head) {
        this.head = head;
    }

    public void addNode(int data)
    {
        NodeDLL newNode = new NodeDLL(data);
        if (head == null && tail == null)
        {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }
        if (newNode.data <= head.data)
        {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            count++;
            return;
        }
        if (newNode.data >= tail.data)
        {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
            count++;
            return;
        }
        NodeDLL p = head;
        while (p != null)
        {
            if (newNode.data > p.data)
            {
                p = p.next;
            }
            else
            {
                newNode.next = p;
                p.previous.next = newNode;
                newNode.previous = p.previous;
                p.previous = newNode;
                count++;
                return;
            }
        }
    }
    public int getSize()
    {
        return count;
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
    public void deleteNode(int data)
    {
        if (head == null && tail == null)
        {
            System.out.println("Nothing to delete, Empty DLL");
        }
        if (data < head.data || data > tail.data)
        {
            System.out.println("Not Found Element = " + data +
                    " , because either < head or > than tail");
            return;
        }
        if (head.data == data && head == tail)
        {
            head = null;
            tail = null;
            count--;
            return;
        }
        if (head.data == data)
        {
            NodeDLL p = head;
            head.next.previous = null;
            head = head.next;
            p.previous = null;
            p.next = null;
            count--;
            return;
        }
        if (tail.data == data)
        {
            NodeDLL p = tail;
            tail.previous.next = null;
            tail = tail.previous;
            tail.next = null;
            p.previous = null;
            count--;
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
    public void printNode(int data) {
        if (head == null && tail == null) {
            System.out.println("You cannot print for Empty List");
            return;
        }
        if (head.data == data) {
            System.out.println("Element found = " + head.data);
            return;
        }
        if (tail.data == data) {
            System.out.println("Element found = " + tail.data);
            return;
        }
        if (data < head.data || data > tail.data)
        {
            System.out.println("Not Found Element = " + data +
                    " , because either < head or > than tail");
            return;
        }
        NodeDLL p = head;
        while (p != null) {
            if (p.data == data) {
                System.out.println("Element found = " + p.data);
                return;
            }
            p = p.next;
        }
        System.out.println("This Element not found");
    }
    public void deleteList()
    {
        while (head != null)
        {
            head = head.next;
            count--;
        }
    }

    public NodeDLL merge2SortedDLL(NodeDLL a, NodeDLL b)
    {
        if (a == null && b == null)
        {
            System.out.println("2 DLL is Empty , Can not merge");
            return null;
        }
        NodeDLL dummy = new NodeDLL(0);
        NodeDLL tail = dummy;
        while (a != null && b != null)
        {
            if (a.data < b.data)
            {
                tail.next = a;
                a.previous = tail;
                a = a.next;
            }
            else
            {
                tail.next = b;
                b.previous = tail;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null && b != null)
        {
            tail.next = b;
            b.previous = tail;
        }
        else if (b == null && a != null)
        {
            tail.next = a;
            a.previous = tail;
        }
        dummy.next.previous = null;
        return dummy.next;
    }

    public NodeDLL merge2SortedDLLRec(NodeDLL first, NodeDLL second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        if (first.data < second.data) {
            first.next = merge2SortedDLLRec(first.next, second);
            first.next.previous = first;
            first.previous = null;
            return first;
        } else {
            second.next = merge2SortedDLLRec(first, second.next);
            second.next.previous = second;
            second.previous = null;
            return second;
        }
    }

    public static void main(String[] args) {

        DLLOperation dllOperation = new DLLOperation();
        dllOperation.addNode(5);
        dllOperation.addNode(10);
        dllOperation.addNode(4);
        dllOperation.addNode(7);
        dllOperation.addNode(3);
        dllOperation.addNode(2);
        dllOperation.addNode(15);
        dllOperation.addNode(9);
        dllOperation.addNode(8);
        dllOperation.addNode(6);
        System.out.println("Size = "+ dllOperation.getSize());
        dllOperation.printDLL();
        dllOperation.deleteNode(15);
        dllOperation.deleteNode(2);
        dllOperation.deleteNode(6);
        dllOperation.deleteNode(8);
        dllOperation.deleteNode(25);
        dllOperation.deleteNode(1);
        System.out.println("Size = "+ dllOperation.getSize());
        dllOperation.printDLL();
        dllOperation.printNode(3);
        dllOperation.printNode(5);
        dllOperation.printNode(9);
        dllOperation.printNode(10);
        dllOperation.printNode(25);
        dllOperation.printNode(1);
        dllOperation.deleteList();
        System.out.println("Size = "+ dllOperation.getSize());
        dllOperation.printDLL();

        DLLOperation dllOperation1 = new DLLOperation();
        dllOperation1.addNode(1);
        dllOperation1.addNode(4);
        dllOperation1.addNode(7);

        DLLOperation dllOperation2 = new DLLOperation();
        dllOperation2.addNode(2);
        dllOperation2.addNode(5);
        dllOperation2.addNode(8);
        dllOperation1.setHead(dllOperation1.merge2SortedDLL(dllOperation1.getHead(),dllOperation2.getHead()));
        dllOperation1.printDLL();
        dllOperation1.addNode(0);
        dllOperation1.addNode(10);
        dllOperation1.addNode(9);
        dllOperation1.addNode(6);
        dllOperation1.printDLL();

        DLLOperation dllOperation3 = new DLLOperation();
        dllOperation3.addNode(1);
        dllOperation3.addNode(4);
        dllOperation3.addNode(7);

        DLLOperation dllOperation4 = new DLLOperation();
        dllOperation4.addNode(2);
        dllOperation4.addNode(5);
        dllOperation4.addNode(8);
        dllOperation3.setHead(dllOperation3.merge2SortedDLLRec(dllOperation3.getHead(),dllOperation4.getHead()));
        dllOperation3.printDLL();
        dllOperation3.addNode(0);
        dllOperation3.addNode(10);
        dllOperation3.addNode(9);
        dllOperation3.addNode(6);
        dllOperation3.printDLL();

        DLLOperation dllOperation5 = new DLLOperation();
        dllOperation5.setHead(dllOperation5.merge2SortedDLLRec(dllOperation5.getHead(),dllOperation5.getHead()));
        dllOperation5.printDLL();

    }
}
