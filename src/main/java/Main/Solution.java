package Main;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;
import Heuristic_Algorithms.Greedy_Algorithm;

import java.util.ArrayList;

public class Solution {
    Graph gr;
    ArrayList<String> algorithm;


    public Solution(Graph gr, ArrayList<String> algorithms) {
        FactorySolution fc = new FactorySolution(gr);
//        this.algorithm = fc.getAlgorithms();
        this.algorithm = algorithms;
        this.gr = gr;
    }

    public ArrayList<String> solve() {
        ArrayList<GraphColoring> solution = new ArrayList<>();
        ArrayList<String> solut = new ArrayList<>();
////        ArrayList<GraphColoring> alg= FactorySolution.getAlgorithms(algorithm);
        FactorySolution fc = new FactorySolution(gr);
        for (int i = 0; i < algorithm.size(); i++) {
            if (algorithm.get(i) == "Greedy_Algorithm") {
//                solution.add();
                Greedy_Algorithm gre = new Greedy_Algorithm(gr);
//                gre.executeGraphAlgorithm();
                solut.add(i, gre.execute());
            }

        }

        return solut;
    }

}