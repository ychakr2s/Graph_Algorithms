package Main;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Linear_Programming;
import Graph.Graph;
import Heuristic_Algorithms.*;

import java.util.ArrayList;

public class FactorySolution {
    FactorySolution() {
    }

    public ArrayList<GraphColoring> getAlgorithms(ArrayList<String> algorithms, Graph gr) {
        ArrayList<GraphColoring> algorithm = new ArrayList<>();
//        Graph gr = new Graph(2);
        for (int i = 0; i < algorithms.size(); i++) {
            if (algorithms.get(i) == "Greedy_Algorithm") {
                algorithm.add(new Greedy_Algorithm(gr));
            }
            if (algorithms.get(i) == "Depth_First_Search_Algorithm") {
                algorithm.add(new Depth_First_Search_Algorithm(gr));
            }
            if (algorithms.get(i) == "Recursive_Largest_First_Algorithm") {
                algorithm.add(new Recursive_Largest_First_Algorithm(gr));
            }
            if (algorithms.get(i) == "Largest_First_Algorithm") {
                algorithm.add(new Largest_First_Algorithm(gr));
            }
            if (algorithms.get(i) == "Breadth_First_Search_Algorithm") {
                algorithm.add(new Breadth_First_Search_Algorithm(gr));
            }
            if (algorithms.get(i) == "dSatur_Algorithm") {
                algorithm.add(new dSatur_Algorithm(gr));
            }
            if (algorithms.get(i) == "welsh_Powell_Algorithm") {
                algorithm.add(new welsh_Powell_Algorithm(gr));
            }
            if (algorithms.get(i) == "Linear_Programming") {
                algorithm.add(new Linear_Programming(gr));
            }
        }

        return algorithm;
    }
}
