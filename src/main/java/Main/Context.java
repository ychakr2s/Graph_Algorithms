package Main;

import AbstractGraphColoring.GraphColoring;

import java.util.ArrayList;

class Context {
    private ArrayList<GraphColoring> algorithms;

    public Context(ArrayList<GraphColoring> algorithms) {
        this.algorithms = algorithms;
    }

    void execute() {
        //delegates behavior to Strategy object
        for (GraphColoring algorithm : algorithms) {
//            algorithm.executeGraphAlgorithm();
        }
    }

}
