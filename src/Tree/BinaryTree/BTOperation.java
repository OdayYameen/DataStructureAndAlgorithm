package Tree.BinaryTree;

import Tree.BTNode;

import java.util.Scanner;

public class BTOperation {

    BTNode root;
    public BTNode getRoot()
    {
        return root;
    }
    private BTNode createBT()
    {
        System.out.println("Enter -1 to not add node.");
        Scanner in = new Scanner(System.in);
        int data = in.nextInt();
        if (data == -1)
        {
            return null;
        }
        BTNode newNode = new BTNode(data);
        System.out.println("Enter left child for ==> "+ data);
        newNode.left = createBT();
        System.out.println("Enter right child for ==> "+ data);
        newNode.right = createBT();
        return newNode;
    }
    public void createBinaryTree()
    {
        root = createBT();
    }
    public void printInOrder(BTNode root)
    {
        if (root == null)
        {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + "  ,  ");
        printInOrder(root.right);
    }
    public void printPreOrder(BTNode root)
    {
        if (root == null)
        {
            return;
        }
        System.out.print(root.data + "  ,  ");
        printInOrder(root.left);
        printInOrder(root.right);
    }
    public void printPostOrder(BTNode root)
    {
        if (root == null)
        {
            return;
        }
        printInOrder(root.left);
        printInOrder(root.right);
        System.out.print(root.data + "  ,  ");
    }

    public static void main(String[] args) {

        BTOperation btOperation = new BTOperation();
        btOperation.createBinaryTree();
        System.out.println("Print inorder");
        btOperation.printInOrder(btOperation.getRoot());
        System.out.println();
        System.out.println("Print preorder");
        btOperation.printPreOrder(btOperation.getRoot());
        System.out.println();
        System.out.println("Print postorder");
        btOperation.printPostOrder(btOperation.getRoot());
        System.out.println("Print inorder");
        btOperation.printInOrder(btOperation.getRoot());
    }
}
