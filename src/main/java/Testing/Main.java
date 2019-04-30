package Testing;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;
import Heuristic_Algorithms.Largest_First_Algorithm;
import Heuristic_Algorithms.dSatur_Algorithm;
import Heuristic_Algorithms.welsh_Powell_Algorithm;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(8);
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

        GraphColoring lf = new Largest_First_Algorithm(g);
        lf.executeAlgorithm();

        GraphColoring wp = new welsh_Powell_Algorithm(g);
        wp.executeAlgorithm();

        GraphColoring dS = new dSatur_Algorithm(g);
        dS.executeAlgorithm();
    }
}
