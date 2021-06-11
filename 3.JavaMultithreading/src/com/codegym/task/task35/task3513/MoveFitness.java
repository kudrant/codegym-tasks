package com.codegym.task.task35.task3513;

public class MoveFitness implements Comparable<MoveFitness>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveFitness(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveFitness moveFitness) {
        if(this == moveFitness)
            return 0;

        if(this.numberOfEmptyTiles > moveFitness.numberOfEmptyTiles) {
            return 1;
        }
        if(this.numberOfEmptyTiles < moveFitness.numberOfEmptyTiles) {
            return -1;
        }
        return Integer.compare(this.score, moveFitness.score);
    }
}
