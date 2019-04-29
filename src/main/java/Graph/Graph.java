package Graph;

import java.util.HashSet;
import java.util.Iterator;

public class Graph {

    // No. of vertices
    private int V;
    // Adjacency List
    private HashSet<Integer>[] adj;
    private int[] vertices;

    /*
     * Constructor
     */
    public Graph(int v) {
        this.V = v;
        this.adj = new HashSet[V];

        for (int i = 0; i < V; ++i)
            adj[i] = new HashSet<Integer>();

        this.vertices = new int[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = i;
        }
    }

    /*
     * The first method returns the vertices of this Graph.
     * the second method returns the number of the vertices.
     * the third returns the edges of each vertex
     */
    public int[] getVertices() {
        return this.vertices;
    }

    public int getNumVertices() {
        return this.V;
    }

    public HashSet<Integer> getEdges(int v) {
        return this.adj[v];
    }

    /*
     * This Method adds Edges between two Vertices
     */
    public void addEdge(int from, int to) {
        if (to > getNumVertices() || from > getNumVertices())
            System.out.println("The vertices does not exists");
        else {
            if (from == to) {
            } else {
                getEdges(from).add(to);
                getEdges(to).add(from);
            }
        }
    }

    /*
     * This method checks whether there is an Edge between two vertices
     */
    public boolean isEdges(int v1, int v2) {
        Iterator<Integer> it = getEdges(v1).iterator();
        while (it.hasNext()) {
            int v = it.next();
            if (v == v2)
                return true;
        }
        return false;
    }

    /*
     * This method returns the Degree of the intended Vertex
     */
    public int getVertexDegree(int v) {
        return getEdges(v).size();
    }

    /*
     * This method returns the Vertex with the highest adjacency degree
     */
    public int vertexHighstAdjDegree(int[] ver) {
        int max = 0;
        int vertex = 0;
        int count = 0;
        if (ver.length > 1) {
            for (int i = 0; i < ver.length; i++) {
                if (getVertexDegree(ver[i]) > max) {
                    max = getVertexDegree(ver[i]);
                    vertex = ver[i];
                }

                if (getVertexDegree(ver[i]) == 0 && getVertexDegree(i) == max && count == 0) {
                    vertex = ver[i];
                    count++;
                }
                if (getVertexDegree(ver[i]) == 0) {
                    vertex = ver[i];
                }
            }
        } else {
            vertex = ver[0];
        }
        return vertex;
    }

    /*
     * ----------------------- print methods ------------------------------
     */
    public String toString() {
        String string = "";
        for (int v = 0; v < V; v++) {
            string += " Adjacency list of vertex " + v + " Edges of Vertex: " + v + ":  " + v;

            for (Integer pCrawl : getEdges(v)) {

                string += " -> " + pCrawl;
            }
            string += "\n";
        }
        return string;
    }

    public void print() {
        System.out.println(toString());
    }
}