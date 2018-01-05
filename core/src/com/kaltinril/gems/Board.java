package com.kaltinril.gems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by racka on 1/2/2018.
 */

public class Board {

    Gem[][] surface;
    int width;
    int height;
    int offset = 26;
    int boardX;
    int boardY;

    Board(int posX, int posY, int width, int height){
        this.width = width;
        this.height = height;
        surface = new Gem[width][height];
        boardX = posX;
        boardY = posY;
    }

    public void draw(SpriteBatch batch){

        for(int y=0;y<height; y++){
            for(int x=0; x<width; x++){
                if (surface[x][y] != null)
                    surface[x][y].draw(batch, boardX + (x * offset), boardY + (y * offset));
            }
        }
    }

    public void placeGem(Gem g, int x, int y){
        surface[x][y] = g;
    }

    // Remove a gem from the board
    public Gem removeGem(int x, int y){
        Gem g = surface[x][y];
        surface[x][y] = null;

        return g;
    }

    // Fill the board randomly with gems
    public void fill(Gem.Types[] typesOfGemsToPlace, HashMap<Gem.Types, Gem> possibleGems) {
        int max = typesOfGemsToPlace.length;

        if (max > 0) {
            Random rand = new Random();

            Gem g;
            int randomGem;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Pick a random type from the possible types
                    randomGem = rand.nextInt(max);

                    // Get the gem name/enum to use
                    Gem.Types gemType = typesOfGemsToPlace[randomGem];

                    // Get the gem that matches the type of the random value
                    g = possibleGems.get(gemType);

                    // Place the gem on the surface
                    placeGem(g, x, y);
                }
            }
        }
    }

    // Re-arrange the board if there are no more moves
    public void shuffle(){

    }

}
