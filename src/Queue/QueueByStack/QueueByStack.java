package Queue.QueueByStack;

import SingleLinkList.NodeSLL;
import Stack.ByLL.StackLL;

public class QueueByStack {
    StackLL s1 = new StackLL();
    StackLL s2 = new StackLL();
    int count;

    public void enqueue(int x)
    {
        s1.push(x);
        count++;
    }
    public int dequeue()
    {
        for (int i = 0; i< count;i++)
        {
            s2.push(s1.pop());
        }
        int x = s2.pop();
        count--;
        for (int i = 0; i< count;i++)
        {
            s1.push(s2.pop());
        }
        return x;
    }
    public void display()
    {
        if (count == 0)
        {
            System.out.println("Empty QueueByStack, Cannot print");
            return;
        }
        for (int i = 0; i< count;i++)
        {
            s2.push(s1.pop());
        }
        for (int i = 0; i< count;i++)
        {
            System.out.print(s2.peek()+"  ");
            s1.push(s2.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QueueByStack queueByStack = new QueueByStack();
        queueByStack.enqueue(5);
        queueByStack.enqueue(4);
        queueByStack.enqueue(3);
        queueByStack.display();
        System.out.println(queueByStack.dequeue());
        System.out.println(queueByStack.dequeue());
        System.out.println(queueByStack.dequeue());
        queueByStack.display();
        System.out.println(queueByStack.dequeue());
    }
}
