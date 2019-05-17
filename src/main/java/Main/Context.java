package Main;

import AbstractGraphColoring.GraphColoring;

import java.util.ArrayList;

/*
 * The Context class doesn't implement an algorithm directly.
 * Instead, Context refers to the Strategy interface for performing an algorithm (algorithm.execute()),
 * which makes Context independent of how an algorithm is implemented.
 */
class Context {
    private ArrayList<GraphColoring> algorithms;

    protected Context(ArrayList<GraphColoring> algorithms) {
        this.algorithms = algorithms;
    }

    void execute() {
        //delegates behavior to Strategy object
        for (GraphColoring algorithm : algorithms) {
            algorithm.executeGraphAlgorithm();
        }
    }

}
