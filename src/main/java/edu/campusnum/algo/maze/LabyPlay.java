package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.Direction;
import edu.campusnum.algo.maze.model.MazeCell;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LabyPlay extends JPanel {
	List<MazeCell> maze;
	public LabyPlay(List<MazeCell> maze) {
		this.maze = maze;
	}

	private void play(Graphics2D g) {
		g.fillPolygon(new int[]{100, 200, 200}, new int[]{100, 150, 200}, 3);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		play(g2d);
	}


}
