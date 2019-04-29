package Heuristic_Algorithms;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.Arrays;
import java.util.Iterator;

public class Greedy_Algorithm extends GraphColoring {
    private Graph graph;
    private int V;
    private int resultColors[];
    private boolean available[];

    public Greedy_Algorithm(Graph graph) {
        this.graph = graph;
        this.V = graph.getNumVertices();
        this.resultColors = new int[V];
        Arrays.fill(resultColors, -1);

        /*
         * A temporary array to store the available colors. False value of available[cr]
         * would mean that the color cr is assigned to one of its adjacent vertices.
         * Initially, all colors are available
         */
        this.available = new boolean[V];
        Arrays.fill(available, true);

    }

	@Override
    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors

    public void executeAlgorithm() {

        // Assign the first color to first vertex
        setColor(0, 0, resultColors);

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {
            // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> it = graph.getEdges(u).iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (getColor(i, resultColors) != -1)
                    available[getColor(i, resultColors)] = false;
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            setColor(u, cr, resultColors); // Assign the found color

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }
    }

    public void description() {

    }

    public void printTest() {

    }

}
