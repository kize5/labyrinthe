package edu.campusnum.algo.maze.model;

public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    final int value;
    Direction(int i) {
        this.value = i;
    }
}
