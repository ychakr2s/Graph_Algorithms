package Applications;

import java.util.Iterator;

public class Solve_Sudoku extends SudokuGraph {

    private int V;
    private int[] resultColors;
    private boolean[] fixedColor;

    Solve_Sudoku() {
        this.V = getNumVertices();
        this.resultColors = new int[V];

        this.fixedColor = new boolean[V];
    }

    /*
     * A utility function to check if the current color assignment is safe for vertex v.
     */
    private boolean isSafe(int v, int c) {

        Iterator<Integer> it = getEdges(v).iterator();
        while (it.hasNext()) {
            int vertex = it.next();
            if (getColor(vertex) == c)
                return false;
        }
        return true;
    }

    /*
     * A recursive utility function to solve m coloring problem
     */
    private boolean graphColoringUtil(int v) {
        /*
         * base case: If all vertices are assigned a color then return true
         */
        if (v == getNumVertices())
            return true;

        if (fixedColor[v]) {
            return graphColoringUtil(v + 1);
        }

        /*
         * Consider this vertex v and try different colors
         */
        for (int c = 1; c <= 9; c++) {
            /*
             * Check if assignment of color c to v is fine
             */
            if (isSafe(v, c) && !fixedColor[v]) {
                setColor(v, c);

                /*
                 * recur to assign colors to rest of the vertices
                 */
                if (graphColoringUtil(v + 1))
                    return true;

                // if next vertex was not colorable. reset the color and try next one
                setColor(v, -1);
            }

        }

        /*
         * If no color can be assigned to this vertex then return false
         */
        return false;
    }

    void setFixedColor(int v) {
        this.fixedColor[v] = true;
    }

    public void setColor(int vertex, int color) {
        this.resultColors[vertex] = color;
    }

    private int getColor(int vertex) {
        return this.resultColors[vertex];
    }


    //    @Override
    public String executeGraphAlgorithm() {
        if (graphColoringUtil(0)) {
            System.out.println("Solution exist");
            return toString();

        } else {
            System.out.println("the Solution does not exists");
            return "There is an Input Error";
        }

    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("This is the Solution of the Sudoku Problem using Graph Coloring: \n");
        string.append("\n");

        int i = 0;
        int j = 0;
        for (; i <= V - 9; i = i + 9) {

            for (; j < i + 9; j++) {

                string.append(getColor(j)).append(" ");
            }
            string.append("\n");
        }
        return string.toString();
    }

//    public void printSudoku() {
//        int i = 0;
//        int j = 0;
//        for (; i <= V - 9; i = i + 9) {
//            for (; j < i + 9; j++) {
//                System.out.print("   " + getColor(j));
//            }
//            System.out.println();
//        }
//    }
}
