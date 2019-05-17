package Exact_Algorithm;

import Graph.Graph;

import java.util.Random;
import java.util.Scanner;

public class kleinTest {
    public static void main(String[] args) {
        System.out.println("Inter nodes");
        Scanner sc = new Scanner(System.in);
        int count =0;
        while (count<10) {
            int nodes = sc.nextInt();

            Graph g = new Graph(nodes);
            Random rn = new Random();

            for (int i = 0; i < nodes; i++) {
                g.addEdge(rn.nextInt(nodes), rn.nextInt(nodes));
            }
//			g.printGraph(g);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            Linear_Programming l= new Linear_Programming(g);
            l.executeGraphAlgorithm();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//			reserve lp = new reserve();
//			lp.solve(g);
            count++;
        }
    }
}
