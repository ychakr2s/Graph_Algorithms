package Main;

import Exact_Algorithm.LP_Test;
import Exact_Algorithm.Linear_Programming;
import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\bechmarkSet\\1-FirstSet\\david.txt";
//

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        readFile rd = new readFile();
        Graph gr = rd.readGraph(filename);
        LP_Test lp = new LP_Test(gr);
        lp.executeGraphAlgorithm();
        Linear_Programming lpp = new Linear_Programming(gr);
        lpp.executeGraphAlgorithm();
        ArrayList<String> algstr = new ArrayList<>();
//        algstr.add("Breadth");
        algstr.add("Depth");
        algstr.add("Greedy");
        algstr.add("welsh");
////        algstr.add("dSatur");
//        algstr.add("Largest");
////        algstr.add("Recursive");
//        algstr.add("Linear_Programming");
//        algstr.add("Backtracking");
//
//
//        JsonOutput jso = new JsonOutput(gr, imp.execute());
//        Gson gs = new Gson();
//        String json = gs.toJson(jso);
//
//        System.out.println(gs.toJson(jso));

        Instant start = Instant.now();

        //Measure execution time for this method
        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));
        imp.execute();

        Instant finish = Instant.now();

//        long timeElapsed = Duration.between(start, finish);  //in millis
        System.out.println("Time: "+Duration.between(start, finish).toMillis());

    }
}
