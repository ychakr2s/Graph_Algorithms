package Exact_Algorithm;

import Graph.Graph;
import Main.Context;
import Main.FactoryAlgorithms;
import Main.JsonOutput;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class kleinTest {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\johnson8-2-4.clq";

        // Output of the Program
        String outputFile = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Output_Files\\output.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename);
//        Linear_Programming backtrack = new Linear_Programming(gr);

        ArrayList<String> algstr = new ArrayList<>();
        algstr.add("Breadth");
        algstr.add("Depth");
        algstr.add("Greedy");
        algstr.add("welsh");
        algstr.add("dSatur");
        algstr.add("Largest");
        algstr.add("Recursive");
        algstr.add("Linear_Programming");
        algstr.add("Backtracking");




        try {
            Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));

            JsonOutput jso = new JsonOutput(gr, imp.execute());
            Gson gs = new Gson();
            String json = gs.toJson(jso);

            bw.write(json + System.getProperty("line.separator"));

            bw.close();

            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }


//        System.out.println("Inter nodes");
//        Scanner sc = new Scanner(System.in);
//        int count =0;
//        while (count<10) {
//            int nodes = sc.nextInt();
//
//            Graph g = new Graph(nodes);
//            Random rn = new Random();
//
//            for (int i = 0; i < nodes; i++) {
//                g.addEdge(rn.nextInt(nodes), rn.nextInt(nodes));
//            }
////			g.printGraph(g);
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//
//            Linear_Programming l= new Linear_Programming(g);
//            l.executeGraphAlgorithm();
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
////			reserve lp = new reserve();
////			lp.solve(g);
//            count++;
//        }
    }
}
