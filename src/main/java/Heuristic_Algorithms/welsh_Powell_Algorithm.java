package Heuristic_Algorithms;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class welsh_Powell_Algorithm extends GraphColoring {

    private Graph graph;
    // No. of vertices
    private int V;
    private int[] vertices;
    private int resultColors[];
    // This variable represent whether a color available for this Vertex or not
    private boolean[] available;

    public welsh_Powell_Algorithm(Graph g) {
        this.graph = g;
        this.V = graph.getNumVertices();
        this.vertices = graph.getVertices();
        this.resultColors = new int[V];
        Arrays.fill(resultColors, -1);
        this.available = new boolean[V];
        Arrays.fill(available, true);
    }

    /*
     * This Method sorted the the Vertices descending according to the Vertex degree
     */
    public int[] sortDesc(int[] a) {
        int[] ret = new int[V];
        for (int i = 0; i < V; i++) {
            ret[i] = graph.vertexHighstAdjDegree(a);
            int b[] = remove(a, ret[i]);
            a = b;
        }
        return ret;
    }

    // remove an element from Array
    public int[] remove(int arr[], int v) {
        int ret[] = new int[arr.length - 1];
        if (arr.length > 1) {
            int cout = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == v) {
                } else {
                    ret[cout] = arr[i];
                    cout++;
                }
            }
            return ret;
        } else
            return ret;

    }

    /*
     *  this method checks whether the passed vertex is adjacency to already colored vertices.
     */
    public boolean AdjToAlreadyColored(ArrayList<Integer> y, int ver) {
        for (int i = 0; i < y.size(); i++) {
            if (graph.isEdges(y.get(i), ver)) {
                return true;
            }
        }
        return false;
    }

    /*
     * this method removes the ALREADY COLORED VERTICES from the sorted array
     */
    public int[] removeColored(ArrayList<Integer> alreadyColor, int[] sortedArray) {
        int b[] = sortedArray;
        for (int i = 0; i < alreadyColor.size(); i++) {
            b = remove(b, alreadyColor.get(i));
        }
        return b;
    }

    @Override
    public void executeAlgorithm() {

        // List the vertices in order of descending valence i.e.valence degree(v(i)) >= degree(v(i+1)) .
        int verts[] = sortDesc(vertices);
        // Colour the first vertex in the list.
        int color = 0;
        ArrayList<Integer> alreadyColored = new ArrayList<Integer>();

        while (V > 0) {

            for (int v : verts) {
                /*
                 * Go down the sorted list and color every vertex not connected to the colored vertices above the same color
                 */
                if (!AdjToAlreadyColored(alreadyColored, v)) {
                    setColor(v, color, resultColors);
                    alreadyColored.add(v);
                    V--;
                }
            }
            // cross out all colored vertices in the list.
            verts = removeColored(alreadyColored, verts);
            alreadyColored.clear();

            /*
             * Repeat the process on the uncolored vertices with a new color-always until
             * all in descending order of degree until all vertices are colored.
             */
            color++;
        }
        printTest(resultColors, graph);
    }

    @Override
    public void description() {
        System.out.println("this is the implementation of the Welsh-Powell Algorithm ");
    }

    @Override
    public void printTest() {
        description();
        System.out.println(toString(resultColors));
        if (test(resultColors, graph))
            System.out.println("+++++++++++++++++++ the Algorithms runs correctly +++++++++++++++++++++");
        else
            System.out.println("+++++++++++++++++++ the Algorithms runs wrongly +++++++++++++++++++++++");
    }
}
