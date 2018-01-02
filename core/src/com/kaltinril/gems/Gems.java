package com.kaltinril.gems;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gems extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	Board gameBoard;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("gems/gem_heart.png");

		// TOOD: Load all images using the libgdx asset manager

		// Create the game board surface
		int tilesWide = 10;
		int tilesHigh = 10;
		int tileWidth = 25 + 1; // 1 is buffer between tiles
		int tileHeight = 25 + 1; // 1 is buffer between tiles
		int boardStartX = (Gdx.graphics.getWidth() - (tilesWide*tileWidth)) / 2;
		int boardStartY = (Gdx.graphics.getHeight() - (tilesHigh*tileHeight)) / 2;
		gameBoard = new Board(boardStartX, boardStartY , 10, 10);

		// Create a gem
		// TODO: Load all gems, with their uniquie attributes and images
		Gem g = new Gem(img);

		// TODO: load this level and place the gems
		// Place a temporary gem
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				gameBoard.placeGem(g, i, j);
			}
		}

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		gameBoard.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
