package com.kaltinril.gems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

}
