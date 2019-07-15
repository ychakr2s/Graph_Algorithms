package Main;

import Contex.Context;
import Create_Json.JsonOutput;
import Exact_Algorithm.Backtracking;
import Factory.FactoryAlgorithms;
import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Test_Dimacs_File {
    public static void main(String[] args) throws IOException {

        String fileName = "D:/ABschlussArbeit/IDE_Project/IntelliJ_Workspace/Graph_Algorithm_Second/src/main/java/Output_Files/th-4-miles750.json";
        try {
            if (Files.exists(Paths.get(fileName))) {
                Files.delete(Paths.get(fileName));
                Files.createFile(Paths.get(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\bechmarkSet\\4-FourthSet\\le450_5b.txt";

        readFile rd = new readFile();
        Graph gr = rd.dimacsToGraph(filename);

        ArrayList<String> algstr = new ArrayList<>();
//        algstr.add("Linear");

        algstr.add("Largest");

        algstr.add("Recursive");

        algstr.add("Greedy");
        algstr.add("dSatur");
        algstr.add("welsh");
        algstr.add("Depth");
        algstr.add("Breadth");

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));

        JsonOutput jso = new JsonOutput(gr, imp.execute());
        Gson gs = new Gson();
        String json = gs.toJson(jso);
        System.out.println(json);

        bw.write(json + System.getProperty("line.separator"));
        bw.close();
    }
}

