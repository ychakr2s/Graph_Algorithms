package Main;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Graph.Graph;
import Heuristic_Algorithms.*;

import java.util.ArrayList;

public class FactorySolution {
    Graph gr;

    FactorySolution(Graph graph) {
        gr = graph;
    }

    public ArrayList<GraphColoring> getAlgorithms(ArrayList<String> algorithms, Graph gr) {
        ArrayList<GraphColoring> algorithm = new ArrayList<>();
//        Graph gr = new Graph(2);
        for (int i = 0; i < algorithms.size(); i++) {
            if (algorithms.get(i) == "Greedy_Algorithm") {
                algorithm.add(i, new Greedy_Algorithm(gr));
            }
            if (algorithms.get(i) == "Depth_First_Search_Algorithm") {
                algorithm.add(i, new Depth_First_Search_Algorithm(gr));

            }
            if (algorithms.get(i) == "Recursive_Largest_First_Algorithm") {
                algorithm.add(i, new Recursive_Largest_First_Algorithm(gr));
            }
            if (algorithms.get(i) == "Largest_First_Algorithm") {
                algorithm.add(i, new Largest_First_Algorithm(gr));
            }
            if (algorithms.get(i) == "Breadth_First_Search_Algorithm") {
                algorithm.add(i, new Breadth_First_Search_Algorithm(gr));
            }
            if (algorithms.get(i) == "dSatur_Algorithm") {
                algorithm.add(i, new dSatur_Algorithm(gr));
            }
            if (algorithms.get(i) == "welsh_Powell_Algorithm") {
                algorithm.add(i, new welsh_Powell_Algorithm(gr));
            }
        }

        return algorithm;
    }
}
