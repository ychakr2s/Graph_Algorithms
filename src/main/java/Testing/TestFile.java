package Testing;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Graph.Graph;
import Heuristic_Algorithms.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestFile {
    public static void main(String[] args) throws IOException {
//            String filename = "D:/ABschlussArbeit/IDE_Project/IntelliJ_Workspace/Graph_Algorithm_Implementation/src/main/java/Testing/facebook_combined.txt";

        Path path = Paths.get("D:/ABschlussArbeit/IDE_Project/IntelliJ_Workspace/Graph_Algorithm_Implementation/src/main/java/Testing/facebook_combined.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/CYassine/te2sFile2.txt"));

        String line = "";
        String data="" ;
        int a ;
        Graph gr = new Graph(4039);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            line = reader.readLine();

            while (line != null) {
                String[] splited = line.split("\\s+");
//                System.out.println(splited[0] + " "+splited[1]);
                gr.addEdge(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
//                out.write(splited[0] + " "+splited[1] + System.getProperty("line.separator"));
                if (splited[0].equals("e")) {
                    a = Integer.parseInt(splited[1]) + Integer.parseInt(splited[2]);
                    data = String.valueOf(a);
                    out.write(data + System.getProperty("line.separator"));
                }

                line = reader.readLine();
            }
            out.write(gr.toString() + System.getProperty("line.separator"));
            out.close();

            //System.out.println(data);
//            gr.print();
            Breadth_First_Search_Algorithm bfs = new Breadth_First_Search_Algorithm(gr);
            bfs.executeGraphAlgorithms();

            welsh_Powell_Algorithm wl = new welsh_Powell_Algorithm(gr);
            wl.executeGraphAlgorithms();

            GraphColoring ds = new dSatur_Algorithm(gr);
            ds.executeGraphAlgorithms();

            GraphColoring lf = new Largest_First_Algorithm(gr);
            lf.executeGraphAlgorithms();

            GraphColoring rlf = new Recursive_Largest_First_Algorithm(gr);
            rlf.executeGraphAlgorithms();

            GraphColoring gree = new Greedy_Algorithm(gr);
            gree.executeGraphAlgorithms();

            Depth_First_Search_Algorithm dfs = new Depth_First_Search_Algorithm(gr);
            dfs.executeGraphAlgorithms();

            GraphColoring bck = new Backtracking(gr,87);
            bck.executeGraphAlgorithms();


//            String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Implementation\\src\\main\\java\\Testing\\facebook_combined.txt";
//        String line ="";
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//            line = reader.readLine();
//            int vertex = 0;
//
//            while (line != null) {
//                for (int j = 0; j < line.length(); j++) {
//
////                    if (Character.isDigit(line.charAt(j))) {
////                        int color = Character.getNumericValue(line.charAt(j));
//////						sd.setColor(vertex, color);
//////						sd.setFixedColor(vertex);
////                        System.out.print(color);
////                    }
//                    System.out.print(line);
////                    System.out.println();
//
//                    vertex++;
//
//                }
//                line = reader.readLine();
//            }
//            System.out.println("+++++++++++++++++++++++++++++++ Backtrcking+++++++++++++++++++++++++++++++++++++");
//			BacktrackingForSudoku bck = new BacktrackingForSudoku(sd, 9);
//			bck.executeAlgorithm();
//			sd.printSudoku();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
