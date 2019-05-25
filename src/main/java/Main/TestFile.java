package Main;

import AbstractGraphColoring.GraphColoring;
import Exact_Algorithm.Backtracking;
import Exact_Algorithm.Linear_Programming;
import Graph.Graph;
import Heuristic_Algorithms.*;
import ReadFile.readFile;

import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\graph.txt";

        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename);
        ArrayList<GraphColoring> algorithms = new ArrayList<>();


//            algorithms.add(new Recursive_Largest_First_Algorithm(gr));
//            algorithms.add(new Depth_First_Search_Algorithm(gr));
        algorithms.add(new Breadth_First_Search_Algorithm(gr));
        algorithms.add(new Largest_First_Algorithm(gr));
        algorithms.add(new Backtracking(gr, 58));
        algorithms.add(new Depth_First_Search_Algorithm(gr));
//        algorithms.add(new Linear_Programming(gr));

        Context imp = new Context(algorithms);

        imp.execute();
    }
}
