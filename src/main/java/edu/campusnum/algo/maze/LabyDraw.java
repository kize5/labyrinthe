package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.Direction;
import edu.campusnum.algo.maze.model.MazeCell;
import edu.campusnum.algo.maze.model.Solver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class LabyDraw extends JPanel implements LabyInterface {

	List<MazeCell> maze;
	Solver solver;
	int width;
	int cellSize;

	public LabyDraw(List<MazeCell> maze, Solver solver) {
		this.maze = maze;
		this.solver = solver;
		this.width = getWidth() - 100;
		this.cellSize = width / (int) Math.sqrt(this.maze.size());
	}

	public void drawLaby(Graphics g) {
		int width = getWidth() - 100;
		int cellSize = width / (int) Math.sqrt(this.maze.size());

		for (MazeCell cell : this.maze) {
			int x = cell.getPosX() * cellSize;
			int y = cell.getPosY() * cellSize;

			if (cell.hasWall(Direction.NORTH) || cell.isStart()) {
				g.setColor(Color.BLACK);
				g.drawLine(x, y, x + cellSize, y);
			}

			if (cell.hasWall(Direction.EAST) || cell.isExit()) {
				g.setColor(Color.BLACK);
				g.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
			}

			if (cell.hasWall(Direction.SOUTH)) {
				g.setColor(Color.BLACK);
				g.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
			}

			if (cell.hasWall(Direction.WEST)) {
				g.setColor(Color.BLACK);
				g.drawLine(x, y, x, y + cellSize);
			}
			if (cell.isStart()) {
				drawStart(g, cell, cellSize);
			}
			if (cell.isExit()) {
				drawEnd(g, cell, cellSize);
			}
		}
	}

	public void drawPath(ArrayList<MazeCell> listCell, Graphics2D g) {
		System.out.println("drawPath");
		int width = 1000;
		int cellSize = width / (int) Math.sqrt(this.maze.size());
		for (int i = 0; i < listCell.size() - 1; i++) {
			MazeCell currentCell = listCell.get(i);
			MazeCell nextCell = listCell.get(i + 1);
			g.setColor(new Color(218, 247, 166));
			g.setStroke(new BasicStroke(10));
			g.drawLine((currentCell.getPosX() * cellSize) + cellSize/2, (currentCell.getPosY() * cellSize) +cellSize/2, (nextCell.getPosX() * cellSize) + cellSize/2, (nextCell.getPosY()* cellSize)+cellSize/2);
		}
	}

	public void drawStart(Graphics g, MazeCell cell, int cellSize) {
		System.out.println("drawStart");
		g.setColor(new Color(  27, 155, 20 ));
		g.fillOval((cell.getPosX() * cellSize)+5, (cell.getPosY() * cellSize)+5, cellSize-10, cellSize-10);
	}

	public void drawEnd(Graphics g, MazeCell cell, int cellSize) {
		System.out.println("drawEnd");
		g.setColor(new Color( 199, 0, 57));
		g.fillOval((cell.getPosX() * cellSize)+5, (cell.getPosY() * cellSize)+5, cellSize-10, cellSize-10);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.translate(50, 25);
		Graphics2D g2d = (Graphics2D) g;
		drawLaby(g2d);
		drawPath(this.solver.solve(g2d), g2d);
	}
}
