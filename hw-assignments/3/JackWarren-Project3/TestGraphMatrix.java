import java.util.*;

public class TestGraphMatrix{
    public static void main(String[] args){
        GraphMatrix matrix = new GraphMatrix();
        matrix.init(5);
        System.out.println(matrix);
        matrix.addEdge(0, 1, 1);
        matrix.addEdge(0, 2, 1);
        matrix.addEdge(1, 4, 1);
        matrix.addEdge(2, 4, 1);
        matrix.addEdge(2, 3, 1);
        System.out.println(matrix);
        System.out.println(matrix.neighbors(0));
        System.out.println(matrix.neighbors(4));
        System.out.println(matrix.neighbors(1));
        ArrayList<Integer> bfs = matrix.BFS(0);
        System.out.println(bfs);
        matrix.resetVisited();
        System.out.println(matrix.topologicalSort());
        System.out.println("----------\n");
        GraphMatrix big = new GraphMatrix();
        big.init(8);
        big.addEdge(0, 1, 1);
        big.addEdge(0, 2, 1);
        big.addEdge(2, 1, 1);
        big.addEdge(1, 3, 1);
        big.addEdge(1, 4, 1);
        big.addEdge(4, 5, 1);
        big.addEdge(2, 6, 1);
        big.addEdge(2, 7, 1);
/*
        big.addEdge(1, 0, 1);
        big.addEdge(2, 0, 1);
        big.addEdge(1, 2, 1);
        big.addEdge(3, 1, 1);
        big.addEdge(4, 1, 1);
        big.addEdge(5, 4, 1);
        big.addEdge(6, 2, 1);
        big.addEdge(7, 2, 1);
*/
        System.out.println(big);
        System.out.println(big.neighbors(0));
        System.out.println(big.neighbors(1));
        System.out.println(big.BFS(2));
        big.resetVisited();
        System.out.println(big.hasPath(2, 5));
        big.resetVisited();
        System.out.println(big.topologicalSort());
    }
}