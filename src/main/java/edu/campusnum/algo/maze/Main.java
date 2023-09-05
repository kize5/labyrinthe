package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.Maze;
import edu.campusnum.algo.maze.model.MazeCell;

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
            String mazeName = "ex-0";

            // We get the maze as a list of MazeCell
            List<MazeCell> maze = mazeLoader.getMaze(mazeSize, mazeName);

            Maze Maze = new Maze(maze);
            List<MazeCell> maze2 = Maze.getMaze();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SwingUtilities.isEventDispatchThread();
                    JFrame f = new JFrame("LabyDraw");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.add(new LabyDraw(maze2));
                    f.setBackground(Color.white);
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