package Exact_Algorithm;

import Applications.Solve_Sudoku;
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
        String sudokuFile = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\sudoku1.txt";
        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename);

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
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));

            Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));

            JsonOutput jso = new JsonOutput(gr, imp.execute());
            Gson gs = new Gson();
            String json = gs.toJson(jso);

            bw.write(json + System.getProperty("line.separator"));

            bw.append("New Line!");
            bw.close();

            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
