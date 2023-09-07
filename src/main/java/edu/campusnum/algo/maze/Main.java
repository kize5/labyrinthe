package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.Maze;
import edu.campusnum.algo.maze.model.MazeCell;
import edu.campusnum.algo.maze.model.Solver;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            // We create a new JsonMazeReader object with the file name as parameter
            JsonMazeReader mazeLoader = new JsonMazeReader("mazes.json");

            // Specify the size and the name of the maze to load
            int mazeSize = 25;
            String mazeName = "ex-2";

            // We get the maze as a list of MazeCell
            List<MazeCell> listCell = mazeLoader.getMaze(mazeSize, mazeName);

            Maze Maze = new Maze(listCell);
            Solver solver = new Solver(Maze);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SwingUtilities.isEventDispatchThread();
                    JFrame f = new JFrame("LabyDraw");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.add(new LabyDraw(listCell, solver));
                    f.setBackground(new Color(196, 164, 132));
                    f.setSize(1100, 1100);
//                    f.pack();
                    f.setVisible(true);
                }
            });


//            System.out.println(maze);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}