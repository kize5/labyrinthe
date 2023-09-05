package edu.campusnum.algo.maze.model;

import java.util.ArrayList;

public class Solver {

	private Maze maze;
	ArrayList<MazeCell> visited = new ArrayList<MazeCell>();

	public Solver(Maze maze) {
		this.maze = maze;
	}

	public void solve() {
		MazeCell start = maze.getStart();
		MazeCell exit = maze.getExit();
		MazeCell current = start;
		while (current != exit) {
			current = nextStep(current);
//			current.setVisited(true);
		}
	}

	private MazeCell nextStep(MazeCell current) {
		if (current.isStart()) {
			this.visited.add(current);
		}
		return current;
	}
}
