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

    public static void main(String[] args) {

        LLQueue llQueue = new LLQueue();
        llQueue.enqueue(5);
        llQueue.enqueue(4);
        llQueue.enqueue(3);
        llQueue.enqueue(2);
        llQueue.enqueue(1);
        llQueue.display();
        System.out.println(llQueue.peek());
        llQueue.dequeue();
        System.out.println(llQueue.peek());
        llQueue.dequeue();
        System.out.println(llQueue.peek());
        llQueue.dequeue();
        System.out.println(llQueue.peek());
        llQueue.dequeue();
        System.out.println(llQueue.peek());
        llQueue.dequeue();
        System.out.println(llQueue.peek());
        llQueue.display();
        llQueue.dequeue();
        System.out.println(llQueue.peek());
    }
}
