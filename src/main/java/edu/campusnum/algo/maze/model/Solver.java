package edu.campusnum.algo.maze.model;

import java.awt.*;
import java.util.ArrayList;

public class Solver {

	private final Maze maze;
	ArrayList<MazeCell> visited = new ArrayList<>();
	ArrayList<MazeCell> nerverAgain = new ArrayList<>();
	boolean isOut = false;

	public Solver(Maze maze) {
		this.maze = maze;
	}

	public ArrayList<MazeCell> solve(Graphics2D g) {
		if (!this.isOut) {
			MazeCell start = maze.getStart();
			MazeCell exit = maze.getExit();
			MazeCell current = start;
			while (current != exit) {
				//THis if prevent double in the visited list
				if (!this.visited.contains(current)) {
					this.visited.add(current);
				}
				//Move to the next cell
				current = nextStep(current);
				System.out.println("PosX = " + current.getPosX() + " / PosY = " + current.getPosY());
			}
			//Add the last cell to the visited list
			this.visited.add(current);
			this.isOut = true;
			System.out.println("Gg you're out");

			//Remove the nerverAgain list from the visited list to obtain the path
			for (MazeCell cell : nerverAgain) {
				this.visited.remove(cell);
			}
		}
		// Return a list of visited cells to draw the path
		return visited;
	}

	private MazeCell nextStep(MazeCell current) {
		//if there is no wall, and neighbour is not visited, go to the neighbour
		for (Direction dir : Direction.values()) {
			if (!current.hasWall(dir)) {
				MazeCell neighbor = getNeighbor(current, dir);
				if (neighbor != null && !visited.contains(neighbor)) {
					return neighbor;
				}
			}
		}
		//if there is no wall, but neibourgh is visited, add the current cell to the nerverAgain list and go to neighbor anyway
		for (Direction dir : Direction.values()) {
			if (!current.hasWall(dir)) {
				MazeCell neighbor = getNeighbor(current, dir);
				if (neighbor != null && !nerverAgain.contains(neighbor)) {
					this.nerverAgain.add(current);
					return neighbor;
				}
			}
		}
		return null;
	}

	// Return the neighbor cell in the given direction
	private MazeCell getNeighbor(MazeCell current, Direction dir) {
		int x = current.getPosX();
		int y = current.getPosY();

		return switch (dir) {
			case NORTH -> maze.getCell(x, y - 1);
			case EAST -> maze.getCell(x + 1, y);
			case SOUTH -> maze.getCell(x, y + 1);
			case WEST -> maze.getCell(x - 1, y);
		};
	}
}


