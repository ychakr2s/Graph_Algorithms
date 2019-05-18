package Main;

import AbstractGraphColoring.Algorithm;
import Graph.Graph;

import java.util.ArrayList;

public class Solution {
    private Graph Graph;
    private ArrayList<Algorithm> algorithms;

    Solution(Graph gr, ArrayList<Algorithm> algorithms) {
        this.Graph = gr;
        this.algorithms = algorithms;
    }

    public void solve() {
        //algorithms.get(0).executeGraphAlgorithm();
    }
}
