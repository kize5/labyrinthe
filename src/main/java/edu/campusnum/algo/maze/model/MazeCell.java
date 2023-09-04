package edu.campusnum.algo.maze.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

/**
 * A cell of the maze
 */
public class MazeCell {

    /**
     * The position of the cell in the maze
     */
    private final int posX;

    /**
     * The position of the cell in the maze
     */
    private final int posY;

    /**
     * True if the cell is the exit
     */
    private final boolean exit;

    /**
     * True if the cell is the start
     */
    private final boolean start;

    /**
     * The walls of the cell
     */
    private final boolean[] walls;

    @JsonCreator
    public MazeCell(
            @JsonProperty("posY") int posX,
            @JsonProperty("posX") int posY,
            @JsonProperty("exit") boolean exit,
            @JsonProperty("entrance") boolean start,
            @JsonProperty("walls") boolean[] walls
    ) {
        this.posX = posX;
        this.posY = posY;
        this.exit = exit;
        this.start = start;
        this.walls = walls;
    }

    /**
     * Returns true if the cell has a wall at the given direction
     * @param direction the direction to check
     * @return true if the cell has a wall at the given direction
     */
    public boolean hasWall(Direction direction) {
        return this.walls[direction.value];
    }

    /**
     * @return the position of the cell in the maze
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return the position of the cell in the maze
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @return true if the cell is the exit
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * @return true if the cell is the start
     */
    public boolean isStart() {
        return start;
    }

    @Override
    public String toString() {
        return "MazeCell{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", exit=" + exit +
                ", start=" + start +
                ", walls=" + Arrays.toString(walls) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeCell mazeCell = (MazeCell) o;
        return posX == mazeCell.posX && posY == mazeCell.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
