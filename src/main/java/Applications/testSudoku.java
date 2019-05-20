package Applications;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class testSudoku {

    public static void main(String[] args) {

        String fileName = "C://Users/CYassine/Desktop/lines.txt";

//        SudokuGraph sd = new SudokuGraph();
        Solve_Sudoku bck = new Solve_Sudoku();

        String line = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            line = reader.readLine();
            int vertex = 0;

            while (line != null) {
                for (int j = 0; j < line.length(); j++) {

                    if (Character.isDigit(line.charAt(j))) {
                        int color = Character.getNumericValue(line.charAt(j));
                        bck.setColor(vertex, color);
                        bck.setFixedColor(vertex);
                    }

                    vertex++;

                }
                line = reader.readLine();
            }
            System.out.println("+++++++++++++++++++++++++++++++ Backtrcking+++++++++++++++++++++++++++++++++++++");
            bck.executeGraphAlgorithm();
//            bck.printSudoku();

            Gson gs = new Gson();
            String json = gs.toJson(bck.executeGraphAlgorithm());
            System.out.println(json);

        } catch (Exception e) {

        }

    }
}
