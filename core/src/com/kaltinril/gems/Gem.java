package com.kaltinril.gems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by racka on 1/2/2018.
 * This is a base class that all
 * the different types of gems
 * will inherit from
 */

public class Gem {

    Texture img;

    Gem(Texture gemImage){
        this.img = gemImage;
    }

    public void draw(SpriteBatch batch, int x, int y){
        batch.draw(img, x, y);
    }
}
