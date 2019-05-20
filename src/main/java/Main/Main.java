package Main;

import Graph.Graph;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
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
        arl.add("Greedy");
        arl.add("Breadth");
        arl.add("Depth");
        arl.add("largest");
        arl.add("welsh-powel");
        arl.add("Recursive");
        arl.add("Linear programming");
        arl.add("Backtracking");
        arl.add("dSatur");

        Context ct = new Context(FactoryAlgorithms.getAlgorithms(arl, g));
        System.out.println("++++++++++++++++++++++++ Context ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Gson gs = new Gson();
        String json = gs.toJson(ct.execute());
        System.out.println(json);

        String filename = "D:/ABschlussArbeit/IDE_Project/IntelliJ_Workspace/Graph_Algorithm_Second/src/main/java/Output_Files/fileOut.txt";
        File file = new File(filename);

        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();

    }
}
