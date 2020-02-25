package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSUsingAdjList {
    int vertices;
    LinkedList<Integer> adjList[];

    public DFSUsingAdjList(int v) {
        this.vertices = v;
        this.adjList = new LinkedList[this.vertices];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int i, int j) {
        adjList[i].add(j);
        adjList[j].add(i);
    }

    public void dfs(int vertex) {
        boolean[] visited = new boolean[this.vertices];
        dfsUtil(vertex, visited);
    }

    public void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println("vertex: " + vertex);

        Iterator<Integer> iter = adjList[vertex].listIterator();
        while(iter.hasNext()) {
            int nextVertex = iter.next();
            if(!visited[nextVertex]) {
                dfsUtil(nextVertex, visited);
            }
        }
    }

    public void printAdjList(LinkedList[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.println("Vertex " + i);
            for (Object node : adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        DFSUsingAdjList dfs = new DFSUsingAdjList(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 3);
        dfs.addEdge(2, 0);
        dfs.printAdjList(dfs.adjList);
        dfs.dfs(1);
    }
}
