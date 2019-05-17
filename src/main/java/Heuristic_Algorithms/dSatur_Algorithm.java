package Heuristic_Algorithms;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class dSatur_Algorithm extends GraphColoring {
    private Graph graph;
    private int[] dSatur;
    private int V;
    private boolean[] alreadyColored;
    private boolean[] available;
    private int[] resultColors;

    /*
     * Constructor
     */
    public dSatur_Algorithm(Graph g) {
        this.graph = g;
        this.V = graph.getNumVertices();
        this.dSatur = new int[V];
        this.resultColors = new int[V];
        Arrays.fill(resultColors, -1);

        this.alreadyColored = new boolean[V];
        Arrays.fill(alreadyColored, false);

        this.available = new boolean[V];
        Arrays.fill(available, true);
    }

    /*
     *This method calculate for the uncolored vertex the degree of the adjacency vertices which are colored with different colors.
     */
    private void calculateDsatur(int v) {
        graph.getEdges(v).stream().forEach((i) -> {
            if (!alreadyColored[i]) {
                dSatur[i]++;
            }

        });
    }

    private int[] highestDsatur(int[] arr) {
        ArrayList<Integer> theReturns = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                if (arr[i] > max) {
                    theReturns.removeAll(theReturns);
                }
                max = arr[i];
                theReturns.add(i);
            }
        }
        // Convert ArrayList to Array
        return theReturns.stream().mapToInt(i -> i).toArray();
    }

    private void colorVertex(int vertex, int c) {
        setColor(vertex, c, resultColors);
        dSatur[vertex] = -1;
        alreadyColored[vertex] = true;
    }

    @Override
    public void executeGraphAlgorithm() {
        int count = 0;
        /*
         * The uncolored vertex that has the largest degree in the degree set 𝐷𝑒𝑔(𝑣𝑖) is selected for coloring.
         * The selected vertex is colored with first color.
         */
        int v0 = graph.vertexHighstAdjDegree(graph.getVertices());
        colorVertex(v0, 0);
        // calculate the number adjacent vertices which are colored with different colors for every uncolored vertex.
        calculateDsatur(v0);

        while (count < V - 1) {
            /*
             * the uncolored vertex whose number of adjacent vertices colored with different colors is the maximum is selected for coloring.
             * If more than one vertex provide this condition, the vertex which has the largest degree among them is selected.
             */
            int[] v = highestDsatur(this.dSatur);
            int vertex = graph.vertexHighstAdjDegree(v);
            // Find the appropriate color for this vertex
            int cr = findRightColor(graph, vertex, resultColors, available);
            colorVertex(vertex, cr); // Assign the found color
            calculateDsatur(vertex);

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
            count++;
        }
        printSolution();
    }

    @Override
    public void description() {
        System.out.println("this is the implementation of the Saturation Degree Algorithm ");
    }

    @Override
    public void printSolution() {
        description();
        printTest(resultColors, graph);
    }
}
