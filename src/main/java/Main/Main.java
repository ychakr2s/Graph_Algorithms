package Main;

import Contex.Context;
import Exact_Algorithm.Linear_Programming;
import Factory.FactoryAlgorithms;
import Graph.Graph;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
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

//         i miss here Factory for Algorithms
        ArrayList<String> arl = new ArrayList<>();
        Gson gs = new Gson();

        arl.add("Greedy");
        arl.add("Breadth");

        Context ct = new Context(FactoryAlgorithms.getAlgorithms(arl, g));
        ct.execute();
        Linear_Programming lp = new Linear_Programming(g);
        lp.executeGraphAlgorithm();

//        LP_Test lt = new LP_Test(g);
//        lt.executeGraphAlgorithm();

//        JsonOutput sl = new JsonOutput(g, ct.execute());
//        System.out.println("++++++++++++++++++++++++ Context +++++++++++++++++++++++++++++++");
//
//        Gson gs = new Gson();
//        String json = gs.toJson(sl);
//        System.out.println(json);
//
//        String filename = "D:/ABschlussArbeit/IDE_Project/IntelliJ_Workspace/Graph_Algorithm_Second/src/main/java/Output_Files/fileOut.json";
//        File file = new File(filename);
//
//        FileWriter writer = new FileWriter(file);
//        writer.write(json);
//        writer.close();
    }
}
