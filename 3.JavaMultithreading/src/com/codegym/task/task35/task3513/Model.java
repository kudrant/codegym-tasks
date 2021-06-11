package com.codegym.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;
    boolean isSaveNeeded = true;

    Stack<Tile[][]> previousStates;
    Stack<Integer> previousScores;

    public Model() {
        resetGameTiles();
        previousScores = new Stack<Integer>();
        previousStates = new Stack<Tile[][]>();
    }

    private void saveState (Tile[][] tiles) {
        int width = tiles[0].length;
        int height = tiles.length;
        Tile[][] gameState = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameState[i][j] = new Tile(tiles[i][j].value);;
            }
        }
        previousStates.push(gameState);
        int scoreState = score;
        previousScores.push(scoreState);
        isSaveNeeded = false;
    }

    public void rollback() {
        if(!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random () * 100)) % 4;
        switch (n) {
            case 0: left(); break;
            case 1: up(); break;
            case 2: right(); break;
            case 3: down(); break;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> result = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0)
                    result.add(gameTiles[i][j]);
            }
        }
        return result;
    }

    public void addTile() {
        List<Tile> tilesList = getEmptyTiles();
        if (tilesList.size() > 0) {
            int randomTileID = (int) (tilesList.size() * Math.random());
            tilesList.get(randomTileID).value = (Math.random () < 0.9 ? 2 : 4);
        }
    }

    private void swap(Tile[] array, int ind1, int ind2) {
        Tile tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private boolean consolidateTiles(Tile[] tiles) {
        boolean needIteration = true;
        boolean isChanged = false;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].value != 0)
                    continue;
                else {
                    if (tiles[i+1].value == 0)
                        continue;
                    else{
                        swap(tiles, i,i + 1);
                        isChanged = true;
                        needIteration = true;
                    }
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length -1; i++) {
            if (tiles[i+1].value == tiles[i].value && tiles[i].value != 0) {
                tiles[i].value *= 2;
                tiles[i+1].value = 0;
                if (tiles[i].value > maxTile)
                    maxTile = tiles[i].value;
                score += tiles[i].value;
                //i++;
                isChanged = true;
            }
        }
        consolidateTiles(tiles);
        return isChanged;
    }

    public boolean hasBoardChanged() {
        int weightCurrent = 0;
        int weightPrevious = 0;
        Tile[][] previousState = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                weightCurrent += gameTiles[i][j].value;
                weightPrevious += previousState[i][j].value;
            }
        }
        return weightCurrent != weightPrevious;
    }

    public MoveFitness getMoveFitness(Move move) {
        MoveFitness moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveFitness(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveFitness(-1, 0, move);
        rollback();

        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveFitness> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveFitness(this::left));
        queue.add(getMoveFitness(this::up));
        queue.add(getMoveFitness(this::right));
        queue.add(getMoveFitness(this::down));

        Move move = queue.peek().getMove();
        move.move();
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j+1].value)
                    return true;
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[j][i].value == gameTiles[j+1][i].value)
                    return true;
            }
        }
        return false;
    }

    public void left() {
        if(isSaveNeeded) {
            saveState(this.gameTiles);

        }
        boolean isChanged = false;
        for (Tile[] row: gameTiles
             ) {
            if (consolidateTiles(row) | mergeTiles(row))
                isChanged =true;
        }
        if (isChanged)
            addTile();
            isSaveNeeded= true;
    }

    public void up() {
        saveState(this.gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    private void rotate() {
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        int maxID = FIELD_WIDTH - 1; //3
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                temp[maxID-j][i] = gameTiles[i][j];
            }
        }

        gameTiles = temp;


    }

    public void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    public void printTiles(Tile[] tiles) {
        for (Tile tile: tiles
             ) {
            System.out.print(tile.value + ", ");
        }
        System.out.println("");
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
}
