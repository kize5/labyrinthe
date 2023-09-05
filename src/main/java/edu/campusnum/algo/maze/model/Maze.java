package edu.campusnum.algo.maze.model;

import java.util.List;

public class Maze {
	List<MazeCell> maze;
	public Maze(List<MazeCell> cellList) {
		setMaze(cellList);
	}

	public List<MazeCell> getMaze() {
		return maze;
	}

	public void setMaze(List<MazeCell> maze) {
		this.maze = maze;
	}
	public MazeCell getCell(int x, int y) {
		for (MazeCell cell : this.maze) {
			if (cell.getPosX() == x && cell.getPosY() == y) {
				return cell;
			}
		}
		return null;
	}
	public MazeCell getStart() {
		for (MazeCell cell : this.maze) {
			if (cell.isStart()) {
				return cell;
			}
		}
		return null;
	}
	public MazeCell getExit() {
		for (MazeCell cell : this.maze) {
			if (cell.isExit()) {
				return cell;
			}
		}
		return null;
	}
//	public MazeCell getNeibourgh(MazeCell cell, Direction direction) {
//
//	}
}
