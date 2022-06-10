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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.plantsvszombies.game.PlantsVsZombies;
import com.plantsvszombies.game.model.Pea;
import com.plantsvszombies.game.model.PeaShooter;

public class GameScreen extends ScreenAdapter {
	
	private PlantsVsZombies game;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Viewport viewport;
	
	PeaShooter shooter;
	Array<Rectangle> projectiles = new Array<Rectangle>();
	long lastShootTime = TimeUtils.millis();
	Texture pea = new Texture(Gdx.files.internal("pea.png"));
	
	public GameScreen(PlantsVsZombies game) {
		this.game = game;
	}

		@Override
	    public void show() {
	        TmxMapLoader loader = new TmxMapLoader();
	        map = loader.load("mapa.tmx");

	        
	        renderer = new OrthogonalTiledMapRenderer(map, 0.1f);
	        camera = new OrthographicCamera();
	        //viewport = new FitViewport(400, 400, camera);
	        
	        shooter = new PeaShooter(100, 500, 700, 100, 100, 1, 1);
	        projectiles.add(shooter.shoot());
	        
	        //Gdx.input.setInputProcessor(entity);
	        
	    }
		

	    @Override
	    public void render(float delta) {
	    	
	    	if(TimeUtils.timeSinceMillis(lastShootTime) > 3000) {
	    		projectiles.add(shooter.shoot());
	    		lastShootTime = TimeUtils.millis();
	    	}
	    	
	    	for (Rectangle pea : projectiles) {
	    		pea.x += 100 * Gdx.graphics.getDeltaTime();
	    	}

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
	        
	        Vector2 v2s = new Vector2();
	        shooter.getCenter(v2s);
	        game.batch.draw(shooter.getTexture(), v2s.x, v2s.y, shooter.width, shooter.height);
	        for (Rectangle p : projectiles) {
	        	Vector2 v2 = new Vector2();
	        	p.getCenter(v2);
	        	game.batch.draw(pea, v2.x, v2.y, 20, 20);
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
	    	
	    	//viewport.update(width * 2, height * 2);
	    	camera.viewportWidth = width/10;
	    	camera.viewportHeight = height/10;
	    	camera.update();
	    	
	    }
	

}
