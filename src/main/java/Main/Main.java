package Main;

import Exact_Algorithm.Linear_Programming;
import Graph.Graph;

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
        Linear_Programming lp = new Linear_Programming(g);
//        lp.executeGraphAlgorithm();
//        lp.solve();


//        ArrayList<GraphColoring> algorithms = new ArrayList<>();
//
//
//        algorithms.add(new Recursive_Largest_First_Algorithm(g));
//        algorithms.add(new Depth_First_Search_Algorithm(g));
//        algorithms.add(new Breadth_First_Search_Algorithm(g));
//        algorithms.add(new Largest_First_Algorithm(g));
//        algorithms.add(new Backtracking(g, 5));
//        Context imp = new Context(algorithms);

//        Gson gs = new Gson();
//        String json = gs.toJson(g);
//        System.out.println(json);

//        imp.execute();

    }
}
