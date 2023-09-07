package edu.campusnum.algo.maze.model;

import java.util.List;

public class Maze {
	List<MazeCell> cells;
	public Maze(List<MazeCell> cellList) {
		setCells(cellList);
	}

	public List<MazeCell> getCells() {
		return cells;
	}

	public void setCells(List<MazeCell> cells) {
		this.cells = cells;
	}
	public MazeCell getCell(int x, int y) {
		for (MazeCell cell : this.cells) {
			if (cell.getPosX() == x && cell.getPosY() == y) {
				return cell;
			}
		}
		return null;
	}
	public MazeCell getStart() {
		for (MazeCell cell : this.cells) {
			if (cell.isStart()) {
				return cell;
			}
		}
		return null;
	}
	public MazeCell getExit() {
		for (MazeCell cell : this.cells) {
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
