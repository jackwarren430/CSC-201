import java.util.*;

public class GraphMatrix implements Graph{
    
    private int[][] matrix;
    private boolean[] visited;
    private int nodes;
    private int edges;


    public void init(int n){
        matrix = new int[n][n];
        visited = new boolean[n];
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
        if (v >= nodes || w >= nodes) {
            System.out.println("ERROR: node does not exist");
            return false;
        } else if (matrix[v][w] > 0){
            return true;
        } else {
            return false;
        }
    }

    public void addEdge(int v, int w, int wgt){
        if (v >= nodes || w >= nodes){
            System.out.println("ERROR: node does not exist");
            return;
        }
        matrix[v][w] = wgt;
        edges++;
    }

    public void removeEdge(int v, int w){
        if (v >= nodes || w >= nodes){
            System.out.println("ERROR: node does not exist");
            return;
        }
        matrix[v][w] = 0;
        edges--;
    }

    public int getWeight(int v, int w){
        if (v >= nodes || w >= nodes){
            System.out.println("ERROR: node does not exist");
            return -1;
        }
        return matrix[v][w];
    }

    public void setWeight(int v, int w, int wgt){
        if (v >= nodes || w >= nodes){
            System.out.println("Error: node does not exist");
            return;
        } else if (matrix[v][w] == 0){
            System.out.println("ERROR: no edge exists here");
            return;
        }
        matrix[v][w] = wgt;
    }

    public ArrayList<Integer> neighbors(int v){
        if (v >= nodes){
            System.out.println("ERROR: node does not exist");
            return null;
        }
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (int i = 0; i < nodes; i++){
            int from = matrix[v][i];
            if (from > 0){
                toReturn.add(i);
            } 
        }
        return toReturn;
    }

    public void resetVisited(){
        visited = new boolean[nodes];
    }

    public ArrayList<Integer> BFS(int v){
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;
        while (q.peek() != null){
            int curr = q.remove();
            toReturn.add(curr);
            ArrayList<Integer> neighbors = neighbors(curr);
            for (int i : neighbors){
                if (visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return toReturn;

    }

    public boolean hasPath(int v, int w){
        if (v >= nodes || w >= nodes){
            System.out.println("ERROR: node does not exist");
            return false;
        }
        ArrayList<Integer> bfs = BFS(v);
        return bfs.contains(w) ? true : false;
    }

    public ArrayList<Integer> topologicalSort(){
        return null;
    }

    public String toString(){
        String toReturn = "";
        for (int i = 0; i < nodes; i++){
            for (int j = 0; j < nodes; j++){
                toReturn += matrix[i][j] + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }

}