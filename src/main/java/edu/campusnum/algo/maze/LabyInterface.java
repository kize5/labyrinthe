package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.MazeCell;

import java.awt.*;

public interface LabyInterface {

	public void drawLaby(Graphics g);
	public void drawPath();

	public void drawStart(Graphics g, MazeCell cell , int cellSize);

	public void drawEnd(Graphics g, MazeCell cell ,int cellSize);

	public void paintComponent(Graphics g);

	}
