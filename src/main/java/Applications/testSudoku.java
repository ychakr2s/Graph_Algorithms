package Applications;

import com.google.gson.Gson;

import java.io.*;

public class testSudoku {

    public static void main(String[] args) {

        String fileName = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\lines.txt";
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
            System.out.println("++++++++++++++++++Solve Sudoku ++++++++++++++++++++++++++++++++");
            System.out.println(bck.executeGraphAlgorithm());

            // Output the Result in the File
            File file = new File("D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Output_Files\\sudoku.txt");

            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(bck.executeGraphAlgorithm());
            br.newLine();

            br.close();
            fr.close();

        } catch (Exception e) {

        }

    }
}
