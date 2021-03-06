package com.codegym.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();

        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());

        game.setLocationRelativeTo(null);
        game.setVisible(true);


//        Model model = new Model();
//        Tile[] tiles = new Tile[4];
//        tiles[0] = new Tile(2);
//        tiles[1] = new Tile(8);
//        tiles[2] = new Tile(8);
//        tiles[3] = new Tile(0);
//        model.mergeTiles(tiles);


    }
}
