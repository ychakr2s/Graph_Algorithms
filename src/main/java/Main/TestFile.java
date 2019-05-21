package Main;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Exact_Algorithm.Linear_Programming;
import Graph.Graph;
import Heuristic_Algorithms.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\graph.txt";

        Path path = Paths.get(filename);
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/CYassine/te2sFile2.txt"));

        String line = "";
        String data = "";
        int a;
        Graph gr = new Graph(251);
        String toJjson = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            line = reader.readLine();

            while (line != null) {
                String[] splited = line.split("\\s+");
////                System.out.println(splited[0] + " "+splited[1]);
//                toJjson = splited[0] + " " + splited[1] + "\n";
//                gr.addEdge(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
//                out.write(splited[0] + " "+splited[1] + System.getProperty("line.separator"));
                if (splited[0].equals("e")) {
                    gr.addEdge(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
                    a = Integer.parseInt(splited[1]) + Integer.parseInt(splited[2]);
//                    data = String.valueOf(a);
                    out.write(data + System.getProperty("line.separator"));
                }

                line = reader.readLine();
            }
            out.close();
            ArrayList<GraphColoring> algorithms = new ArrayList<>();


//            algorithms.add(new Recursive_Largest_First_Algorithm(gr));
//            algorithms.add(new Depth_First_Search_Algorithm(gr));
//            algorithms.add(new Breadth_First_Search_Algorithm(gr));
//            algorithms.add(new Largest_First_Algorithm(gr));
            algorithms.add(new Backtracking(gr, 58));
            algorithms.add(new Depth_First_Search_Algorithm(gr));
            algorithms.add(new Linear_Programming(gr));

            Context imp = new Context(algorithms);

            imp.execute();

//            Gson gs = new Gson();
//            String json = gs.toJson(gr);
//            System.out.println(json);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
