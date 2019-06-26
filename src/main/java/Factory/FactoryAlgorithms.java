package Factory;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Exact_Algorithm.Linear_Programming;
import Graph.Graph;
import Heuristic_Algorithms.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Factory generates objects of concrete class based on given information.
 */
public class FactoryAlgorithms {

    FactoryAlgorithms() {
    }

    public static ArrayList<GraphColoring> getAlgorithms(ArrayList<String> algorithms, Graph gr) {
        ArrayList<GraphColoring> algorithm = new ArrayList<>();

        for (int i = 0; i < algorithms.size(); i++) {
            if (algorithms.get(i).contains("Greedy")) {
                algorithm.add(new Greedy_Algorithm(gr));
            }
            if (algorithms.get(i).contains("Depth")) {
                algorithm.add(new Depth_First_Search_Algorithm(gr));
            }
            if (algorithms.get(i).contains("Recursive")) {
                algorithm.add(new Recursive_Largest_First_Algorithm(gr));
            }
            if (algorithms.get(i).contains("Largest")) {
                algorithm.add(new Largest_First_Algorithm(gr));
            }
            if (algorithms.get(i).contains("Breadth")) {
                algorithm.add(new Breadth_First_Search_Algorithm(gr));
            }
            if (algorithms.get(i).contains("dSatur")) {
                algorithm.add(new dSatur_Algorithm(gr));
            }
            if (algorithms.get(i).contains("welsh")) {
                algorithm.add(new welsh_Powell_Algorithm(gr));
            }
            if (algorithms.get(i).contains("Linear")) {
                algorithm.add(new Linear_Programming(gr));
            }
            if (algorithms.get(i).contains("Backtracking")) {
                System.out.println("geben Sie fuer Backtracking Problem Anzahl der m Farben ein: ");
                Scanner sc = new Scanner(System.in);
                int m = sc.nextInt();
                algorithm.add(new Backtracking(gr, m));
            }
        }
        return algorithm;
    }
}
