package Graph.GraphRepresent;

import java.util.*;

public class GraphRepresent {


    private void buildGraphByArrayList(boolean buildReverse,boolean directed)
    {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i< V ; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        /*addEdge(adj,0,1,directed);
        addEdge(adj,0,4,directed);
        addEdge(adj,1,4,directed);
        addEdge(adj,1,3,directed);
        addEdge(adj,1,2,directed);
        addEdge(adj,3,4,directed);
        addEdge(adj,2,3,directed);*/
        addEdge(adj,0, 1, directed);
        addEdge(adj,0, 4, directed);
        addEdge(adj,0, 3, directed);
        addEdge(adj,2, 0, directed);
        addEdge(adj,3, 2, directed);
        addEdge(adj,4, 1, directed);
        addEdge(adj,4, 3, directed);
        printAdjGraph(adj);
        if (buildReverse)
        {
            ArrayList<ArrayList<Integer>> tr = getTranspose(adj);
            System.out.println("Print transpose ...");
            printAdjGraph(tr);
        }

    }
    private void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v,boolean directed)
    {
        if (adj != null) {
            if (directed) {
                adj.get(u).add(v);
            } else {
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
    }
    private void printAdjGraph(ArrayList<ArrayList<Integer>> adj)
    {
        if (adj != null && !adj.isEmpty())
        {
            for (int i = 0; i < adj.size(); i++)
            {
                System.out.println("\n AdjList for vertex " + i);
                System.out.print("the head");
                ArrayList<Integer> y = adj.get(i);
                if (y != null && !y.isEmpty())
                {
                    for (int j = 0; j < y.size();j++)
                    {
                        System.out.print(" --> " + y.get(j));
                    }
                    System.out.println();
                }

            }
        }
    }
    private void addEdge(HashMap<Integer,TreeSet<Integer>> graph, int u, int v)
    {
        if (graph!= null)
        {
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    private void printGraph(HashMap<Integer,TreeSet<Integer>> graph)

    {
        if (graph != null && !graph.isEmpty())
        {
            for (int i = 0; i< graph.size(); i++)
            {
                System.out.println("AdjSet of vertex " + i);
                TreeSet<Integer> x = graph.get(i);
                if (x!= null && !x.isEmpty())
                {
                    Iterator y = x.iterator();
                    while (y.hasNext())
                    {
                        System.out.print(y.next() + " ");
                    }
                }
                System.out.println();

            }
        }
    }
    private void searchEdge(HashMap<Integer,TreeSet<Integer>> graph, int u, int v)
    {
        if (graph != null && !graph.isEmpty())
        {
            if (graph.get(u).contains(v))
            {
                System.out.println("Edge from " + u + " to "
                        + v + " found");
            }
            else
            {
                System.out.println("Edge from " + u + " to "
                        + v + " not found");
            }
            System.out.println();
        }
    }
    private ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> tr = new ArrayList<>();
        for (int i=0;i<adj.size(); i++)
        {
            tr.add(new ArrayList<Integer>());
        }
        if (adj != null && !adj.isEmpty()) {
            for (int i = 0; i < adj.size(); i++)
            {
                for (int j = 0; j<adj.get(i).size();j++)
                {
                    addEdge(tr,adj.get(i).get(j),i,true);
                }
            }
        }
        return tr;
    }
    private void buildGraphBySets()
    {
        HashMap<Integer, TreeSet<Integer>> graph
                = new HashMap<>();
        int V =5;
        for (int i = 0; i< V; i++)
        {
            graph.put(i,new TreeSet<>());
        }
        addEdge(graph,0, 1);
        addEdge(graph,0, 4);
        addEdge(graph,1, 2);
        addEdge(graph,1, 3);
        addEdge(graph,1, 4);
        addEdge(graph,2, 3);
        addEdge(graph,3, 4);
        //print
        printGraph(graph);
        //search
        searchEdge(graph,2, 1);
        searchEdge(graph,0, 3);
    }

    public static void main(String[] args) {
        GraphRepresent x = new GraphRepresent();
        //x.buildGraphBySets();
        x.buildGraphByArrayList(true,true);
    }
}
