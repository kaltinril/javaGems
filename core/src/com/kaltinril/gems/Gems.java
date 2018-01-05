package com.kaltinril.gems;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class Gems extends ApplicationAdapter {
	SpriteBatch batch;
	Texture imgGemHeart;
	Texture imgGemDiamond;

	Board gameBoard;
	@Override
	public void create () {
		batch = new SpriteBatch();
		imgGemHeart = new Texture("gems/gem_heart.png");
		imgGemDiamond = new Texture("gems/gem_diamond.png");

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
		Gem gemHeart = new Gem(imgGemHeart, Gem.Types.HEART);
		Gem gemDiamond = new Gem(imgGemDiamond, Gem.Types.DIAMOND);
		int maxTypes = Gem.Types.SIZE;

		HashMap<Gem.Types, Gem> possibleGems = new HashMap<Gem.Types, Gem>();
		possibleGems.put(Gem.Types.HEART, gemHeart);
		possibleGems.put(Gem.Types.DIAMOND, gemDiamond);

		gameBoard.fill(new Gem.Types[]{Gem.Types.HEART, Gem.Types.DIAMOND}, possibleGems);
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
		imgGemHeart.dispose();
		imgGemDiamond.dispose();
	}
}
