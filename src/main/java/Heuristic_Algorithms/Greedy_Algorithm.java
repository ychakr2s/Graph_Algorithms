package Heuristic_Algorithms;

import AbstractGraphColoring.Algorithm;
import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.Arrays;

public class Greedy_Algorithm extends GraphColoring {
    //    private Graph graph;
    //    private int V;
    private int[] resultColors;

    /*
     * Constructor
     */
    public Greedy_Algorithm(Graph graph) {
        super(graph);
//        this.graph = graph;
//        this.V = ;
        this.resultColors = new int[V];
        Arrays.fill(resultColors, -1);


    }

    @Override
    public Algorithm executeGraphAlgorithm() {
        // Assign the first color to first vertex
        setColor(0, 0, resultColors);

        // Assign colors to remaining V-1 vertices
        for (int vertex = 1; vertex < V; vertex++) {
            /*
             * Process all adjacent vertices and flag their colors as unavailable.
             * A temporary array to store the available colors. False value of available[cr]
             * would mean that the color cr is assigned to one of its adjacent vertices.
             * Initially, all colors are available
             */
            boolean[] available = new boolean[V];
            Arrays.fill(available, true);


            int cr = findRightColor(graph, vertex, resultColors, available);
            setColor(vertex, cr, resultColors); // Assign the found color

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }
        printSolution();
        return new Algorithm(computeResultsColors(resultColors), resultColors,"Greedy Algorithm");
    }

    @Override
    public void description() {
        System.out.println("This is the Implementation of the Greedy Algorithm");
    }

    @Override
    public void printSolution() {
        description();
        printTest(resultColors, graph);
    }

}
