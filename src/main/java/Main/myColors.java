package Main;

import AbstractGraphColoring.GraphColoring;
import Graph.Graph;

import java.util.ArrayList;

public class myColors {
    Graph gr;
    String color;
    ArrayList<GraphColoring> algorithm = new ArrayList<>();

    //    myColors(Graph gr){
//        Solution s = new Solution(gr,algorithm);
//    }
    myColors(Graph gr, String c, ArrayList<GraphColoring> algorithm) {
        this.gr = gr;
        this.color = c;
        this.algorithm = algorithm;
    }
    public void solve(){

    }

    public static void main(String[] args) {

    }
}
