package Graph.BFS;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    private void BFSDisconnected()
    {
        System.out.println("DisconnectedGraph BFS");
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
        {
            System.out.println("BFS For vertex = " + i);
            if (!visited[i])
            {
                BFSDisconnectedHelper(i,visited);
            }
        }
    }
    private void BFSDisconnectedHelper(int src,boolean []visited)
    {

        LinkedList<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.push(src);

        while (!queue.isEmpty())
        {
            int u = queue.poll();
            System.out.print(u + "  ");
            for (int v : adj[u])
            {
                if (!visited[v])
                {
                    visited[v] = true;
                    queue.push(v);
                }
            }
        }
        System.out.println();
    }
    private void DFSDisconnected()
    {
        System.out.println("DisconnectedGraph DFS");
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
        {
            System.out.println("DFS For vertex = " + i);
            if (!visited[i])
            {
                DFSDisconnectedHelper(i,visited);
            }
        }
    }
    private void DFSDisconnectedHelper(int src,boolean []visited)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty())
        {
            int u = stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if (!visited[u])
            {
                visited[u] = true;
                System.out.print(u + "  ");
                for (int v : adj[u])
                {
                    if (!visited[v])
                    {
                        stack.push(v);
                    }
                }
            }
        }
        System.out.println();
    }
    private void DFS(int src)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty())
        {
            int u = stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if (!visited[u])
            {
                visited[u] = true;
                System.out.print(u + "  ");
                for (int v : adj[u])
                {
                    if (!visited[v])
                    {
                        stack.push(v);
                    }
                }
            }
        }
    }

    /**
     * BFS Level Order traversal it means Level queue
     */
    private void BFS(int src)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.push(src);

        while (!queue.isEmpty())
        {
            int u = queue.poll();
            System.out.print(u + "  ");
            for (int v : adj[u])
            {
                if (!visited[v])
                {
                    visited[v] = true;
                    queue.push(v);
                }
            }
        }
        System.out.println();
    }
    private void DFSRecursive(int src)
    {
        boolean []visited = new boolean[V];
        if (!visited[src])
        {
            DFSRecursiveHelper(src,visited);
        }
    }

    private void DFSRecursiveHelper(int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + "  ");
        for (int v : adj[src])
        {
            if (!visited[v])
            {
                DFSRecursiveHelper(v,visited);
            }
        }
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFSRecursive(2);
    }
}
