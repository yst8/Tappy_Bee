package ru.uristr.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ResourseLoader {

    private static TextureAtlas atlas;
    public static Sprite grass, bee1, bee2, bee3, honeycombDown, logo,
            honeycombUp, gameOver, retry, background, buttonOff, buttonOn,
            honeycombResult, tappyBee, starOff, starOn, highScore, tapToFly;
    public static Animation beeAnimation;
    public static Sound dead, flap, coin, fall;
    public static Music fly;
    public static BitmapFont font, shadow, whitefont;

    public static void load () {

        //Atlas
        atlas = new TextureAtlas(Gdx.files.internal("texture/texture.pack"), true);

        //Sprites
        grass = new Sprite(atlas.findRegion("grass"));
        bee1 = new Sprite(atlas.findRegion("bee1"));
        bee2 = new Sprite(atlas.findRegion("bee2"));
        bee3 = new Sprite(atlas.findRegion("bee3"));
        honeycombDown = new Sprite(atlas.findRegion("honeycombDown"));
        logo = new Sprite(atlas.findRegion("logo"));
        logo.flip(false, true);
        honeycombUp = new Sprite(atlas.findRegion("honeycombUp"));
        gameOver = new Sprite(atlas.findRegion("gameOver"));
        retry = new Sprite(atlas.findRegion("retry"));
        background = new Sprite(atlas.findRegion("background"));
        buttonOff = new Sprite(atlas.findRegion("buttonOff"));
        buttonOn = new Sprite(atlas.findRegion("buttonOn"));
        honeycombResult = new Sprite(atlas.findRegion("honeycombResult"));
        tappyBee = new Sprite(atlas.findRegion("tappyBee"));
        starOff = new Sprite(atlas.findRegion("starOff"));
        starOn = new Sprite(atlas.findRegion("starOn"));
        highScore = new Sprite(atlas.findRegion("highScore"));
        tapToFly = new Sprite(atlas.findRegion("tapToFly"));

        //Animation bee (LOOK AT THE GENERIC TYPE!!! DELETE IF NEEDED)
        TextureRegion[] bee = {bee1, bee2, bee3};
        beeAnimation = new Animation<TextureRegion>(0.06f, bee);
        beeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //Audio loader
        dead = Gdx.audio.newSound(Gdx.files.internal("sounds/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("sounds/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("sounds/coin.wav"));
        fall = Gdx.audio.newSound(Gdx.files.internal("sounds/fall.wav"));
        ResourseLoader.fly = Gdx.audio.newMusic(Gdx.files.internal("sounds/fly.mp3"));

        //Fonts loader
        font = new BitmapFont(Gdx.files.internal("fonts/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        whitefont = new BitmapFont(Gdx.files.internal("fonts/whitetext.fnt"));
        whitefont.getData().setScale(.1f, -.1f);
        shadow = new BitmapFont(Gdx.files.internal("fonts/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);

    }

    public static void dispose() {
        atlas.dispose();

        dead.dispose();
        flap.dispose();
        coin.dispose();
        fly.dispose();

        font.dispose();
        shadow.dispose();
    }

}