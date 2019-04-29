package Heuristic_Algorithms;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.Arrays;

public class Largest_First_Algorithm extends GraphColoring {
    /*
     * Attributes
     */
    private Graph graph;
    private int V;
    private int[] resultColors;
    // This variable represent whether a color available for this Vertex or not
    private boolean[] available;

    /*
     * Constructor
     */
    public Largest_First_Algorithm(Graph g) {
        this.graph = g;
        this.V = graph.getNumVertices();

        this.resultColors = new int[V];
        Arrays.fill(resultColors, -1);

        this.available = new boolean[g.getNumVertices()];
        Arrays.fill(available, true);
    }

    // @SuppressWarnings("Duplicates")
    @Override
    public void executeAlgorithm() {
        int count = 1;
        // Assign the first color to first vertex
        int vertex0 = graph.vertexHighstAdjDegree(graph.getVertices());
        setColor(vertex0, 0, resultColors);
        // remove the colored Vertex from the Vertices Array
        int[] descend = remove(graph.getVertices(), vertex0);

        while (count < V) {
            int vertex = graph.vertexHighstAdjDegree(descend);
            int cr = assignRightColor(graph, vertex, resultColors, available);
            // Assign the found color to the Vertex
            setColor(vertex, cr, resultColors);
            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
            count++;
            descend = remove(descend, vertex);
        }
    }

    @Override
    public void description() {
        System.out.println("this is the implementation of the Largest First Algorithm ");
    }

    @Override
    public void printSolution() {
        description();
        printTest(resultColors, graph);
    }
}
