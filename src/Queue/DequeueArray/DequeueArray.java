package Queue.DequeueArray;

public class DequeueArray {
    private final static int SIZE = 5;
    int dequeue[] = new int[SIZE];
    int front = -1;
    int rear = -1;
    int count;

    public void enqueueFront(int x)
    {
        if (front == -1 && rear == -1)
        {
            front = rear = 0;
            dequeue[front] = x;
            count++;
            return;
        }
        if ((rear+1)%SIZE == front)
        {
            System.out.println("overFlow condition for Dequeue");
            return;
        }
        if (front == 0)
        {
            front = SIZE - 1;
            dequeue[front] = x;
            count++;
            return;
        }
        front--;
        dequeue[front] = x;
        count++;
    }
    public void enqueueRear(int x)
    {
        if (front == -1 && rear ==-1)
        {
            front = rear = 0;
            dequeue[rear] = x;
            count++;
        }
        else if ((rear+1)%SIZE == front)
        {
            System.out.println("Queue is Full,Overflow");
        }
        else
        {
            rear = (rear+1)%SIZE;
            dequeue[rear] = x;
            count++;
        }
    }
    public void displayDequeue()
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
                System.out.print(dequeue[i]+"  ");
                i = (i+1)%SIZE;
            }
            System.out.print(dequeue[rear]);
            System.out.println();
        }
    }

    public int dequeueFront()
    {
        if (front == -1 && rear == -1)
        {
            System.out.println("Queue is Empty, UnderFlow");
            return -1;
        }
        else if (rear == front)
        {
            int p = dequeue[front];
            rear = front = -1;
            count--;
            return p;
        }
        else
        {
            int p = dequeue[front];
            front = (front+1)%SIZE;
            count--;
            return p;
        }
    }
    public int dequeueRear()
    {
        if (front == -1 && rear == -1)
        {
            System.out.println("Queue is Empty, UnderFlow");
            return -1;
        }
        if (rear == front)
        {
            int p = dequeue[rear];
            rear = front = -1;
            count--;
            return p;
        }
        if (rear == 0)
        {
            int p = dequeue[rear];
            rear = SIZE - 1;
            count--;
            return p;
        }

            int p = dequeue[rear];
            rear--;
            count--;
            return p;

    }

    public static void main(String[] args) {

        DequeueArray dequeueArray = new DequeueArray();
        dequeueArray.enqueueFront(5);
        dequeueArray.enqueueRear(6);
        dequeueArray.enqueueRear(7);
        dequeueArray.enqueueFront(4);
        dequeueArray.enqueueFront(3);
        dequeueArray.displayDequeue();
        dequeueArray.dequeueFront();
        dequeueArray.dequeueRear();
        dequeueArray.dequeueRear();
        dequeueArray.dequeueFront();
        dequeueArray.dequeueFront();
        dequeueArray.displayDequeue();
    }
}
