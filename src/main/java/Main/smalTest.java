package Main;

import Contex.Context;
import Create_Json.JsonOutput;
import Factory.FactoryAlgorithms;
import Graph.Graph;
import ReadFile.readFile;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class smalTest {
    public static void main(String[] args) {
        String filename = "D:/ABschlussArbeit/IDE_Project/IntelliJ_Workspace/Graph_Algorithm_Second/src/main/java/Output_Files/miles750.json";
        try {
            if (Files.exists(Paths.get(filename))) {
                Files.delete(Paths.get(filename));
                Files.createFile(Paths.get(filename));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Stream<Path> filePathStream = Files.walk(Paths.get("D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\bechmarkSet\\4-FourthSet"))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {

                    readFile rd = new readFile();
                    Graph gr = rd.readGraph(String.valueOf(filePath));
                    ArrayList<String> algstr = new ArrayList<>();
//                    algstr.add("Backtracking");
                    algstr.add("Depth");
                    algstr.add("Breadth");
                    algstr.add("dSatur");
                    algstr.add("Greedy");
                    algstr.add("Largest");
                    algstr.add("Recursive");
                    algstr.add("welsh");
//                    algstr.add("Linear");

                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
                        Context imp = new Context(FactoryAlgorithms.getAlgorithms(algstr, gr));

                        JsonOutput jso = new JsonOutput(gr, imp.execute());
                        Gson gs = new Gson();
                        String json = gs.toJson(jso);

                        bw.write(json + System.getProperty("line.separator"));
                        bw.close();

                        System.out.println(json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
