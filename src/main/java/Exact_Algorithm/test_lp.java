package Exact_Algorithm;

import Graph.Graph;
import Heuristic_Algorithms.Greedy_Algorithm;
import Main.Context;
import Main.FactoryAlgorithms;
import Main.JsonOutput;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.util.ArrayList;

public class test_lp {
    public static void main(String[] args) {

        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\bechmarkSet\\2-SecondSet\\queen11_11.txt";

        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename);

        LP_Test lpt = new LP_Test(gr);
        Greedy_Algorithm gg= new Greedy_Algorithm(gr);
//
//        lpt.executeGraphAlgorithm();

//        gg.executeGraphAlgorithm();
        ArrayList<String> algstr = new ArrayList<>();
        algstr.add("Backtracking");
        algstr.add("Greedy");
        algstr.add("dSatur");
        algstr.add("welsh");
        algstr.add("Linear");


        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));

        JsonOutput jso = new JsonOutput(gr, imp.execute());
        Gson gs = new Gson();
        String json = gs.toJson(jso);
        System.out.println(json);
    }
}
