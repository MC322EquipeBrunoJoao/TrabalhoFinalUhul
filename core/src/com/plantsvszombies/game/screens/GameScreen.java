package com.plantsvszombies.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.plantsvszombies.game.PlantsVsZombies;
import com.plantsvszombies.game.controller.MasterController;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.MapObject;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Sun;

public class GameScreen extends ScreenAdapter implements InputProcessor{
	
	private PlantsVsZombies game;
	private MapObject mapObject;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private MasterController masterController = MasterController.getInstance();
	private Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
	BitmapFont font = new BitmapFont();
	BitmapFont.BitmapFontData bounds;
	
	public GameScreen(PlantsVsZombies game) {
		this.game = game;
	}

	@Override
    public void show() {
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
		backgroundMusic.setVolume(0.5f);
		mapObject = masterController.createMap("mapa.tmx");
		MasterController.getInstance().setInitialGameConditions();
		camera = masterController.setCamera();
        renderer = new OrthogonalTiledMapRenderer(mapObject.getTiledMap(), 0.1f);
        Gdx.input.setInputProcessor(this);
    }
	

    @Override
    public void render(float delta) {
   
    	masterController.control(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0, 0, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setView(camera);
        renderer.render();
        game.batch.begin();

        for (Entity entity : masterController.getEntities()) {
        	Vector2 vetor = new Vector2();
        	entity.getCenter(vetor);
        	game.batch.draw(entity.getTexture(),
        			entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
        }
        
        masterController.displaySunAmount(game.batch);

        game.batch.end();
        
    }

    @Override
    public void hide() {
    	backgroundMusic.stop();
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
		
		
		for(Sun sun : masterController.getSuns()) {
			
			if(sun.isInsideSunArea(screenX, Gdx.graphics.getHeight() - screenY)) {
				masterController.pickSun(sun);
				System.out.println("\n QTD SOL" + masterController.getSunAmount());
				return true;
				
			}
			
		}

		ITile tile = masterController.getTile(screenX, Gdx.graphics.getHeight() - screenY);
		
		masterController.shopInteraction(tile);
		
		//Plant plant = masterController.HandleEvent(tile);
		Plant plant = null;
		
		if(!masterController.isPlantSelected()){
	 			masterController.selectPlant(tile);
		 
		  
		 }
		  
		 else{
		  	plant = masterController.handlePlantCreation(tile);
		  	
		 }
		
		
		
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
