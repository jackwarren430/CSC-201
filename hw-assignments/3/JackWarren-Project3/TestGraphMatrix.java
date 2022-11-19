public class TestGraphMatrix{
    public static void main(String[] args){
        GraphMatrix matrix = new GraphMatrix();
        matrix.init(5);
        System.out.println(matrix);
        matrix.addEdge(0, 1, 1);
        matrix.addEdge(0, 2, 1);
        matrix.addEdge(1, 3, 1);
        matrix.addEdge(2, 4, 1);
        matrix.addEdge(1, 4, 1);
        System.out.println(matrix);
        System.out.println(matrix.neighbors(0));
        System.out.println(matrix.neighbors(4));
        System.out.println(matrix.neighbors(1));
    }
}