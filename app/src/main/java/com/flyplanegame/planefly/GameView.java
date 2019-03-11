package com.flyplanegame.planefly;

import android.content.Context;

import com.flyplanegame.planefly.GameRooms.DifficultyRoom;
import com.flyplanegame.planefly.GameRooms.GameOverRoom;
import com.flyplanegame.planefly.GameRooms.GameRoom;
import com.flyplanegame.planefly.GameRooms.ScoreRoom;
import com.flyplanegame.planefly.GameRooms.StartRoom;

import javax.microedition.khronos.opengles.GL10;

import ge.xordinate.xengine.EngineView;
import ge.xordinate.xengine.Graphic;

/**
 * GameView
 * <p>
 *  Game view keeps all objects and variables
 * <p/>
 */
public class GameView extends EngineView{

    // Rooms - User interfaces
    public static StartRoom startRoom;
    public static GameRoom game;
    public static DifficultyRoom difficulty;
    public static GameOverRoom gameOver;
    public static ScoreRoom scoreroom;

    // Game Objects - Player plane, obstacles, bonus etc.
    public static Graphic BonusIcon, BonusIcon2, Bird1, Bird2;
    public static Graphic Xspeedlow;
    public static Graphic Ufo;
    public static Graphic Help;
    public static Graphic title;
    public static Graphic play;
    public static Graphic easy;
    public static Graphic hard;
    public static Graphic flower;
    public static Graphic bg;
    public static Graphic over;
    public static Graphic score;
    public static Graphic victory;
    public static Graphic mute;
    public static Graphic smoke;

    /**
     * Game View Constructor
     */
    public GameView(Context context){
        super(context);
    }

    /**
     * Initialize graphics and objects
     */
    @Override
    protected void onCreateGraphics(){
        getGraphicsHelper().setParameters(false, GL10.GL_NEAREST, GL10.GL_NEAREST);
        victory = getGraphicsHelper().addGraphic(R.drawable.victory);
        mute = getGraphicsHelper().addGraphic(R.drawable.mute);
        Bird1 = getGraphicsHelper().addGraphic(R.drawable.bird1);
        Bird2 = getGraphicsHelper().addGraphic(R.drawable.bird2);
        Help = getGraphicsHelper().addGraphic(R.drawable.help);
        Xspeedlow = getGraphicsHelper().addGraphic(R.drawable.speedlowbonus);
        BonusIcon = getGraphicsHelper().addGraphic(R.drawable.kucultme);
        BonusIcon2 = getGraphicsHelper().addGraphic(R.drawable.changecontrolbonus);
        Ufo = getGraphicsHelper().addGraphic(R.drawable.arrow);
        title = getGraphicsHelper().addGraphic(R.drawable.title);
        play = getGraphicsHelper().addGraphic(R.drawable.play);
        easy = getGraphicsHelper().addGraphic(R.drawable.easybutton);
        hard = getGraphicsHelper().addGraphic(R.drawable.hardbutton);
        score = getGraphicsHelper().addGraphic(R.drawable.score);
        flower = getGraphicsHelper().addGraphic(R.drawable.rock);
        bg = getGraphicsHelper().addGraphic(R.drawable.background);
        over = getGraphicsHelper().addGraphic(R.drawable.gameover);
        smoke = getGraphicsHelper().addGraphic(R.drawable.smoke);
    }

    /**
     * Prepare rooms and set game objects
     */
    @Override
    protected void onCreateRooms(){
        // Initialize rooms
        difficulty = new DifficultyRoom(this);
        startRoom = new StartRoom(this);
        game = new GameRoom(this);
        gameOver = new GameOverRoom(this);
        scoreroom = new ScoreRoom(this);

        // Set start room
        startRoom.set();

        // Set room and prepare to rendering
        goToRoom(startRoom);
    }
}
