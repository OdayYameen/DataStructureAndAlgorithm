package Stack.ByArray;

public class StackArray {
    private final static int SIZE = 5;
    int []stack = new int[SIZE];
    int top = -1;

    public void push(int x)
    {
        if (top == SIZE-1)
        {
            System.out.println("OverFlow condition");
        }
        else
        {
            top++;
            stack[top] = x;
        }
    }
    public int pop()
    {
        if (top == -1)
        {
            System.out.println("UnderFlow condition");
            return top;
        }
        else
        {
            int temp = stack[top];
            top--;
            return temp;
        }

    }
    public int peek()
    {
        if (top == -1)
        {
            System.out.println("UnderFlow condition");
            return top;
        }
        else
        {
            int temp = stack[top];
            return temp;
        }
    }
    public void displayStack()
    {
        if (top == -1)
        {
            System.out.println("Empty Stack, nothing to display");
            return;
        }
        for (int i = top; i >= 0; i--)
        {
            System.out.print(stack[i]+"  ");
        }
        System.out.println();
    }
}
