package Main;

import Exact_Algorithm.Linear_Programming;
import Graph.Graph;

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
//        Linear_Programming lp = new Linear_Programming(g);
//        lp.executeGraphAlgorithm();
//        lp.solve();

        ArrayList<String> algorithms = new ArrayList<>();

        algorithms.add("Recursive_Largest_First_Algorithm");
        algorithms.add("Depth_First_Search_Algorithm");
        algorithms.add("Linear_Programming");
        algorithms.add("dSatur_Algorithm");
        algorithms.add("Largest_First_Algorithm");
        FactorySolution fc = new FactorySolution();
        Context imp = new Context(fc.getAlgorithms(algorithms, g));

//        Gson gs = new Gson();
//        String json = gs.toJson(g);
//        System.out.println(json);

        imp.execute();

    }
}
