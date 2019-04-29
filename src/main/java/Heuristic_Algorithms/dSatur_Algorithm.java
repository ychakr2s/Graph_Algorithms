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

    // This method calculate the Saturation degree of the wanted Vertex
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

    /*
     * This method execute an degree Saturation
     */
    @Override
    public void executeAlgorithm() {
        int count = 0;
        // Assign the first color to first vertex
        int v0 = graph.vertexHighstAdjDegree(graph.getVertices());
        colorVertex(v0, 0);
        calculateDsatur(v0);

        /*
         * Assign colors to remaining V-1 vertices If there is more than one take the
         * highest degree
         */

        while (count < V - 1) {
            int[] v = highestDsatur(this.dSatur);
            int cv = graph.vertexHighstAdjDegree(v);

            int cr = assignRightColor(graph, cv, resultColors, available);
            colorVertex(cv, cr); // Assign the found color
            calculateDsatur(cv);

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
            count++;
        }
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
