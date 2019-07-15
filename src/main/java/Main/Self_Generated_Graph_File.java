package Main;

import Contex.Context;
import Create_Json.JsonOutput;
import Factory.FactoryAlgorithms;
import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Self_Generated_Graph_File {
    public static void main(String[] args) {

        String filename = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\self_Generated.txt";

        readFile rd = new readFile();
        Graph gr = rd.self_generated(filename);

        ArrayList<String> algstr = new ArrayList<>();
        algstr.add("Linear");
        algstr.add("Largest");
        algstr.add("Recursive");
        algstr.add("Greedy");
        algstr.add("dSatur");
        algstr.add("welsh");
        algstr.add("Depth");
        algstr.add("Breadth");

        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));

        JsonOutput jso = new JsonOutput(gr, imp.execute());
        Gson gs = new Gson();
        String json = gs.toJson(jso);
        System.out.println(json);
    }
}
