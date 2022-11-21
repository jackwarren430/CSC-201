import java.util.*;

public class GraphMatrix implements Graph{
    
    //  instance vars:
    //      int[][] matrix acts as graph storage
    //      boolean[] visited keeps track of visited nodes for bfs
    //      int nodes to keep track of number of nodes
    //      int edges to keep track of num edges
    private int[][] matrix;
    private boolean[] visited;
    private int nodes;
    private int edges;


    //  initialization makes empty square matrix of size n
    //      makes empty boolean array of size n
    //      sets nodes to n and edges to 0
    public void init(int n){
        matrix = new int[n][n];
        visited = new boolean[n];
        nodes = n;
        edges = 0;
    }

    // returns number of nodes in graph
    public int nodeCount(){
        return nodes;
    }

    //  returns number of edges in graph
    public int edgeCount(){
        return edges;
    }

    //  checks to make sure nodes are valid,
    //  then returns true if the matrix value for v and w is greater than 0
    //  returns false otherwise
    public boolean hasEdge(int v, int w){
        if (v >= nodes || w >= nodes || v < 0 || w < 0) {
            System.out.println("ERROR: node does not exist");
            return false;
        } else if (matrix[v][w] > 0){
            return true;
        } else {
            return false;
        }
    }

    //  takes in two nodes and a weight. if the nodes are valid then matrix from v to w is set to wgt
    public void addEdge(int v, int w, int wgt){
        if (v >= nodes || w >= nodes || v < 0 || w < 0){
            System.out.println("ERROR: node does not exist");
            return;
        }
        // makes sure there was not an edge before adding 1 to edges
        edges = matrix[v][w] == 0 ? edges + 1 : edges;
        matrix[v][w] = wgt;
    }

    //  takes two nodes. if they're valid, set matrix[v][w] to 0
    public void removeEdge(int v, int w){
        if (v >= nodes || w >= nodes || v < 0 || w < 0){
            System.out.println("ERROR: node does not exist");
            return;
        }
        //  makes sure there was an edge before removing 1 from edges
        edges = matrix[v][w] > 0 ? edges - 1 : edges;
        matrix[v][w] = 0;
    }

    //  if both nodes are valid, simply return matrix[v][w]
    public int getWeight(int v, int w){
        if (v >= nodes || w >= nodes || v < 0 || w < 0){
            System.out.println("ERROR: node does not exist");
            return -1;
        }
        return matrix[v][w];
    }

    //  sets matrix[v][w] to wgt if both nodes are valid and there's already a weight there
    public void setWeight(int v, int w, int wgt){
        if (v >= nodes || w >= nodes || v < 0 || w < 0){
            System.out.println("Error: node does not exist");
            return;
        } else if (matrix[v][w] == 0){
            System.out.println("ERROR: no edge exists here");
            return;
        }
        matrix[v][w] = wgt;
    }

    // if the node is valid, this method iterates through the row of this node in matrix
    //  and returns all the nodes with weight > 0
    public ArrayList<Integer> neighbors(int v){
        if (v >= nodes || v < 0){
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

    //  simply reinitializes visited
    public void resetVisited(){
        visited = new boolean[nodes];
    }

    //  this method uses a queue to perform BFS. it adds the first vertex given by the user
    //  into the queue, then runs a while loop: while the queue is not empty, dequeue, add it
    //  to the return arraylist, find its neighbors, and for all the neighbors that aren't visited,
    //  add them to the queue and mark them visited. after the while loop finishes simply return the arraylist.
    public ArrayList<Integer> BFS(int v){
        if (v >= nodes || v < 0){
            System.out.println("ERROR: node does not exist");
            return null;
        }
        //  initializes toReturn arraylist and a linked list queue
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        //  adds first vertex chose by user and marks it visited
        q.add(v);
        visited[v] = true;
        //  while the queue is not empty
        while (q.peek() != null){
            //  dequeue, add it to arraylist, and fet all its neighbors
            int curr = q.remove();
            toReturn.add(curr);
            ArrayList<Integer> neighbors = neighbors(curr);
            for (int i : neighbors){
                //  for all unvisited neighbros, add them to queue and mark them visited
                if (visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return toReturn;

    }

    //  simply calls BFS(v), and if the return arraylist contains w then there is a path, so return true
    //  return false otherwise
    public boolean hasPath(int v, int w){
        if (v >= nodes || w >= nodes || v < 0 || w < 0){
            System.out.println("ERROR: node does not exist");
            return false;
        }
        ArrayList<Integer> bfs = BFS(v);
        return bfs.contains(w) ? true : false;
    }

    //  this method works similar to bfs, except instead of keeping track of which ones are visited,
    //  jsut keeps track of which nodes are still in-degree > 0 in the current state
    public ArrayList<Integer> topologicalSort(){
        //  initializes toReturn arraylist, array to keep track of in-degrees and a queue
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        int[] in_degrees = new int[nodes];
        Queue<Integer> q = new LinkedList<Integer>();
        //  iterate through array to count up in-degree of all nodes. takes 0(n^2)
        for (int i = 0; i < nodes; i++){
            for (int j = 0; j < nodes; j++){
                if (matrix[j][i] > 0){
                    in_degrees[i]++;
                }
            }
            //if the in-degree is 0, add it to queue first
            if (in_degrees[i] == 0){
                q.add(i);
            }
        }
        //while the queue is not empty
        while (q.peek() != null){
            //  dequeue, then find its neighbors
            int curr = q.remove();
            ArrayList<Integer> neighbors = neighbors(curr);
            for (int i : neighbors){
                //decrement its in-degree, then if it's 0, add it to the queue
                //all nodes are only added once because in degree has to be 1 at this point
                in_degrees[i]--;
                if (in_degrees[i] == 0){
                    q.add(i);
                }
            }
            toReturn.add(curr);

        }

        return toReturn;
    }

    //  tostring for testing
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