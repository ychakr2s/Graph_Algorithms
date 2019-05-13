package AbstractGraphColoring;

import Graph.Graph;

public abstract class GraphColoring {

    protected GraphColoring() {
    }

    /*
     * the first extended Algorithms must be executed
     * the seconds method describes the implemented Algorithm
     * the third method prints the test of the Algorithms
     */
    public abstract void executeGraphAlgorithms();

    public abstract void description();

    public abstract void printSolution();

    protected void setColor(int vertex, int color, int[] resultColors) {
        resultColors[vertex] = color;
    }

    protected int getColor(int vertex, int[] resultColor) {
        return resultColor[vertex];
    }

    // remove an element from Array
    protected int[] remove(int[] arr, int v) {
        int[] ret = new int[arr.length - 1];
        if (arr.length > 1) {
            int cout = 0;
            for (int i1 : arr) {
                if (i1 == v) {
                } else {
                    ret[cout] = i1;
                    cout++;
                }
            }
            return ret;
        } else
            return ret;
    }

    protected int findRightColor(Graph graph, int cv, int[] resultColors, boolean[] available) {
        // Process all adjacent vertices and flag their colors as unavailable
        for (int i : graph.getEdges(cv)) {
            if (getColor(i, resultColors) != -1) {
                available[getColor(i, resultColors)] = false;
            }
        }

        // Find the first available color
        int cr;
        for (cr = 0; cr < graph.getNumVertices(); cr++) {
            if (available[cr])
                break;
        }
        return cr;
    }

    private boolean colorIsUsed(int d, int[] a, int lenght) {
        if (d == -1)
            return true;
        if (lenght == 0 && a[lenght] != -1) {
            return false;
        }
        for (int i = 0; i < lenght; i++) {
            if (d == a[i])
                return true;
        }
        return false;
    }

    private int computeResultsColors(int[] resultColor) {
        int result = 0;
        for (int i = 0; i < resultColor.length; i++) {
            if (!colorIsUsed(getColor(i, resultColor), resultColor, i)) {
                result++;
            }
        }
        return result;
    }

    private boolean test(int[] resultColors, Graph graph) {
        for (int i = 0; i < resultColors.length; i++) {
            if (resultColors[i] == -1)
                return false;

            for (int v : graph.getEdges(i)) {
                if (graph.isEdges(i, v) && resultColors[i] == resultColors[v]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * This method shows how many colors we need it to color the Graph
     */
    private String toString(int[] resultColor) {
        String print = "";
        print += "We need " + computeResultsColors(resultColor) + " Colors to Color this Graph\n";
        return print;
    }

    protected void printTest(int[] resultColors, Graph graph) {
        if (test(resultColors, graph))
            System.out.println("+++++++++++++++++++ the Algorithm runs correctly +++++++++++++++++++++");
        else
            System.out.println("+++++++++++++++++++ the Algorithm runs wrongly +++++++++++++++++++++++");
        System.out.println(toString(resultColors));
    }
}
