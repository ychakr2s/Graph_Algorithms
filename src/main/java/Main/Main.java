package Main;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Graph.Graph;
import Heuristic_Algorithms.*;
import com.google.gson.Gson;

import java.util.ArrayList;

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

//        g.print();

//        ArrayList<GraphColoring> algorithms = new ArrayList<>();
        ArrayList<String> algorithm = new ArrayList<>();
        algorithm.add("Greedy_Algorithm");
//        Greedy_Algorithm ge = new Greedy_Algorithm(g);
//        ge.executeGraphAlgorithm();

//
        Solution sl = new Solution(g, algorithm);
        System.out.println(sl.solve());
//        FactorySolution fc = new FactorySolution(g);
//
//
//
////        algorithms.add(new Recursive_Largest_First_Algorithm(g));
////        algorithms.add(new Depth_First_Search_Algorithm(g));
////        algorithms.add(new Breadth_First_Search_Algorithm(g));
////        algorithms.add(new Largest_First_Algorithm(g));
////        algorithms.add(new Backtracking(g, 5));
//
//        algorithm.add("Recursive_Largest_First_Algorithm");
//        algorithm.add("Depth_First_Search_Algorithm");
//        algorithm.add("Breadth_First_Search_Algorithm");
//        algorithm.add("Largest_First_Algorithm");
////        algorithm.add(new Backtracking(g, 5));
//
//        Context imp = new Context(fc.getAlgorithms(algorithm));
//
        Gson gs = new Gson();
//        Solution m = new Solution();
        String json = gs.toJson(sl);
        System.out.println(json);
//
//        imp.execute();


//        GraphColoring rlf = new Recursive_Largest_First_Algorithm(g);
//        rlf.executeGraphAlgorithm();
//
//        GraphColoring dfs = new Depth_First_Search_Algorithm(g);
//        dfs.executeGraphAlgorithm();
//
//        GraphColoring brf = new Breadth_First_Search_Algorithm(g);
//        brf.executeGraphAlgorithm();
//
//        GraphColoring lf = new Largest_First_Algorithm(g);
//        lf.executeGraphAlgorithm();
//
//        GraphColoring gr = new Greedy_Algorithm(g);
//        gr.executeGraphAlgorithm();
//
//        GraphColoring wp = new welsh_Powell_Algorithm(g);
//        wp.executeGraphAlgorithm();
//
//        GraphColoring dS = new dSatur_Algorithm(g);
//        dS.executeGraphAlgorithm();
//
//        GraphColoring bk = new Backtracking(g,5);
//        bk.executeGraphAlgorithm();
    }
}
