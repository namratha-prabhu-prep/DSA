package Graphs;

import java.util.LinkedList;

public class AdjacencyList {
    public static class Graph {
        int vertices;
        // array of LinkedList
        // You can also use an ArrayList instead of LinkedList
        LinkedList<Integer> adjList[];

        public Graph(int v){
            this.vertices = v;
            this.adjList = new LinkedList[vertices];

            for(int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList();
            }
        }
    }

    public void addEdge(Graph graph, int src, int dest) {
        graph.adjList[src].add(dest);
        // for undirected graphs
        graph.adjList[dest].add(src);
    }

    public void printAdjList(Graph graph) {
        for (int i = 0; i < graph.adjList.length; i++) {
            System.out.println("Vertex " + i);
            for (Integer node : graph.adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjList = new AdjacencyList();
        Graph graph = new Graph(4);
        adjList.addEdge(graph, 0, 1);
        adjList.addEdge(graph, 0, 3);
        adjList.addEdge(graph, 1, 2);
        adjList.addEdge(graph, 2, 3);
        adjList.addEdge(graph, 2, 0);
        adjList.printAdjList(graph);
    }
}
