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

    enum Types {
        HEART,
        DIAMOND,
        STAR,
        TRIANGLE,
        SQUARE,
        DONUT;

        // Instead of calling Gem.Types.values().length
        // We can just call Gem.Types.SIZE;
        // A bit more obvious what we intend
        public static final int SIZE = Types.values().length;
    }

    Texture img;
    Types type;
    int combineEffect; // What happens when this is combined, beyond the normal destruction

    Gem(Texture gemImage, Gem.Types gemType){
        this.img = gemImage;
        this.type = gemType;
    }

    public void draw(SpriteBatch batch, int x, int y){
        batch.draw(img, x, y);
    }
}
