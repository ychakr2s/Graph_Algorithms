package Exact_Algorithm;

import Graph.Graph;
import Heuristic_Algorithms.Breadth_First_Search_Algorithm;
import Heuristic_Algorithms.Greedy_Algorithm;
import com.google.gson.Gson;
//import Heuristic_Algorithms.Depth_First_Search_Algorithm;
//import Heuristic_Algorithms.Greedy_Algorithm;
//import Heuristic_Algorithms.dSatur_Algorithm;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class kleinTest {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\johnson8-2-4.clq";

        Path path = Paths.get(filename);
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/CYassine/te2sFile2.txt"));


        Graph gr = new Graph(29);

        try {
            String line = "";
            String data = "";
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            line = reader.readLine();

            while (line != null) {
                String[] splited = line.split("\\s+");

                if (splited[0].equals("e")) {
                    gr.addEdge(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
//                    bw.write(data + System.getProperty("line.separator"));
                }
                line = reader.readLine();
            }
            bw.close();
//            Greedy_Algorithm gee = new Greedy_Algorithm(gr);
//            gee.executeGraphAlgorithm();

            Linear_Programming backtrack = new Linear_Programming(gr);
            backtrack.executeGraphAlgorithm();

            Gson gs = new Gson();
            String json = gs.toJson( backtrack.executeGraphAlgorithm());
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
