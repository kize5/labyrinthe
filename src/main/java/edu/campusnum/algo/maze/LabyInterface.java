package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.MazeCell;

import java.awt.*;
import java.util.ArrayList;

public interface LabyInterface {

	public void drawLaby(Graphics g);
	public void drawPath(ArrayList<MazeCell> listCell, Graphics2D g);

	public void drawStart(Graphics g, MazeCell cell , int cellSize);

	public void drawEnd(Graphics g, MazeCell cell ,int cellSize);

	public void paintComponent(Graphics g);

	}
