import java.util.*;

public class GraphMatrix implements Graph{
    
    private int[][] matrix;
    private int[][] visited;
    private int nodes;
    private int edges;

    public GraphMatrix(){

    }

    public void init(int n){
        matrix = new int[n][n];
        visited = new int[n][n];
        nodes = n;
        edges = 0;
    }

    public int nodeCount(){
        return nodes;
    }

    public int edgeCount(){
        return edges;
    }

    public boolean hasEdge(int v, int w){
        
    }

    public void addEdge(int v, int w, int wgt){

    }

    public void removeEdge(int v, int w){

    }

    public int getWeight(int v, int w){

    }

    public void setWeight(int v, int w, int wgt){

    }

    public ArrayList<Integer> neighbors(int v){

    }

    public void resetVisited(){

    }

    public ArrayList<Integer> BFS(){

    }

    public boolean hasPath(int v, int w){

    }

    public ArrayList<Integer> topologicalSort(){

    }


}