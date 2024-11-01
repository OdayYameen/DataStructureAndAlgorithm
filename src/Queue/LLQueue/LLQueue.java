package Queue.LLQueue;

import SingleLinkList.NodeSLL;

public class LLQueue {

    NodeSLL front;
    NodeSLL rear;
    int count = 0;

    public void enqueue(int x)
    {
        NodeSLL newNode = new NodeSLL(x);
        if (front == null && rear == null)
        {
            front = rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }
    public int dequeue()
    {
        if (rear == null && front == null)
        {
            System.out.println("Empty LL Queue, cannot dequeue");
            return -1;
        }
        if (rear == front)
        {
            int x = front.data;
            front = rear = null;
            count--;
            return x;
        }
            NodeSLL p = front;
            front = front.next;
            p.next = null;
            count--;
            return p.data;

    }
    public int peek()
    {
        if (rear == null && front == null)
        {
            System.out.println("Empty LL Queue, cannot peek");
            return -1;
        }

        return front.data;

    }

    public void display()
    {
        if (rear == null && front == null)
        {
            System.out.println("Empty LL Queue, cannot display");
        return;
        }
        NodeSLL p = front;
        while (p != null)
        {
            System.out.print(p.data+"  ");
            p = p.next;
        }
        System.out.println();
    }
}
