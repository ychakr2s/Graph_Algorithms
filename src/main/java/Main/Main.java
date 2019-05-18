package Main;

import AbstractGraphColoring.Algorithm;
import Exact_Algorithm.Linear_Programming;
import Graph.Graph;
import Heuristic_Algorithms.*;
//import Heuristic_Algorithms.welsh_Powell_Algorithm;
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

//        ArrayList<GraphColoring> algorithms = new ArrayList<>();
//        algorithms.add(new Greedy_Algorithm(g));

//        Solution sl = new Solution(g, algorithms);
//        sl.solve();
//
//        algorithms.add("Recursive_Largest_First_Algorithm");

        System.out.println();
//        ArrayList<String> algorithms = new ArrayList<>();
//
//        algorithms.add("Recursive_Largest_First_Algorithm");
//        algorithms.add("Depth_First_Search_Algorithm");
////        algorithms.add("Linear_Programming");
//        algorithms.add("dSatur_Algorithm");
//        algorithms.add("Largest_First_Algorithm");
//        FactoryAlgorithms fc = new FactoryAlgorithms();
//        Context imp = new Context(fc.getAlgorithms(algorithms, g));

        Greedy_Algorithm gre = new Greedy_Algorithm(g);
        welsh_Powell_Algorithm wl = new welsh_Powell_Algorithm(g);
        Largest_First_Algorithm lg = new Largest_First_Algorithm(g);
        dSatur_Algorithm ds = new dSatur_Algorithm(g);
        Recursive_Largest_First_Algorithm rlf = new Recursive_Largest_First_Algorithm(g);
        Depth_First_Search_Algorithm dfs = new Depth_First_Search_Algorithm(g);
        Breadth_First_Search_Algorithm bfs = new Breadth_First_Search_Algorithm(g);
        Linear_Programming lp = new Linear_Programming(g);

        ArrayList<Algorithm> alg = new ArrayList<>();
        alg.add(gre.executeGraphAlgorithm());
        alg.add(wl.executeGraphAlgorithm());
        alg.add(lg.executeGraphAlgorithm());
        alg.add(ds.executeGraphAlgorithm());
        alg.add(rlf.executeGraphAlgorithm());
        alg.add(dfs.executeGraphAlgorithm());
        alg.add(bfs.executeGraphAlgorithm());
        alg.add(lp.executeGraphAlgorithm());


//        Algorithm alg = gre.executeGraphAlgorithm();

        Solution sl = new Solution(g, alg);

        Gson gs = new Gson();
        String json = gs.toJson(sl);
        System.out.println(json);

//        imp.execute();

    }
}
