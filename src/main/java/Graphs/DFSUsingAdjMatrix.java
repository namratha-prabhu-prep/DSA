package Graphs;

import java.util.Stack;

public class DFSUsingAdjMatrix {
    class Vertex {
        char label;
        boolean visited;
        public Vertex(char label) {
            this.label = label;
            this.visited = false;
        }
    }

    int maxVertices = 20;
    int vertexCount;
    Vertex[] vertices;
    int[][] adjMatrix;
    Stack stack;

    public DFSUsingAdjMatrix() {
        vertices = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        stack = new Stack();
    }

    public void addVertex(char lab) {
        vertices[vertexCount++] = new Vertex(lab);
    }

    public void displayVertex(int index) {
        System.out.println(vertices[index].label);
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void dfs() {
        vertices[0].visited = true;
        displayVertex(0);
        stack.push(0);

        while(!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex((Integer) stack.peek());
            if(v == -1) {
                stack.pop(); // backtracking
            } else {
                vertices[v].visited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for(int j = 0; j < vertexCount; j++) {
            vertices[j].visited = false; // reset flags because if we add a vertex or edge, we would not be able to
            // do DFS as all the vertex would be visited already.
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for(int j = 0; j < vertexCount; j++) {
            if(adjMatrix[v][j] == 1 && vertices[j].visited == false) {
                return j;
            }
        }
        return -1;
    }

    public void printMatrix(){
        for(int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        DFSUsingAdjMatrix dfs = new DFSUsingAdjMatrix();
        dfs.addVertex('a');
        dfs.addVertex('b');
        dfs.addVertex('c');
        dfs.addVertex('d');
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 0);
        dfs.addEdge(1, 3);
        dfs.addEdge(2, 0);
        dfs.addEdge(0, 1);
        dfs.addEdge(3, 0);
        dfs.addEdge(3, 1);
        dfs.printMatrix();
        dfs.dfs();
        /*
        o/p:

        0 1 1 1
        1 0 0 1
        1 0 0 0
        1 1 0 0
        a
        b
        c
        d
         */
    }
}
