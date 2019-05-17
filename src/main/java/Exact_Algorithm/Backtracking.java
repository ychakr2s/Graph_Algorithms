package Exact_Algorithm;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.Arrays;

public class Backtracking extends GraphColoring {
    private Graph graph;
    private int V;
    private int m;
    private int[] resultColor;

    public Backtracking(Graph g, int m) {
        this.graph = g;
        this.V = graph.getNumVertices();
        this.m = m;
        this.resultColor = new int[V];
        Arrays.fill(resultColor, -1);
    }

    /*
     * A utility function to check if the current color assignment is safe for
     * vertex v
     */
    private boolean isSafe(int v, int c) {
        for (int edge : graph.getEdges(v)) {
            if (getColor(edge, resultColor) == c)
                return false;
        }
        return true;
    }

    /*
     * A recursive utility function to solve m coloring problem
     */
    private boolean graphColoringUtil(int v) {
        /*
         * base case: If all vertices are assigned a color then return true
         */
        if (v == V)
            return true;

        /*
         * Consider this vertex v and try different colors
         */
        for (int c = 0; c < m; c++) {
            /*
             * Check if assignment of color c to v is fine
             */
            if (isSafe(v, c)) {
                setColor(v, c, resultColor);
                /*
                 * recur to assign colors to rest of the vertices
                 */
                if (graphColoringUtil(v + 1))
                    return true;
            }
        }

        /*
         * If no color can be assigned to this vertex then return false
         */
        return false;
    }

    /*
     * This function solves the m Coloring problem using Backtracking. It mainly
     * uses graphColoringUtil() to solve the problem. It returns false if the m
     * colors cannot be assigned, otherwise return true and prints the Solution.
     */
    @Override
    public void executeGraphAlgorithm() {
        if (graphColoringUtil(0)) {
            printSolution();
        } else
            System.out.println("the Solution does not exists");
    }

    @Override
    public void description() {
        System.out.println("This is the implementation of the Backtracking algorithm \n" +
                "The Solution exists: +++++++++++++");
    }

    @Override
    public void printSolution() {
        description();
        printTest(resultColor, graph);
    }
}
