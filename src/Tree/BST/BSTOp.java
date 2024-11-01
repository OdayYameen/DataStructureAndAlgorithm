package Tree.BST;

import Tree.BTNode;

public class BSTOp {


    public BTNode insert(BTNode root, int data)
    {
        if (root == null)
        {
            root = new BTNode(data);
            return root;
        }
        if (data < root.data)
        {
            root.left = insert(root.left,data);
        }
        else if (data > root.data)
        {
            root.right = insert(root.right,data);
        }
        return root;
    }

    public BTNode search(BTNode root, int data)
    {
        BTNode found = null;
        if (root == null)
        {
            return null;
        }
        if (root.data == data)
        {
            found = root;
        }
        if (found == null)
        {
            found = search(root.left, data);
        }
        if (found == null)
        {
            found = search(root.right,data);
        }
        return found;
    }
    public void editNode(BTNode root, int data, int newData)
    {
        BTNode founded = search(root, data);
        if (founded != null)
        {
            founded.data = newData;
        }
        else
        {
            System.out.println("This data = "+data+ " node not found");
        }
    }
    public boolean isExist(BTNode root, int data)
    {
        boolean found = false;
        if (root == null)
        {
            return false;
        }
        if (root.data == data)
        {
            found = true;
        }
        if (!found)
        {
            found = isExist(root.left, data);
        }
        if (!found)
        {
            found = isExist(root.right,data);
        }
        return found;
    }
    public void printInOrder(BTNode root)
    {
        if (root == null)
        {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + "    ");
        printInOrder(root.right);
    }
    public void printPreOrder(BTNode root)
    {
        if (root == null)
        {
            return;
        }
        System.out.print(root.data + "    ");
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
        System.out.print(root.data + "    ");
    }
    public BTNode deleteNode(BTNode root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    int minValue(BTNode root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    public BTNode deleteNodeBetterPerformance(BTNode root, int k) {

        // Base case
        if (root == null)
            return root;

        // Recursive calls for ancestors of
        // node to be deleted
        if (root.data > k)
        {
            root.left = deleteNodeBetterPerformance(root.left, k);
        }
        else if (root.data < k)
        {
            root.right = deleteNodeBetterPerformance(root.right, k);
        }
        else
        {
            // We reach here when root is the node
            // to be deleted.

            // If one of the children is empty
            if (root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }

            // If both children exist
            else
            {
                BTNode succParent = root;

                // Find successor
                BTNode succ = root.right;

                while (succ.left != null)
                {
                    succParent = succ;
                    succ = succ.left;
                }

                // Delete successor. Since successor
                // is always left child of its parent
                // we can safely make successor's right
                // right child as left of its parent.
                // If there is no succ, then assign
                // succ->right to succParent->right
                if (succParent != root)
                    succParent.left = succ.right;
                else
                    succParent.right = succ.right;

                // Copy Successor Data to root
                root.data = succ.data;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BSTOp bstOp = new BSTOp();
        BTNode root = null;
        root = bstOp.insert(root ,5);
        root = bstOp.insert(root ,3);
        root = bstOp.insert(root ,2);
        root = bstOp.insert(root ,4);
        root = bstOp.insert(root ,8);
        root = bstOp.insert(root ,9);
        root = bstOp.insert(root ,7);
        bstOp.printInOrder(root);
        bstOp.editNode(root,9,10);
        System.out.println();
        bstOp.printInOrder(root);
        System.out.println();
        System.out.println("is Exist");
        System.out.println(bstOp.isExist(root,7));
        //root = bstOp.deleteNode(root,2);
        root = bstOp.deleteNodeBetterPerformance(root, 2);
        System.out.println();
        System.out.println("delete 2");
        bstOp.printInOrder(root);
        root = bstOp.deleteNodeBetterPerformance(root, 3);
        System.out.println();
        System.out.println("delete 3");
        bstOp.printInOrder(root);
        root = bstOp.deleteNodeBetterPerformance(root, 5);
        System.out.println();
        System.out.println("delete 5");
        bstOp.printInOrder(root);
    }
}
