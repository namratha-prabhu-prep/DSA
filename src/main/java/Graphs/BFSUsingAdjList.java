package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSUsingAdjList {
    int vertices;
    LinkedList<Integer> adjList[];
    Queue<Integer> queue;
    boolean visited[];

    public BFSUsingAdjList(int v) {
        this.vertices = v;
        this.adjList = new LinkedList[v];
        queue = new LinkedList();
        visited = new boolean[v];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int i, int j) {
        adjList[i].add(j);
        adjList[j].add(i);
    }

    public void bfs(int vertex) {
        visited[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()) {
            int v1 = queue.poll();
            System.out.println("Vertex: " +  v1);
            Iterator<Integer> i = adjList[v1].listIterator();
            while(i.hasNext()) {
                int nextVertex = i.next();
                if(!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
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
        BFSUsingAdjList bfs = new BFSUsingAdjList(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 3);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 3);
        bfs.addEdge(2, 0);
        // bfs.printAdjList(bfs.adjList);
        bfs.bfs(1);
    }
}
