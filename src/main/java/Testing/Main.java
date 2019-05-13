package Testing;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Graph.Graph;
import Heuristic_Algorithms.*;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(12);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(0, 7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 7);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        g.print();

        GraphColoring rlf = new Recursive_Largest_First_Algorithm(g);
        rlf.executeGraphAlgorithms();

        GraphColoring dfs = new Depth_First_Search_Algorithm(g);
        dfs.executeGraphAlgorithms();

        GraphColoring brf = new Breadth_First_Search_Algorithm(g);
        brf.executeGraphAlgorithms();

        GraphColoring lf = new Largest_First_Algorithm(g);
        lf.executeGraphAlgorithms();

        GraphColoring gr = new Greedy_Algorithm(g);
        gr.executeGraphAlgorithms();

        GraphColoring wp = new welsh_Powell_Algorithm(g);
        wp.executeGraphAlgorithms();

        GraphColoring dS = new dSatur_Algorithm(g);
        dS.executeGraphAlgorithms();

        GraphColoring bk = new Backtracking(g,5);
        bk.executeGraphAlgorithms();
    }
}
