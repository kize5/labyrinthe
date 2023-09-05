package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.Direction;
import edu.campusnum.algo.maze.model.Maze;
import edu.campusnum.algo.maze.model.MazeCell;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class LabyDraw extends JPanel implements LabyInterface {

	List<MazeCell> maze;

	Zorro zorro;
	int[] exit = {5, 5};

	public LabyDraw(List<MazeCell> maze) {
		this.maze = maze;
		this.zorro = new Zorro();
	}

	public void getOut() {
		int count = 0;
		while (this.zorro.getPosX() != this.exit[0] && this.zorro.getPosY() != this.exit[1]) {
			for (MazeCell cell : this.maze) {
				if (cell.isStart()) {
					this.zorro.setPosX(cell.getPosX());
					this.zorro.setPosY(cell.getPosY());
					return;
				}
				if (cell.isExit()) {
					this.exit = new int[]{cell.getPosX(), cell.getPosY()};
				}
				if (cell.getPosX() == zorro.getPosX() && cell.getPosY() == zorro.getPosY()) {
					System.out.println("Zorro is in cell " + cell.getPosX() + " " + cell.getPosY());
					return;
				}
				if (this.zorro.getPosX() == this.exit[0] && this.zorro.getPosY() == this.exit[1]) {
					System.out.println("Zorro is out !");
					return;
				}
				if (!cell.hasWall(Direction.NORTH)) {
					if (cell.getPosX() == this.zorro.getPosX() && cell.getPosY() == this.zorro.getPosY() - 1) {
						System.out.println("Zorro is going north");
						this.zorro.setPosY(this.zorro.getPosY() - 1);
						break;
					}
				}
			}
		}
	}


	public void drawLaby(Graphics g) {
		System.out.println("drawLaby");
//		System.out.println(this.maze);
		int width = getWidth() - 100;
		int cellSize = width / (int) Math.sqrt(this.maze.size());
		for (MazeCell cell : this.maze) {
			if (cell.hasWall(Direction.NORTH)) {
				g.setColor(Color.BLACK);
				g.drawLine(cell.getPosX() * cellSize, cell.getPosY() * cellSize, cell.getPosX() * cellSize + cellSize, cell.getPosY() * cellSize);
			}
			if (cell.hasWall(Direction.EAST)) {
				g.setColor(Color.BLACK);
				g.drawLine(cell.getPosX() * cellSize + cellSize, cell.getPosY() * cellSize, cell.getPosX() * cellSize + cellSize, cell.getPosY() * cellSize + cellSize);
			}
			if (cell.hasWall(Direction.SOUTH)) {
				g.setColor(Color.BLACK);
				g.drawLine(cell.getPosX() * cellSize, cell.getPosY() * cellSize + cellSize, cell.getPosX() * cellSize + cellSize, cell.getPosY() * cellSize + cellSize);
			}
			if (cell.hasWall(Direction.WEST)) {
				g.setColor(Color.BLACK);
				g.drawLine(cell.getPosX() * cellSize, cell.getPosY() * cellSize, cell.getPosX() * cellSize, cell.getPosY() * cellSize + cellSize);
			}
			if (cell.isStart()) {
				drawStart(g, cell, cellSize);
			}
			if (cell.isExit()) {
				drawEnd(g, cell, cellSize);
			}
		}
	}

	public void drawPath() {
		System.out.println("drawPath");
	}

	public void drawStart(Graphics g, MazeCell cell, int cellSize) {
		System.out.println("drawStart");
		g.setColor(Color.GREEN);
		g.fillRect(cell.getPosX() * cellSize, cell.getPosY() * cellSize, cellSize, cellSize);
	}

	public void drawEnd(Graphics g, MazeCell cell, int cellSize) {
		System.out.println("drawEnd");
		g.setColor(Color.RED);
		g.fillRect(cell.getPosX() * cellSize, cell.getPosY() * cellSize, cellSize, cellSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		drawLaby(g2d);
		getOut();
	}

}
