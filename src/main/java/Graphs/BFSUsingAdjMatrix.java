package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSUsingAdjMatrix {
    class Vertex {
        public char label;
        public boolean visited;
        public Vertex(char label) {
            this.label = label;
            this.visited = false;
        }
    }

    private int maxVertices = 20;
    private int verticesCount;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private Queue<Integer> queue;

    public BFSUsingAdjMatrix() {
        adjMatrix = new int[maxVertices][maxVertices];
        vertices = new Vertex[maxVertices];
        verticesCount = 0;
        queue = new LinkedList();
    }

    public void addVertex(char label){
        vertices[verticesCount++] = new Vertex(label);
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertices[vertex].label);
    }

    public void bfs() {
        vertices[0].visited = true;
        displayVertex(0);
        queue.add(0);
        int v2;

        while(!queue.isEmpty()) {
            int v1 = queue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1) {
                vertices[v2].visited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for(int i = 0; i < verticesCount; i++) {
            vertices[i].visited = false;
        }
    }

    public int getAdjUnvisitedVertex(int vertex) {
        for(int j = 0; j < verticesCount; j++) {
            if(adjMatrix[vertex][j] == 1 && vertices[j].visited == false) {
                return j;
            }
        }
        return -1;
    }

    public void printMatrix(){
        for(int i = 0; i < verticesCount; i++){
            for (int j = 0; j < verticesCount; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BFSUsingAdjMatrix bfs = new BFSUsingAdjMatrix();
        bfs.addVertex('a');
        bfs.addVertex('b');
        bfs.addVertex('c');
        bfs.addVertex('d');
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(0, 3);
        bfs.addEdge(1, 0);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 0);
        bfs.addEdge(0, 1);
        bfs.addEdge(3, 0);
        bfs.addEdge(3, 1);
        bfs.printMatrix();
        bfs.bfs();
    }
}
