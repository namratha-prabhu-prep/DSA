package Graphs;

public class AdjacencyMatrix {
    int vertices;
    int[][] matrix;

    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public void removeEdge(int i, int j){
        matrix[i][j] = 0;
        matrix[j][i] = 0;
    }

    public boolean isEdge(int i, int j){
        if(matrix[i][j] == 1) return true;
        return false;
    }

    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(4);
        adjMatrix.addEdge(0,  1);
        adjMatrix.addEdge(0, 3);
        adjMatrix.addEdge(1, 3);
        adjMatrix.addEdge(2, 0);
        adjMatrix.printMatrix();
    }
}
