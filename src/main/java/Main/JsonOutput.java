package Main;

import AbstractGraphColoring.Algorithm;
import Graph.Graph;

import java.util.ArrayList;

public class JsonOutput {
    private Graph Graph;
    private ArrayList<Algorithm> algorithms;

    public JsonOutput(Graph gr, ArrayList<Algorithm> algorithms) {
        this.Graph = gr;
        this.algorithms = algorithms;
    }
}
