package com.fredcom.camera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bg;
	ShapeRenderer sr;
	OrthographicCamera camera;
	int X = 400 ;
	int Y = 300;
	int speedCamera = 5;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg02.jpg");
		sr = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.viewportWidth = 800;
		camera.viewportHeight = 600;
		camera.position.set(X,Y, 0);
		camera.update();

	}

	@Override
	public void render () {

		System.out.println("Position X: " + X + "   " + "Positon Y: " + Y + "   " + "SpeedCamera: " + speedCamera);

		//Update

		if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_ADD))
		{
			if(speedCamera < 100)
			{
				speedCamera+=5;
			}
		}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_SUBTRACT))
		{
			if(speedCamera > 5)
			{
				speedCamera-=5;
			}

		}


		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			if(Y < 770 - speedCamera)
			{
				Y+=speedCamera;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			if(Y > 300 + speedCamera)
			{
				Y-=speedCamera;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			if( X > 400 + speedCamera)
			{
				X-=speedCamera;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			if(X < 1520 - speedCamera)
			{
				X+=speedCamera;
			}

		}

		camera.position.set(X,Y, 0);


		//Draw
		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();

		batch.setProjectionMatrix(camera.combined);
		batch.draw(bg, 0, 0);
		batch.end();

		camera.update();

		dessinLignes();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

	private void dessinLignes()
	{
		sr.begin(ShapeRenderer.ShapeType.Line);
		sr.line(0,100,800,100);
		sr.line(0,200,800,200);
		sr.line(0, 300, 800, 300);
		sr.line(0,400,800,400);
		sr.line(0,500,800,500);
		sr.line(400,0,400,600);
		sr.line(100,0,100,600);
		sr.line(200,0,200,600);
		sr.line(300,0,300,600);
		sr.line(500,0,500,600);
		sr.line(600,0,600,600);
		sr.line(700,0,700,600);
		sr.end();
	}
}
