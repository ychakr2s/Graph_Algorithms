package Main;

//import Exact_Algorithm.LP_Test;

import Contex.Context;
import Create_Json.JsonOutput;
import Exact_Algorithm.Linear_Programming;
import Factory.FactoryAlgorithms;
import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename1 = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\bechmarkSet\\1-FirstSet\\anna.txt";
        String filename2 = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\bechmarkSet\\1-FirstSet\\david.txt";

        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename1);
        Graph gr2 = rd.readGraph(filename2);

        ArrayList<String> algstr = new ArrayList<>();
        algstr.add("Breadth");
        algstr.add("Depth");
        algstr.add("dSatur");
        algstr.add("Greedy");
        algstr.add("Largest");
        algstr.add("Recursive");
        algstr.add("welsh");

        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));
        Context imp1 = new Context(FactoryAlgorithms.getAlgorithms(algstr,gr2));

        JsonOutput jso = new JsonOutput(gr, imp.execute());
        JsonOutput jso1 = new JsonOutput(gr2, imp1.execute());

        Gson gs = new Gson();
        String json = gs.toJson(jso);
        String json1 = gs.toJson(jso1);

        System.out.println(json + "\n"+ json1);


    }
}
