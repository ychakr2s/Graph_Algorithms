package ReadFile;

import Applications.Solve_Sudoku;
import Graph.Graph;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class readFile {

    public int edges;

    public readFile() {
    }

    /*
     * This method read a File and produce a Graph.
     */
    public Graph readGraph(String filename) {

        Path path = Paths.get(filename);
        Graph gr = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            String line = reader.readLine();
            while (line != null) {
                String[] splited = line.split("\\s+");
                if (splited[0].equals("p")) {
                    gr = new Graph(Integer.parseInt(splited[2]));
                    gr.setEdge(Integer.parseInt(splited[3]));
                }

                if (splited[0].equals("e")) {
                    assert gr != null;
                    gr.addEdge(Integer.parseInt(splited[1]) - 1, Integer.parseInt(splited[2]) - 1);
                }

                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gr;
    }

    /*
     * this method get a Json file and parse it to Java. It is parsed to Graph.
     */
    public Graph jsonToGraph(String filename) {

        Gson gson = new Gson();
        Graph gr = new Graph(0);

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(filename));

            //convert the json string back to object
            Graph graph = gson.fromJson(br, Graph.class);

            gr = new Graph(graph.getNumVertices());

            for (int i = 0; i < graph.getNumVertices(); i++) {
                Iterator itr = graph.getEdges(i).iterator();
                while (itr.hasNext()) {

                    double a = (double) itr.next();
                    int c = (int) a;
                    gr.addEdge(i, c);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gr;
    }

    /*
     * This method read a Sudoku File and produce from him a Sudoku File.
     */
    public Solve_Sudoku readGraphSudoku(String filename) {

        Path path = Paths.get(filename);
        Solve_Sudoku sd = new Solve_Sudoku();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            String line = reader.readLine();
            int vertex = 0;

            while (line != null) {
                for (int j = 0; j < line.length(); j++) {

                    if (Character.isDigit(line.charAt(j))) {
                        int color = Character.getNumericValue(line.charAt(j));
                        sd.setColor(vertex, color);
                        sd.setFixedColor(vertex);
                    }
                    vertex++;

                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sd;
    }
}
