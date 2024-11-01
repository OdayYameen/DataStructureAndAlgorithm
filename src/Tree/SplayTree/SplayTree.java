package Tree.SplayTree;

// data structure that represents a node in the tree
class Node {
    int data; // holds the key
    Node parent; // pointer to the parent
    Node left; // pointer to left child
    Node right; // pointer to right child

    public Node(int data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}

public class SplayTree {
    private Node root;

    public SplayTree() {
        root = null;
    }

    private void printHelper(Node currPtr, String indent, boolean last) {
        // print the tree structure on the screen
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            System.out.println(currPtr.data);

            printHelper(currPtr.left, indent, false);
            printHelper(currPtr.right, indent, true);
        }
    }

    private Node searchTreeHelper(Node node, int key) {
        Node PrevNode = null;
        Node z = root;
        while (z != null)
        {
            PrevNode = z;
            if (key > z.data)
                z = z.right;
            else if (key < z.data)
                z = z.left;
            else if(key == z.data) {
                splay(z);
                return z;
            }

        }
        if(PrevNode != null)
        {
            splay(PrevNode);
            return null;
        }
        return null;
    }

    private void deleteNodeHelper(Node node, int key) {
        Node x = null;
        Node t = null;
        Node s = null;
        Node prevNode = null;
        while (node != null)
        {
            prevNode = node;
            if (node.data == key) {
                x = node;
            }

            if (node.data <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (x == null)
        {
            if (prevNode != null)
            {
                splay(prevNode);
            }
            System.out.println("Couldn't find key in the tree");
            return;
        }
        // make the node to be deleted as root
        splay(x);
        if (x.right != null) {
            // t will equal right subtree of root if it is not null and the parent for sub right root = null
            t = x.right;
            t.parent = null;
        } else {
            t = null;
        }
        s = x;
        // separate left subtree from right subtree but saving them as reference
        s.right = null;
        x = null;

        // join operation
        if (s.left != null){ // remove x
            s.left.parent = null;
        }
        // join the left subtree with right subtree
        root = join(s.left, t);
        s = null;
    }

    // rotate left at node x
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Splaying operation. It moves x to the root of the tree
    private void splay(Node x)
    {
        while (x.parent != null)
        {
            if (x.parent.parent == null)
            {
                if (x == x.parent.left)
                {
                    // zig rotation
                    rightRotate(x.parent);
                }
                else
                {
                    // zag rotation
                    leftRotate(x.parent);
                }
            }
            else if (x == x.parent.left && x.parent == x.parent.parent.left)
            {
                // zig-zig rotation
                rightRotate(x.parent.parent);
                rightRotate(x.parent);
            }
            else if (x == x.parent.right && x.parent == x.parent.parent.right)
            {
                // zag-zag rotation
                leftRotate(x.parent.parent);
                leftRotate(x.parent);
            }
            else if (x == x.parent.right && x.parent == x.parent.parent.left)
            {
                // zig-zag rotation
                leftRotate(x.parent);
                rightRotate(x.parent);
            }
            else
            {
                //x == x.parent.left && x.parent == x.parent.parent.right
                // zag-zig rotation
                rightRotate(x.parent);
                leftRotate(x.parent);
            }
        }
    }

    // joins two trees s and t
    private Node join(Node s, Node t){
        if (s == null) {
            // if left subtree null return right subtree
            return t;
        }

        if (t == null) {
            // if right subtree null return left subtree
            return s;
        }
        Node x = maximum(s);
        // make the maximum in left subtree the root of left subtree
        splay(x);
        x.right = t;
        t.parent = x;
        return x;
    }


    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Pre-Order traversal
    // Node->Left Subtree->Right Subtree
    public void preorder() {
        preOrderHelper(this.root);
    }

    // In-Order traversal
    // Left Subtree -> Node -> Right Subtree
    public void inorder() {
        inOrderHelper(this.root);
    }

    // Post-Order traversal
    // Left Subtree -> Right Subtree -> Node
    public void postorder() {
        postOrderHelper(this.root);
    }

    // search the tree for the key k
    // and return the corresponding node
    public Node searchTree(int k) {
        return searchTreeHelper(root, k);
    }

    // find the node with the minimum key
    public Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // find the node with the maximum key
    public Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // find the successor of a given node
    public Node successor(Node x) {
        // if the right subtree is not null,
        // the successor is the leftmost node in the
        // right subtree
        if (x.right != null) {
            return minimum(x.right);
        }

        // else it is the lowest ancestor of x whose
        // left child is also an ancestor of x.
        Node y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // find the predecessor of a given node
    public Node predecessor(Node x) {
        // if the left subtree is not null,
        // the predecessor is the rightmost node in the
        // left subtree
        if (x.left != null) {
            return maximum(x.left);
        }

        Node y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    // insert the key to the tree in its appropriate position
    public void insert(int key) {
        Node node = new Node(key);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y is parent of x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        // splay node
        splay(node);
    }

    // delete the node from the tree
    void deleteNodeTD(int data) {
        deleteNodeHelper(this.root, data);
    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

    void deleteNodeBU(int key)
    {
        Node curr = root;
        Node prev = null;

        // Check if the key is actually
        // present in the BST.
        // the variable prev points to
        // the parent of the key to be deleted.
        while (curr != null && curr.data != key) {
            prev = curr;
            if (key < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        if (curr == null) {
            System.out.println("Key " + key
                    + " not found in the"
                    + " provided BST.");
            if (prev != null)
            {
                splay(prev);
            }
            return;
        }

        // Check if the node to be
        // deleted has at most one child.
        if (curr.left == null || curr.right == null) {

            // newCurr will replace
            // the node to be deleted.
            Node newCurr;

            // if the left child does not exist.
            if (curr.left == null)
                newCurr = curr.right;
            else
                newCurr = curr.left;

            // check if the node to
            // be deleted is the root.
            if (prev == null) {
                if (newCurr != null)
                {
                    newCurr.parent = null;
                }
                root = newCurr;
                return;
            }
            // check if the node to be deleted
            // is prev's left or right child
            // and then replace this with newCurr
            if (curr == prev.left)
                prev.left = newCurr;
            else
                prev.right = newCurr;

            if (newCurr != null)
            {
                newCurr.parent = prev;
            }
        }

        // node to be deleted has
        // two children.
        else {
            Node p = null;
            Node temp;

            // Compute the inorder successor
            temp = curr.right;
            while (temp.left != null) {
                p = temp;
                temp = temp.left;
            }

            // check if the parent of the inorder
            // successor is the curr or not(i.e. curr=
            // the node which has the same data as
            // the given data by the user to be
            // deleted). if it isn't, then make the
            // left child of its parent equal to
            // the inorder successor's right child.
            if (p != null) {

                if (temp.right != null)
                {
                    temp.right.parent = p;
                }
                p.left = temp.right;
            }
                // if the inorder successor was the
                // curr (i.e. curr = the node which has the
                // same data as the given data by the
                // user to be deleted), then make the
                // right child of the node to be
                // deleted equal to the right child of
                // the inorder successor.
            else {
                if (temp.right != null)
                {
                    temp.right.parent = curr;
                }
                curr.right = temp.right;

            }
            curr.data = temp.data;
        }
        if (prev != null)
        {
            splay(prev);
        }

    }
    public static void main(String [] args) {
        SplayTree tree = new SplayTree();

        tree.insert(14);
        tree.insert(28);
        tree.insert(19);
        tree.insert(63);
        tree.insert(5);
        tree.insert(7);
        tree.deleteNodeTD(24);
        tree.deleteNodeTD(28);
        tree.deleteNodeTD(28);
        tree.deleteNodeTD(14);
        tree.deleteNodeTD(20);
        tree.searchTree(18);
        tree.searchTree(64);
        tree.insert(12);
        tree.insert(15);
        tree.insert(10);
        tree.insert(17);
        tree.insert(7);
        tree.insert(13);
        tree.insert(16);
        tree.insert(14);
        tree.deleteNodeBU(12);
        tree.deleteNodeBU(14);
        tree.deleteNodeBU(16);
        tree.deleteNodeBU(20);
        tree.deleteNodeBU(17);
        tree.deleteNodeBU(13);
        tree.searchTree(10);
        tree.deleteNodeBU(10);
        tree.insert(10);
        tree.deleteNodeBU(7);
        tree.deleteNodeBU(10);
        tree.deleteNodeBU(15);
        tree.insert(10);
        tree.insert(15);
        tree.insert(9);
        tree.insert(11);
        tree.deleteNodeBU(16);
        tree.searchTree(12);
        tree.inorder();
        System.out.println();
        tree.prettyPrint();
    }
}
