package com.plantsvszombies.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.plantsvszombies.game.PlantsVsZombies;

public class GameScreen extends ScreenAdapter {
	
	private PlantsVsZombies game;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;

	public GameScreen(PlantsVsZombies game) {
		this.game = game;
	}
	

	@Override
	    public void show() {
	        TmxMapLoader loader = new TmxMapLoader();
	        map = loader.load("mapa.tmx");

	        
	        renderer = new OrthogonalTiledMapRenderer(map, 0.1f);
	        camera = new OrthographicCamera(1000, 1000);
	        
	        
	        //Gdx.input.setInputProcessor(entity);
	        
	    }

	    @Override
	    public void render(float delta) {
	        

	        Gdx.gl.glClearColor(0, 0, .25f, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        
	        float xCamera = map.getProperties().get("tilewidth", Integer.class)
	        				* map.getProperties().get("width", Integer.class)*.05f;
	        
	        float yCamera = map.getProperties().get("tileheight", Integer.class)
 				* map.getProperties().get("height", Integer.class) * .05f;
	        
	        camera.position.set(xCamera,yCamera,0);
	        camera.update();
	        
	        //game.batch.setProjectionMatrix(camera.combined);
	        
	        renderer.setView(camera);
	        renderer.render();
	        
	        
	        game.batch.begin();
	        //entity.draw(game.batch);
	        //controller.update()
	        //controller.draw()
	        game.batch.end();

	    }

	    @Override
	    public void hide() {
	        super.dispose();
	    }
	    
	    public void resize(int width, int height) {
	    	
	    	camera.viewportWidth = width/10;
	    	camera.viewportHeight = height/10;
	    	camera.update();
	    	
	    }
	

}
