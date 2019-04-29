package AbstractGraphColoring;

import Graph.Graph;

import java.util.Iterator;

public abstract class GraphColoring {

    public GraphColoring() {
    }

    // the extended Algorithms must be executed
    public abstract void executeAlgorithm();

    // this method describes the implimented Algorithm
    public abstract void description();

    /*
     * This method prints the test of the Algorithms
     */
    public abstract void printTest();

    public void setColor(int v, int color, int resultColors[]) {
        resultColors[v] = color;
    }

    public int getColor(int v, int resultColor[]) {
        return resultColor[v];
    }

    public boolean colorIsUsed(int d, int a[], int lenght) {
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

    public int resultsColors(int resultColor[]) {
        int result = 0;
        for (int i = 0; i < resultColor.length; i++) {
            if (!colorIsUsed(getColor(i, resultColor), resultColor, i)) {
                result++;
            }
        }
        return result;
    }

    public boolean test(int resultColors[], Graph graph) {
        for (int i = 0; i < resultColors.length; i++) {
            if (resultColors[i] == -1)
                return false;

            Iterator<Integer> itr = graph.getEdges(i).iterator();
            while (itr.hasNext()) {
                int v = itr.next();
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
    public String toString(int resultColor[]) {
        String print = "";
        print += "We need " + resultsColors(resultColor) + " Colors to Color this Graph\n";
        return print;
    }

    public void printTest(int[] resultColors, Graph graph) {
        if (test(resultColors, graph)) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++ \n The Algorithm runs correctly ");
        } else
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++ \n The Algorithm runs wrongly ");
        System.out.println(toString());
    }
}
