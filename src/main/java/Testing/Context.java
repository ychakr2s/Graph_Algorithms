package Testing;

import AbstractGraphColoring.GraphColoring;

import java.util.ArrayList;

class Contex {
    private ArrayList<GraphColoring> algorithms;

    public Contex(ArrayList<GraphColoring> algorithms) {
        this.algorithms = algorithms;
    }

    void execute() {
        //delegates behavior to Strategy object
        for (GraphColoring algorithm : algorithms) {
            algorithm.executeGraphAlgorithm();
        }
    }

}
