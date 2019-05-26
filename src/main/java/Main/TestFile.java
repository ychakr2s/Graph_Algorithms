package Main;

import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\hamming6-4.clq";

        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename);
        ArrayList<String> algstr = new ArrayList<>();
        algstr.add("Greedy");
        algstr.add("dSatur");
        algstr.add("Largest");
        algstr.add("Recursive");


        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));
        JsonOutput jso = new JsonOutput(gr, imp.execute());
        Gson gs = new Gson();
        System.out.println(gs.toJson(jso));

    }
}
