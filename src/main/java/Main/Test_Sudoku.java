package Main;

import Applications.Solve_Sudoku;
import ReadFile.readFile;

import java.io.*;

public class Test_Sudoku {

    public static void main(String[] args) {

        String fileName = "D:\\ABschlussArbeit\\IDE_Project\\IntelliJ_Workspace\\Graph_Algorithm_Second\\src\\main\\java\\Input_Files\\sudoku\\sudoku1.txt";
        readFile rd = new readFile();
        Solve_Sudoku bck = rd.readGraphSudoku(fileName);

        try {
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
