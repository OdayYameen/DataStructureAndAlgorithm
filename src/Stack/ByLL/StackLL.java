package Stack.ByLL;

import SingleLinkList.NodeSLL;

public class StackLL {
  NodeSLL top;
  int count = 0;

  public void push(int x)
  {
    NodeSLL newNode = new NodeSLL(x);
    newNode.next = top;
    top = newNode;
    count++;
  }
  public void display()
  {
    if (top == null)
    {
      System.out.println("Empty Stack LL");
    }
    else
    {
      NodeSLL p = top;
      while (p != null)
      {
        System.out.print(p.data+"  ");
        p = p.next;
      }
      System.out.println();
    }
  }
  public int pop()
  {
    if (top == null)
    {
      System.out.println("UnderFlow Condition, Empty StackList");
      return -1;
    }
    else
    {
      NodeSLL p = top;
      top = top.next;
      p.next = null;
      count--;
      return p.data;
    }
  }
  public int peek()
  {
    if (top == null)
    {
      System.out.println("UnderFlow Condition, Empty StackList");
      return -1;
    }
    else
    {
      return top.data;
    }
  }

  public NodeSLL getTop() {
    return top;
  }
}
