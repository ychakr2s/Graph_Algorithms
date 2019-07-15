package Main;

import Contex.Context;
import Create_Json.JsonOutput;
import Exact_Algorithm.Linear_Programming;
import Factory.FactoryAlgorithms;
import Graph.Graph;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class Per_Hand_generated_Graph {
    public static void main(String[] args) throws IOException {
        Graph g = new Graph(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 7);

        ArrayList<String> arl = new ArrayList<>();
        arl.add("Greedy");
        arl.add("Breadth");
        Gson gs = new Gson();

        Context ct = new Context(FactoryAlgorithms.getAlgorithms(arl, g));
        JsonOutput jso = new JsonOutput(g, ct.execute());

        String json = gs.toJson(jso);
        System.out.println(json);

    }
}
