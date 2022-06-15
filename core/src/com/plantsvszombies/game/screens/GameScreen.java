package com.plantsvszombies.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.PlantsVsZombies;
import com.plantsvszombies.game.controller.EntityController;
import com.plantsvszombies.game.controller.InputController;
import com.plantsvszombies.game.controller.MasterController;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Pea;
import com.plantsvszombies.game.model.PeaShooter;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.SunFlower;
import com.plantsvszombies.game.model.Tile;
import com.plantsvszombies.game.model.Zombie;

public class GameScreen extends ScreenAdapter implements InputProcessor{
	
	private PlantsVsZombies game;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private InputController inputController;
	private MasterController masterController = new MasterController();
	
	public GameScreen(PlantsVsZombies game) {
		this.game = game;
		this.inputController = new InputController();
	}

		@Override
	    public void show() {
	        //TmxMapLoader loader = new TmxMapLoader();
	        //map = loader.load("mapa.tmx");
			//map = masterController.getMapController().createMap("mapa.tmx");
			map = masterController.createMap("mapa.tmx");
			
	        
	        renderer = new OrthogonalTiledMapRenderer(map, 0.1f);
	        camera = new OrthographicCamera(1000, 1000);
	        
	        Gdx.input.setInputProcessor(this);
	        
	    }
		

	    @Override
	    public void render(float delta) {
	    	
	    	masterController.control(Gdx.graphics.getDeltaTime());

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
	        
	        
	        for (Entity entity : masterController.getEntities()) {
	        	Vector2 vetor = new Vector2();
	        	entity.getCenter(vetor);
	        	game.batch.draw(entity.getTexture(), entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
	        }
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

		@Override
		public boolean keyDown(int keycode) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean keyUp(int keycode) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean keyTyped(char character) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			
			//lembra de depois adicionar um mapController
			
			//Tile tile = new Tile(screenX, screenY, map);
			Tile tile = masterController.getMapController().getTile(screenX, Gdx.graphics.getHeight() - screenY);
			
			Plant plant = masterController.getInputController().HandleEvent(tile);
			
			if(plant != null)
				masterController.addPlant(plant);
			
			
			return true;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean touchDragged(int screenX, int screenY, int pointer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean mouseMoved(int screenX, int screenY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean scrolled(float amountX, float amountY) {
			// TODO Auto-generated method stub
			return false;
		}
	

}
