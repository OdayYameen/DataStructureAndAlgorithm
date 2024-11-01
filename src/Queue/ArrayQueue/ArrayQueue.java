package Queue.ArrayQueue;

public class ArrayQueue {
    private final static int SIZE = 5;
    int []queue = new int[SIZE];
    int front = -1;
    int rear = -1;
    int count = 0;

    public void enqueue(int x)
    {
        if (front == -1 && rear ==-1)
        {
            front = rear = 0;
            queue[rear] = x;
            count++;
        }
        else if ((rear+1)%SIZE == front)
        {
            System.out.println("Queue is Full,Overflow");
        }
        else
        {
            rear = (rear+1)%SIZE;
            queue[rear] = x;
            count++;
        }
    }
    public int dequeue()
    {
        if (front == -1 && rear == -1)
        {
            System.out.println("Queue is Empty, UnderFlow");
            return -1;
        }
        else if (rear == front)
        {
            int p = queue[front];
            rear = front = -1;
            count--;
            return p;
        }
        else
        {
            int p = queue[front];
            front = (front+1)%SIZE;
            count--;
            return p;
        }
    }
    public void displayQueue()
    {
        if (front == -1 && rear == -1)
        {
            System.out.println("Cannot Display Queue, is Empty");
        }
        else
        {
            int i = front;
            while (i != rear)
            {
                System.out.print(queue[i]+"  ");
                i = (i+1)%SIZE;
            }
            System.out.print(queue[rear]);
            System.out.println();
        }
    }
    public int getSize()
    {
        return count;
    }

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(8);
        System.out.println("Size = "+arrayQueue.getSize());
        arrayQueue.displayQueue();
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        arrayQueue.displayQueue();
        System.out.println(arrayQueue.dequeue());
        System.out.println("Size = "+arrayQueue.getSize());
    }
}
