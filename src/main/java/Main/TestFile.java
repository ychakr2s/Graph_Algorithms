package Main;

import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\dataJson.json";
//

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        readFile rd = new readFile();
        Graph gr = rd.jsonToGraph(filename);

        ArrayList<String> algstr = new ArrayList<>();
        algstr.add("Breadth");
        algstr.add("Depth");
        algstr.add("Greedy");
//        algstr.add("welsh");
//        algstr.add("dSatur");
//        algstr.add("Largest");
//        algstr.add("Recursive");
//        algstr.add("Linear_Programming");
//        algstr.add("Backtracking");
//
        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));
//
        JsonOutput jso = new JsonOutput(gr, imp.execute());
        Gson gs = new Gson();
//        String json = gs.toJson(jso);
//
        System.out.println(gs.toJson(jso));

    }
}
